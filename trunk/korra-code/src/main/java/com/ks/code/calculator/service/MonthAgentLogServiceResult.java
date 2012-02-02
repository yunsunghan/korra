package com.ks.code.calculator.service;

import com.ks.code.calculator.domain.MonthAgentLog;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class MonthAgentLogServiceResult {
	
	private MonthAgentLog monthagentlog;
	private List<MonthAgentLog> monthagentlogList;
	private Long count;
	private String pageView;
	
	public MonthAgentLogServiceResult() {
	}
	public MonthAgentLogServiceResult(MonthAgentLog monthagentlog) {
		this.monthagentlog = monthagentlog;
	}
	public MonthAgentLogServiceResult(List<MonthAgentLog> monthagentlogList, Long count, String pageView) {
		this.monthagentlogList = monthagentlogList;
		this.count = count;
		this.pageView = pageView;
	}
}
