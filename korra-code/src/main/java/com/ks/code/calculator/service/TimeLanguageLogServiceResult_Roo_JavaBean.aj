// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.calculator.service;

import com.ks.code.calculator.domain.TimeLanguageLog;
import java.lang.Long;
import java.lang.String;
import java.util.List;

privileged aspect TimeLanguageLogServiceResult_Roo_JavaBean {
    
    public TimeLanguageLog TimeLanguageLogServiceResult.getTimelanguagelog() {
        return this.timelanguagelog;
    }
    
    public void TimeLanguageLogServiceResult.setTimelanguagelog(TimeLanguageLog timelanguagelog) {
        this.timelanguagelog = timelanguagelog;
    }
    
    public List<TimeLanguageLog> TimeLanguageLogServiceResult.getTimelanguagelogList() {
        return this.timelanguagelogList;
    }
    
    public void TimeLanguageLogServiceResult.setTimelanguagelogList(List<TimeLanguageLog> timelanguagelogList) {
        this.timelanguagelogList = timelanguagelogList;
    }
    
    public Long TimeLanguageLogServiceResult.getCount() {
        return this.count;
    }
    
    public void TimeLanguageLogServiceResult.setCount(Long count) {
        this.count = count;
    }
    
    public String TimeLanguageLogServiceResult.getPageView() {
        return this.pageView;
    }
    
    public void TimeLanguageLogServiceResult.setPageView(String pageView) {
        this.pageView = pageView;
    }
    
}
