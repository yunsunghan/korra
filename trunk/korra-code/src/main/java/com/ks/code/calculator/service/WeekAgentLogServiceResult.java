package com.ks.code.calculator.service;

import com.ks.code.calculator.domain.WeekAgentLog;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class WeekAgentLogServiceResult {
	
	private WeekAgentLog weekagentlog;
	private List<WeekAgentLog> weekagentlogList;
	private Long count;
	private String pageView;
	
	public WeekAgentLogServiceResult() {
	}
	public WeekAgentLogServiceResult(WeekAgentLog weekagentlog) {
		this.weekagentlog = weekagentlog;
	}
	public WeekAgentLogServiceResult(List<WeekAgentLog> weekagentlogList, Long count, String pageView) {
		this.weekagentlogList = weekagentlogList;
		this.count = count;
		this.pageView = pageView;
	}
}
