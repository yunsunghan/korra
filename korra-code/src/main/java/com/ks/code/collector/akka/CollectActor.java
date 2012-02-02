package com.ks.code.collector.akka;

import com.ks.code.calculator.service.TimeAgentLogService;
import com.ks.code.calculator.service.TimeAreaLogService;
import com.ks.code.calculator.service.TimeLanguageLogService;
import com.ks.code.collector.domain.RawLog;
import com.ks.code.collector.domain.repository.CodeLogRepository;

public interface CollectActor {
	public String collectBlocking(RawLog codeLog, String shotUrl); //blocking
	public void collectNonBlocking(RawLog codeLog); // non-blocking but, controller got it for part of process
		
	public void setTimeAgentLogService(TimeAgentLogService timeAgentLogService);
	public void setTimeAreaLogService(TimeAreaLogService timeAreaLogService);
	public void setTimeLanguageLogService(TimeLanguageLogService timeLanguageLogService);
	public void setCodeLogRepository(CodeLogRepository codeLogRepository);
}
