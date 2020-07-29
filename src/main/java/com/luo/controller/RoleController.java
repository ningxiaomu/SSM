/*    */ package com.luo.controller;;
/*    */ 
/*    */ import com.luo.controller.RoleController;
/*    */ import com.luo.domain.RoleInfo;
/*    */ import com.luo.service.RoleService;
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
/*    */ @Controller
/*    */ @RequestMapping({"/role"})
/*    */ public class RoleController
/*    */ {
/*    */   @Autowired
/*    */   private RoleService roleService;
/*    */   
/*    */   @RequestMapping({"/findAllRole"})
/*    */   @ResponseBody
/*    */   public ModelAndView findAllRole() {
/* 32 */     List<RoleInfo> list = new ArrayList<>();
/*    */     try {
/* 34 */       list = this.roleService.findAllRole();
/*    */     }
/* 36 */     catch (Exception e) {
/* 37 */       e.printStackTrace();
/*    */     } 
/* 39 */     Map<String, List<RoleInfo>> map = new HashMap<>();
/* 40 */     map.put("result", list);
/* 41 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */ 
/*    */   
/*    */   @RequestMapping({"/saveRole"})
/*    */   @ResponseBody
/*    */   public ModelAndView saveRole(@RequestBody RoleInfo roleInfo) {
/* 48 */     boolean flag = this.roleService.saveRole(roleInfo);
/* 49 */     Map<String, Boolean> map = new HashMap<>();
/* 50 */     map.put("result", Boolean.valueOf(flag));
/* 51 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\controller\RoleController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */