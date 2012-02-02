// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.calculator.domain;

import com.ks.code.calculator.domain.MonthLanguageLog;
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

privileged aspect MonthLanguageLog_Roo_Entity {
    
    declare @type: MonthLanguageLog: @Entity;
    
    declare @type: MonthLanguageLog: @Table(name = "ks_month_language_log");
    
    @PersistenceContext
    transient EntityManager MonthLanguageLog.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long MonthLanguageLog.id;
    
    @Version
    @Column(name = "version")
    private Integer MonthLanguageLog.version;
    
    public Long MonthLanguageLog.getId() {
        return this.id;
    }
    
    public void MonthLanguageLog.setId(Long id) {
        this.id = id;
    }
    
    public Integer MonthLanguageLog.getVersion() {
        return this.version;
    }
    
    public void MonthLanguageLog.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void MonthLanguageLog.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void MonthLanguageLog.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            MonthLanguageLog attached = MonthLanguageLog.findMonthLanguageLog(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void MonthLanguageLog.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void MonthLanguageLog.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public MonthLanguageLog MonthLanguageLog.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        MonthLanguageLog merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager MonthLanguageLog.entityManager() {
        EntityManager em = new MonthLanguageLog().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long MonthLanguageLog.countMonthLanguageLogs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM MonthLanguageLog o", Long.class).getSingleResult();
    }
    
    public static List<MonthLanguageLog> MonthLanguageLog.findAllMonthLanguageLogs() {
        return entityManager().createQuery("SELECT o FROM MonthLanguageLog o", MonthLanguageLog.class).getResultList();
    }
    
    public static MonthLanguageLog MonthLanguageLog.findMonthLanguageLog(Long id) {
        if (id == null) return null;
        return entityManager().find(MonthLanguageLog.class, id);
    }
    
    public static List<MonthLanguageLog> MonthLanguageLog.findMonthLanguageLogEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM MonthLanguageLog o", MonthLanguageLog.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}