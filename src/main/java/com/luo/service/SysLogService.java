package com.luo.service;

import com.luo.domain.SysLog;
import java.util.List;

public interface SysLogService {
  void save(SysLog paramSysLog);
  
  List<SysLog> findAllLog(Integer paramInteger1, Integer paramInteger2);
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\SysLogService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */