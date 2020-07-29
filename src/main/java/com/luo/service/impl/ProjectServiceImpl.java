package com.luo.service.impl;
/*    */ 
/*    */ import com.luo.dao.ProjectDao;
/*    */ import com.luo.domain.ProjectInfo;
/*    */ import com.luo.service.ProjectService;
/*    */ import com.luo.service.impl.ProjectServiceImpl;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("projectService")
/*    */ @Transactional
/*    */ public class ProjectServiceImpl
/*    */   implements ProjectService
/*    */ {
/*    */   @Autowired
/*    */   private ProjectDao projectDao;
/*    */   
/* 20 */   public List<ProjectInfo> findAllProject() { return this.projectDao.findAllProject(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 25 */   public List<String> findAllProjectName() { return this.projectDao.findAllProjectName(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 30 */   public void saveProject(ProjectInfo projectInfo) { this.projectDao.saveProject(projectInfo); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 35 */   public ProjectInfo findProjectByName(String projectname) { return this.projectDao.findProjectByName(projectname); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean editProject(ProjectInfo projectInfo) {
/*    */     boolean flag;
/* 42 */     String projectid = projectInfo.getProjectid();
/*    */     
/* 44 */     this.projectDao.editProject(projectInfo);
/* 45 */     ProjectInfo projectInfoAfter = null;
/*    */     try {
/* 47 */       projectInfoAfter = this.projectDao.findProjectById(projectid);
/*    */     }
/* 49 */     catch (Exception exception) {}
/*    */ 
/*    */     
/* 52 */     if (projectInfo.getProjectName().equals(projectInfoAfter.getProjectName()) && projectInfo.getDomain().equals(projectInfoAfter.getDomain()) && projectInfo.getProjectDesc().equals(projectInfoAfter.getProjectDesc())) {
/* 53 */       flag = true;
/*    */     } else {
/* 55 */       flag = false;
/*    */     } 
/*    */ 
/*    */     
/* 59 */     return flag;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean delSelectProject(String projectid) {
/*    */     boolean flag;
/* 65 */     this.projectDao.delSelectProject(projectid);
/* 66 */     ProjectInfo projectInfo = this.projectDao.findProjectById(projectid);
/* 67 */     System.out.println("projectInfo:" + projectInfo);
/* 68 */     if (projectInfo == null) {
/*    */       
/* 70 */       flag = true;
/*    */     } else {
/* 72 */       flag = false;
/*    */     } 
/*    */     
/* 75 */     return flag;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\impl\ProjectServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */