package com.ks.code.account.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.ks.code.account.domain.Account;
import com.ks.code.account.service.AccountService;
import com.ks.code.account.service.AccountServiceResult;

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

//@RooMaxWeb(targetObject = Account.class)
@RequestMapping("/backoffice/accounts")
@Controller
public class AccountController {

	@Autowired AccountService accountService;
	
    @RequestMapping(value="create", method = RequestMethod.POST)
    public String create(@Valid Account account, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("account", account);
            return "backoffice/accounts/create";
        }
        uiModel.asMap().clear();
        accountService.save(account);
        return "redirect:/backoffice/accounts/show/" + encodeUrlPathSegment(account.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value="create", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        uiModel.addAttribute("account", new Account());
        return "backoffice/accounts/create";
    }
    
    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("result", accountService.findById(id));
        uiModel.addAttribute("itemId", id);
        return "backoffice/accounts/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(	
						@RequestParam(value = "currentPage", required = false, defaultValue="1") Integer currentPage,
						@RequestParam(value = "startNumber", required = false, defaultValue="0") Integer startNumber,					 
    					Model uiModel) {
        uiModel.addAttribute("result", accountService.findAccountEntries(currentPage, startNumber));
        return "backoffice/accounts/list";
    }
    
    @RequestMapping(value="update", method = RequestMethod.POST)
    public String update(@Valid Account account, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("account", account);
            return "backoffice/accounts/update";
        }
        uiModel.asMap().clear();
        accountService.update(account);
        return "redirect:/backoffice/accounts/show/" + encodeUrlPathSegment(account.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("account", accountService.findById(id).getAccount());
        return "backoffice/accounts/update";
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(
    		@PathVariable("id") Long id, 
			@RequestParam(value = "currentPage", required = false, defaultValue="1") Integer currentPage,
			@RequestParam(value = "startNumber", required = false, defaultValue="0") Integer startNumber,	 
    		Model uiModel) {
    	accountService.findById(id).getAccount().remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("currentPage", currentPage);
        uiModel.addAttribute("startNumber", startNumber);
        return "redirect:/backoffice/accounts";
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
