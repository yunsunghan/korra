package com.ks.code.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.calculator.domain.MonthAreaLog;
import com.ks.code.calculator.service.MonthAreaLogService;
import com.ks.code.calculator.service.MonthAreaLogServiceResult;

@Service
public class MonthAreaLogServiceImpl implements MonthAreaLogService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@Override
	public void save(MonthAreaLog montharealog) {
		Long count = MonthAreaLog.findByCodeCreatorIdAndAreaIpAndLogTimeCount(montharealog.getCodeCreatorId(), montharealog.getAreaIp(), montharealog.getLogDay());
		if(count <= 0L){
			montharealog.persist();			
		}else{
			MonthAreaLog agentLog = MonthAreaLog.findByCodeCreatorIdAndAreaIpAndLogTime(montharealog.getCodeCreatorId(), montharealog.getAreaIp(), montharealog.getLogDay());
			agentLog.setCount(agentLog.getCount() + montharealog.getCount());
			agentLog.merge();
		}
	}
	@Override
	public MonthAreaLogServiceResult findMonthAreaLogEntries(int currentPage, int startNumber) {
		Long count = MonthAreaLog.countMonthAreaLogs();
		return new MonthAreaLogServiceResult(MonthAreaLog.findMonthAreaLogEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}	
}
