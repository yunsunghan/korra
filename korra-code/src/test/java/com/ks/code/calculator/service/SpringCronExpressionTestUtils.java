package com.ks.code.calculator.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;

public class SpringCronExpressionTestUtils {
	public static String getCronExpressionOfMethod(Class<?> targetClass, String methodName)  {
			  Method scheduledMethod;
			  try {
			   scheduledMethod = targetClass.getDeclaredMethod(methodName,
			     new Class[] {});
			  } catch (SecurityException e) {
			   throw new IllegalArgumentException("cannot access the method : " + methodName, e);
			  } catch (NoSuchMethodException e) {
			   throw new IllegalArgumentException(e);
			  }
			  Scheduled scheduleInfo = scheduledMethod.getAnnotation(Scheduled.class);
			  String cronExpression = scheduleInfo.cron();
			  return cronExpression;
			 }

			public static void assertSchedule(String cronExpression, String initialTime,
			   List<String> expectedTimeList, String datePattern) {
			  CronTrigger trigger = new CronTrigger(cronExpression);
			  Date startTime;
			  try {
			   startTime = DateUtils.parseDate(initialTime,
			     new String[] { datePattern });
			  } catch (ParseException e) {
			   throw new IllegalArgumentException("wrong date format", e);
			  }
			  SimpleTriggerContext context = new SimpleTriggerContext();
			  context.update(startTime, startTime, startTime);

			  for (String exptectedTime : expectedTimeList) {
			   Date nextExecutionTime = trigger.nextExecutionTime(context);
			   String actualTime = DateFormatUtils.format(nextExecutionTime,
			     datePattern);
			   assertThat("executed on expected time", actualTime, is(exptectedTime));
			   context.update(nextExecutionTime, nextExecutionTime, nextExecutionTime);
			  }
			 }
}
