package com.ks.code.calculator.service;
import com.ks.code.calculator.domain.WeekLanguageLog;

public interface WeekLanguageLogService {

	public void save(WeekLanguageLog weeklanguagelog);
	public WeekLanguageLogServiceResult findWeekLanguageLogEntries(int currentPage, int startNumber);
	
}
