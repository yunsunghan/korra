package com.ks.code.creator.service;
import com.ks.code.account.domain.Account;
import com.ks.code.creator.domain.CodeCategory;

public interface CodeCategoryService {

	public CodeCategory save(CodeCategory codecategory);
	public CodeCategory update(CodeCategory codecategory);
	public void remove(CodeCategory codecategory);
	public CodeCategoryServiceResult findById(Long id);
	public CodeCategoryServiceResult findCodeCategoryEntries(Account account, int currentPage, int startNumber);
	
}
