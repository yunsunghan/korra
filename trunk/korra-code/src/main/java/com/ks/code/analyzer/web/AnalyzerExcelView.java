package com.ks.code.analyzer.web;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.ks.code.collector.domain.RawLog;
import com.ks.code.core.exception.IdNotFoundException;
import com.ks.code.core.web.util.DateUtils;

@Component
@Qualifier("loggerExcelView")
public class AnalyzerExcelView{ // extends AbstractExcelView {

//	public void setContentType(String arg0) {
//        super.setContentType(arg0);
//    }
//	
//	@Override
//    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook wb, HttpServletRequest request, HttpServletResponse response) throws Exception {
//    	response.setHeader("Content-Disposition", "attachment; filename=\""+DateUtils.getFormattedString(new Date())+".xls\"");
//        this.setContentType("application/msexcel");
//        
//        @SuppressWarnings("unchecked")
//		List<RawLog> resultList = (List<RawLog>) model.get("resultList");
//        if(resultList.size() == 0) throw new IdNotFoundException("데이터가 존재하지 않습니다.");
//        
//        String sheetName = "Sheet0";
//        int initRowIdx = 0;
//        if(model.get("sheetName") != null) 
//        	sheetName = (String)model.get("sheetName");
//        
//        HSSFSheet sheet = null;
//        HSSFCell cell = null;
//        sheet = wb.createSheet(sheetName);
//        sheet.setDefaultColumnWidth((short)12);        
//
//        if(model.get("titles") != null){
//        	String[] titles = (String[])model.get("titles");
//        	for(int i=0; i<titles.length; i++ ){
//        		cell = getCell(sheet, 0, i);
//        		setText(cell, titles[i]);
//        	}
//        	initRowIdx = 1;
//        }
//
//        for(int i=0; i< resultList.size(); i++){
//        	RawLog codeLog = (RawLog)resultList.get(i);
//        	for(int j=0; j<6; j++){
//        		String date = DateUtils.getFormattedString(new Date());
//        		if(codeLog.getWriteDate() != null) date = DateUtils.getFormattedString(codeLog.getWriteDate());
//        		setText(getCell(sheet, i+initRowIdx, 0),codeLog.getId().toString());
//        		setText(getCell(sheet, i+initRowIdx, 1),codeLog.getAcceptLanguage());
//        		setText(getCell(sheet, i+initRowIdx, 2),codeLog.getUserAgent());
//        		setText(getCell(sheet, i+initRowIdx, 3),date);
//        		setText(getCell(sheet, i+initRowIdx, 4),codeLog.getCodeCreatorId().toString());
//        	}
//        }
//    }
}
