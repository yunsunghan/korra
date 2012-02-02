package com.ks.code.analyzer.service;

import com.ks.code.collector.domain.RawLog;

public class LawLogFixture {

	public static RawLog get() {
		RawLog code = new RawLog();
		code.setAcceptLanguage("ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4");
		code.setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30");
		code.setIp("127.0.0.1");
		return code;
	}
	
}
