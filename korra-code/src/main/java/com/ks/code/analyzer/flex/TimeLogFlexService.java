package com.ks.code.analyzer.flex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.roo.addon.RooFlexScaffold;
import org.springframework.stereotype.Service;

import com.ks.code.calculator.domain.TimeAgentLog;
import com.ks.code.calculator.domain.TimeAreaLog;
import com.ks.code.calculator.domain.TimeLanguageLog;
import com.ks.code.calculator.service.TimeAgentLogService;
import com.ks.code.calculator.service.TimeAreaLogService;
import com.ks.code.calculator.service.TimeLanguageLogService;
import com.ks.code.core.flex.FlexService;
import com.ks.code.type.domain.AgentType;
import com.ks.code.type.domain.CountryType;
import com.ks.code.type.domain.LanguageType;

@RooFlexScaffold(entity = FlexServiceResult.class)
@RemotingDestination
@Service
public class TimeLogFlexService extends FlexService {
	
	@Autowired TimeAgentLogService timeAgentLogService;
	@Autowired TimeAreaLogService timeAreaLogService;
	@Autowired TimeLanguageLogService timeLanguageLogService;
	
	public FlexServiceResult findAllAgents(String startDateString, String endDateString){
		List<FlexData> result = new ArrayList<FlexData>();
		List<TimeAgentLog> list = timeAgentLogService.findTimeAgentLogsByWriteDateBetween(getStartDate(startDateString), getStartDate(endDateString));
		return new FlexServiceResult(arrayProcessByTimeAgentLog(result, list),AgentType.findAllAgentTypes(),null,null,topCount);
	}
	public FlexServiceResult findAllAreas(String startDateString, String endDateString){
		List<FlexData> result = new ArrayList<FlexData>();
		List<TimeAreaLog> list = timeAreaLogService.findTimeAreaLogsByWriteDateBetween(getStartDate(startDateString), getStartDate(endDateString));
		return new FlexServiceResult(arrayProcessByTimeAreaLog(result, list),null,CountryType.findAllCountryTypes(),null,topCount);
	}	
	public FlexServiceResult findAllLanguages(String startDateString, String endDateString){
		List<FlexData> result = new ArrayList<FlexData>();
		List<TimeLanguageLog> list = timeLanguageLogService.findTimeLanguageLogsByWriteDateBetween(getStartDate(startDateString), getStartDate(endDateString));
		return new FlexServiceResult(arrayProcessByTimeLanguageLog(result, list),null,null,LanguageType.findAllLanguageTypes(),topCount);
	}	
}
