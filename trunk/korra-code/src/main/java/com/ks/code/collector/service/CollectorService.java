package com.ks.code.collector.service;

import com.ks.code.collector.domain.RawLog;

public interface CollectorService {
	String collect(RawLog codeLog, String shotUrl);
	void persist(RawLog codeLog);
}
