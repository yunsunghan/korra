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
@RooJpaActiveRecord(table = "ks_time_agent_log")
public class TimeAgentLog {

    @NotNull
    private Long codeCreatorId;

    @NotNull
    private String agent;

    @NotNull
    private Long count;

    @NotNull
    private Long logTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "yyyy-MM-dd hh:mm:ss")
    private Date writeDate;

    public TimeAgentLog() {
        super();
    }

    public TimeAgentLog(Long codeCreatorId, String agent, Long count, Date writeDate, Long logTime) {
        super();
        this.codeCreatorId = codeCreatorId;
        this.agent = agent;
        this.count = count;
        this.writeDate = writeDate;
        this.logTime = logTime;
    }

    public static TimeAgentLog findByCodeCreatorIdAndAgentAndLogTime(Long codeCreatorId, String agent, Long logTime) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (agent == null) throw new IllegalArgumentException("The agent argument is required");
        if (logTime == null) throw new IllegalArgumentException("The logTime argument is required");
        return entityManager().createQuery("SELECT o FROM TimeAgentLog AS o WHERE o.codeCreatorId = :codeCreatorId AND o.agent=:agent AND logTime=:logTime ", TimeAgentLog.class)
        		.setParameter("codeCreatorId", codeCreatorId)
        		.setParameter("agent", agent)
        		.setParameter("logTime", logTime)
        		.getSingleResult();
    }

    public static Long findByCodeCreatorIdAndAgentAndLogTimeCount(Long codeCreatorId, String agent, Long logTime) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (agent == null) throw new IllegalArgumentException("The agent argument is required");
        if (logTime == null) throw new IllegalArgumentException("The logTime argument is required");
        return entityManager().createQuery("SELECT count(o) FROM TimeAgentLog AS o WHERE o.codeCreatorId = :codeCreatorId AND o.agent=:agent AND logTime=:logTime ", Long.class).setParameter("codeCreatorId", codeCreatorId).setParameter("agent", agent).setParameter("logTime", logTime).getSingleResult();
    }
    public static TypedQuery<TimeAgentLog> findTimeAgentLogsByWriteDateBetween(Date minWriteDate, Date maxWriteDate) {
        if (minWriteDate == null) throw new IllegalArgumentException("The minWriteDate argument is required");
        if (maxWriteDate == null) throw new IllegalArgumentException("The maxWriteDate argument is required");
        EntityManager em = TimeAgentLog.entityManager();
        TypedQuery<TimeAgentLog> q = em.createQuery("SELECT o FROM TimeAgentLog AS o WHERE o.writeDate BETWEEN :minWriteDate AND :maxWriteDate Order by logTime asc, agent asc", TimeAgentLog.class);
        q.setParameter("minWriteDate", minWriteDate);
        q.setParameter("maxWriteDate", maxWriteDate);
        return q;
    }    
}
