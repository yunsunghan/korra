package com.ks.code.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.calculator.domain.WeekAreaLog;
import com.ks.code.calculator.service.WeekAreaLogService;
import com.ks.code.calculator.service.WeekAreaLogServiceResult;

@Service
public class WeekAreaLogServiceImpl implements WeekAreaLogService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@Override
	public void save(WeekAreaLog weekarealog) {
		Long count = WeekAreaLog.findByCodeCreatorIdAndAreaIpAndLogTimeCount(weekarealog.getCodeCreatorId(), weekarealog.getAreaIp(), weekarealog.getLogDay());
		if(count <= 0L){
			weekarealog.persist();			
		}else{
			WeekAreaLog agentLog = WeekAreaLog.findByCodeCreatorIdAndAreaIpAndLogTime(weekarealog.getCodeCreatorId(), weekarealog.getAreaIp(), weekarealog.getLogDay());
			agentLog.setCount(agentLog.getCount() + weekarealog.getCount());
			agentLog.merge();
		}
	}
	@Override
	public WeekAreaLogServiceResult findWeekAreaLogEntries(int currentPage, int startNumber) {
		Long count = WeekAreaLog.countWeekAreaLogs();
		return new WeekAreaLogServiceResult(WeekAreaLog.findWeekAreaLogEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}	
}
