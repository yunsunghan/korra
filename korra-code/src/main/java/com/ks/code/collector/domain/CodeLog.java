package com.ks.code.collector.domain;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.document.mongodb.mapping.Document;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@Document(collection="CodeLog")
public class CodeLog {
	
	@Id
    private ObjectId id;
    private String userAgent;
    private String acceptLanguage;
    private String ip;
    private Date writeDate;
    private Long codeCreatorId;

    public CodeLog() {
		super();
	}
	public CodeLog(ObjectId id, String userAgent, String acceptLanguage,
			String ip, Date writeDate, Long codeCreatorId) {
		super();
		this.id = id;
		this.userAgent = userAgent;
		this.acceptLanguage = acceptLanguage;
		this.ip = ip;
		this.writeDate = writeDate;
		this.codeCreatorId = codeCreatorId;
	}
}
