package com.luo.service;

import com.luo.domain.RoleInfo;
import com.luo.domain.UserInfo;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  List<UserInfo> findAllUser();
  
  UserInfo findUserByName(String paramString);
  
  List<UserInfo> findAllUserPage(int paramInt1, int paramInt2);
  
  List<UserInfo> findUserDel(int paramInt1, int paramInt2);
  
  String getUserCount();
  
  String getProjectCount();
  
  String getCaseCount();
  
  boolean saveUser(UserInfo paramUserInfo);
  
  UserInfo findUserById(String paramString);
  
  List<RoleInfo> findUserOtherRole(String paramString);
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\UserService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */