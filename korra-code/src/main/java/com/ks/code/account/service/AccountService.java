package com.ks.code.account.service;
import com.ks.code.account.domain.Account;

public interface AccountService {

	public Account save(Account account);
	public Account update(Account account);
	public void remove(Account account);
	public AccountServiceResult findById(Long id);
	public AccountServiceResult findAccountEntries(int currentPage, int startNumber);
	
}
