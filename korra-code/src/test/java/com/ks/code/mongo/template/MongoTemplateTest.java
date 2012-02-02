package com.ks.code.mongo.template;

import static org.springframework.data.document.mongodb.query.Criteria.where;

import java.util.Date;

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
public class MongoTemplateTest {

	@Autowired MongoTemplate mongoTemplate;
	@Test
	public void testLog(){
		mongoTemplate.insert(new CodeLog(new ObjectId(),"MSIE", "ko-KR", "127.0.0.1", new Date(), 1L));
		CodeLog codeLog = mongoTemplate.findOne(new Query(where("userAgent").is("MSIE")), CodeLog.class);
		System.out.println(codeLog);
	}
}
