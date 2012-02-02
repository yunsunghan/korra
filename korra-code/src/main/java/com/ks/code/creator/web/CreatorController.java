package com.ks.code.creator.web;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.ks.code.creator.domain.CodeCategory;
import com.ks.code.creator.domain.CodeCreator;
import com.ks.code.creator.domain.aggregate.CodeFormatType;
import com.ks.code.creator.domain.aggregate.CodeSizeType;
import com.ks.code.creator.service.CreatorService;
import com.ks.code.web.KsController;

//import com.ks.spring.roo.addon.maxweb.metadata.RooMaxWeb;

//@RooMaxWeb(targetObject = CodeCreator.class)
@RequestMapping("/backoffice/codecreators")
@Controller
public class CreatorController extends KsController {

	@Autowired CreatorService creatorService;
	@Value("${korra.short.url}") private String shortUrl;	
	
    @RequestMapping(value="create", method = RequestMethod.POST)
    public String create(@Valid CodeCreator codecreator, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {

        if (bindingResult.hasErrors()) {
        	System.out.println(codecreator);
            uiModel.addAttribute("codecreator", codecreator);
            return "backoffice/codecreators/create";
        }
        
		codecreator.setAccount(this.getAccountFromSesson(httpServletRequest));
		uiModel.asMap().clear();
        codecreator = creatorService.save(codecreator);
        uiModel.addAttribute("codecreator", codecreator);
        return "redirect:/backoffice/codecreators/show/" + encodeUrlPathSegment(codecreator.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value="create", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        uiModel.addAttribute("codecreator", new CodeCreator());
        uiModel.addAttribute("codecreator", new CodeCreator());
        return "backoffice/codecreators/create";
    }
    
    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("result", creatorService.findById(id));
        uiModel.addAttribute("itemId", id);
        uiModel.addAttribute("shortUrl", shortUrl);
        return "backoffice/codecreators/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(	
						@RequestParam(value = "currentPage", required = false, defaultValue="1") Integer currentPage,
						@RequestParam(value = "startNumber", required = false, defaultValue="0") Integer startNumber,					 
    					Model uiModel, HttpServletRequest httpServletRequest) {
        uiModel.addAttribute("result", creatorService.findCodeCreatorEntries(this.getAccountFromSesson(httpServletRequest),currentPage, startNumber));
        uiModel.addAttribute("shortUrl", shortUrl);
        return "backoffice/codecreators/list";
    }
    
    @RequestMapping(value="update", method = RequestMethod.POST)
    public String update(CodeCreator codecreator, Model uiModel, HttpServletRequest httpServletRequest) {
        
    	CodeCreator findCodeCreator = CodeCreator.findCodeCreator(codecreator.getId());
    	findCodeCreator.setSubject(codecreator.getSubject());
    	findCodeCreator.setContentUrl(codecreator.getContentUrl());
        creatorService.update(findCodeCreator);
        uiModel.asMap().clear();
        return "redirect:/backoffice/codecreators/show/" + encodeUrlPathSegment(codecreator.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("codecreator", creatorService.findById(id).getCodeCreator());
        return "backoffice/codecreators/update";
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(
    		@PathVariable("id") Long id, 
			@RequestParam(value = "currentPage", required = false, defaultValue="1") Integer currentPage,
			@RequestParam(value = "startNumber", required = false, defaultValue="0") Integer startNumber,	 
    		Model uiModel) {
    	creatorService.remove(CodeCreator.findCodeCreator(id));
        uiModel.asMap().clear();
        uiModel.addAttribute("currentPage", currentPage);
        uiModel.addAttribute("startNumber", startNumber);
        return "redirect:/backoffice/codecreators";
    }

    @ModelAttribute("codeformats")
    public Collection<CodeFormatType> populateCodeFormats() {
        return Arrays.asList(CodeFormatType.class.getEnumConstants());
    }
    @ModelAttribute("codeSizes")
    public Collection<CodeSizeType> populateCodeSizes() {
    	return Arrays.asList(CodeSizeType.class.getEnumConstants());
    }
    @ModelAttribute("codeCategorys")
    public Collection<CodeCategory> populateCodeCategorys(HttpServletRequest httpServletRequest) {
    	return CodeCategory.findCodeCategorysByParentIdIsNullAndAccount(getAccountFromSesson(httpServletRequest)).getResultList();
    }
    
    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}
