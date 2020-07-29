/*    */ package com.luo.controller;;
/*    */ 
/*    */ import com.luo.controller.PermissionController;
/*    */ import com.luo.domain.PermissionInfo;
/*    */ import com.luo.service.PermissionService;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ import org.springframework.web.servlet.View;
/*    */ import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/permission"})
/*    */ public class PermissionController
/*    */ {
/*    */   @Autowired
/*    */   private PermissionService permissionService;
/*    */   
/*    */   @RequestMapping({"/findAllPermission"})
/*    */   @ResponseBody
/*    */   public ModelAndView findAllPermission() {
/* 33 */     List<PermissionInfo> list = new ArrayList<>();
/*    */     try {
/* 35 */       list = this.permissionService.findAllPermission();
/*    */     }
/* 37 */     catch (Exception e) {
/* 38 */       e.printStackTrace();
/*    */     } 
/* 40 */     Map<String, List<PermissionInfo>> map = new HashMap<>();
/* 41 */     map.put("result", list);
/* 42 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */ 
/*    */   
/*    */   @RequestMapping({"/savePermission"})
/*    */   @ResponseBody
/*    */   public ModelAndView saveRole(@RequestBody PermissionInfo permissionInfo) {
/* 49 */     boolean flag = this.permissionService.savePermission(permissionInfo);
/* 50 */     Map<String, Boolean> map = new HashMap<>();
/* 51 */     map.put("result", Boolean.valueOf(flag));
/* 52 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\controller\PermissionController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */