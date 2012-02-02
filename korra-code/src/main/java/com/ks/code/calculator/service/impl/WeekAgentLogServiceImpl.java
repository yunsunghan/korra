package com.ks.code.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.calculator.domain.WeekAgentLog;
import com.ks.code.calculator.service.WeekAgentLogService;
import com.ks.code.calculator.service.WeekAgentLogServiceResult;

@Service
public class WeekAgentLogServiceImpl implements WeekAgentLogService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@Override
	public void save(WeekAgentLog weekagentlog) {
		Long count = WeekAgentLog.findByCodeCreatorIdAndAgentAndLogTimeCount(weekagentlog.getCodeCreatorId(), weekagentlog.getAgent(), weekagentlog.getLogDay());
		if(count <= 0L){
			weekagentlog.persist();			
		}else{
			WeekAgentLog agentLog = WeekAgentLog.findByCodeCreatorIdAndAgentAndLogTime(weekagentlog.getCodeCreatorId(), weekagentlog.getAgent(), weekagentlog.getLogDay());
			agentLog.setCount(agentLog.getCount() + weekagentlog.getCount());
			agentLog.merge();
		}
	}
	@Override
	public WeekAgentLogServiceResult findWeekAgentLogEntries(int currentPage, int startNumber) {
		Long count = WeekAgentLog.countWeekAgentLogs();
		return new WeekAgentLogServiceResult(WeekAgentLog.findWeekAgentLogEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}	
}
