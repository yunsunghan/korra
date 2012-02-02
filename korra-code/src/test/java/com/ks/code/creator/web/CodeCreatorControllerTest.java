package com.ks.code.creator.web;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import com.ks.code.core.write.CodeCreatorFixture;
import com.ks.code.creator.domain.CodeCreator;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		,"file:src/main/webapp/WEB-INF/spring/webmvc-config.xml"		
		})
public class CodeCreatorControllerTest {

	@Autowired CreatorController creatorController;

	@Test
	public void id(){
		Assert.assertNotNull(creatorController);
	}

	@Test
	public void listTest(){
		Model uiModel = new ExtendedModelMap();
		Integer currentPage=0;
		Integer startNumber=0;
		MockHttpServletRequest request = new MockHttpServletRequest();
		String list = creatorController.list(currentPage, startNumber, uiModel,request);
		assertEquals("backoffice/codecreators/list",list);
	}
	
	@Test
	public void createFormTest(){
		Model uiModel = new ExtendedModelMap();
		String view = creatorController.createForm(uiModel);
		assertEquals("backoffice/codecreators/create",view);
	}
	
	@Test
	public void createTest(){
		Model uiModel = new ExtendedModelMap();
		CodeCreator codecreator = CodeCreatorFixture.get();
		WebDataBinder binder = new WebDataBinder(codecreator, "codecreator");
		BindingResult bindingResult = binder.getBindingResult();
		HttpServletRequest httpServletRequest = new MockHttpServletRequest();
		String view = creatorController.create(codecreator, bindingResult, uiModel, httpServletRequest);
		CodeCreator result = (CodeCreator) uiModel.asMap().get("codecreator");
		assertEquals("redirect:/backoffice/codecreators/show/"+result.getId(),view);
	}
}
