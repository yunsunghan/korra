package com.ks.code.calculator.service;
import com.ks.code.calculator.domain.MonthAgentLog;

public interface MonthAgentLogService {

	public void save(MonthAgentLog monthagentlog);
	public MonthAgentLogServiceResult findMonthAgentLogEntries(int currentPage, int startNumber);
	
}
