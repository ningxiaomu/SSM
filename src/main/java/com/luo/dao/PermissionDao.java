package com.luo.dao;

import com.luo.domain.PermissionInfo;
import com.luo.domain.RoleInfo;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao {
  @Select({"select * from role where roleid in (select roleid from user_role where userid=#{userid})"})
  @Results({@Result(id = true, column = "roleid", property = "roleid"), @Result(column = "roleName", property = "roleName"), @Result(column = "roleDesc", property = "roleDesc"), @Result(property = "users", column = "roleid", many = @Many(select = "com.luo.dao.UserDao.findByUserId", fetchType = FetchType.EAGER))})
  List<RoleInfo> findUserRole(String paramString);
  
  @Select({"select * from role where roleid in (select roleid from user_role where userid=#{userid})"})
  List<RoleInfo> findRoleByUserId(String paramString) throws Exception;
  
  @Select({"select * from role where roleName = #{roleName}"})
  RoleInfo findRoleByName(String paramString);
  
  @Select({"select * from permission"})
  List<PermissionInfo> findAllPermission();
  
  @Insert({"insert into permission (permissionid,permissionName,url) values (replace(uuid(), '-', ''),#{permissionName},#{url})"})
  void savePermission(PermissionInfo paramPermissionInfo);
  
  @Select({"select * from role where roleid=#{roleid}"})
  RoleInfo findById(String paramString);
  
  @Select({"select * from lb_permission where id not in (select permissionid from role_permission where roleid=#{roleid})"})
  List<PermissionInfo> findOtherPermission(String paramString);
  
  @Insert({"insert into role_permission (roleid,permissionid) values (#{roleid},#{permissionid})"})
  void addPermissionToUser(@Param("roleid") String paramString1, @Param("permissionid") String paramString2);
  
  @Select({"select count(*) from permission"})
  Integer getCountPermission();
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\dao\PermissionDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */