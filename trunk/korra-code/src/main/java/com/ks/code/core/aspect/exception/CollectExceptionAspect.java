package com.ks.code.core.aspect.exception;

import java.util.Date;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ks.code.collector.domain.aggregate.ErrorHistory;

@Component
@Aspect
public class CollectExceptionAspect {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	 
	@Pointcut("execution(public * *..*.collect(..))")
	public void collectExpPointer() {}
	
	@AfterThrowing(pointcut="collectExpPointer()",throwing="ex", argNames="ex")
	public void execute(Exception ex){
		logger.info("[@AfterThrowing] Start...");
		process(ex);
		logger.info("[@AfterThrowing] End...");
	}
	
	private void process(Exception ex){
		ErrorHistory error = null;
		try {
			logger.info("[@AfterThrowing]    + entry Error History.");
			
			
			StackTraceElement[] stackTrace = ex.getStackTrace();
			StringBuffer sb = new StringBuffer();
			int count = 1;
			for (StackTraceElement stackTraceElement : stackTrace) {
				if(count < 2){
					sb.append("["+count+"]file name   : "+stackTraceElement.getFileName());
					sb.append("["+count+"]class name  : "+stackTraceElement.getClassName());
					sb.append("["+count+"]method name : "+stackTraceElement.getMethodName());
					sb.append("["+count+"]line number : "+stackTraceElement.getLineNumber());
				}
				count++;
			}
			error = new ErrorHistory(ex.getMessage(), sb.toString(), new Date(), System.getProperty("user.name"));
			error.persist();
			logger.info("[@AfterThrowing]    + Message : {}",ex.getMessage());
			logger.info("[@AfterThrowing]    + StackTrace : {}",ex.getStackTrace().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
