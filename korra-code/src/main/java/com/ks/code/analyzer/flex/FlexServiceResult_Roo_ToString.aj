// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.analyzer.flex;

import java.lang.String;

privileged aspect FlexServiceResult_Roo_ToString {
    
    public String FlexServiceResult.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AgentTypes: ").append(getAgentTypes() == null ? "null" : getAgentTypes().size()).append(", ");
        sb.append("CountryTypes: ").append(getCountryTypes() == null ? "null" : getCountryTypes().size()).append(", ");
        sb.append("FlexDatas: ").append(getFlexDatas() == null ? "null" : getFlexDatas().size()).append(", ");
        sb.append("LanguageTypes: ").append(getLanguageTypes() == null ? "null" : getLanguageTypes().size()).append(", ");
        sb.append("TopCount: ").append(getTopCount());
        return sb.toString();
    }
    
}