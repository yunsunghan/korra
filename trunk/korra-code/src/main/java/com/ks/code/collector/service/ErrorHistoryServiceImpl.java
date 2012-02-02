package com.ks.code.collector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.collector.domain.aggregate.ErrorHistory;

@Service
public class ErrorHistoryServiceImpl implements ErrorHistoryService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@Override
	public ErrorHistory save(ErrorHistory errorhistory) {
		errorhistory.persist();
		return errorhistory;
	}
		
	@Override
	public ErrorHistory update(ErrorHistory errorhistory) {
		errorhistory.merge();
		return errorhistory;
	}	

	@Override
	public void remove(ErrorHistory errorhistory) {
		errorhistory.remove();
	}

	@Override
	public ErrorHistoryServiceResult findById(Long id) {
		return new ErrorHistoryServiceResult(ErrorHistory.findErrorHistory(id));
	}

	@Override
	public ErrorHistoryServiceResult findErrorHistoryEntries(int currentPage, int startNumber) {
		Long count = ErrorHistory.countErrorHistorys();
		return new ErrorHistoryServiceResult(ErrorHistory.findErrorHistoryEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}	
}
