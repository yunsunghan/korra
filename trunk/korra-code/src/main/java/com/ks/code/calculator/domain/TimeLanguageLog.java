package com.ks.code.calculator.domain;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "ks_time_language_log")
public class TimeLanguageLog {

    @NotNull
    private Long codeCreatorId;

    @NotNull
    private String language;

    @NotNull
    private Long count;

    @NotNull
    private Long logTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "yyyy-MM-dd hh:mm:ss")
    private Date writeDate;

    public TimeLanguageLog() {
        super();
    }

    public TimeLanguageLog(Long codeCreatorId, String language, Long count, Date writeDate, Long logTime) {
        super();
        this.codeCreatorId = codeCreatorId;
        this.language = language;
        this.count = count;
        this.writeDate = writeDate;
        this.logTime = logTime;
    }

    public static TimeLanguageLog findByCodeCreatorIdAndLanguageAndLogTime(Long codeCreatorId, String language, Long logTime) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (language == null) throw new IllegalArgumentException("The langugage argument is required");
        if (logTime == null) throw new IllegalArgumentException("The logTime argument is required");
        return entityManager().createQuery("SELECT o FROM TimeLanguageLog AS o WHERE o.codeCreatorId = :codeCreatorId And o.language=:language AND logTime=:logTime", TimeLanguageLog.class).setParameter("codeCreatorId", codeCreatorId).setParameter("language", language).setParameter("logTime", logTime).getSingleResult();
    }

    public static Long findByCodeCreatorIdAndLanguageAndLogTimeCount(Long codeCreatorId, String language, Long logTime) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (language == null) throw new IllegalArgumentException("The langugage argument is required");
        if (logTime == null) throw new IllegalArgumentException("The logTime argument is required");
        return entityManager().createQuery("SELECT count(o) FROM TimeLanguageLog AS o WHERE o.codeCreatorId = :codeCreatorId And o.language=:language AND logTime=:logTime", Long.class).setParameter("codeCreatorId", codeCreatorId).setParameter("language", language).setParameter("logTime", logTime).getSingleResult();
    }
    public static TypedQuery<TimeLanguageLog> findTimeLanguageLogsByWriteDateBetween(Date minWriteDate, Date maxWriteDate) {
        if (minWriteDate == null) throw new IllegalArgumentException("The minWriteDate argument is required");
        if (maxWriteDate == null) throw new IllegalArgumentException("The maxWriteDate argument is required");
        EntityManager em = TimeLanguageLog.entityManager();
        TypedQuery<TimeLanguageLog> q = em.createQuery("SELECT o FROM TimeLanguageLog AS o WHERE o.writeDate BETWEEN :minWriteDate AND :maxWriteDate  Order by logTime asc, language asc", TimeLanguageLog.class);
        q.setParameter("minWriteDate", minWriteDate);
        q.setParameter("maxWriteDate", maxWriteDate);
        return q;
    }    
}
