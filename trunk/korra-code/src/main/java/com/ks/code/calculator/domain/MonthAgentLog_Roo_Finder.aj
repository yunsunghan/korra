// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.calculator.domain;

import com.ks.code.calculator.domain.MonthAgentLog;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect MonthAgentLog_Roo_Finder {
    
    public static TypedQuery<MonthAgentLog> MonthAgentLog.findMonthAgentLogsByWriteDateBetween(Date minWriteDate, Date maxWriteDate) {
        if (minWriteDate == null) throw new IllegalArgumentException("The minWriteDate argument is required");
        if (maxWriteDate == null) throw new IllegalArgumentException("The maxWriteDate argument is required");
        EntityManager em = MonthAgentLog.entityManager();
        TypedQuery<MonthAgentLog> q = em.createQuery("SELECT o FROM MonthAgentLog AS o WHERE o.writeDate BETWEEN :minWriteDate AND :maxWriteDate", MonthAgentLog.class);
        q.setParameter("minWriteDate", minWriteDate);
        q.setParameter("maxWriteDate", maxWriteDate);
        return q;
    }
    
}
