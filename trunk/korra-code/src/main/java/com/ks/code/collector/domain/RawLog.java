package com.ks.code.collector.domain;

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
@RooJpaActiveRecord(table = "ks_code_log")
public class RawLog {

    @NotNull
    private String userAgent;

    @NotNull
    private String acceptLanguage;

    @NotNull
    private String ip;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date writeDate;

    @NotNull
    private Long codeCreatorId;

    /**
     * log는 최대한 관계설정을 자제한다.
     * @param codeCreatorId
     * @return
     */
    public static TypedQuery<RawLog> findCodeLogsByCodeCreator(Long codeCreatorId) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreator ID argument is required");
        EntityManager em = RawLog.entityManager();
        TypedQuery<RawLog> q = em.createQuery("SELECT o FROM CodeLog AS o WHERE o.codeCreatorId = :codeCreatorId", RawLog.class);
        q.setParameter("codeCreatorId", codeCreatorId);
        return q;
    }
}
