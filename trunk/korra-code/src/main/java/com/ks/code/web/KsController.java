package com.ks.code.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import com.ks.code.account.domain.Account;

public class KsController {
	
	
    protected Account getAccountFromSesson(HttpServletRequest httpServletRequest) {
    	Account account = null;
    	Object attribute = httpServletRequest.getSession().getAttribute("ks_account");
    	if(attribute instanceof Account){
    		account = (Account) attribute;
    	}else{
	    	UserDetails principal = null;
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    	if (authentication != null) {
	           if(authentication.getPrincipal() instanceof UserDetails) principal = (UserDetails) authentication.getPrincipal(); 
	        }
	    	account = Account.findAccountsByUserNameEquals(principal.getUsername()).getSingleResult(); 
	    	if(account == null) throw new SessionAuthenticationException("[KorraCode] not found user info....");
	    	httpServletRequest.getSession().setAttribute("ks_account", account);
    	}
    	return account;
	}

}
