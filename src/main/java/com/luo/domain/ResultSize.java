package com.luo.domain;
/*    */ 
/*    */ import com.luo.domain.ResultSize;
/*    */ 
/*    */ public class ResultSize {
/*    */   String TestTime;
/*    */   String Passed;
/*    */   
/*  9 */   public String getTestTime() { return this.TestTime; }
/*    */   
/*    */   String Failed;
/*    */   
/* 13 */   public void setTestTime(String testTime) { this.TestTime = testTime; }
/*    */ 
/*    */   
/*    */   String Skipped;
/*    */ 
/*    */   
/* 19 */   public String getPassed() { return this.Passed; }
/*    */ 
/*    */ 
/*    */   
/* 23 */   public void setPassed(String passed) { this.Passed = passed; }
/*    */ 
/*    */ 
/*    */   
/* 27 */   public String getFailed() { return this.Failed; }
/*    */ 
/*    */ 
/*    */   
/* 31 */   public void setFailed(String failed) { this.Failed = failed; }
/*    */ 
/*    */ 
/*    */   
/* 35 */   public String getSkipped() { return this.Skipped; }
/*    */ 
/*    */ 
/*    */   
/* 39 */   public void setSkipped(String skipped) { this.Skipped = skipped; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 44 */   public String toString() { return "ResultSize{TestTime='" + this.TestTime + '\'' + ", Passed='" + this.Passed + '\'' + ", Failed='" + this.Failed + '\'' + ", Skipped='" + this.Skipped + '\'' + '}'; }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\domain\ResultSize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */