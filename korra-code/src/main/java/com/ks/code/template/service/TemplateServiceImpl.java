package com.ks.code.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.template.domain.ContentPage;

@Service
public class TemplateServiceImpl implements TemplateService {

	@Autowired protected Paging paging;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@Override
	public ContentPage save(ContentPage contentpage) {
		contentpage.persist();
		return contentpage;
	}
		
	@Override
	public ContentPage update(ContentPage contentpage) {
		contentpage.merge();
		return contentpage;
	}	

	@Override
	public void remove(ContentPage contentpage) {
		contentpage.remove();
	}

	@Override
	public TemplateServiceResult findById(Long id) {
		return new TemplateServiceResult(ContentPage.findContentPage(id));
	}

	@Override
	public TemplateServiceResult findContentPageEntries(int currentPage, int startNumber) {
		Long count = ContentPage.countContentPages();
		return new TemplateServiceResult(ContentPage.findContentPageEntries(startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}	
}
