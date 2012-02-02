package com.ks.code.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.calculator.domain.WeekLanguageLog;
import com.ks.code.calculator.service.WeekLanguageLogService;
import com.ks.code.calculator.service.WeekLanguageLogServiceResult;

@Service
public class WeekLanguageLogServiceImpl implements WeekLanguageLogService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@Override
	public void save(WeekLanguageLog weeklanguagelog) {
		Long count = WeekLanguageLog.findByCodeCreatorIdAndLanguageAndLogTimeCount(weeklanguagelog.getCodeCreatorId(), weeklanguagelog.getLanguage(), weeklanguagelog.getLogDay());
		if(count <= 0L){
			weeklanguagelog.persist();			
		}else{
			WeekLanguageLog agentLog = WeekLanguageLog.findByCodeCreatorIdAndLanguageAndLogTime(weeklanguagelog.getCodeCreatorId(), weeklanguagelog.getLanguage(), weeklanguagelog.getLogDay());
			agentLog.setCount(agentLog.getCount() + weeklanguagelog.getCount());
			agentLog.merge();
		}
	}
	@Override
	public WeekLanguageLogServiceResult findWeekLanguageLogEntries(int currentPage, int startNumber) {
		Long count = WeekLanguageLog.countWeekLanguageLogs();
		return new WeekLanguageLogServiceResult(WeekLanguageLog.findWeekLanguageLogEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}	
}
