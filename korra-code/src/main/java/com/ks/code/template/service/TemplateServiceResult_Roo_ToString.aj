// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.ks.code.template.service;

import java.lang.String;

privileged aspect TemplateServiceResult_Roo_ToString {
    
    public String TemplateServiceResult.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContentPage: ").append(getContentPage()).append(", ");
        sb.append("ContentPageList: ").append(getContentPageList() == null ? "null" : getContentPageList().size()).append(", ");
        sb.append("Count: ").append(getCount()).append(", ");
        sb.append("PageView: ").append(getPageView());
        return sb.toString();
    }
    
}