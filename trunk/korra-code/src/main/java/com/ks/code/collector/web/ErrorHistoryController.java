package com.ks.code.collector.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.ks.code.collector.domain.aggregate.ErrorHistory;
import com.ks.code.collector.service.ErrorHistoryService;
import com.ks.code.collector.service.ErrorHistoryServiceResult;

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

//@RooMaxWeb(targetObject = ErrorHistory.class)
@RequestMapping("/backoffice/errorhistorys")
@Controller
public class ErrorHistoryController {

	@Autowired ErrorHistoryService errorhistoryService;
	
    @RequestMapping(value="create", method = RequestMethod.POST)
    public String create(@Valid ErrorHistory errorhistory, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("errorhistory", errorhistory);
            return "backoffice/errorhistorys/create";
        }
        uiModel.asMap().clear();
        errorhistoryService.save(errorhistory);
        return "redirect:/backoffice/errorhistorys/show/" + encodeUrlPathSegment(errorhistory.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value="create", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        uiModel.addAttribute("errorhistory", new ErrorHistory());
        return "backoffice/errorhistorys/create";
    }
    
    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("result", errorhistoryService.findById(id));
        uiModel.addAttribute("itemId", id);
        return "backoffice/errorhistorys/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(	
						@RequestParam(value = "currentPage", required = false, defaultValue="1") Integer currentPage,
						@RequestParam(value = "startNumber", required = false, defaultValue="0") Integer startNumber,					 
    					Model uiModel) {
        uiModel.addAttribute("result", errorhistoryService.findErrorHistoryEntries(currentPage, startNumber));
        return "backoffice/errorhistorys/list";
    }
    
    @RequestMapping(value="update", method = RequestMethod.POST)
    public String update(@Valid ErrorHistory errorhistory, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("errorhistory", errorhistory);
            return "backoffice/errorhistorys/update";
        }
        uiModel.asMap().clear();
        errorhistoryService.update(errorhistory);
        return "redirect:/backoffice/errorhistorys/show/" + encodeUrlPathSegment(errorhistory.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("errorhistory", errorhistoryService.findById(id).getErrorHistory());
        return "backoffice/errorhistorys/update";
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(
    		@PathVariable("id") Long id, 
			@RequestParam(value = "currentPage", required = false, defaultValue="1") Integer currentPage,
			@RequestParam(value = "startNumber", required = false, defaultValue="0") Integer startNumber,	 
    		Model uiModel) {
    	errorhistoryService.findById(id).getErrorHistory().remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("currentPage", currentPage);
        uiModel.addAttribute("startNumber", startNumber);
        return "redirect:/backoffice/errorhistorys";
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
