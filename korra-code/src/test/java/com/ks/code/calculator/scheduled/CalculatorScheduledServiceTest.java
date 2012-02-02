package com.ks.code.calculator.scheduled;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		})
public class CalculatorScheduledServiceTest {

	@Autowired CalculatorScheduledService calculatorScheduledService;
	
	@Test
	public void testDI(){
		Assert.assertNotNull(calculatorScheduledService);
	}
	
	@Test
	public void testWeekExecute(){

	}
	
	@Test
	public void testMonthExecute(){
		
	}
}
