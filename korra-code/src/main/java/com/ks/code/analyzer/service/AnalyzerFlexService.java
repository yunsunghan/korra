package com.ks.code.analyzer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.roo.addon.RooFlexScaffold;
import org.springframework.stereotype.Component;

import com.ks.code.collector.domain.RawLog;

@RooFlexScaffold(entity = RawLog.class)
@RemotingDestination
@Component
public class AnalyzerFlexService {
	
	@Autowired AnalyzerService analyzerService;
	
	public List<RawLog> findAll(){
		return RawLog.findAllRawLogs();
	}
}
