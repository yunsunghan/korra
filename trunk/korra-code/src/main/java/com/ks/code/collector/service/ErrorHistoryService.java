package com.ks.code.collector.service;
import com.ks.code.collector.domain.aggregate.ErrorHistory;

public interface ErrorHistoryService {

	/**
	 * under code 
	 * auto-created by max-service addons
	 * ?•ì±… : save,update??ErrorHistoryë¥? find*??DTOë¥?..
	 */
	public ErrorHistory save(ErrorHistory errorhistory);
	public ErrorHistory update(ErrorHistory errorhistory);
	public void remove(ErrorHistory errorhistory);
	public ErrorHistoryServiceResult findById(Long id);
	public ErrorHistoryServiceResult findErrorHistoryEntries(int currentPage, int startNumber);
	
}
