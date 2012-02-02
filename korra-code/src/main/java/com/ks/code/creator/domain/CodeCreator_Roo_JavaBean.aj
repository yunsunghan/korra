// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.creator.domain;

import com.ks.code.account.domain.Account;
import com.ks.code.creator.domain.CodeCategory;
import com.ks.code.creator.domain.aggregate.CodeFile;
import com.ks.code.creator.domain.aggregate.CodeFormatType;
import com.ks.code.template.domain.ContentPage;
import java.lang.String;
import java.util.Date;
import java.util.List;

privileged aspect CodeCreator_Roo_JavaBean {
    
    public Account CodeCreator.getAccount() {
        return this.account;
    }
    
    public void CodeCreator.setAccount(Account account) {
        this.account = account;
    }
    
    public String CodeCreator.getShortUrl() {
        return this.shortUrl;
    }
    
    public void CodeCreator.setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
    
    public String CodeCreator.getSubject() {
        return this.subject;
    }
    
    public void CodeCreator.setSubject(String subject) {
        this.subject = subject;
    }
    
    public String CodeCreator.getContentUrl() {
        return this.contentUrl;
    }
    
    public void CodeCreator.setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }
    
    public CodeFormatType CodeCreator.getCodeFormat() {
        return this.codeFormat;
    }
    
    public void CodeCreator.setCodeFormat(CodeFormatType codeFormat) {
        this.codeFormat = codeFormat;
    }
    
    public List<CodeFile> CodeCreator.getCodeFiles() {
        return this.codeFiles;
    }
    
    public void CodeCreator.setCodeFiles(List<CodeFile> codeFiles) {
        this.codeFiles = codeFiles;
    }
    
    public Date CodeCreator.getWriteDate() {
        return this.writeDate;
    }
    
    public void CodeCreator.setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }
    
    public CodeCategory CodeCreator.getCodeCategory() {
        return this.codeCategory;
    }
    
    public void CodeCreator.setCodeCategory(CodeCategory codeCategory) {
        this.codeCategory = codeCategory;
    }
    
    public ContentPage CodeCreator.getContentPage() {
        return this.contentPage;
    }
    
    public void CodeCreator.setContentPage(ContentPage contentPage) {
        this.contentPage = contentPage;
    }
    
}
