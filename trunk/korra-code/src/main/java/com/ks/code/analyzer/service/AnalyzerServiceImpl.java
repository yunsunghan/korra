package com.ks.code.analyzer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.collector.domain.RawLog;
import com.ks.code.creator.domain.CodeCreator;

@Service
@Transactional
public class AnalyzerServiceImpl implements AnalyzerService {

	@Autowired protected Paging paging;
	
	@Override
	public List<RawLog> findRawLogsByCodeCreator(CodeCreator codeCreator) {
		return RawLog.findCodeLogsByCodeCreator(codeCreator.getId()).getResultList();
	}
	
	@Override
	public RawLogResult findRawLogEntries(int currentPage, int startNumber){
		Long count = RawLog.countRawLogs();
		return new RawLogResult(RawLog.findRawLogEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	
	@Override
	public RawLog findRawLog(Long id){
		return RawLog.findRawLog(id);
	}
	
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}		
}
