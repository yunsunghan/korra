// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.calculator.service;

import java.lang.String;

privileged aspect MonthAgentLogServiceResult_Roo_ToString {
    
    public String MonthAgentLogServiceResult.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Count: ").append(getCount()).append(", ");
        sb.append("Monthagentlog: ").append(getMonthagentlog()).append(", ");
        sb.append("MonthagentlogList: ").append(getMonthagentlogList() == null ? "null" : getMonthagentlogList().size()).append(", ");
        sb.append("PageView: ").append(getPageView());
        return sb.toString();
    }
    
}