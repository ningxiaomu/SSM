package com.luo.service;

import com.luo.domain.RoleInfo;
import java.util.List;

public interface RoleService {
  List<RoleInfo> findAllRole();
  
  boolean saveRole(RoleInfo paramRoleInfo);
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\RoleService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */