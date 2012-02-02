package com.ks.code.core.write;

import com.ks.code.creator.domain.CodeCreator;
import com.ks.code.creator.domain.aggregate.CodeFormatType;

public class CodeCreatorFixture {

	public static CodeCreator get() {
		String url = "www.youtube.com";
		CodeCreator codeCreator = new CodeCreator();
		codeCreator.setShortUrl(url);
		codeCreator.setSubject("bbbbbbbbb");
		codeCreator.setCodeFormat(CodeFormatType.QR_CODE);
		codeCreator.setContentUrl(url+"/watch?v=PSAssbe-32g");
		return codeCreator;
	}

}
