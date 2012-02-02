package com.ks.code.calculator.service;
import com.ks.code.calculator.domain.WeekAreaLog;

public interface WeekAreaLogService {

	public void save(WeekAreaLog weekarealog);
	public WeekAreaLogServiceResult findWeekAreaLogEntries(int currentPage, int startNumber);
	
}
