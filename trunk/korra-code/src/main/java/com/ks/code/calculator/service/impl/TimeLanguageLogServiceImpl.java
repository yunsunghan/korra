package com.ks.code.calculator.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.calculator.domain.TimeLanguageLog;
import com.ks.code.calculator.service.TimeLanguageLogService;
import com.ks.code.calculator.service.TimeLanguageLogServiceResult;

@Service
@Transactional
public class TimeLanguageLogServiceImpl implements TimeLanguageLogService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@TriggersRemove(cacheName = {"analyzer.timelog"}, when = com.googlecode.ehcache.annotations.When.AFTER_METHOD_INVOCATION, removeAll = true)
	@Override
	public void save(TimeLanguageLog timelanguagelog) {
		Long count = TimeLanguageLog.findByCodeCreatorIdAndLanguageAndLogTimeCount(timelanguagelog.getCodeCreatorId(), timelanguagelog.getLanguage(), timelanguagelog.getLogTime());
		if(count <= 0L){
			timelanguagelog.persist();
		}else{
			TimeLanguageLog timeLanguageLog = TimeLanguageLog.findByCodeCreatorIdAndLanguageAndLogTime(timelanguagelog.getCodeCreatorId(), timelanguagelog.getLanguage(), timelanguagelog.getLogTime());
			timeLanguageLog.setCount(timeLanguageLog.getCount() + 1);
			timeLanguageLog.merge();
		}
		System.out.println("[log]LanguageLog insert");
	}
	@Override
	public TimeLanguageLogServiceResult findTimeLanguageLogEntries(int currentPage, int startNumber) {
		Long count = TimeLanguageLog.countTimeLanguageLogs();
		return new TimeLanguageLogServiceResult(TimeLanguageLog.findTimeLanguageLogEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}
	@Cacheable(cacheName = "analyzer.timelog")
	@Override
	public List<TimeLanguageLog> findTimeLanguageLogsByWriteDateBetween(Date startDate, Date endDate) {
		return TimeLanguageLog.findTimeLanguageLogsByWriteDateBetween(startDate, endDate).getResultList();
	}	
}
