// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.calculator.domain;

import java.lang.String;

privileged aspect MonthLanguageLog_Roo_ToString {
    
    public String MonthLanguageLog.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CodeCreatorId: ").append(getCodeCreatorId()).append(", ");
        sb.append("Count: ").append(getCount()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Language: ").append(getLanguage()).append(", ");
        sb.append("LogDay: ").append(getLogDay()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("WriteDate: ").append(getWriteDate());
        return sb.toString();
    }
    
}
