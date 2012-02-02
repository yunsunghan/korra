package com.ks.code.account.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		})
public class AccountServiceTest {

	@Autowired AccountService accountService;
	
	@Test
	public void idTest(){
		Assert.assertNotNull(accountService);
	}
}
