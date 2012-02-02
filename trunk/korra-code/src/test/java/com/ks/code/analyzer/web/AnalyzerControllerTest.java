package com.ks.code.analyzer.web;

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

import com.ks.code.analyzer.web.AnalyzerController;
import com.ks.code.core.write.CodeCreatorFixture;
import com.ks.code.creator.domain.CodeCreator;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		,"file:src/main/webapp/WEB-INF/spring/webmvc-config.xml"		
		})
public class AnalyzerControllerTest {

	@Autowired AnalyzerController loggerController;

	@Test
	public void id(){
		Assert.assertNotNull(loggerController);
	}

	@Test
	public void listTest(){
		Model uiModel = new ExtendedModelMap();
		Integer currentPage=0;
		Integer startNumber=0;
		MockHttpServletRequest request = new MockHttpServletRequest();
		String list = loggerController.list(currentPage, startNumber, uiModel);
		assertEquals("backoffice/analyzer/list",list);
	}
}
