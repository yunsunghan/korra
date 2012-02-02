package com.ks.code.calculator.service;

import com.ks.code.calculator.domain.MonthAreaLog;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class MonthAreaLogServiceResult {
	
	private MonthAreaLog montharealog;
	private List<MonthAreaLog> montharealogList;
	private Long count;
	private String pageView;
	
	public MonthAreaLogServiceResult() {
	}
	public MonthAreaLogServiceResult(MonthAreaLog montharealog) {
		this.montharealog = montharealog;
	}
	public MonthAreaLogServiceResult(List<MonthAreaLog> montharealogList, Long count, String pageView) {
		this.montharealogList = montharealogList;
		this.count = count;
		this.pageView = pageView;
	}
}
