package com.ks.code.analyzer.flex;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.ks.code.type.domain.AgentType;
import com.ks.code.type.domain.CountryType;
import com.ks.code.type.domain.LanguageType;

@RooJavaBean
@RooToString
public class FlexServiceResult {

	private Integer topCount;
	private List<FlexData> flexDatas;
	private List<AgentType> agentTypes;
	private List<CountryType> countryTypes;
	private List<LanguageType> languageTypes;
	
	public FlexServiceResult() {}
	public FlexServiceResult(List<FlexData> flexDatas, List<AgentType> agentTypes,List<CountryType> countryTypes, List<LanguageType> languageTypes, int topCount) {
		this.flexDatas = flexDatas;
		this.agentTypes = agentTypes;
		this.countryTypes = countryTypes;
		this.languageTypes = languageTypes;
		this.topCount = topCount;
	}
}