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
@RooJpaActiveRecord(table = "ks_time_area_log")
public class TimeAreaLog {

    @NotNull
    private Long codeCreatorId;

    @NotNull
    private String areaIp;

    @NotNull
    private Long count;

    @NotNull
    private Long logTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "yyyy-MM-dd hh:mm:ss")
    private Date writeDate;

    public TimeAreaLog() {
        super();
    }

    public TimeAreaLog(Long codeCreatorId, String areaIp, Long count, Date writeDate, Long logTime) {
        super();
        this.codeCreatorId = codeCreatorId;
        this.areaIp = areaIp;
        this.count = count;
        this.writeDate = writeDate;
        this.logTime = logTime;
    }

    public static TimeAreaLog findByCodeCreatorIdAndAreaIpAndLogTime(Long codeCreatorId, String areaIp, Long logTime) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (areaIp == null) throw new IllegalArgumentException("The areaIp argument is required");
        if (logTime == null) throw new IllegalArgumentException("The logTime argument is required");
        return entityManager().createQuery("SELECT o FROM TimeAreaLog AS o WHERE o.codeCreatorId = :codeCreatorId And o.areaIp=:areaIp AND logTime=:logTime", TimeAreaLog.class).setParameter("codeCreatorId", codeCreatorId).setParameter("areaIp", areaIp).setParameter("logTime", logTime).getSingleResult();
    }

    public static Long findByCodeCreatorIdAndAreaIpAndLogTimeCount(Long codeCreatorId, String areaIp, Long logTime) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (areaIp == null) throw new IllegalArgumentException("The areaIp argument is required");
        if (logTime == null) throw new IllegalArgumentException("The logTime argument is required");
        return entityManager().createQuery("SELECT count(o) FROM TimeAreaLog AS o WHERE o.codeCreatorId = :codeCreatorId And o.areaIp=:areaIp AND logTime=:logTime", Long.class).setParameter("codeCreatorId", codeCreatorId).setParameter("areaIp", areaIp).setParameter("logTime", logTime).getSingleResult();
    }
    public static TypedQuery<TimeAreaLog> findTimeAreaLogsByWriteDateBetween(Date minWriteDate, Date maxWriteDate) {
        if (minWriteDate == null) throw new IllegalArgumentException("The minWriteDate argument is required");
        if (maxWriteDate == null) throw new IllegalArgumentException("The maxWriteDate argument is required");
        EntityManager em = TimeAreaLog.entityManager();
        TypedQuery<TimeAreaLog> q = em.createQuery("SELECT o FROM TimeAreaLog AS o WHERE o.writeDate BETWEEN :minWriteDate AND :maxWriteDate Order by logTime asc, areaIp asc", TimeAreaLog.class);
        q.setParameter("minWriteDate", minWriteDate);
        q.setParameter("maxWriteDate", maxWriteDate);
        return q;
    }    
}
