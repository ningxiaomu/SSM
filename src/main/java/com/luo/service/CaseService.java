package com.luo.service;

import com.luo.domain.CaseInfo;
import java.util.List;

public interface CaseService {
  public String findAllCase();
  
  boolean saveCase(CaseInfo paramCaseInfo);
  
  CaseInfo findCaseByCaseid(String paramString);
  
  String findProjectIdByName(String paramString);
  
  List<CaseInfo> findAppointCase(String paramString);
  
  CaseInfo findCaseByCaseName(String paramString);
  
  List<CaseInfo> findAllCasePage(int paramInt1, int paramInt2);

  List<CaseInfo> findAllSelectCasePage(String paramString, int paramInt1, int paramInt2);
  
  boolean delSelectCase(String paramString);
  
  CaseInfo findCaseById(String paramString);
  
  boolean editCase(CaseInfo paramCaseInfo);
  
  String findProjectById(String paramString);
  
  List<CaseInfo> findCaseByIdReturnJson(String paramString);
  
  List<CaseInfo> findConditionCase(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2);
}

