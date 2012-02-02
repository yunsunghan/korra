package com.ks.code.calculator.service;

import com.ks.code.calculator.domain.MonthLanguageLog;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class MonthLanguageLogServiceResult {
	
	private MonthLanguageLog monthlanguagelog;
	private List<MonthLanguageLog> monthlanguagelogList;
	private Long count;
	private String pageView;
	
	public MonthLanguageLogServiceResult() {
	}
	public MonthLanguageLogServiceResult(MonthLanguageLog monthlanguagelog) {
		this.monthlanguagelog = monthlanguagelog;
	}
	public MonthLanguageLogServiceResult(List<MonthLanguageLog> monthlanguagelogList, Long count, String pageView) {
		this.monthlanguagelogList = monthlanguagelogList;
		this.count = count;
		this.pageView = pageView;
	}
}
