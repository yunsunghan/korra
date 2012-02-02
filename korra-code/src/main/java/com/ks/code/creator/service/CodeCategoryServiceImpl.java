package com.ks.code.creator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.account.domain.Account;
import com.ks.code.creator.domain.CodeCategory;

@Service
public class CodeCategoryServiceImpl implements CodeCategoryService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@Override
	public CodeCategory save(CodeCategory codecategory) {
		codecategory.persist();
		return codecategory;
	}
		
	@Override
	public CodeCategory update(CodeCategory codecategory) {
		codecategory.merge();
		return codecategory;
	}	

	@Override
	public void remove(CodeCategory codecategory) {
		codecategory.remove();
	}

	@Override
	public CodeCategoryServiceResult findById(Long id) {
		return new CodeCategoryServiceResult(CodeCategory.findCodeCategory(id));
	}

	@Override
	public CodeCategoryServiceResult findCodeCategoryEntries(Account account, int currentPage, int startNumber) {
		if(account == null) return null;
		Long count = CodeCategory.countCodeCategorys();
		return new CodeCategoryServiceResult(CodeCategory.findCodeCategoryEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}	
}
