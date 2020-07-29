package com.luo.service;

import com.luo.domain.ProjectInfo;
import java.util.List;

public interface ProjectService {
  List<ProjectInfo> findAllProject();
  
  List<String> findAllProjectName();
  
  void saveProject(ProjectInfo paramProjectInfo);
  
  ProjectInfo findProjectByName(String paramString);
  
  boolean editProject(ProjectInfo paramProjectInfo);
  
  boolean delSelectProject(String paramString);
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\ProjectService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */