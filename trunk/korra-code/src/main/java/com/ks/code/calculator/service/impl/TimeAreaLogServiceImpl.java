package com.ks.code.calculator.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.calculator.domain.TimeAreaLog;
import com.ks.code.calculator.service.TimeAreaLogService;
import com.ks.code.calculator.service.TimeAreaLogServiceResult;

@Service
@Transactional
public class TimeAreaLogServiceImpl implements TimeAreaLogService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@TriggersRemove(cacheName = {"analyzer.timelog"}, when = com.googlecode.ehcache.annotations.When.AFTER_METHOD_INVOCATION, removeAll = true) 
	@Override
	public void save(TimeAreaLog timearealog) {
		Long count = TimeAreaLog.findByCodeCreatorIdAndAreaIpAndLogTimeCount(timearealog.getCodeCreatorId(), timearealog.getAreaIp(), timearealog.getLogTime());
		if(count <= 0L){
		timearealog.persist();
		}else{
			TimeAreaLog areaLog = TimeAreaLog.findByCodeCreatorIdAndAreaIpAndLogTime(timearealog.getCodeCreatorId(), timearealog.getAreaIp(), timearealog.getLogTime());
			areaLog.setCount(areaLog.getCount() + 1);
			areaLog.merge();
		}
		System.out.println("[log]AreaLog insert");
	}

	@Override
	public TimeAreaLogServiceResult findTimeAreaLogEntries(int currentPage, int startNumber) {
		Long count = TimeAreaLog.countTimeAreaLogs();
		return new TimeAreaLogServiceResult(TimeAreaLog.findTimeAreaLogEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}

	@Cacheable(cacheName = "analyzer.timelog") 
	@Override
	public List<TimeAreaLog> findTimeAreaLogsByWriteDateBetween(Date startDate,	Date endDate) {
		return TimeAreaLog.findTimeAreaLogsByWriteDateBetween(startDate, endDate).getResultList();
	}	
}
