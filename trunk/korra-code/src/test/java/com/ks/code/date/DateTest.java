package com.ks.code.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.ks.code.calculator.domain.TimeAgentLog;

@RunWith(JUnit4.class)
public class DateTest {

	@Test
	public void testDate(){
		SimpleDateFormat format= new SimpleDateFormat ("yyyy-MM-dd");
		SimpleDateFormat format2= new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);//하루전
		String today = format.format(calendar.getTime());
		Date date = null;
		try {
			date = format2.parse(today+" 00:00:01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String today2 = format2.format(date);
//		String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(calendar.getTime());
		System.out.println(today);
		System.out.println(new Date());
	}

}
