package com.ks.code.creator.service;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.ks.code.creator.domain.CodeCategory;
import com.ks.code.creator.domain.CodeCreator;

@RooJavaBean
@RooToString
public class CreatorServiceResult {
	
	private CodeCreator codeCreator;
	private List<CodeCreator> codeCreatorList;
	private Long count;
	private String pageView;
	
	private CodeCategory codeCategory;
	private List<CodeCategory> codeCategoryList;
	
	
	public CreatorServiceResult() {
	}
	public CreatorServiceResult(CodeCreator codecreator) {
		this.codeCreator = codecreator;
	}
	public CreatorServiceResult(List<CodeCreator> codecreatorList, Long count, String pageView) {
		this.codeCreatorList = codecreatorList;
		this.count = count;
		this.pageView = pageView;
	}
}
