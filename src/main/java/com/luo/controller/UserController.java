/*     */ package com.luo.controller;;
/*     */ 
/*     */ import com.github.pagehelper.PageInfo;
/*     */ import com.luo.controller.UserController;
/*     */ import com.luo.domain.RoleInfo;
/*     */ import com.luo.domain.UserInfo;
/*     */ import com.luo.service.UserService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ import org.springframework.web.servlet.View;
/*     */ import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/user"})
/*     */ public class UserController
/*     */ {
/*     */   @Autowired
/*     */   private UserService userService;
/*     */   
/*     */   @RequestMapping({"/findAllUserPage"})
/*     */   @ResponseBody
/*     */   public ModelAndView findAllUser(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {
/*  34 */     List<UserInfo> list = new ArrayList<>();
/*  35 */     list = this.userService.findAllUserPage(page.intValue(), size.intValue());
/*  36 */     PageInfo pageInfo = new PageInfo(list);
/*  37 */     Map<String, Object> mp = new HashMap<>();
/*  38 */     mp.put("obj", pageInfo);
/*  39 */     Map<String, Object> map = new HashMap<>();
/*  40 */     map.put("result", list);
/*  41 */     map.putAll(mp);
/*  42 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/findUserDel"})
/*     */   @ResponseBody
/*     */   public ModelAndView findUserDel(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {
/*  54 */     List<UserInfo> list = new ArrayList<>();
/*  55 */     list = this.userService.findUserDel(page.intValue(), size.intValue());
/*  56 */     PageInfo pageInfo = new PageInfo(list);
/*  57 */     Map<String, Object> mp = new HashMap<>();
/*  58 */     mp.put("obj", pageInfo);
/*  59 */     Map<String, Object> map = new HashMap<>();
/*  60 */     map.put("result", list);
/*  61 */     map.putAll(mp);
/*  62 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/getUserCount"})
/*     */   @ResponseBody
/*     */   public ModelAndView getUserCount() {
/*  69 */     String userCount = "";
/*  70 */     String projectCount = "";
/*  71 */     String caseCount = "";
/*     */     try {
/*  73 */       userCount = this.userService.getUserCount();
/*  74 */       projectCount = this.userService.getProjectCount();
/*  75 */       caseCount = this.userService.getCaseCount();
/*  76 */     } catch (Exception e) {
/*  77 */       e.printStackTrace();
/*     */     } 
/*  79 */     List<String> list = new ArrayList<>();
/*  80 */     list.add(userCount);
/*  81 */     list.add(projectCount);
/*  82 */     list.add(caseCount);
/*  83 */     Map<String, List<String>> map = new HashMap<>();
/*  84 */     map.put("result", list);
/*  85 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/saveUser"})
/*     */   @ResponseBody
/*     */   public ModelAndView saveUser(UserInfo userInfo) {
/*  93 */     boolean flag = this.userService.saveUser(userInfo);
/*     */     
/*  95 */     System.out.println("添加用户的结果" + flag);
/*  96 */     Map<String, Boolean> map = new HashMap<>();
/*  97 */     map.put("result", Boolean.valueOf(flag));
/*  98 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/findUserByIdAndAllRole"})
/*     */   public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "userid", required = true) String userid) {
/* 103 */     ModelAndView modelAndView = new ModelAndView();
/*     */     
/* 105 */     UserInfo userInfo = this.userService.findUserById(userid);
/*     */     
/* 107 */     List<RoleInfo> otherRoles = this.userService.findUserOtherRole(userid);
/* 108 */     modelAndView.addObject("user", userInfo);
/* 109 */     modelAndView.addObject("otherRoles", otherRoles);
/* 110 */     modelAndView.setViewName("user-role");
/* 111 */     return modelAndView;
/*     */   }
/*     */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\controller\UserController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */