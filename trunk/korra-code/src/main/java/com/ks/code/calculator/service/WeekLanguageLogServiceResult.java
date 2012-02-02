package com.ks.code.calculator.service;

import com.ks.code.calculator.domain.WeekLanguageLog;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class WeekLanguageLogServiceResult {
	
	private WeekLanguageLog weeklanguagelog;
	private List<WeekLanguageLog> weeklanguagelogList;
	private Long count;
	private String pageView;
	
	public WeekLanguageLogServiceResult() {
	}
	public WeekLanguageLogServiceResult(WeekLanguageLog weeklanguagelog) {
		this.weeklanguagelog = weeklanguagelog;
	}
	public WeekLanguageLogServiceResult(List<WeekLanguageLog> weeklanguagelogList, Long count, String pageView) {
		this.weeklanguagelogList = weeklanguagelogList;
		this.count = count;
		this.pageView = pageView;
	}
}
