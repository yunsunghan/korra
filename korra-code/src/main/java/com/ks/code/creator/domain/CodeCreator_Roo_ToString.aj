// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.creator.domain;

import java.lang.String;

privileged aspect CodeCreator_Roo_ToString {
    
    public String CodeCreator.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account: ").append(getAccount()).append(", ");
        sb.append("CodeCategory: ").append(getCodeCategory()).append(", ");
        sb.append("CodeFiles: ").append(getCodeFiles() == null ? "null" : getCodeFiles().size()).append(", ");
        sb.append("CodeFormat: ").append(getCodeFormat()).append(", ");
        sb.append("ContentPage: ").append(getContentPage()).append(", ");
        sb.append("ContentUrl: ").append(getContentUrl()).append(", ");
        sb.append("ShortUrl: ").append(getShortUrl()).append(", ");
        sb.append("Subject: ").append(getSubject()).append(", ");
        sb.append("WriteDate: ").append(getWriteDate());
        return sb.toString();
    }
    
}
