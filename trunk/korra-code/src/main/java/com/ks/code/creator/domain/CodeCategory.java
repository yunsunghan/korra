package com.ks.code.creator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.ks.code.account.domain.Account;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "ks_code_category", 
			finders = { "findCodeCategorysByParentIdIsNullAndAccount", 
						"findCodeCategorysByParentIdEqualsAndAccount"})
public class CodeCategory {

    private Long parentId;

    @NotNull
    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "codeCategory")
    @OrderBy(value = "id desc")
    private Set<CodeCreator> codeCreators = new HashSet<CodeCreator>();
    
	@ManyToOne
	private Account account;
	
    public static List<CodeCategory> findCodeCategoryEntriesByAccount(Account account, int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CodeCategory o where o.account = :account", CodeCategory.class)
        		.setParameter("account", account)
        		.setFirstResult(firstResult)
        		.setMaxResults(maxResults).getResultList();
    }	
}
