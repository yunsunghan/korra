package com.ks.code.creator.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ks.code.core.write.CodeCreatorFixture;
import com.ks.code.creator.domain.CodeCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		})
public class CreatorServiceTest {

	@Autowired CreatorService creatorService;
	
	@Test
	public void testDI(){
		Assert.assertNotNull(creatorService);
	}
	@Test
	public void testSave(){
		CodeCreator codeCreator = CodeCreatorFixture.get();
		creatorService.save(codeCreator);
		Assert.assertNotNull(creatorService);
	}
}
