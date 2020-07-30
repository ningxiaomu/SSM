package com.luo.dao;

import com.luo.domain.CaseInfo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseDao {
  @Select({"SELECT *  FROM `mycase` ORDER BY joinTime ASC "})
  List<CaseInfo> findAllCase();
  
  @Insert({"insert mycase(caseid,caseName,project,domain,requestAddress,method,contentType,need_login,parameter,exResult,joinTime,status) values(replace(uuid(),'-',''),#{caseName},#{project},#{domain},#{requestAddress},#{method},#{contentType},#{need_login},#{parameter},#{exResult},now(),#{status})"})
  Integer saveCase(CaseInfo paramCaseInfo);
  
  @Select({"select * from mycase where caseid=#{caseid}"})
  CaseInfo findCaseByCaseid(String paramString);
  
  @Select({"select projectId from project where projectName=#{projectName}"})
  String findProjectIdByName(String paramString);
  
  @Select({"select * from mycase where caseid in (select caseid from project_mycase where projectid=#{projectid})"})
  List<CaseInfo> findAppointCase(String paramString);
  
  @Select({"select * from mycase where caseName=#{caseName}"})
  CaseInfo findCaseByCaseName(String paramString);
  
  @Select({"select * from mycase where project=#{projectName}"})
  List<CaseInfo> findAllSelectCase(String paramString);
  
  @Delete({"delete from mycase where caseid=#{caseid}"})
  Integer delSelectCase(String paramString);
  
  @Update({"update  mycase set caseName=#{caseName},project=#{project},domain=#{domain},requestAddress=#{requestAddress},method=#{method},contentType=#{contentType},need_login=#{need_login},parameter=#{parameter},exResult=#{exResult},status=#{status} where caseid=#{caseid}"})
  Integer editCase(CaseInfo paramCaseInfo);
  
  @Select({"select project from mycase where caseid=#{caseid}"})
  String findProjectById(String paramString);
  
  @Select({"select * from mycase where caseid=#{caseid}"})
  List<CaseInfo> findCaseByIdReturnJson(String paramString);
  
  @Select({"select * from `mycase`  where caseName  like CONCAT('%',#{conditionValue},'%')"})
  List<CaseInfo> findConditionCase(String paramString);
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\dao\CaseDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */