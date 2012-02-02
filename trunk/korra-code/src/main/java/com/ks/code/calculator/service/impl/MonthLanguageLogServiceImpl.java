package com.ks.code.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.calculator.domain.MonthLanguageLog;
import com.ks.code.calculator.service.MonthLanguageLogService;
import com.ks.code.calculator.service.MonthLanguageLogServiceResult;

@Service
public class MonthLanguageLogServiceImpl implements MonthLanguageLogService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@Override
	public void save(MonthLanguageLog monthlanguagelog) {
		Long count = MonthLanguageLog.findByCodeCreatorIdAndLanguageAndLogTimeCount(monthlanguagelog.getCodeCreatorId(), monthlanguagelog.getLanguage(), monthlanguagelog.getLogDay());
		if(count <= 0L){
			monthlanguagelog.persist();			
		}else{
			MonthLanguageLog agentLog = MonthLanguageLog.findByCodeCreatorIdAndLanguageAndLogTime(monthlanguagelog.getCodeCreatorId(), monthlanguagelog.getLanguage(), monthlanguagelog.getLogDay());
			agentLog.setCount(agentLog.getCount() + monthlanguagelog.getCount());
			agentLog.merge();
		}
	}
	@Override
	public MonthLanguageLogServiceResult findMonthLanguageLogEntries(int currentPage, int startNumber) {
		Long count = MonthLanguageLog.countMonthLanguageLogs();
		return new MonthLanguageLogServiceResult(MonthLanguageLog.findMonthLanguageLogEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}	
}
