package com.luo.domain;
/*     */ 
/*     */ import com.luo.domain.InterfaceInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InterfaceInfo
/*     */ {
/*     */   private String interfaceId;
/*     */   private String interfaceName;
/*     */   private String project;
/*     */   private String domain;
/*     */   private String method;
/*     */   private String requestAddress;
/*     */   private String creator;
/*     */   private String joinTime;
/*     */   private String parameterName_headers;
/*     */   private String parameterValue_headers;
/*     */   private String is_required_headers;
/*     */   
/*  29 */   public String getMethod() { return this.method; }
/*     */   private String example_headers; private String remark_headers; private String parameterName_body; private String type_body; private String is_required_body; private String defaultValue_body; private String remark_body; private String parameterName_return; private String type_return; private String is_required_return; private String defaultValue_return;
/*     */   private String remark_return;
/*     */   
/*  33 */   public void setMethod(String method) { this.method = method; }
/*     */ 
/*     */ 
/*     */   
/*  37 */   public String getInterfaceId() { return this.interfaceId; }
/*     */ 
/*     */ 
/*     */   
/*  41 */   public void setInterfaceId(String interfaceId) { this.interfaceId = interfaceId; }
/*     */ 
/*     */ 
/*     */   
/*  45 */   public String getInterfaceName() { return this.interfaceName; }
/*     */ 
/*     */ 
/*     */   
/*  49 */   public void setInterfaceName(String interfaceName) { this.interfaceName = interfaceName; }
/*     */ 
/*     */ 
/*     */   
/*  53 */   public String getProject() { return this.project; }
/*     */ 
/*     */ 
/*     */   
/*  57 */   public void setProject(String project) { this.project = project; }
/*     */ 
/*     */ 
/*     */   
/*  61 */   public String getDomain() { return this.domain; }
/*     */ 
/*     */ 
/*     */   
/*  65 */   public void setDomain(String domain) { this.domain = domain; }
/*     */ 
/*     */ 
/*     */   
/*  69 */   public String getRequestAddress() { return this.requestAddress; }
/*     */ 
/*     */ 
/*     */   
/*  73 */   public void setRequestAddress(String requestAddress) { this.requestAddress = requestAddress; }
/*     */ 
/*     */ 
/*     */   
/*  77 */   public String getCreator() { return this.creator; }
/*     */ 
/*     */ 
/*     */   
/*  81 */   public void setCreator(String creator) { this.creator = creator; }
/*     */ 
/*     */ 
/*     */   
/*  85 */   public String getJoinTime() { return this.joinTime; }
/*     */ 
/*     */ 
/*     */   
/*  89 */   public void setJoinTime(String joinTime) { this.joinTime = joinTime; }
/*     */ 
/*     */ 
/*     */   
/*  93 */   public String getParameterName_headers() { return this.parameterName_headers; }
/*     */ 
/*     */ 
/*     */   
/*  97 */   public void setParameterName_headers(String parameterName_headers) { this.parameterName_headers = parameterName_headers; }
/*     */ 
/*     */ 
/*     */   
/* 101 */   public String getParameterValue_headers() { return this.parameterValue_headers; }
/*     */ 
/*     */ 
/*     */   
/* 105 */   public void setParameterValue_headers(String parameterValue_headers) { this.parameterValue_headers = parameterValue_headers; }
/*     */ 
/*     */ 
/*     */   
/* 109 */   public String getIs_required_headers() { return this.is_required_headers; }
/*     */ 
/*     */ 
/*     */   
/* 113 */   public void setIs_required_headers(String is_required_headers) { this.is_required_headers = is_required_headers; }
/*     */ 
/*     */ 
/*     */   
/* 117 */   public String getExample_headers() { return this.example_headers; }
/*     */ 
/*     */ 
/*     */   
/* 121 */   public void setExample_headers(String example_headers) { this.example_headers = example_headers; }
/*     */ 
/*     */ 
/*     */   
/* 125 */   public String getRemark_headers() { return this.remark_headers; }
/*     */ 
/*     */ 
/*     */   
/* 129 */   public void setRemark_headers(String remark_headers) { this.remark_headers = remark_headers; }
/*     */ 
/*     */ 
/*     */   
/* 133 */   public String getParameterName_body() { return this.parameterName_body; }
/*     */ 
/*     */ 
/*     */   
/* 137 */   public void setParameterName_body(String parameterName_body) { this.parameterName_body = parameterName_body; }
/*     */ 
/*     */ 
/*     */   
/* 141 */   public String getType_body() { return this.type_body; }
/*     */ 
/*     */ 
/*     */   
/* 145 */   public void setType_body(String type_body) { this.type_body = type_body; }
/*     */ 
/*     */ 
/*     */   
/* 149 */   public String getIs_required_body() { return this.is_required_body; }
/*     */ 
/*     */ 
/*     */   
/* 153 */   public void setIs_required_body(String is_required_body) { this.is_required_body = is_required_body; }
/*     */ 
/*     */ 
/*     */   
/* 157 */   public String getDefaultValue_body() { return this.defaultValue_body; }
/*     */ 
/*     */ 
/*     */   
/* 161 */   public void setDefaultValue_body(String defaultValue_body) { this.defaultValue_body = defaultValue_body; }
/*     */ 
/*     */ 
/*     */   
/* 165 */   public String getRemark_body() { return this.remark_body; }
/*     */ 
/*     */ 
/*     */   
/* 169 */   public void setRemark_body(String remark_body) { this.remark_body = remark_body; }
/*     */ 
/*     */ 
/*     */   
/* 173 */   public String getParameterName_return() { return this.parameterName_return; }
/*     */ 
/*     */ 
/*     */   
/* 177 */   public void setParameterName_return(String parameterName_return) { this.parameterName_return = parameterName_return; }
/*     */ 
/*     */ 
/*     */   
/* 181 */   public String getType_return() { return this.type_return; }
/*     */ 
/*     */ 
/*     */   
/* 185 */   public void setType_return(String type_return) { this.type_return = type_return; }
/*     */ 
/*     */ 
/*     */   
/* 189 */   public String getIs_required_return() { return this.is_required_return; }
/*     */ 
/*     */ 
/*     */   
/* 193 */   public void setIs_required_return(String is_required_return) { this.is_required_return = is_required_return; }
/*     */ 
/*     */ 
/*     */   
/* 197 */   public String getDefaultValue_return() { return this.defaultValue_return; }
/*     */ 
/*     */ 
/*     */   
/* 201 */   public void setDefaultValue_return(String defaultValue_return) { this.defaultValue_return = defaultValue_return; }
/*     */ 
/*     */ 
/*     */   
/* 205 */   public String getRemark_return() { return this.remark_return; }
/*     */ 
/*     */ 
/*     */   
/* 209 */   public void setRemark_return(String remark_return) { this.remark_return = remark_return; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 214 */   public String toString() { return "InterfaceInfo{interfaceId='" + this.interfaceId + '\'' + ", interfaceName='" + this.interfaceName + '\'' + ", project='" + this.project + '\'' + ", domain='" + this.domain + '\'' + ", requestAddress='" + this.requestAddress + '\'' + ", creator='" + this.creator + '\'' + ", joinTime='" + this.joinTime + '\'' + ", parameterName_headers='" + this.parameterName_headers + '\'' + ", parameterValue_headers='" + this.parameterValue_headers + '\'' + ", is_required_headers='" + this.is_required_headers + '\'' + ", example_headers='" + this.example_headers + '\'' + ", remark_headers='" + this.remark_headers + '\'' + ", parameterName_body='" + this.parameterName_body + '\'' + ", type_body='" + this.type_body + '\'' + ", is_required_body='" + this.is_required_body + '\'' + ", defaultValue_body='" + this.defaultValue_body + '\'' + ", remark_body='" + this.remark_body + '\'' + ", parameterName_return='" + this.parameterName_return + '\'' + ", type_return='" + this.type_return + '\'' + ", is_required_return='" + this.is_required_return + '\'' + ", defaultValue_return='" + this.defaultValue_return + '\'' + ", remark_return='" + this.remark_return + '\'' + '}'; }
/*     */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\domain\InterfaceInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */