package com.ks.code.account.service;

import com.ks.code.account.domain.Account;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class AccountServiceResult {
	
	private Account account;
	private List<Account> accountList;
	private Long count;
	private String pageView;
	
	public AccountServiceResult() {
	}
	public AccountServiceResult(Account account) {
		this.account = account;
	}
	public AccountServiceResult(List<Account> accountList, Long count, String pageView) {
		this.accountList = accountList;
		this.count = count;
		this.pageView = pageView;
	}
}
