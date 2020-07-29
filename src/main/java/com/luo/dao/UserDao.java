package com.luo.dao;

import com.luo.domain.RoleInfo;
import com.luo.domain.UserInfo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
  @Select({"select * from user where username=#{username}"})
  UserInfo findUserByUsername(String paramString);
  
  @Select({"select * from user where userid=#{userid}"})
  UserInfo findByUserId(String paramString) throws Exception;
  
  @Select({"select * from user where username=#{username}"})
  @Results({@Result(id = true, property = "userid", column = "userid"), @Result(property = "username", column = "username"), @Result(property = "email", column = "email"), @Result(property = "password", column = "password"), @Result(property = "phoneNum", column = "phoneNum"), @Result(property = "status", column = "status"), @Result(property = "roles", column = "userid", javaType = List.class, many = @Many(select = "com.luo.dao.RoleDao.findRoleByUserId"))})
  UserInfo findByUsername(String paramString) throws Exception;
  
  @Select({"select * from user"})
  List<UserInfo> findAllUser();
  
  @Insert({"INSERT  user(userid,username,password, email, phoneNum,joinTime,status) VALUES (replace(uuid(), '-', ''),#{username},#{password},#{email},#{phoneNum},now(),#{status})"})
  void saveUser(UserInfo paramUserInfo);
  
  @Select({"select * from user where username=#{username}"})
  UserInfo findUserByName(String paramString);
  
  @Select({"select * from user where userid=#{userid}"})
  UserInfo findUserById(String paramString);
  
  @Update({"update user set username=#{username},email=#{email},phoneNum=#{phoneNum},password=#{password},status=#{status} where userid=#{userid}"})
  void updateUser(UserInfo paramUserInfo);
  
  @Delete({"delete from user where userid=#{userid}"})
  void deleteUserById(String paramString);
  
  @Select({"select * from user where status=0"})
  List<UserInfo> findDelUser();
  
  @Update({"update user set status=0 where userid=#{userid}"})
  void stopUserById(String paramString);
  
  @Update({"update user set status=1 where userid=#{userid}"})
  void enableUserById(String paramString);
  
  @Select({"select * from role where roleid not in (select roleid  from user_role where userid=#{userid})"})
  List<RoleInfo> findOtherRoles(String paramString);
  
  @Insert({"insert into user_role (userid,roleid) values(#{userId},#{roleId})"})
  void addRoleToUser(@Param("userId") String paramString1, @Param("roleId") String paramString2);
  
  @Select({"select count(*) from user"})
  String getUserCount();
  
  @Select({"select count(*) from project"})
  String getProjectCount();
  
  @Select({"select count(*) from mycase"})
  String getCaseCount();
  
  @Select({"select count(*) from user"})
  Integer getCount();
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\dao\UserDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */