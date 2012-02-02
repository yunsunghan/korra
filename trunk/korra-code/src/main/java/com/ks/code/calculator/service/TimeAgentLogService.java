package com.ks.code.calculator.service;
import java.util.Date;
import java.util.List;

import com.ks.code.calculator.domain.TimeAgentLog;

public interface TimeAgentLogService {

	public void save(TimeAgentLog timeagentlog);
	public TimeAgentLogServiceResult findTimeAgentLogEntries(int currentPage, int startNumber);
	public List<TimeAgentLog> findTimeAgentLogsByWriteDateBetween(Date startDate, Date endDate);
}
