// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.analyzer.service;

import java.lang.String;

privileged aspect RawLogResult_Roo_ToString {
    
    public String RawLogResult.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Count: ").append(getCount()).append(", ");
        sb.append("PageView: ").append(getPageView()).append(", ");
        sb.append("RawLog: ").append(getRawLog()).append(", ");
        sb.append("RawLogList: ").append(getRawLogList() == null ? "null" : getRawLogList().size());
        return sb.toString();
    }
    
}
