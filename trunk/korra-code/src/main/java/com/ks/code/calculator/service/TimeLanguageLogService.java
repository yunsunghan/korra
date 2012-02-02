package com.ks.code.calculator.service;
import java.util.Date;
import java.util.List;

import com.ks.code.calculator.domain.TimeLanguageLog;

public interface TimeLanguageLogService {

	public void save(TimeLanguageLog timelanguagelog);
	public TimeLanguageLogServiceResult findTimeLanguageLogEntries(int currentPage, int startNumber);
	public List<TimeLanguageLog> findTimeLanguageLogsByWriteDateBetween(Date startDate,	Date endDate);
}
