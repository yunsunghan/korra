package com.ks.code.creator.domain.aggregate;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.ks.code.creator.domain.CodeCreator;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "ks_code_file")
public class CodeFile {

	private String fileUrl; // 웹 경로
	
	private String fileDir; // 물리 경로
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private CodeCreator codeCreator;
	

}
