// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.creator.domain;

import com.ks.code.account.domain.Account;
import com.ks.code.creator.domain.CodeCategory;
import java.lang.Long;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect CodeCategory_Roo_Finder {
    
    public static TypedQuery<CodeCategory> CodeCategory.findCodeCategorysByParentIdEqualsAndAccount(Long parentId, Account account) {
        if (parentId == null) throw new IllegalArgumentException("The parentId argument is required");
        if (account == null) throw new IllegalArgumentException("The account argument is required");
        EntityManager em = CodeCategory.entityManager();
        TypedQuery<CodeCategory> q = em.createQuery("SELECT o FROM CodeCategory AS o WHERE o.parentId = :parentId  AND o.account = :account", CodeCategory.class);
        q.setParameter("parentId", parentId);
        q.setParameter("account", account);
        return q;
    }
    
    public static TypedQuery<CodeCategory> CodeCategory.findCodeCategorysByParentIdIsNullAndAccount(Account account) {
        if (account == null) throw new IllegalArgumentException("The account argument is required");
        EntityManager em = CodeCategory.entityManager();
        TypedQuery<CodeCategory> q = em.createQuery("SELECT o FROM CodeCategory AS o WHERE o.parentId IS NULL  AND o.account = :account", CodeCategory.class);
        q.setParameter("account", account);
        return q;
    }
    
}
