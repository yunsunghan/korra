package com.ks.code.collector.domain.repository;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ks.code.collector.domain.CodeLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext-mongo.xml"
		})
public class CodeLogRepositoryTest {

	@Autowired CodeLogRepository codeLogRepository;
	@Autowired MongoTemplate mongoTemplate;
	String id = null;
	@Test
	public void findAll(){
		Assert.assertNotNull(codeLogRepository);
		List<CodeLog> findAll = codeLogRepository.findAll();
		System.out.println("---------------------------"+findAll.size());
		for(CodeLog c : findAll){
			System.out.println(c);
			System.out.println("---------------------------");
			id = c.getId().toString();
		}
	}
	
	@Test
	public void findOne(){
		List<CodeLog> findAll = codeLogRepository.findAll();
		String id = null;
		for(CodeLog c : findAll){
			id = c.getId().toString();
			break;
		}
		CodeLog codeLog = codeLogRepository.findOne(id);
		System.out.println("---------------------------");
		System.out.println(codeLog);
		System.out.println("---------------------------");
	}
	
	@Test
	public void save(){
		Assert.assertNotNull(codeLogRepository);
		for(int i=0; i < 2; i++){
			CodeLog codeLog = new CodeLog(new ObjectId(),"MSIE", "ko-KR", "127.0.0.1", new Date(), 1L);
			Assert.assertEquals("MSIE",codeLogRepository.save(codeLog).getUserAgent());
		}
		System.out.println("---------------------------");
		System.out.println(codeLogRepository.count());
		System.out.println("---------------------------");
	}
}
