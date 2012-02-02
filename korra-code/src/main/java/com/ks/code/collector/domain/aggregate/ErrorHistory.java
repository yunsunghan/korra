package com.ks.code.collector.domain.aggregate;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "ks_error_history")
public class ErrorHistory {
	
		@Type(type="text")
		private String errorMessage;     
	
		@Type(type="text")
		private String stackTrace;     
	    
		@Temporal(TemporalType.TIMESTAMP)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date writeDate;   
		
		private String summary;

		public ErrorHistory() {
			super();
		}

		public ErrorHistory(String errorMessage, String stackTrace,
				Date writeDate, String summary) {
			super();
			this.errorMessage = errorMessage;
			this.stackTrace = stackTrace;
			this.writeDate = writeDate;
			this.summary = summary;
		}
}
