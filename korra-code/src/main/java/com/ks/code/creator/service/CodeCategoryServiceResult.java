package com.ks.code.creator.service;

import com.ks.code.creator.domain.CodeCategory;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class CodeCategoryServiceResult {
	
	private CodeCategory codeCategory;
	private List<CodeCategory> codeCategoryList;
	private Long count;
	private String pageView;
	
	public CodeCategoryServiceResult() {
	}
	public CodeCategoryServiceResult(CodeCategory codecategory) {
		this.codeCategory = codecategory;
	}
	public CodeCategoryServiceResult(List<CodeCategory> codecategoryList, Long count, String pageView) {
		this.codeCategoryList = codecategoryList;
		this.count = count;
		this.pageView = pageView;
	}
}
