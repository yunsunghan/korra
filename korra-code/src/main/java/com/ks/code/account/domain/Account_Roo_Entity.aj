// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.account.domain;

import com.ks.code.account.domain.Account;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Account_Roo_Entity {
    
    declare @type: Account: @Entity;
    
    declare @type: Account: @Table(name = "ks_account");
    
    @PersistenceContext
    transient EntityManager Account.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Account.id;
    
    @Version
    @Column(name = "version")
    private Integer Account.version;
    
    public Long Account.getId() {
        return this.id;
    }
    
    public void Account.setId(Long id) {
        this.id = id;
    }
    
    public Integer Account.getVersion() {
        return this.version;
    }
    
    public void Account.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Account.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Account.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Account attached = Account.findAccount(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Account.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Account.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Account Account.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Account merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Account.entityManager() {
        EntityManager em = new Account().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Account.countAccounts() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Account o", Long.class).getSingleResult();
    }
    
    public static List<Account> Account.findAllAccounts() {
        return entityManager().createQuery("SELECT o FROM Account o", Account.class).getResultList();
    }
    
    public static Account Account.findAccount(Long id) {
        if (id == null) return null;
        return entityManager().find(Account.class, id);
    }
    
    public static List<Account> Account.findAccountEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Account o", Account.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
