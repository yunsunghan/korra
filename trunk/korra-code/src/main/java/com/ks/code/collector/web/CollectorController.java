package com.ks.code.collector.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ks.code.calculator.service.TimeAgentLogService;
import com.ks.code.calculator.service.TimeAreaLogService;
import com.ks.code.calculator.service.TimeLanguageLogService;
import com.ks.code.collector.akka.CollectActor;
import com.ks.code.collector.domain.RawLog;
import com.ks.code.collector.domain.repository.CodeLogRepository;
import com.ks.code.collector.service.CollectorService;
import com.ks.code.creator.domain.CodeCreator;

@Controller
public class CollectorController {

	@Autowired CollectorService collectorService;
	
	@Autowired private CollectActor collectActor;
	@Autowired private TimeAgentLogService timeAgentLogService;
	@Autowired private TimeAreaLogService timeAreaLogService;
	@Autowired private TimeLanguageLogService timeLanguageLogService;
	@Autowired private CodeLogRepository codeLogRepository;
	
	@RequestMapping(value="/collect/{shortUrl}", method = RequestMethod.GET)
	public String collect(@PathVariable("shortUrl") String shortUrl, HttpServletRequest request){
		RawLog rawLog = new RawLog();
		rawLog.setIp(request.getRemoteAddr());
		String lang = request.getHeader("accept-language");
		if( lang == null) lang = "ko-KR";
		rawLog.setAcceptLanguage(lang);
		rawLog.setUserAgent(request.getHeader("user-agent"));
		String contentsUrl = collectorService.collect(rawLog , shortUrl);
		return "redirect:"+contentsUrl;
	}
	
	
	@RequestMapping(value="/ab/{shortUrl}", method = RequestMethod.GET)
	public String akka_blocking(@PathVariable("shortUrl") String shortUrl, HttpServletRequest request){		
		RawLog rawLog = new RawLog();
		rawLog.setIp(request.getRemoteAddr());
		String lang = request.getHeader("accept-language");
		if( lang == null) lang = "ko-KR";
		rawLog.setAcceptLanguage(lang);
		rawLog.setUserAgent(request.getHeader("user-agent"));
		
		// set DI
		collectActor.setTimeAgentLogService(timeAgentLogService);
		collectActor.setTimeAreaLogService(timeAreaLogService);
		collectActor.setTimeLanguageLogService(timeLanguageLogService);
		
		// action
		String string = collectActor.collectBlocking(rawLog, shortUrl);
		return "redirect:"+string;
	}
	
	@RequestMapping(value="/an/{shortUrl}", method = RequestMethod.GET)
	public String akka_none_blocking(@PathVariable("shortUrl") String shortUrl, HttpServletRequest request){		
		RawLog rawLog = new RawLog();
		rawLog.setIp(request.getRemoteAddr());
		String lang = request.getHeader("accept-language");
		if( lang == null) lang = "ko-KR";
		rawLog.setAcceptLanguage(lang);
		rawLog.setUserAgent(request.getHeader("user-agent"));
		
		// set DI
		collectActor.setTimeAgentLogService(timeAgentLogService);
		collectActor.setTimeAreaLogService(timeAreaLogService);
		collectActor.setTimeLanguageLogService(timeLanguageLogService);
		collectActor.setCodeLogRepository(codeLogRepository);

		// logging none blocking
		CodeCreator codeCreator = CodeCreator.findCodeCreatorsByShortUrlEquals(shortUrl).getSingleResult();
		rawLog.setCodeCreatorId(codeCreator.getId()); // id 전달
		rawLog.setWriteDate(new Date());
		
		// action
		collectActor.collectNonBlocking(rawLog);
		
		return "redirect:"+codeCreator.getContentUrl();
	}
	
	
}
