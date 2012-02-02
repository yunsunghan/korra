package com.ks.code.calculator.service;

import com.ks.code.calculator.domain.TimeAreaLog;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class TimeAreaLogServiceResult {
	
	private TimeAreaLog timearealog;
	private List<TimeAreaLog> timearealogList;
	private Long count;
	private String pageView;
	
	public TimeAreaLogServiceResult() {
	}
	public TimeAreaLogServiceResult(TimeAreaLog timearealog) {
		this.timearealog = timearealog;
	}
	public TimeAreaLogServiceResult(List<TimeAreaLog> timearealogList, Long count, String pageView) {
		this.timearealogList = timearealogList;
		this.count = count;
		this.pageView = pageView;
	}
}
