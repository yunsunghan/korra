package com.ks.code.template.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.ks.code.template.domain.ContentPage;
import com.ks.code.template.service.TemplateService;
import com.ks.code.template.service.TemplateServiceResult;

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

//@RooMaxWeb(targetObject = ContentPage.class)
@RequestMapping("/backoffice/contentpages")
@Controller
public class TemplateController {

	@Autowired TemplateService templateService;
	
    @RequestMapping(value="create", method = RequestMethod.POST)
    public String create(@Valid ContentPage contentpage, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("contentpage", contentpage);
            return "backoffice/contentpages/create";
        }
        uiModel.asMap().clear();
        templateService.save(contentpage);
        return "redirect:/backoffice/contentpages/show/" + encodeUrlPathSegment(contentpage.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value="create", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        uiModel.addAttribute("contentpage", new ContentPage());
        return "backoffice/contentpages/create";
    }
    
    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("result", templateService.findById(id));
        uiModel.addAttribute("itemId", id);
        return "backoffice/contentpages/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(	
						@RequestParam(value = "currentPage", required = false, defaultValue="1") Integer currentPage,
						@RequestParam(value = "startNumber", required = false, defaultValue="0") Integer startNumber,					 
    					Model uiModel) {
        uiModel.addAttribute("result", templateService.findContentPageEntries(currentPage, startNumber));
        return "backoffice/contentpages/list";
    }
    
    @RequestMapping(value="update", method = RequestMethod.POST)
    public String update(@Valid ContentPage contentpage, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("contentpage", contentpage);
            return "backoffice/contentpages/update";
        }
        uiModel.asMap().clear();
        templateService.update(contentpage);
        return "redirect:/backoffice/contentpages/show/" + encodeUrlPathSegment(contentpage.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("contentpage", templateService.findById(id).getContentPage());
        return "backoffice/contentpages/update";
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(
    		@PathVariable("id") Long id, 
			@RequestParam(value = "currentPage", required = false, defaultValue="1") Integer currentPage,
			@RequestParam(value = "startNumber", required = false, defaultValue="0") Integer startNumber,	 
    		Model uiModel) {
    	templateService.findById(id).getContentPage().remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("currentPage", currentPage);
        uiModel.addAttribute("startNumber", startNumber);
        return "redirect:/backoffice/contentpages";
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
