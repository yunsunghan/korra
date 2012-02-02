package com.ks.code.analyzer.service;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.ks.code.collector.domain.RawLog;

@RooJavaBean
@RooToString
public class RawLogResult {

	private RawLog rawLog;
	private List<RawLog> rawLogList;
	private Long count;
	private String pageView;
	
	public RawLogResult() {
	}

	public RawLogResult(List<RawLog> rawLogList, Long count, String pageView) {
		super();
		this.rawLogList = rawLogList;
		this.count = count;
		this.pageView = pageView;
	}
}
