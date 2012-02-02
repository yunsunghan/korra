package com.ks.code.test.support;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext-*.xml"
//		,"file:src/main/webapp/WEB-INF/spring/webmvc-config.xml"
//		,"file:src/main/webapp/WEB-INF/spring/jersey-config.xml"
		})
//@Transactional		
public class SpringIntegrationTestSupport {
	
}
