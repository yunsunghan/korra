package com.ks.code.calculator.service;

import com.ks.code.calculator.domain.TimeLanguageLog;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class TimeLanguageLogServiceResult {
	
	private TimeLanguageLog timelanguagelog;
	private List<TimeLanguageLog> timelanguagelogList;
	private Long count;
	private String pageView;
	
	public TimeLanguageLogServiceResult() {
	}
	public TimeLanguageLogServiceResult(TimeLanguageLog timelanguagelog) {
		this.timelanguagelog = timelanguagelog;
	}
	public TimeLanguageLogServiceResult(List<TimeLanguageLog> timelanguagelogList, Long count, String pageView) {
		this.timelanguagelogList = timelanguagelogList;
		this.count = count;
		this.pageView = pageView;
	}
}
