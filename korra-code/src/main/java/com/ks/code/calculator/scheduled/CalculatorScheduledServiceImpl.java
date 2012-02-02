package com.ks.code.calculator.scheduled;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ks.code.calculator.domain.MonthAgentLog;
import com.ks.code.calculator.domain.MonthAreaLog;
import com.ks.code.calculator.domain.MonthLanguageLog;
import com.ks.code.calculator.domain.TimeAgentLog;
import com.ks.code.calculator.domain.TimeAreaLog;
import com.ks.code.calculator.domain.TimeLanguageLog;
import com.ks.code.calculator.domain.WeekAgentLog;
import com.ks.code.calculator.domain.WeekAreaLog;
import com.ks.code.calculator.domain.WeekLanguageLog;
import com.ks.code.calculator.service.MonthAgentLogService;
import com.ks.code.calculator.service.MonthAreaLogService;
import com.ks.code.calculator.service.MonthLanguageLogService;
import com.ks.code.calculator.service.WeekAgentLogService;
import com.ks.code.calculator.service.WeekAreaLogService;
import com.ks.code.calculator.service.WeekLanguageLogService;
import com.ks.code.core.web.util.DateUtils;

@Component
@Transactional
public class CalculatorScheduledServiceImpl implements CalculatorScheduledService {

	@Autowired private WeekAgentLogService weekAgentLogService;
	@Autowired private WeekAreaLogService weekAreaLogService;
	@Autowired private WeekLanguageLogService weekLanguageLogService;
	
	@Autowired private MonthAgentLogService monthAgentLogService;
	@Autowired private MonthAreaLogService  monthAreaLogService;
	@Autowired private MonthLanguageLogService  monthLanguageLogService;
	
	/**
	 * 
	 * 책임 : 주(week)단위 로그를 기록한다.
	 * 
	 * - 일일 time log 를 검색하여 기록한다.  
	 * - time log의 대상은 timeAgent,timeArea,timeLang 3개를 각각의 week log 테이블에 기록한다.
	 * 
	 */
	@Override
	@Scheduled(cron = "0 31 7 * * *")
	public void weekAndMonthExecute() {
		System.out.println("@Scheduled-------------------------------------");
		Date startDay = DateUtils.getBeforeDay(-1);
		Date endDay = DateUtils.getBeforeDay(0);
		
		Date today = new Date();
		String todayString = DateUtils.getFormattedString(today, "yyyy-MM-dd");
		
		// 1) agent :: time-> week,month
		List<TimeAgentLog> timeAgentLogs = TimeAgentLog.findTimeAgentLogsByWriteDateBetween(startDay, endDay).getResultList();
		if(timeAgentLogs.size() > 0){
			for (TimeAgentLog timeAgentLog : timeAgentLogs) {
				WeekAgentLog weekagentlog = new WeekAgentLog(timeAgentLog.getCodeCreatorId(),timeAgentLog.getAgent(),timeAgentLog.getCount(),todayString, today);
				weekAgentLogService.save(weekagentlog);
				MonthAgentLog monthagentlog = new MonthAgentLog(timeAgentLog.getCodeCreatorId(),timeAgentLog.getAgent(),timeAgentLog.getCount(),todayString, today);
				monthAgentLogService.save(monthagentlog);
			}
		}
		// 2) area :: time-> week,month
		List<TimeAreaLog> timeAreaLogs = TimeAreaLog.findTimeAreaLogsByWriteDateBetween(startDay, endDay).getResultList();
		if(timeAreaLogs.size() > 0){
			for (TimeAreaLog timeAreaLog : timeAreaLogs) {
				WeekAreaLog weekarealog = new WeekAreaLog(timeAreaLog.getCodeCreatorId(),timeAreaLog.getAreaIp(),timeAreaLog.getCount(),todayString, today);
				weekAreaLogService.save(weekarealog);
				MonthAreaLog montharealog = new MonthAreaLog(timeAreaLog.getCodeCreatorId(),timeAreaLog.getAreaIp(),timeAreaLog.getCount(),todayString, today);
				monthAreaLogService.save(montharealog);				
			}
		}
		// 3) lang :: time-> week,month
		List<TimeLanguageLog> timeLanguageLogs = TimeLanguageLog.findTimeLanguageLogsByWriteDateBetween(startDay, endDay).getResultList();
		if(timeLanguageLogs.size() > 0){
			for (TimeLanguageLog timeLanguageLog : timeLanguageLogs) {
				WeekLanguageLog weeklanguagelog = new WeekLanguageLog(timeLanguageLog.getCodeCreatorId(),timeLanguageLog.getLanguage(),timeLanguageLog.getCount(),todayString, today);
				weekLanguageLogService.save(weeklanguagelog);			
				MonthLanguageLog monthlanguagelog = new MonthLanguageLog(timeLanguageLog.getCodeCreatorId(),timeLanguageLog.getLanguage(),timeLanguageLog.getCount(),todayString, today);
				monthLanguageLogService.save(monthlanguagelog);
			}
		}
	}
}
