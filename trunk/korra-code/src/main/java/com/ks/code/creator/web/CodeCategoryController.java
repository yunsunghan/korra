package com.ks.code.creator.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.ks.code.creator.domain.CodeCategory;
import com.ks.code.creator.service.CodeCategoryService;
import com.ks.code.creator.service.CodeCategoryServiceResult;
import com.ks.code.web.KsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

//import com.ks.spring.roo.addon.maxweb.metadata.RooMaxWeb;

//@RooMaxWeb(targetObject = CodeCategory.class)
@RequestMapping("/backoffice/codecategorys")
@Controller
public class CodeCategoryController extends KsController {

	@Autowired CodeCategoryService codecategoryService;
	
    @RequestMapping(value="create", method = RequestMethod.POST)
    public String create(@Valid CodeCategory codecategory, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("codecategory", codecategory);
            return "backoffice/codecategorys/create";
        }
        uiModel.asMap().clear();
        codecategory.setAccount(getAccountFromSesson(httpServletRequest));
        codecategoryService.save(codecategory);
        return "redirect:/backoffice/codecategorys/show/" + encodeUrlPathSegment(codecategory.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value="create", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        uiModel.addAttribute("codecategory", new CodeCategory());
        return "backoffice/codecategorys/create";
    }
    
    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("result", codecategoryService.findById(id));
        uiModel.addAttribute("itemId", id);
        return "backoffice/codecategorys/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(	
						@RequestParam(value = "currentPage", required = false, defaultValue="1") Integer currentPage,
						@RequestParam(value = "startNumber", required = false, defaultValue="0") Integer startNumber,					 
    					Model uiModel, HttpServletRequest httpServletRequest) {
        uiModel.addAttribute("result", codecategoryService.findCodeCategoryEntries(getAccountFromSesson(httpServletRequest), currentPage, startNumber));
        return "backoffice/codecategorys/list";
    }
    
    @RequestMapping(value="update", method = RequestMethod.POST)
    public String update(@Valid CodeCategory codecategory, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("codecategory", codecategory);
            return "backoffice/codecategorys/update";
        }
        uiModel.asMap().clear();
        codecategoryService.update(codecategory);
        return "redirect:/backoffice/codecategorys/show/" + encodeUrlPathSegment(codecategory.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("codecategory", codecategoryService.findById(id).getCodeCategory());
        return "backoffice/codecategorys/update";
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(
    		@PathVariable("id") Long id, 
			@RequestParam(value = "currentPage", required = false, defaultValue="1") Integer currentPage,
			@RequestParam(value = "startNumber", required = false, defaultValue="0") Integer startNumber,	 
    		Model uiModel) {
    	codecategoryService.findById(id).getCodeCategory().remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("currentPage", currentPage);
        uiModel.addAttribute("startNumber", startNumber);
        return "redirect:/backoffice/codecategorys";
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
