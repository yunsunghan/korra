package com.ks.code.calculator.service;
import com.ks.code.calculator.domain.MonthLanguageLog;

public interface MonthLanguageLogService {

	public void save(MonthLanguageLog monthlanguagelog);
	public MonthLanguageLogServiceResult findMonthLanguageLogEntries(int currentPage, int startNumber);
	
}
