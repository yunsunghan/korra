package com.ks.code.core.flex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ks.code.analyzer.flex.FlexData;
import com.ks.code.calculator.domain.TimeAgentLog;
import com.ks.code.calculator.domain.TimeAreaLog;
import com.ks.code.calculator.domain.TimeLanguageLog;

public class FlexService {

	protected int topCount = 0;
	
    protected Date getStartDate(String dateString) {
    	Date result = null;
		try {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			result = f.parse(dateString + " 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
    }   

    protected List<FlexData> arrayProcessByTimeAgentLog(List<FlexData> result, List<TimeAgentLog> list) {
		Long timeHistory = 0L;
		int count = 0;
		FlexData flex = null;
		String titleHistory = null;
		for (TimeAgentLog target : list) {
			
			Long logTime = target.getLogTime();
			Long logCount = target.getCount();
			String title = target.getAgent();
    		// 처음 시작 할때-------------------------------------------  
    		if(timeHistory.equals(0L)){
    			flex = new FlexData();
    			flex.setTime(logTime);
    			flex.setCount1(logCount);
    			flex.setCountName1(title);
    			flex.setThisCount(1); 
    			count++;
    		}else{
    			if(!timeHistory.equals(logTime)){
    				result.add(flex);
    				flex = new FlexData();
    				flex.setTime(logTime);
    				flex.setCount1(logCount);	
    				flex.setCountName1(title);
    				flex.setThisCount(1); 
    			}else{
    				flex = setCounts(count, flex, logCount, title,titleHistory);
    			}
    			count++;
    		}
    		timeHistory = logTime;
    		titleHistory = title;
		}
		result.add(flex); // 마지막 저장
		return result;
	}
    protected List<FlexData> arrayProcessByTimeLanguageLog(List<FlexData> result, List<TimeLanguageLog> list) {
		Long timeHistory = 0L;
		int count = 0;
		FlexData flex = null;
		String titleHistory = null;
    	for (TimeLanguageLog target : list) {
    		
    		Long logTime = target.getLogTime();
    		Long logCount = target.getCount();
    		String title = target.getLanguage();
    		
    		// 처음 시작 할때-------------------------------------------  
    		if(timeHistory.equals(0L)){
    			flex = new FlexData();
    			flex.setTime(logTime);
    			flex.setCount1(logCount);
    			flex.setCountName1(title);
    			flex.setThisCount(1); 
    			count++;
    		}else{
    			if(!timeHistory.equals(logTime)){
    				result.add(flex);
    				flex = new FlexData();
    				flex.setTime(logTime);
    				flex.setCount1(logCount);	
    				flex.setCountName1(title);
    				flex.setThisCount(1); 
    			}else{
    				flex = setCounts(count, flex, logCount, title,titleHistory);
    			}
    			count++;
    		}
    		timeHistory = logTime;
    		titleHistory = title;
    	}
    	result.add(flex); // 마지막 저장
    	return result;
    }
    protected List<FlexData> arrayProcessByTimeAreaLog(List<FlexData> result, List<TimeAreaLog> list) {
		Long timeHistory = 0L;
		int count = 0;
		FlexData flex = null;
		String titleHistory = null;
    	for (TimeAreaLog target : list) {
    		
    		Long logTime = target.getLogTime();
    		Long logCount = target.getCount();
    		String title = target.getAreaIp();
    		// 처음 시작 할때-------------------------------------------  
    		if(timeHistory.equals(0L)){
    			flex = new FlexData();
    			flex.setTime(logTime);
    			flex.setCount1(logCount);
    			flex.setCountName1(title);
    			flex.setThisCount(1); 
    			count++;
    		}else{
    			if(!timeHistory.equals(logTime)){
    				result.add(flex);
    				flex = new FlexData();
    				flex.setTime(logTime);
    				flex.setCount1(logCount);	
    				flex.setCountName1(title);
    				flex.setThisCount(1); 
    			}else{
    				flex = setCounts(count, flex, logCount, title,titleHistory);
    			}
    			count++;
    		}
    		timeHistory = logTime;
    		titleHistory = title;
    	}
    	result.add(flex); // 마지막 저장
    	return result;
    }

	private FlexData setCounts(int count, FlexData flex, Long logCount, String title, String titleHistory) {
		boolean updatable=false;
		if(titleHistory.equals(title)){ // update
			updatable = true;
		}else{
			flex.setThisCount(flex.getThisCount() + 1);
			if(topCount < flex.getThisCount())topCount = flex.getThisCount();
		}
		
		switch(flex.getThisCount()){
			case(1):
				if(updatable){
					flex.setCount1(flex.getCount1() + logCount);
				}else{
					flex.setCount1(logCount);
					flex.setCountName1(title);
				}
			break;
			case(2):
				if(updatable){
					flex.setCount2(flex.getCount2() + logCount);
				}else{
					flex.setCount2(logCount);
					flex.setCountName2(title);
				}
			break;
			case(3):
				if(updatable){
					flex.setCount3(flex.getCount3() + logCount);
				}else{
					flex.setCount3(logCount);
					flex.setCountName3(title);
				}
			break;
			case(4):
				if(updatable){
					flex.setCount4(flex.getCount4() + logCount);
				}else{
					flex.setCount4(logCount);
					flex.setCountName4(title);
				}
			break;
			case(5):
				if(updatable){
					flex.setCount5(flex.getCount5() + logCount);
				}else{
					flex.setCount5(logCount);
					flex.setCountName5(title);
				}
			break;
			case(6):
				if(updatable){
					flex.setCount6(flex.getCount6() + logCount);
				}else{
					flex.setCount6(logCount);
					flex.setCountName6(title);
				}
			break;
			case(7):
				if(updatable){
					flex.setCount7(flex.getCount7() + logCount);
				}else{
					flex.setCount7(logCount);
					flex.setCountName7(title);
				}
			break;
			case(8):
				if(updatable){
					flex.setCount8(flex.getCount8() + logCount);
				}else{
					flex.setCount8(logCount);
					flex.setCountName8(title);
				}
			break;
			case(9):
				if(updatable){
					flex.setCount9(flex.getCount9() + logCount);
				}else{
					flex.setCount9(logCount);
					flex.setCountName9(title);
				}
			break;
			default :
				if(flex.getCount10() == null) flex.setCount10(0L);
				if(updatable){
					flex.setCount10(flex.getCount10() + logCount);
				}else{
					flex.setCount10(flex.getCount10() + logCount);// 누적
					flex.setCountName10("ETC");
				}
				break;
		}
		return flex;
	}    
}
