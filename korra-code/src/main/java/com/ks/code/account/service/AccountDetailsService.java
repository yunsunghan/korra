package com.ks.code.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ks.code.account.domain.Account;

@Component("accountDetailsService")
public class AccountDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		AccountSession accountSession = null;
		try{
			authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
			Account account  = (Account) Account.findAccountsByUserNameEquals(username).getSingleResult();
			accountSession = new AccountSession(
					account.getUserName(),
					account.getPassword(),
					enabled, 
					accountNonExpired, 
					credentialsNonExpired, 
					accountNonLocked, 
					authorities,
					account.getEmail()
					);
		}catch (Exception e) {
			throw new UsernameNotFoundException("Account user Not Founded");
		}
		return accountSession;
	}
}