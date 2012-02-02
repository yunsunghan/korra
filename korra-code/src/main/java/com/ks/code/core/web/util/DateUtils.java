package com.ks.code.core.web.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtils {
	

	public static String getToDay(){
        return getToDayWrapper(false);
	}
	
	public static String getToDayDetail(){
        return getToDayWrapper(true);
	}
	/**
	 * 날짜변환
	 * @return
	 */
	public static String getDateView(String date,int type){
		String result = null;
		if(date.length() == 14){
			switch (type) {
			case 1:
				result = date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8)+" "+date.substring(8, 10)+":"+date.substring(10, 12)+":"+date.substring(12, 14);
				break;
	
			default:
				// YYYY-MM-DD
				result = date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8);
				break;
			}
		}else{
			// 형식이 일치하지 않습니다.
			result = "YYYY-MM-DD";
		}
        return result;
	}
	
	private static String getToDayWrapper(boolean detail){
		String strDate = null;
        Calendar calendar = Calendar.getInstance();
        int nY, nM, nD;
        nY = calendar.get(Calendar.YEAR);
        nM = calendar.get(Calendar.MONTH) + 1;
        nD = calendar.get(Calendar.DATE);
        strDate = nY+"-";
        if (nM < 10)  strDate += "0";
        strDate += nM+"-";
        if (nD < 10) strDate += "0";
        strDate += nD;
        if(detail){
        	strDate += " "+calendar.get(Calendar.HOUR_OF_DAY);
        	strDate += ":"+calendar.get(Calendar.MINUTE);
        	strDate += ":"+calendar.get(Calendar.SECOND);
        }
        return strDate;
	}
	
	/**
	 * 브라우져의 정보저장을 막기위한 파라미터 수단
	 * @return
	 */
	public static String getDummy(){
		String retVal = "";
		Calendar now = Calendar.getInstance();
		retVal += now.get(Calendar.YEAR);
		retVal += now.get(Calendar.MONTH) + 1;
		retVal += now.get(Calendar.DAY_OF_MONTH);
		retVal += now.get(Calendar.HOUR_OF_DAY);
		retVal += now.get(Calendar.MINUTE);
		retVal += now.get(Calendar.SECOND);
		
		return retVal;
	}
	
	public static String getNowDate(){
		String retVal = "";
		Calendar now = Calendar.getInstance();
		retVal += now.get(Calendar.YEAR) + "-";
		retVal += now.get(Calendar.MONTH) + 1 + "-";
		retVal += now.get(Calendar.DAY_OF_MONTH);
		
		return retVal;
	}
	
	/**
	 * yyyyMMddHHmmss 타입의 시간 정보가 하루 전인지 체크
	 * @param str_date
	 * @return
	 */
	public static boolean dateDiff(String str_date){
		boolean ret_val = false;
		str_date = StringUtils.defaultValue(str_date);
		
		Calendar tmp_calendar = string2Calendar(str_date);
		Calendar beforeOneDay = Calendar.getInstance();
		beforeOneDay.add(Calendar.DAY_OF_MONTH, -1); 
		
		ret_val = beforeOneDay.getTimeInMillis() > tmp_calendar.getTimeInMillis() ? false : true;
		
		return ret_val;
	}
	
	/**
	 * 
	 * @param date
	 * @param format "yyyyMMddHHmmss" 의 형태
	 * @return
	 */
	public static String getFormatDateTime(String date, String format) 
    {
        if (date == null  || format == null) return date;
        Calendar cal = string2Calendar(date);
        
        SimpleDateFormat df = new SimpleDateFormat(format);
        
        return df.format(cal.getTime());
    }
	
	/**
	 * 문자열을 Calendar객체로 변환 반환한다.
	 * @param date 입력되는 날짜.
	 * @return 변환된 Calendar객체
	 */
	
	private static Calendar string2Calendar(String date)
	{
		date = date.replaceAll("[-,]","");
        
        GregorianCalendar cal = new GregorianCalendar();
        
        if(date.length() >= 4)  cal.set(Calendar.YEAR, Integer.parseInt(date.substring(0, 4)));
        if(date.length() >= 6)  cal.set(Calendar.MONTH, Integer.parseInt(date.substring(4, 6)) - 1);
        if(date.length() >= 8)  cal.set(Calendar.DATE, Integer.parseInt(date.substring(6, 8)));
        if(date.length() >=10)  cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date.substring(8, 10)));
        if(date.length() >=12)  cal.set(Calendar.MINUTE, Integer.parseInt(date.substring(10, 12)));
        if(date.length() >=14)  cal.set(Calendar.SECOND, Integer.parseInt(date.substring(12, 14)));
		
		return cal;
	}
    public static String getFormattedString(Date date, String format) {
        SimpleDateFormat dform = new SimpleDateFormat(format);
        String ret = dform.format(date);
        return ret;
    }
    
    public static String getFormattedString(Calendar calendar, String format) {
        return getFormattedString(calendar.getTime(), format);
    }
    
    public static String getFormattedString(long date, String format) {
        return getFormattedString(new Date(date), format);
    }
    
    public static String getFormattedString(Date date) {
        SimpleDateFormat dform = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ret = dform.format(date);
        return ret;
    }
    public static String getFormattedStringDate(Date date) {
    	SimpleDateFormat dform = new SimpleDateFormat("yyyy-MM-dd");
    	String ret = dform.format(date);
    	return ret;
    }
    
    public static String getFormattedString(Calendar calendar) {
        return getFormattedString(calendar.getTime());
    }
    
    public static String getFormattedString(long date) {
        return getFormattedString(new Date(date));
    }
    
    public static Date getBeforeDay(int beforeCount) {
    	Date result = null;
		try {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, beforeCount);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			result = f.parse(year + "-" + month + "-" + day + " 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
    }
    
    /**
     * ex) getGmtDateFromTimeZone(new Date(),"JST")
     * @param date
     * @param timeZoneString
     * @return
     */
    public static Date getGmtDateFromTimeZone(Date date, String timeZoneString){
		Date parseDate = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		TimeZone tz = TimeZone.getTimeZone(timeZoneString);
		df.setTimeZone(tz);
		String format = df.format(date);
		format = format.substring(0, 20) + "GMT";
		try {
			parseDate = df.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parseDate;
	}
    /**
     * ex) getGmtDate(new Date())
     * @param date
     * @return
     */
    public static Date getGmtDate(Date date){
		Date parseDate = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		TimeZone tz = TimeZone.getDefault();
		df.setTimeZone(tz);
		String format = df.format(date);
		format = format.substring(0, 20) + "GMT";
		try {
			parseDate = df.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parseDate;
	}       
}
