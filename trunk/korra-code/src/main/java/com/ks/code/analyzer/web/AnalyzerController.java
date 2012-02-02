package com.ks.code.analyzer.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ks.code.analyzer.service.AnalyzerService;


@RequestMapping("/backoffice/analyzers")
@Controller
public class AnalyzerController {

	@Autowired AnalyzerService analyzerService;
	@Value("${korra.short.url}") private String shortUrl;	

	@RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("codeLog", analyzerService.findRawLog(id));
        uiModel.addAttribute("itemId", id);
        return "backoffice/analyzers/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(	
						@RequestParam(value = "currentPage", required = false, defaultValue="1") Integer currentPage,
						@RequestParam(value = "startNumber", required = false, defaultValue="0") Integer startNumber,					 
    					Model uiModel) {
        uiModel.addAttribute("result", analyzerService.findRawLogEntries(currentPage, startNumber));
        uiModel.addAttribute("shortUrl", shortUrl);
        return "backoffice/analyzers/list";
    }

	@RequestMapping(value = "excel", method = RequestMethod.GET)    
	public ModelAndView execl(ModelMap modelMap, HttpServletRequest request) {
		String[] titles = new String[]{"No", "accept_langugage", "ip", "user_agent", "write_date"};
		modelMap.addAttribute("sheetName", "all");
        modelMap.addAttribute("titles", titles);
		modelMap.addAttribute("resultList", analyzerService.findRawLogEntries(1,0));
		return new ModelAndView("loggerExcelView", modelMap); 
	}      
}
