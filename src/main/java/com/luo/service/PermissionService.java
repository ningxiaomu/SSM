package com.luo.service;

import com.luo.domain.PermissionInfo;
import java.util.List;

public interface PermissionService {
  List<PermissionInfo> findAllPermission();
  
  boolean savePermission(PermissionInfo paramPermissionInfo);
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\PermissionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */