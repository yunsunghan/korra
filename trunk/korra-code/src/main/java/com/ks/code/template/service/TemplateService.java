package com.ks.code.template.service;
import com.ks.code.template.domain.ContentPage;

public interface TemplateService {

	/**
	 * under code 
	 * auto-created by max-service addons
	 * ?�책 : save,update??ContentPage�? find*??DTO�?..
	 */
	public ContentPage save(ContentPage contentpage);
	public ContentPage update(ContentPage contentpage);
	public void remove(ContentPage contentpage);
	public TemplateServiceResult findById(Long id);
	public TemplateServiceResult findContentPageEntries(int currentPage, int startNumber);
	
}
