package com.ks.code.calculator.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.calculator.domain.TimeAgentLog;
import com.ks.code.calculator.service.TimeAgentLogService;
import com.ks.code.calculator.service.TimeAgentLogServiceResult;

@Service
@Transactional
public class TimeAgentLogServiceImpl implements TimeAgentLogService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@TriggersRemove(cacheName = {"analyzer.timelog"}, when = com.googlecode.ehcache.annotations.When.AFTER_METHOD_INVOCATION, removeAll = true) 
	@Override
	public void save(TimeAgentLog timeagentlog) {
		Long count = TimeAgentLog.findByCodeCreatorIdAndAgentAndLogTimeCount(timeagentlog.getCodeCreatorId(), timeagentlog.getAgent(), timeagentlog.getLogTime());
		if(count <= 0L){
			timeagentlog.persist();			
		}else{
			TimeAgentLog agentLog = TimeAgentLog.findByCodeCreatorIdAndAgentAndLogTime(timeagentlog.getCodeCreatorId(), timeagentlog.getAgent(), timeagentlog.getLogTime());
			agentLog.setCount(agentLog.getCount() + 1);
			agentLog.merge();
		}
		System.out.println("[log]AgentLog insert");
	}
	@Override
	public TimeAgentLogServiceResult findTimeAgentLogEntries(int currentPage, int startNumber) {
		Long count = TimeAgentLog.countTimeAgentLogs();
		return new TimeAgentLogServiceResult(TimeAgentLog.findTimeAgentLogEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}
	
	@Cacheable(cacheName = "analyzer.timelog") 
	@Override
	public List<TimeAgentLog> findTimeAgentLogsByWriteDateBetween(Date startDate, Date endDate) {
		return TimeAgentLog.findTimeAgentLogsByWriteDateBetween(startDate, endDate).getResultList();
	}
}
