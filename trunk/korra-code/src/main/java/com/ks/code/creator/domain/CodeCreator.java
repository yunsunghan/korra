package com.ks.code.creator.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.ks.code.account.domain.Account;
import com.ks.code.creator.domain.aggregate.CodeFile;
import com.ks.code.creator.domain.aggregate.CodeFormatType;
import com.ks.code.template.domain.ContentPage;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "ks_code_creator", finders = { "findCodeCreatorsByShortUrlEquals" })
public class CodeCreator {
	
	@ManyToOne
	private Account account;
	
	/**
	 * 코드 입력 정보 
	 */
	private String shortUrl; // 단축URL
	
	@NotNull(message="requiared subject")
	private String subject; // 제목
	
	@NotNull(message="requiared content url")
	private String contentUrl; // 내용 연결 주소

	@NotNull
	@Enumerated(EnumType.STRING)
	private CodeFormatType codeFormat; // 코드 종류
	
	
	/**
	 * 파일 생성 정보
	 */
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="codeCreator")
    @OrderBy(value = "id desc")
	private List<CodeFile> codeFiles  = new ArrayList<CodeFile>();
	
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
	private Date writeDate; // 생성일자
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CodeCategory codeCategory;
	
	@ManyToOne
	private ContentPage contentPage; // content page
	
	/**
	 * finder
	 */
    public static List<CodeCreator> findByPages(Account account, int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CodeCreator o Where o.account = :account Order by o.id desc", CodeCreator.class)
        		.setParameter("account", account)
        		.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
	
}
