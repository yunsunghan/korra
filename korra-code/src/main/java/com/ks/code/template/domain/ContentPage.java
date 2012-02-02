package com.ks.code.template.domain;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.ks.code.creator.domain.CodeCreator;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "ks_content_page")
public class ContentPage {

	@Type(type="text")
	private String context;
	
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date writeDate;
    
    @ManyToOne(fetch=FetchType.EAGER) // 역상
    public CodeCreator codeCreator;
}
