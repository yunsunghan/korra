package com.ks.code.calculator.service;
import com.ks.code.calculator.domain.WeekAgentLog;

public interface WeekAgentLogService {

	public void save(WeekAgentLog weekagentlog);
	public WeekAgentLogServiceResult findWeekAgentLogEntries(int currentPage, int startNumber);
	
}
