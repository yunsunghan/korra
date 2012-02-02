package com.ks.code.date.gmt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		})
public class GMTControllerTest {

	@Test
	public void gmtTest(){
		 Date date = new Date();
		 Date date2 = new Date();
//		 
//		 System.out.println("------------------------------------");
//		 System.out.println(getGmtDateFromTimeZone(new Date(),"JST"));
//		 System.out.println("------------------------------------");
//		 System.out.println(getGmtDate(new Date()));
//		 System.out.println("------------------------------------");
//		 System.out.println(date);
//		 System.out.println("====================================");
		 
		 System.out.println("getGmtDateFromTimeZone : " + getGmtDateFromTimeZone(date,"GMT"));
		 System.out.println("cvtToGmt : " + cvtToGmt(date));
		 System.out.println("getGmtDate : " + getGmtDate(date));
		 System.out.println("getCal : " + getCal(date));
		 System.out.println("현재 : " + date);
		 System.out.println("====================================");
	}
	
	private Date getGmtDateFromTimeZone(Date date, String timeZoneString){
		Date parseDate = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		TimeZone tz = TimeZone.getTimeZone(timeZoneString);
		df.setTimeZone(tz);
		String format = df.format(date);
		System.out.println("--------->"+format);
		format = format.substring(0, 20) + "GMT";
		try {
			parseDate = df.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parseDate;
	}
	private Date getGmtDate(Date date){
		Date parseDate = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		TimeZone tz = TimeZone.getTimeZone("GMT");
		df.setTimeZone(tz);
		String format = df.format(date);
		//format = format.substring(0, 20) + "GMT";
		System.out.println("==--------->"+format);
		try {
			df.setTimeZone(TimeZone.getTimeZone("GMT"));
			parseDate = df.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parseDate;
	}
	private Date cvtToGmt( Date date )
	{
	   TimeZone tz = TimeZone.getDefault();
	   Date ret = new Date( date.getTime() - tz.getRawOffset() );

	   // if we are now in DST, back off by the delta.  Note that we are checking the GMT date, this is the KEY.
	   if ( tz.inDaylightTime( ret ))
	   {
	      Date dstDate = new Date( ret.getTime() - tz.getDSTSavings() );

	      // check to make sure we have not crossed back into standard time
	      // this happens when we are on the cusp of DST (7pm the day before the change for PDT)
	      if ( tz.inDaylightTime( dstDate ))
	      {
	         ret = dstDate;
	      }
	   }

	   return ret;
	}	
	
	public Date getCal(Date pDate){
		java.text.SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		java.util.Calendar cal = Calendar.getInstance(new SimpleTimeZone(0, "GMT"));
		format.setCalendar(cal);
		java.util.Date date = null;
		try {
			date = format.parse(format.format(pDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
