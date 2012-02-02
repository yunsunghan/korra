package com.ks.code.core.aspect.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ks.code.collector.domain.RawLog;

@Component
@Aspect
public class CollectLogAspect {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	 
	@Pointcut("execution(public * *..*.collect(..))")
	public void finderLogPointer() {}
	
	@Around(value="finderLogPointer() && args(codeLog, shortUrl)", argNames="pjp, codeLog, shortUrl")
	public Object execute(ProceedingJoinPoint pjp, RawLog codeLog, String shortUrl) throws Throwable {
		Object proceed = pjp.proceed(new Object[] { codeLog, shortUrl });
		logger.info("[@Around] {} Start...",proceed.getClass().getSimpleName());

		process(proceed.getClass().getSimpleName(), codeLog, shortUrl);
		
		logger.debug("[@Around]    + proceed : {}",proceed.toString());
		logger.info("[@Around] {} End...",proceed.getClass().getSimpleName());
		
		return proceed;
	}

	private void process(String fileName, RawLog codeLog, String shortUrl){
		logger.info("[@Around]     + shortUrl : {}",shortUrl);
		logger.info("[@Around]     + codeLog : {}",codeLog);
	}	
}
