package com.luo.dao;

import com.luo.domain.ProjectInfo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao {
  @Select({"select * from project"})
  List<ProjectInfo> findAllProject();
  
  @Select({"select projectName from project"})
  List<String> findAllProjectName();
  
  @Insert({"insert into project (projectid,projectName,domain,projectDesc,status) values (replace(uuid(),'-',''),#{projectName},#{domain},#{projectDesc},#{status})"})
  void saveProject(ProjectInfo paramProjectInfo);
  
  @Select({"select * from project where projectName=#{projectName}"})
  ProjectInfo findProjectByName(String paramString);
  
  @Update({"update  project set projectName=#{projectName},domain=#{domain},status=#{status},projectDesc=#{projectDesc} where projectid=#{projectid}"})
  void editProject(ProjectInfo paramProjectInfo);
  
  @Select({"select * from project where projectid=#{projectid}"})
  ProjectInfo findProjectById(String paramString);
  
  @Delete({"delete from project where projectid=#{project}"})
  void delSelectProject(String paramString);
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\dao\ProjectDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */