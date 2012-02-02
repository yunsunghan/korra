package com.ks.code.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.calculator.domain.MonthAgentLog;
import com.ks.code.calculator.service.MonthAgentLogService;
import com.ks.code.calculator.service.MonthAgentLogServiceResult;

@Service
public class MonthAgentLogServiceImpl implements MonthAgentLogService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@Override
	public void save(MonthAgentLog monthagentlog) {
		Long count = MonthAgentLog.findByCodeCreatorIdAndAgentAndLogTimeCount(monthagentlog.getCodeCreatorId(), monthagentlog.getAgent(), monthagentlog.getLogDay());
		if(count <= 0L){
			monthagentlog.persist();			
		}else{
			MonthAgentLog agentLog = MonthAgentLog.findByCodeCreatorIdAndAgentAndLogTime(monthagentlog.getCodeCreatorId(), monthagentlog.getAgent(), monthagentlog.getLogDay());
			agentLog.setCount(agentLog.getCount() + monthagentlog.getCount());
			agentLog.merge();
		}
	}

	@Override
	public MonthAgentLogServiceResult findMonthAgentLogEntries(int currentPage, int startNumber) {
		Long count = MonthAgentLog.countMonthAgentLogs();
		return new MonthAgentLogServiceResult(MonthAgentLog.findMonthAgentLogEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}	
}
