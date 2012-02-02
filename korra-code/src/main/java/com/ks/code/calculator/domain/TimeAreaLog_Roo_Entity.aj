// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.calculator.domain;

import com.ks.code.calculator.domain.TimeAreaLog;
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

privileged aspect TimeAreaLog_Roo_Entity {
    
    declare @type: TimeAreaLog: @Entity;
    
    declare @type: TimeAreaLog: @Table(name = "ks_time_area_log");
    
    @PersistenceContext
    transient EntityManager TimeAreaLog.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long TimeAreaLog.id;
    
    @Version
    @Column(name = "version")
    private Integer TimeAreaLog.version;
    
    public Long TimeAreaLog.getId() {
        return this.id;
    }
    
    public void TimeAreaLog.setId(Long id) {
        this.id = id;
    }
    
    public Integer TimeAreaLog.getVersion() {
        return this.version;
    }
    
    public void TimeAreaLog.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void TimeAreaLog.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void TimeAreaLog.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            TimeAreaLog attached = TimeAreaLog.findTimeAreaLog(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void TimeAreaLog.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void TimeAreaLog.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public TimeAreaLog TimeAreaLog.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        TimeAreaLog merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager TimeAreaLog.entityManager() {
        EntityManager em = new TimeAreaLog().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long TimeAreaLog.countTimeAreaLogs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM TimeAreaLog o", Long.class).getSingleResult();
    }
    
    public static List<TimeAreaLog> TimeAreaLog.findAllTimeAreaLogs() {
        return entityManager().createQuery("SELECT o FROM TimeAreaLog o", TimeAreaLog.class).getResultList();
    }
    
    public static TimeAreaLog TimeAreaLog.findTimeAreaLog(Long id) {
        if (id == null) return null;
        return entityManager().find(TimeAreaLog.class, id);
    }
    
    public static List<TimeAreaLog> TimeAreaLog.findTimeAreaLogEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM TimeAreaLog o", TimeAreaLog.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
