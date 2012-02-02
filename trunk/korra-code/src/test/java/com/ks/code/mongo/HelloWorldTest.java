package com.ks.code.mongo;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.ks.code.collector.domain.CodeLog;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

@RunWith(JUnit4.class)
public class HelloWorldTest {
	
	@Test
	public void getConnection(){
		Mongo m = null;
		try {
			m = new Mongo( "localhost" , 27017 );
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException");
			e.printStackTrace();
		} catch (MongoException e) {
			System.out.println("MongoException");
			e.printStackTrace();
		}
	
		Assert.assertEquals("2.0", m.getVersion());
		System.out.println("=================================");
		System.out.println(m.getVersion());
		System.out.println("=================================");
		DB db = m.getDB("korra-code");
		Assert.assertEquals("korra-code", db.getName());
		System.out.println("=================================");
		DBObject ob = new BasicDBObject();
		ob.put("id", "1");
		ob.put("userAgent", "ETC");
		ob.put("acceptLanguage", "ko-KR");
		ob.put("ip", "127.0.0.1");
		ob.put("writeDate", new Date());
		ob.put("codeCreatorId", 1L);
		//DBCollection collection = db.createCollection("CodeLog", ob);
		//collection.insert(ob);
		Set<String> collectionNames = db.getCollectionNames();
		for(String s : collectionNames){
			System.out.println(s);
		}
		System.out.println("=================================");

		
		DBCollection collection2 = db.getCollection("CodeLog");
		DBObject findOne = collection2.findOne();
		System.out.println(findOne);
		System.out.println("=================================");
		
	}
}
