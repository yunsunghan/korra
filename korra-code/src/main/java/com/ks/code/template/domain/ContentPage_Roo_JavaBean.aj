// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.template.domain;

import com.ks.code.creator.domain.CodeCreator;
import java.lang.String;
import java.util.Date;

privileged aspect ContentPage_Roo_JavaBean {
    
    public String ContentPage.getContext() {
        return this.context;
    }
    
    public void ContentPage.setContext(String context) {
        this.context = context;
    }
    
    public Date ContentPage.getUpdateDate() {
        return this.updateDate;
    }
    
    public void ContentPage.setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    public Date ContentPage.getWriteDate() {
        return this.writeDate;
    }
    
    public void ContentPage.setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }
    
    public CodeCreator ContentPage.getCodeCreator() {
        return this.codeCreator;
    }
    
    public void ContentPage.setCodeCreator(CodeCreator codeCreator) {
        this.codeCreator = codeCreator;
    }
    
}