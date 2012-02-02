package com.ks.code.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.account.domain.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@Override
	public Account save(Account account) {
		account.persist();
		return account;
	}
		
	@Override
	public Account update(Account account) {
		account.merge();
		return account;
	}	

	@Override
	public void remove(Account account) {
		account.remove();
	}

	@Override
	public AccountServiceResult findById(Long id) {
		return new AccountServiceResult(Account.findAccount(id));
	}

	@Override
	public AccountServiceResult findAccountEntries(int currentPage, int startNumber) {
		Long count = Account.countAccounts();
		return new AccountServiceResult(Account.findAccountEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}	
}
