package com.ks.code.calculator.service;
import java.util.Date;
import java.util.List;

import com.ks.code.calculator.domain.TimeAreaLog;

public interface TimeAreaLogService {

	public void save(TimeAreaLog timearealog);
	public TimeAreaLogServiceResult findTimeAreaLogEntries(int currentPage, int startNumber);
	public List<TimeAreaLog> findTimeAreaLogsByWriteDateBetween(Date startDate, Date endDate);
}
