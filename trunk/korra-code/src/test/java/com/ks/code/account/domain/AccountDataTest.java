package com.ks.code.account.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		})
public class AccountDataTest {

	@Test
	public void testInsertData(){
		
		Account account = new Account("admin", "1111", "admin@ks.co.kr", null);
		account.persist();
		Account account2 = new Account("user", "1111", "admin@ks.co.kr", null);
		account2.persist();
	}
}
