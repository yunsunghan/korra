// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.analyzer.flex;

import com.ks.code.analyzer.flex.FlexData;
import com.ks.code.type.domain.AgentType;
import com.ks.code.type.domain.CountryType;
import com.ks.code.type.domain.LanguageType;
import java.lang.Integer;
import java.util.List;

privileged aspect FlexServiceResult_Roo_JavaBean {
    
    public Integer FlexServiceResult.getTopCount() {
        return this.topCount;
    }
    
    public void FlexServiceResult.setTopCount(Integer topCount) {
        this.topCount = topCount;
    }
    
    public List<FlexData> FlexServiceResult.getFlexDatas() {
        return this.flexDatas;
    }
    
    public void FlexServiceResult.setFlexDatas(List<FlexData> flexDatas) {
        this.flexDatas = flexDatas;
    }
    
    public List<AgentType> FlexServiceResult.getAgentTypes() {
        return this.agentTypes;
    }
    
    public void FlexServiceResult.setAgentTypes(List<AgentType> agentTypes) {
        this.agentTypes = agentTypes;
    }
    
    public List<CountryType> FlexServiceResult.getCountryTypes() {
        return this.countryTypes;
    }
    
    public void FlexServiceResult.setCountryTypes(List<CountryType> countryTypes) {
        this.countryTypes = countryTypes;
    }
    
    public List<LanguageType> FlexServiceResult.getLanguageTypes() {
        return this.languageTypes;
    }
    
    public void FlexServiceResult.setLanguageTypes(List<LanguageType> languageTypes) {
        this.languageTypes = languageTypes;
    }
    
}
