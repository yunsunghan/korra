package com.ks.code.calculator.flex;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ks.code.analyzer.flex.FlexData;
import com.ks.code.analyzer.flex.FlexServiceResult;
import com.ks.code.analyzer.flex.TimeLogFlexService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/applicationContext.xml"
		})
public class TimeLogFlexServiceTest {

	@Autowired TimeLogFlexService timeLogFlexService;
	
	@Test
	public void testDI(){
		Assert.assertNotNull(timeLogFlexService);
	}
	
	@Test
	public void testAgentFindAll(){
		String startDateString = "2011-08-01";
		String endDateString = "2011-08-04";
		FlexServiceResult result = timeLogFlexService.findAllAgents(startDateString, endDateString);
		List<FlexData> flexDatas = result.getFlexDatas();
		System.out.println("--------------------------------------------------");
		System.out.println(result.getTopCount());
		System.out.println("--------------------------------------------------");
		System.out.println(result.getAgentTypes());
		System.out.println("--------------------------------------------------");
		for (FlexData flexServiceResult : flexDatas) {
			System.out.println(flexServiceResult);
			System.out.println("--------------------------------------------------");
		}
		Assert.assertNotNull(flexDatas.size());
	}
	@Test
	public void testAreaFindAll(){
		String startDateString = "2011-08-01";
		String endDateString = "2011-08-04";
		FlexServiceResult result = timeLogFlexService.findAllAreas(startDateString, endDateString);
		List<FlexData> flexDatas = result.getFlexDatas();
		for (FlexData flexServiceResult : flexDatas) {
			System.out.println("========>" + flexServiceResult);
			System.out.println("--------------------------------------------------");
		}
		Assert.assertNotNull(flexDatas.size());
	}
	@Test
	public void testLangFindAll(){
		String startDateString = "2011-08-01";
		String endDateString = "2011-08-04";
		FlexServiceResult result = timeLogFlexService.findAllLanguages(startDateString, endDateString);
		List<FlexData> flexDatas = result.getFlexDatas();
		for (FlexData flexServiceResult : flexDatas) {
			System.out.println("========>" + flexServiceResult);
			System.out.println("--------------------------------------------------");
		}
		Assert.assertNotNull(flexDatas.size());
	}
}
