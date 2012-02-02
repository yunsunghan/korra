package com.ks.code.calculator.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ks.code.calculator.domain.TimeAgentLog;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		})
public class CalculatorServiceTest {

	@Autowired TimeAgentLogService timeAgentLogService;
	
	@Test
	public void testDI(){
		Assert.assertNotNull(timeAgentLogService);
	}
	
	@Test
	public void test2Date() throws ParseException{
		SimpleDateFormat format= new SimpleDateFormat ("yyyy-MM-dd");
		SimpleDateFormat format2= new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);//하루전
		String today = format.format(calendar.getTime());
		System.out.println(today);
		Date date = format2.parse(today + " 00:00:00");
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.add(Calendar.DATE, 0);//하루전
		String today2 = format.format(calendar2.getTime());
		System.out.println(today2);
		Date date2 = format2.parse(today2 + " 00:00:00");
		
		
		List<TimeAgentLog> list = TimeAgentLog.findTimeAgentLogsByWriteDateBetween(date, date2).getResultList();
		Assert.assertNotNull(list.size());
		if(list.size() > 0){
			for (TimeAgentLog timeAgentLog : list) {
				System.out.println(timeAgentLog);
			}
		}else{
			System.out.println("no data...");
		}
	}

}
