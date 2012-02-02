package com.ks.code.creator.service.support;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ShortUrlTest {

	Long[] idData = {1L,2L,3L,10L,20L,30L,100L,200L,300L,1000L,2000L,3000L,
						10000L,20000L,30000L,100000L,200000L,300000L,1000000L,2000000L,3000000L};
	
	@Test
	public void testShortUrl(){
		for (int i = 0; i < idData.length; i++) {
			String base48Encode = ShortUrlUtil.base48Encode(idData[i]);
			System.out.println(idData[i]+" = " + base48Encode);
			if(idData[i]%3 == 0){
				System.out.println("\n ------------------------------------- \n");
			}
		}
	}
}
