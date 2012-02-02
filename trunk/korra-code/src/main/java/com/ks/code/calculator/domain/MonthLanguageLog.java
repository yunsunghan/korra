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
@RooJpaActiveRecord(table = "ks_month_language_log", finders = { "findMonthLanguageLogsByWriteDateBetween" })
public class MonthLanguageLog {

	@NotNull
	private Long codeCreatorId;
	
    @NotNull
    private String language;

    @NotNull
    private Long count;
    
    @NotNull
    private String logDay;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "yyyy-MM-dd hh:mm:ss")
    private Date writeDate;
    
    public MonthLanguageLog() {
		super();
	}

	public MonthLanguageLog(Long codeCreatorId, String language, Long count,
			String logDay, Date writeDate) {
		super();
		this.codeCreatorId = codeCreatorId;
		this.language = language;
		this.count = count;
		this.logDay = logDay;
		this.writeDate = writeDate;
	}

	public static MonthLanguageLog findByCodeCreatorIdAndLanguageAndLogTime(Long codeCreatorId, String language, String logDay) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (language == null) throw new IllegalArgumentException("The langugage argument is required");
        if (logDay == null) throw new IllegalArgumentException("The logDay argument is required");
        return entityManager().createQuery("SELECT o FROM MonthLanguageLog AS o WHERE o.codeCreatorId = :codeCreatorId And o.language=:language AND logDay=:logDay", MonthLanguageLog.class).setParameter("codeCreatorId", codeCreatorId).setParameter("language", language).setParameter("logDay", logDay).getSingleResult();
    }

    public static Long findByCodeCreatorIdAndLanguageAndLogTimeCount(Long codeCreatorId, String language, String logDay) {
        if (codeCreatorId == null) throw new IllegalArgumentException("The codeCreatorId argument is required");
        if (language == null) throw new IllegalArgumentException("The langugage argument is required");
        if (logDay == null) throw new IllegalArgumentException("The logDay argument is required");
        return entityManager().createQuery("SELECT count(o) FROM MonthLanguageLog AS o WHERE o.codeCreatorId = :codeCreatorId And o.language=:language AND logDay=:logDay", Long.class).setParameter("codeCreatorId", codeCreatorId).setParameter("language", language).setParameter("logDay", logDay).getSingleResult();
    }
}
