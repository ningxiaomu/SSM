package com.luo.service;

import com.luo.domain.InterfaceBodyInfo;
import com.luo.domain.InterfaceHeaderInfo;
import com.luo.domain.InterfaceInfo;
import com.luo.domain.InterfaceReturnDataInfo;
import java.util.List;

public interface InterfaceService {
  List<InterfaceInfo> findAllInterface();
  
  List<InterfaceInfo> findInterfaceById(String paramString);
  
  List<InterfaceHeaderInfo> findInterfaceHeaderById(String paramString);
  
  List<InterfaceBodyInfo> findInterfaceBodyById(String paramString);
  
  List<InterfaceReturnDataInfo> findInterfaceReturnDataById(String paramString);
  
  boolean editBasicInformation(InterfaceInfo paramInterfaceInfo);
  
  boolean delSelectInterface(String paramString);
  
  void addInterface(InterfaceInfo paramInterfaceInfo);
  
  void addInterfaceBody(InterfaceBodyInfo paramInterfaceBodyInfo);
  
  void delInterfaceBody(String paramString);
  
  void delInterfaceReturnData(String paramString);
  
  void addInterfaceReturnData(InterfaceReturnDataInfo paramInterfaceReturnDataInfo);
  
  void delInterfaceHeader(String paramString);
  
  void addInterfaceHeader(InterfaceHeaderInfo paramInterfaceHeaderInfo);
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\InterfaceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */