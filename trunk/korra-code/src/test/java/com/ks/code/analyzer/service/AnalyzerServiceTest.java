package com.ks.code.analyzer.service;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ks.code.analyzer.service.AnalyzerService;
import com.ks.code.collector.domain.RawLog;
import com.ks.code.core.write.CodeCreatorFixture;
import com.ks.code.creator.domain.CodeCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		})
@Transactional
public class AnalyzerServiceTest {

	@Autowired AnalyzerService analyzerService;
	private CodeCreator codeCreator;
	private RawLog rawLog;
	
	@Test
	public void testDI(){
		Assert.assertNotNull(analyzerService);
	}
	
	@Before
	public void testSetCreator(){
		codeCreator = CodeCreatorFixture.get();
		codeCreator.persist();
		rawLog = LawLogFixture.get();
		rawLog.setCodeCreatorId(codeCreator.getId());
		rawLog.setWriteDate(new Date());
		rawLog.persist();
	}
	
	@Test
	public void testSave(){
		List<RawLog> codLogs = analyzerService.findRawLogsByCodeCreator(codeCreator);
		for (RawLog codeLog : codLogs) {
			System.out.println(codeLog);
		}
		Assert.assertNotNull(codLogs.size());
	}
}
