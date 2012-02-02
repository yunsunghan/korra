package com.ks.code.calculator.service;

import com.ks.code.calculator.domain.WeekAreaLog;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class WeekAreaLogServiceResult {
	
	private WeekAreaLog weekarealog;
	private List<WeekAreaLog> weekarealogList;
	private Long count;
	private String pageView;
	
	public WeekAreaLogServiceResult() {
	}
	public WeekAreaLogServiceResult(WeekAreaLog weekarealog) {
		this.weekarealog = weekarealog;
	}
	public WeekAreaLogServiceResult(List<WeekAreaLog> weekarealogList, Long count, String pageView) {
		this.weekarealogList = weekarealogList;
		this.count = count;
		this.pageView = pageView;
	}
}
