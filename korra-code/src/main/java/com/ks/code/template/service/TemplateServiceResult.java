package com.ks.code.template.service;

import com.ks.code.template.domain.ContentPage;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class TemplateServiceResult {
	
	private ContentPage contentPage;
	private List<ContentPage> contentPageList;
	private Long count;
	private String pageView;
	
	public TemplateServiceResult() {
	}
	public TemplateServiceResult(ContentPage contentpage) {
		this.contentPage = contentpage;
	}
	public TemplateServiceResult(List<ContentPage> contentpageList, Long count, String pageView) {
		this.contentPageList = contentpageList;
		this.count = count;
		this.pageView = pageView;
	}
}
