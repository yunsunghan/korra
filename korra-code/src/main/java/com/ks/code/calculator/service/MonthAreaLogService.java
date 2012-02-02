package com.ks.code.calculator.service;
import com.ks.code.calculator.domain.MonthAreaLog;

public interface MonthAreaLogService {

	public void save(MonthAreaLog montharealog);
	public MonthAreaLogServiceResult findMonthAreaLogEntries(int currentPage, int startNumber);
	
}
