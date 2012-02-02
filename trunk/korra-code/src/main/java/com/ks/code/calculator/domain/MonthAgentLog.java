package com.ks.code.calculator.domain;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "ks_month_agent_log", finders = { "findMonthAgentLogsByWriteDateBetween" })
public class MonthAgentLog {

	@NotNull
	private Long codeCreatorId;
	
    @NotNull
    private String agent;

    @NotNull
    private Long count;
    
    @NotNull
    private String logDay;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "yyyy-MM-dd hh:mm:ss")
    private Date writeDate;
    
    
    
    public MonthAgentLog() {
		super();
	}

	public MonthAgentLog(Long codeCreatorId, String agent, Long count,
			String logDay, Date writeDate) {
		super();
		this.codeCreatorId = codeCreatorId;
		this.agent = agent;
		this.count = count;
		this.logDay = logDay;
		this.writeDate = writeDate;
	}

	public static MonthAgentLog findByCodeCreatorIdAndAgentAndLogTime(Long codeCreatorId, String agent, String logDay) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (agent == null) throw new IllegalArgumentException("The agent argument is required");
        if (logDay == null) throw new IllegalArgumentException("The logTime argument is required");
        return entityManager().createQuery("SELECT o FROM MonthAgentLog AS o WHERE o.codeCreatorId = :codeCreatorId AND o.agent=:agent AND logDay=:logDay ", MonthAgentLog.class)
        		.setParameter("codeCreatorId", codeCreatorId)
        		.setParameter("agent", agent)
        		.setParameter("logDay", logDay).getSingleResult();
    }

    public static Long findByCodeCreatorIdAndAgentAndLogTimeCount(Long codeCreatorId, String agent, String logDay) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (agent == null) throw new IllegalArgumentException("The agent argument is required");
        if (logDay == null) throw new IllegalArgumentException("The logTime argument is required");
        return entityManager().createQuery("SELECT count(o) FROM MonthAgentLog AS o WHERE o.codeCreatorId = :codeCreatorId AND o.agent=:agent AND logDay=:logDay ", Long.class)
        		.setParameter("codeCreatorId", codeCreatorId).setParameter("agent", agent)
        		.setParameter("logDay", logDay)
        		.getSingleResult();
    }
}
