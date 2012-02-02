package com.ks.code.calculator.service;

import com.ks.code.calculator.domain.TimeAgentLog;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class TimeAgentLogServiceResult {
	
	private TimeAgentLog timeagentlog;
	private List<TimeAgentLog> timeagentlogList;
	private Long count;
	private String pageView;
	
	public TimeAgentLogServiceResult() {
	}
	public TimeAgentLogServiceResult(TimeAgentLog timeagentlog) {
		this.timeagentlog = timeagentlog;
	}
	public TimeAgentLogServiceResult(List<TimeAgentLog> timeagentlogList, Long count, String pageView) {
		this.timeagentlogList = timeagentlogList;
		this.count = count;
		this.pageView = pageView;
	}
}
