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
@RooJpaActiveRecord(table = "ks_month_area_log", finders = { "findMonthAreaLogsByWriteDateBetween" })
public class MonthAreaLog {
	
	@NotNull
	private Long codeCreatorId;
	
    @NotNull
    private String areaIp;

    @NotNull
    private Long count;
    
    @NotNull
    private String logDay;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "yyyy-MM-dd hh:mm:ss")
    private Date writeDate;
    
    public MonthAreaLog() {
		super();
	}

	public MonthAreaLog(Long codeCreatorId, String areaIp, Long count,
			String logDay, Date writeDate) {
		super();
		this.codeCreatorId = codeCreatorId;
		this.areaIp = areaIp;
		this.count = count;
		this.logDay = logDay;
		this.writeDate = writeDate;
	}

	public static MonthAreaLog findByCodeCreatorIdAndAreaIpAndLogTime(Long codeCreatorId, String areaIp, String logDay) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (areaIp == null) throw new IllegalArgumentException("The areaIp argument is required");
        if (logDay == null) throw new IllegalArgumentException("The logDay argument is required");
        return entityManager().createQuery("SELECT o FROM MonthAreaLog AS o WHERE o.codeCreatorId = :codeCreatorId And o.areaIp=:areaIp AND logDay=:logDay", MonthAreaLog.class).setParameter("codeCreatorId", codeCreatorId).setParameter("areaIp", areaIp).setParameter("logDay", logDay).getSingleResult();
    }

    public static Long findByCodeCreatorIdAndAreaIpAndLogTimeCount(Long codeCreatorId, String areaIp, String logDay) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (areaIp == null) throw new IllegalArgumentException("The areaIp argument is required");
        if (logDay == null) throw new IllegalArgumentException("The logDay argument is required");
        return entityManager().createQuery("SELECT count(o) FROM MonthAreaLog AS o WHERE o.codeCreatorId = :codeCreatorId And o.areaIp=:areaIp AND logDay=:logDay", Long.class).setParameter("codeCreatorId", codeCreatorId).setParameter("areaIp", areaIp).setParameter("logDay", logDay).getSingleResult();
    }
}
