package com.ks.code.account.domain;

import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.ks.code.creator.domain.CodeCreator;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table="ks_account", finders = { "findAccountsByUserNameEquals" })
public class Account {

    private String userName;
    private String password;
    private String email;
    @OneToMany
    private List<CodeCreator> codeCreators;
	
    
    public Account(String userName, String password, String email,
			List<CodeCreator> codeCreators) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.codeCreators = codeCreators;
	}
	public Account() {
		super();
	}
    
    
}
