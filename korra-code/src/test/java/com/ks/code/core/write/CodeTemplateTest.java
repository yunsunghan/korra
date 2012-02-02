package com.ks.code.core.write;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ks.code.core.writer.CodeTemplate;
import com.ks.code.creator.domain.CodeCreator;
import com.ks.code.creator.domain.aggregate.CodeFormatType;
import com.ks.code.creator.domain.aggregate.CodeSizeType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/applicationContext.xml"
		})
public class CodeTemplateTest {

	@Autowired private CodeTemplate codeTemplate;
	
	@Test
	public void idTest(){
		Assert.assertNotNull(codeTemplate);
	}
	@Test
	public void codeCreatorTest(){
		CodeCreator codeCreator = CodeCreatorFixture.get();
		CodeCreator write = codeTemplate.write(codeCreator);
		System.out.println("===============================");
		System.out.println(write);
		System.out.println("===============================");
		Assert.assertNotNull(write);
	}
}
