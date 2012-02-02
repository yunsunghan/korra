package com.ks.code.collector.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import net.sf.javainetlocator.InetAddressLocator;
import net.sf.javainetlocator.InetAddressLocatorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ks.code.calculator.domain.TimeAgentLog;
import com.ks.code.calculator.domain.TimeAreaLog;
import com.ks.code.calculator.domain.TimeLanguageLog;
import com.ks.code.calculator.service.TimeAgentLogService;
import com.ks.code.calculator.service.TimeAreaLogService;
import com.ks.code.calculator.service.TimeLanguageLogService;
import com.ks.code.collector.domain.RawLog;
import com.ks.code.creator.domain.CodeCreator;

@Service
@Transactional
public class CollectorServiceImpl implements CollectorService {

	@Autowired private TimeAgentLogService timeAgentLogService;
	@Autowired private TimeAreaLogService timeAreaLogService;
	@Autowired private TimeLanguageLogService timeLanguageLogService;
	private String code;
	
	@Override
	public String collect(RawLog rawLog, String shortUrl) {
		
		// logging
		CodeCreator codeCreator = CodeCreator.findCodeCreatorsByShortUrlEquals(shortUrl).getSingleResult();
		rawLog.setCodeCreatorId(codeCreator.getId()); // id 전달
		rawLog.setWriteDate(new Date());
		save(rawLog);
		return codeCreator.getContentUrl();
	}

	// 여기서 분산처리해야함.(Akka)
	private void save(RawLog rawLog){
		Calendar calendar = Calendar.getInstance();
		Long logTime = (long) calendar.get(Calendar.HOUR_OF_DAY);//24시간
		Integer dayWeek = calendar.get(Calendar.DAY_OF_WEEK);//요일(1-일,2-월 .. 7-토)
		Date date = calendar.getTime(); //날짜
		
		rawLog.persist();
		timeAgentLogService.save(new TimeAgentLog(rawLog.getCodeCreatorId(), getAgent(rawLog.getUserAgent()), 1L, date, logTime));
		timeLanguageLogService.save(new TimeLanguageLog(rawLog.getCodeCreatorId(), getLanguageCode(rawLog.getAcceptLanguage()), 1L, date, logTime));
		timeAreaLogService.save(new TimeAreaLog(rawLog.getCodeCreatorId(), getCountryCode(rawLog.getIp()), 1L, date, logTime));
	}
	public void persist(RawLog rawLog){
		rawLog.persist();
	}
	// ko
	private String getLanguageCode(String language){
		code = language;
		return language.toLowerCase().substring(0,5);
	}
	// KR
	private String getCountryCode(String ip){
		String countryCode = null;
		try {
			Locale locale = InetAddressLocator.getLocale(ip);
			countryCode = locale.getCountry();
		} catch (InetAddressLocatorException e) {
			e.printStackTrace();
		} finally {
			if(countryCode == null){
				countryCode = code.toUpperCase().substring(4,5);
			}
		}
		return countryCode;
	}
	// MSIE
	private String getAgent(String agent){
		String result = "ETC";
		if(agent.indexOf("MSIE") > 0){ 
			result = "MSIE";
		}else if(agent.indexOf("Firefox/") > 0){
			result = "FIREFOX";
		}else if(agent.indexOf("Chrome/") > 0){
			result = "CHROME";
		}else if(agent.indexOf("Safari/") > 0){
			result = "SAFARI";
		}else if(agent.indexOf("Opera/") > 0){
			result = "OPERA";
		}
		return result;
	}
}
