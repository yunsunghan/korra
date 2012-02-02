package com.ks.code.collector.service;

import java.util.Locale;

import net.sf.javainetlocator.InetAddressLocator;
import net.sf.javainetlocator.InetAddressLocatorException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CollectorIpTest {

	@Test
	public void testIp(){
        try {
		   // 국가정보 설정
		   Locale locale = InetAddressLocator.getLocale("211.50.8.176");    // 아이피 & 도메인 & getRemoteAddr()
		   System.out.println(locale.getCountry());
		   System.out.println(locale.getLanguage());	   
        } catch (InetAddressLocatorException e) {
            e.printStackTrace();
        }
	}
}
