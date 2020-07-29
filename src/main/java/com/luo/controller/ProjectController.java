/*    */ package com.luo.controller;;
/*    */ 
/*    */ import com.luo.controller.ProjectController;
/*    */ import com.luo.domain.ProjectInfo;
/*    */ import com.luo.service.ProjectService;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ import org.springframework.web.servlet.View;
/*    */ import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/project"})
/*    */ public class ProjectController
/*    */ {
/*    */   @Autowired
/*    */   private ProjectService projectService;
/*    */   
/*    */   @RequestMapping({"/findAllProject"})
/*    */   @ResponseBody
/*    */   public ModelAndView findAllProject() {
/* 32 */     List<ProjectInfo> list = new ArrayList<>();
/* 33 */     list = this.projectService.findAllProject();
/* 34 */     Map<String, List<ProjectInfo>> map = new HashMap<>();
/* 35 */     map.put("result", list);
/* 36 */     System.out.println("项目的List:" + list);
/* 37 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @RequestMapping({"/getProjectList"})
/*    */   @ResponseBody
/*    */   public List<String> getAllProjectName() {
/* 47 */     List<String> list = this.projectService.findAllProjectName();
/* 48 */     return list;
/*    */   }
/*    */   
/*    */   @RequestMapping({"/saveProject"})
/*    */   @ResponseBody
/*    */   public ModelAndView saveProject(@RequestBody ProjectInfo projectInfo) {
/* 54 */     String projectname = projectInfo.getProjectName();
/* 55 */     this.projectService.saveProject(projectInfo);
/* 56 */     boolean flag = true;
/*    */     
/* 58 */     ProjectInfo project = this.projectService.findProjectByName(projectname);
/* 59 */     if (project == null) {
/* 60 */       flag = false;
/*    */     } else {
/* 62 */       flag = true;
/*    */     } 
/* 64 */     Map<String, Boolean> map = new HashMap<>();
/* 65 */     map.put("result", Boolean.valueOf(flag));
/* 66 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @RequestMapping({"/editProject"})
/*    */   @ResponseBody
/*    */   public ModelAndView editCaseById(@RequestBody ProjectInfo projectInfo) {
/* 77 */     boolean result = this.projectService.editProject(projectInfo);
/* 78 */     Map<String, Boolean> map = new HashMap<>();
/* 79 */     map.put("result", Boolean.valueOf(result));
/* 80 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */ 
/*    */   
/*    */   @RequestMapping({"/deleteProject"})
/*    */   @ResponseBody
/*    */   public ModelAndView deleteProject(@RequestParam(required = true) String projectid) {
/* 87 */     boolean result = this.projectService.delSelectProject(projectid);
/* 88 */     Map<String, Boolean> map = new HashMap<>();
/* 89 */     map.put("result", Boolean.valueOf(result));
/* 90 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\controller\ProjectController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */