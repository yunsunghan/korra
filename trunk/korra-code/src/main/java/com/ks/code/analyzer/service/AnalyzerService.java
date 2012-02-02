package com.ks.code.analyzer.service;

import java.util.List;

import com.ks.code.collector.domain.RawLog;
import com.ks.code.creator.domain.CodeCreator;

public interface AnalyzerService {

	// flex
	List<RawLog> findRawLogsByCodeCreator(CodeCreator codeCreator);
	
	// web page
	RawLogResult findRawLogEntries(int currentPage, int startNumber);
	
	RawLog findRawLog(Long id);
}
