package com.ks.code.collector.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ks.code.core.write.CodeCreatorFixture;
import com.ks.code.creator.domain.CodeCreator;
import com.ks.code.creator.service.support.ShortUrlUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		,"file:src/main/webapp/WEB-INF/spring/webmvc-config.xml"		
		})
public class CollectorControllerTest {

	@Autowired CollectorController collectorController;
	CodeCreator codeCreator;
	
	@Test
	public void testDI(){
		Assert.assertNotNull(collectorController);
	}
	
	@Before
	public void testSetCreator(){
		codeCreator = CodeCreatorFixture.get();
		codeCreator.persist();
		codeCreator.setShortUrl(ShortUrlUtil.base48Encode(codeCreator.getId()));
		codeCreator.merge();		
	}

	@Test
	public void collectTest(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30");
		request.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		request.addHeader("accept-encoding", "gzip,deflate,sdch");
		request.addHeader("accept-language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4");
		String shortUrl = codeCreator.getShortUrl();
		String view = collectorController.collect(shortUrl , request);
		System.out.println(view);
		Assert.assertEquals("redirect:"+codeCreator.getContentUrl(), view);
	}
	@Test
	public void abTest(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30");
		request.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		request.addHeader("accept-encoding", "gzip,deflate,sdch");
		request.addHeader("accept-language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4");
		String shortUrl = codeCreator.getShortUrl();
		String view = collectorController.akka_none_blocking(shortUrl, request);
		System.out.println(view);
		Assert.assertEquals("redirect:"+codeCreator.getContentUrl(), view);
	}
	@Test
	public void anTest(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30");
		request.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		request.addHeader("accept-encoding", "gzip,deflate,sdch");
		request.addHeader("accept-language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4");
		String shortUrl = codeCreator.getShortUrl();
		String view = collectorController.akka_blocking(shortUrl, request);
		System.out.println(view);
		Assert.assertEquals("redirect:"+codeCreator.getContentUrl(), view);
	}

}
