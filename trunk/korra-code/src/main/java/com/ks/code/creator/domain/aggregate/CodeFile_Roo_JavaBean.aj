// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.creator.domain.aggregate;

import com.ks.code.creator.domain.CodeCreator;
import java.lang.String;

privileged aspect CodeFile_Roo_JavaBean {
    
    public String CodeFile.getFileUrl() {
        return this.fileUrl;
    }
    
    public void CodeFile.setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
    
    public String CodeFile.getFileDir() {
        return this.fileDir;
    }
    
    public void CodeFile.setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }
    
    public CodeCreator CodeFile.getCodeCreator() {
        return this.codeCreator;
    }
    
    public void CodeFile.setCodeCreator(CodeCreator codeCreator) {
        this.codeCreator = codeCreator;
    }
    
}
