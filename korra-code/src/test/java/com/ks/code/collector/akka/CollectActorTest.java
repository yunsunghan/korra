package com.ks.code.collector.akka;


import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import akka.actor.TypedActor;

import com.ks.code.analyzer.service.LawLogFixture;
import com.ks.code.calculator.service.TimeAgentLogService;
import com.ks.code.calculator.service.TimeAreaLogService;
import com.ks.code.calculator.service.TimeLanguageLogService;
import com.ks.code.collector.domain.RawLog;
import com.ks.code.collector.service.CollectorService;
import com.ks.code.creator.domain.CodeCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		})
@Transactional
public class CollectActorTest {
	
//	@Autowired private TypedActorConfigurator googleSupervisor;

	@Autowired private CollectActor collectActor;
	@Autowired private TimeAgentLogService timeAgentLogService;
	@Autowired private TimeAreaLogService timeAreaLogService;
	@Autowired private TimeLanguageLogService timeLanguageLogService;
	
	private CodeCreator codeCreator;
	private RawLog codeLog;
	
	@Test
	public void testDI(){
		assertNotNull(collectActor);
		
	}

//	@Repeat(10)
	@Test
	public void non_blocking(){
		codeLog = LawLogFixture.get();
		collectActor.setTimeAgentLogService(timeAgentLogService);
		collectActor.setTimeAreaLogService(timeAreaLogService);
		collectActor.setTimeLanguageLogService(timeLanguageLogService);
		
		codeCreator = CodeCreator.findCodeCreatorsByShortUrlEquals("B").getSingleResult();
		codeLog.setCodeCreatorId(codeCreator.getId()); // id 전달
		codeLog.setWriteDate(new Date());
		
		System.out.println("1) start 1111111111111111111111111111111111111111");
		collectActor.collectNonBlocking(codeLog);
		System.out.println("1) end 1111111111111111111111111111111111111111");		
	}
//	@Repeat(10)
	@Test
	public void blocking(){
		codeLog = LawLogFixture.get();
		collectActor.setTimeAgentLogService(timeAgentLogService);
		collectActor.setTimeAreaLogService(timeAreaLogService);
		collectActor.setTimeLanguageLogService(timeLanguageLogService);
		
		codeCreator = CodeCreator.findCodeCreatorsByShortUrlEquals("B").getSingleResult();
		codeLog.setCodeCreatorId(codeCreator.getId()); // id 전달
		codeLog.setWriteDate(new Date());		
		String shortUrl = codeCreator.getShortUrl();
		String contentsUrl = null;
		
		System.out.println("1) start 1111111111111111111111111111111111111111");
		contentsUrl = collectActor.collectBlocking(codeLog, shortUrl);
		System.out.println(contentsUrl);
		System.out.println("1) end 1111111111111111111111111111111111111111");
	}

	@Test
	public void non_spring_non_blocking() throws InterruptedException{
		CollectActor actor = TypedActor.newInstance(CollectActor.class,CollectActorImpl.class);
		actor.setTimeAgentLogService(timeAgentLogService);
		actor.setTimeAreaLogService(timeAreaLogService);
		actor.setTimeLanguageLogService(timeLanguageLogService);
		int count = 1;
		do{
		System.out.println(count + ") start...");
			Thread.sleep(10);
			RawLog codeLog = LawLogFixture.get();
			CodeCreator codeCreator = CodeCreator.findCodeCreatorsByShortUrlEquals("B").getSingleResult();
			codeLog.setCodeCreatorId(codeCreator.getId()); // id 전달
			codeLog.setWriteDate(new Date());
			actor.collectNonBlocking(codeLog);
			count++;
		}while(count < 6);
		TypedActor.stop(actor);
	}	
	@Test
	public void spring_non_blocking() throws InterruptedException{
		collectActor.setTimeAgentLogService(timeAgentLogService);
		collectActor.setTimeAreaLogService(timeAreaLogService);
		collectActor.setTimeLanguageLogService(timeLanguageLogService);
		int count = 1;
		do{
			System.out.println(count + ") start...");
			Thread.sleep(10);
			RawLog codeLog = LawLogFixture.get();
			CodeCreator codeCreator = CodeCreator.findCodeCreatorsByShortUrlEquals("B").getSingleResult();
			codeLog.setCodeCreatorId(codeCreator.getId()); // id 전달
			codeLog.setWriteDate(new Date());
			collectActor.collectNonBlocking(codeLog);
			count++;
		}while(count < 6);
		TypedActor.stop(collectActor);
	}	
}
