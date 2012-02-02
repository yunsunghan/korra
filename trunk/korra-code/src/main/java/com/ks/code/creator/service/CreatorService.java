package com.ks.code.creator.service;
import com.ks.code.account.domain.Account;
import com.ks.code.creator.domain.CodeCreator;

public interface CreatorService {

	public CodeCreator save(CodeCreator codecreator);
	public CodeCreator update(CodeCreator codecreator);
	public void remove(CodeCreator codecreator);
	public CreatorServiceResult findById(Long id);
	public CreatorServiceResult findCodeCreatorEntries(Account account, int currentPage, int startNumber);
	
}
