package com.ks.code.core.web.util;

import java.util.*;

public class CalendarUtils {

	private GregorianCalendar gCalendar = new GregorianCalendar(Locale.KOREAN);
	private int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
	private int year = 2007;
	private int month = 8;
	
	public CalendarUtils(int year, int month){
		this.year = year;
		this.month = --month;
		
		gCalendar.setTime(new Date());
		gCalendar.set(Calendar.YEAR, this.year);
		gCalendar.set(Calendar.MONTH, this.month);
		
		if(gCalendar.isLeapYear(this.year))
			daysInMonth[1] = 29;		
	}
	
	public CalendarUtils(String year, String month){
		this(Integer.parseInt(year), Integer.parseInt(month));
	}	
		
	// 해당월 1일의 요일
	public int getFirstDayOfMonth(){
		gCalendar.set(Calendar.DATE, 1);
		return gCalendar.get(Calendar.DAY_OF_WEEK);
	}

	// 월별 일수
	public int getDaysOfMonth(){
		return daysInMonth[this.month];
	}
	
	public void increamentMonth(){
		if(this.month == 11){
			this.month = -1;
			gCalendar.set(Calendar.YEAR, ++this.year);
		}
		gCalendar.set(Calendar.MONTH, ++this.month);
	}
	
	public void decreamentMonth(){
		if(this.month == 0){
			this.month = 12;
			gCalendar.set(Calendar.YEAR, --this.year);
		}
		gCalendar.set(Calendar.MONTH, --this.month);		
	}
	
	public int getYear(){
		return  this.year;
	}
	
	public int getMonth(){
		return this.month+1;
	}

	public String getStrYear(){
		return ""+this.year;
	}
	
	public String getStrMonth(){
		String retVal = "";
		int temp = getMonth();
		if(temp < 10) 
			retVal = "0"+temp;
		else 
			retVal = "" + temp;
		return 	retVal;
	}
}
