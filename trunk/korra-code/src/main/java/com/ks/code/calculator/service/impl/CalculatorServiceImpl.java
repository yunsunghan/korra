package com.ks.code.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ks.code.calculator.service.CalculatorService;
import com.ks.code.calculator.service.MonthAgentLogService;
import com.ks.code.calculator.service.MonthAreaLogService;
import com.ks.code.calculator.service.MonthLanguageLogService;
import com.ks.code.calculator.service.WeekAgentLogService;
import com.ks.code.calculator.service.WeekAreaLogService;
import com.ks.code.calculator.service.WeekLanguageLogService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Autowired WeekAgentLogService weekAgentLogService;
	@Autowired WeekAreaLogService weekAreaLogService;
	@Autowired WeekLanguageLogService weekLanguageLogService;
	@Autowired MonthAgentLogService monthAgentLogService;
	@Autowired MonthAreaLogService  monthAreaLogService;
	@Autowired MonthLanguageLogService  monthLanguageLogService;
}
