package com.ks.code.collector.service;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ks.code.analyzer.service.LawLogFixture;
import com.ks.code.collector.domain.RawLog;
import com.ks.code.core.write.CodeCreatorFixture;
import com.ks.code.creator.domain.CodeCreator;
import com.ks.code.creator.service.support.ShortUrlUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		})
public class CollectorServiceTest {

	@Autowired CollectorService collectorService;
	private CodeCreator codeCreator;
	private RawLog codeLog;
	
	
	@Test
	public void testDI(){
		Assert.assertNotNull(collectorService);
	}
	
	@Before
	public void testSetCreator(){
		codeCreator = CodeCreatorFixture.get();
		codeCreator.persist();
		codeCreator.setShortUrl(ShortUrlUtil.base48Encode(codeCreator.getId()));
		codeCreator.merge();
		codeLog = LawLogFixture.get();
	}
	
	@Test
	public void testCollect(){
		String shotUrl = codeCreator.getShortUrl();
		String contentsUrl = collectorService.collect(codeLog, shotUrl);
		Assert.assertEquals(shotUrl+"/watch?v=PSAssbe-32g", contentsUrl);
	}
}
