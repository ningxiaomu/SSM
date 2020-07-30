package com.luo.domain;




public class CaseInfo {
    private String caseid;
    private String caseName;
    private String project;
    private String domain;
    private String requestAddress;
    private String method;
    private String contentType;
    private String need_login;
    private String parameter;
    private String exResult;
    private String joinTime;
    private Integer status;
    private String statusStr;

    public String getJoinTime() {
        return this.joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public String getStatusStr() {
        if (this.status.intValue() == 0) {
            this.statusStr = "停用";
        } else if (this.status.intValue() == 1) {
            this.statusStr = "启用";
        } else {
            this.statusStr = "错误";
        }
        return this.statusStr;
    }

    public String getNeed_login() {
        return this.need_login;
    }

    public void setNeed_login(String need_login) {
        this.need_login = need_login;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getCaseid() {
        return this.caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    public String getCaseName() {
        return this.caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getProject() {
        return this.project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getRequestAddress() {
        return this.requestAddress;
    }

    public void setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getParameter() {
        return this.parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getExResult() {
        return this.exResult;
    }

    public void setExResult(String exResult) {
        this.exResult = exResult;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return "CaseInfo{caseid='" + this.caseid + '\'' + ", caseName='" + this.caseName + '\'' + ", project='" + this.project + '\'' + ", domain='" + this.domain + '\'' + ", requestAddress='" + this.requestAddress + '\'' + ", method='" + this.method + '\'' + ", contentType='" + this.contentType + '\'' + ", need_login='" + this.need_login + '\'' + ", parameter='" + this.parameter + '\'' + ", exResult='" + this.exResult + '\'' + ", joinTime='" + this.joinTime + '\'' + ", status=" + this.status + ", statusStr='" + this.statusStr + '\'' + '}';
    }
}


