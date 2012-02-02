package com.ks.code.account.service;
import java.util.Collection;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@RooJavaBean
@RooToString
public class AccountSession  extends User {

	private static final long serialVersionUID = 1L;
	
	private String loginId;
	
	private String loginPassword;
	
	private String email;
	
	

	public AccountSession(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities
			,String email) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
		this.loginId = username;
		this.loginPassword = password;
		this.email = email;
	}
	
}
