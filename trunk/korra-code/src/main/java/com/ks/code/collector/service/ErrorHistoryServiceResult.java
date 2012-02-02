package com.ks.code.collector.service;

import com.ks.code.collector.domain.aggregate.ErrorHistory;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class ErrorHistoryServiceResult {
	
	private ErrorHistory errorHistory;
	private List<ErrorHistory> errorHistoryList;
	private Long count;
	private String pageView;
	
	public ErrorHistoryServiceResult() {
	}
	public ErrorHistoryServiceResult(ErrorHistory errorhistory) {
		this.errorHistory = errorhistory;
	}
	public ErrorHistoryServiceResult(List<ErrorHistory> errorhistoryList, Long count, String pageView) {
		this.errorHistoryList = errorhistoryList;
		this.count = count;
		this.pageView = pageView;
	}
}
