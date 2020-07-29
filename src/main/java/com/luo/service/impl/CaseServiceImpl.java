package com.luo.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.luo.dao.CaseDao;
/*     */ import com.luo.domain.CaseInfo;
/*     */ import com.luo.service.CaseService;
/*     */ import com.luo.service.impl.CaseServiceImpl;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ @Service("caseService")
/*     */ @Transactional
/*     */ public class CaseServiceImpl
/*     */   implements CaseService {
/*     */   @Autowired
/*     */   private CaseDao caseDao;
/*     */   
/*  21 */   public List<CaseInfo> findAllCase() { return this.caseDao.findAllCase(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  26 */   public void saveCase(CaseInfo caseInfo) { this.caseDao.saveCase(caseInfo); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  31 */   public CaseInfo findCaseByCaseid(String caseid) { return this.caseDao.findCaseByCaseid(caseid); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   public String findProjectIdByName(String projectName) { return this.caseDao.findProjectIdByName(projectName); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   public List<CaseInfo> findAppointCase(String projectId) { return this.caseDao.findAppointCase(projectId); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   public CaseInfo findCaseByCaseName(String caseName) { return this.caseDao.findCaseByCaseName(caseName); }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CaseInfo> findAllCasePage(int page, int size) {
/*  51 */     PageHelper.startPage(page, size);
/*  52 */     return this.caseDao.findAllCase();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<CaseInfo> findAllSelectCasePage(String projectName, int page, int size) {
/*  57 */     List<CaseInfo> list = new ArrayList<>();
/*  58 */     if (projectName.equals("请选择项目")) {
/*  59 */       PageHelper.startPage(page, size);
/*  60 */       list = this.caseDao.findAllCase();
/*     */     } else {
/*     */       
/*  63 */       PageHelper.startPage(page, size);
/*  64 */       list = this.caseDao.findAllSelectCase(projectName);
/*     */     } 
/*  66 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean delSelectCase(String caseid) {
/*     */     boolean flag;
/*  73 */     this.caseDao.delSelectCase(caseid);
/*  74 */     CaseInfo caseInfo = this.caseDao.findCaseByCaseid(caseid);
/*  75 */     System.out.println("CaseService里的caseinfo:" + caseInfo);
/*  76 */     if (caseInfo == null) {
/*     */       
/*  78 */       flag = true;
/*     */     } else {
/*  80 */       flag = false;
/*     */     } 
/*     */     
/*  83 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  88 */   public CaseInfo findCaseById(String caseid) { return null; }

/*     */   public boolean editCase(CaseInfo caseInfo) {
/*     */     boolean flag;
/*  94 */     String caseid = caseInfo.getCaseid();
/*  95 */     System.out.println("caseInfoBefore" + caseInfo);
/*  96 */     this.caseDao.editCase(caseInfo);
/*  97 */     CaseInfo caseInfoAfter = null;
/*     */     try {
/*  99 */       caseInfoAfter = this.caseDao.findCaseByCaseid(caseid);
/* 100 */     } catch (Exception e) {
/* 101 */       e.printStackTrace();
/*     */     } 
/* 103 */     System.out.println("caseInfoAfter:" + caseInfoAfter);
///* 104 */     if ((caseInfo.getCaseid().equals(caseInfoAfter.getCaseid()) & caseInfo.getCaseName().equals(caseInfoAfter.getCaseName()) & caseInfo.getProject().equals(caseInfoAfter.getProject()) & caseInfo.getParameter().equals(caseInfoAfter.getParameter()) != 0) {
///* 105 */       flag = true;
///*     */     } else {
///* 107 */       flag = false;
///*     */     }
/*     */     
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 115 */   public String findProjectById(String caseid) { return this.caseDao.findProjectById(caseid); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 120 */   public List<CaseInfo> findCaseByIdReturnJson(String caseid) { return this.caseDao.findCaseByIdReturnJson(caseid); }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CaseInfo> findConditionCase(String conditionValue, String conditionSelect, Integer page, Integer size) {
/* 125 */     PageHelper.startPage(page.intValue(), size.intValue());
/* 126 */     if (conditionSelect.equals("接口名称")) {
/* 127 */       conditionSelect = "caseName";
/*     */     }
/* 129 */     System.out.println("conditionSelect:" + conditionSelect);
/* 130 */     System.out.println("conditionValue:" + conditionValue);
/* 131 */     return this.caseDao.findConditionCase(conditionValue);
/*     */   }
/*     */ }

