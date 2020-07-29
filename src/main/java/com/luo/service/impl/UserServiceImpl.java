package com.luo.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.luo.dao.UserDao;
/*     */ import com.luo.domain.RoleInfo;
/*     */ import com.luo.domain.UserInfo;
/*     */ import com.luo.service.UserService;
/*     */ import com.luo.service.impl.UserServiceImpl;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.security.core.authority.SimpleGrantedAuthority;
/*     */ import org.springframework.security.core.userdetails.User;
/*     */ import org.springframework.security.core.userdetails.UserDetails;
/*     */ import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ @Service("user")
/*     */ @Transactional
/*     */ public class UserServiceImpl
/*     */   implements UserService {
/*     */   @Autowired
/*     */   private UserDao userDao;
/*     */   
/*     */   public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
/*  27 */     UserInfo userInfo = null;
/*     */     try {
/*  29 */       userInfo = this.userDao.findByUsername(s);
/*  30 */       System.out.println(userInfo);
/*  31 */     } catch (Exception e) {
/*  32 */       e.printStackTrace();
/*     */     } 
/*  34 */     User user = null;
/*     */     try {
/*  36 */       user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), !(userInfo.getStatus().intValue() == 0), true, true, true, getAuthority(userInfo.getRoles()));
/*  37 */     } catch (Exception e) {
/*  38 */       e.printStackTrace();
/*     */     } 
/*  40 */     return (UserDetails)user;
/*     */   }
/*     */   
/*     */   public List<SimpleGrantedAuthority> getAuthority(List<RoleInfo> roles) throws Exception {
/*  44 */     List<SimpleGrantedAuthority> list = new ArrayList<>();
/*  45 */     for (RoleInfo role : roles) {
/*  46 */       list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
/*     */     }
/*     */     
/*  49 */     System.out.println("用户角色list：" + list);
/*  50 */     return list;
/*     */   }
/*     */ 
/*     */   
/*  54 */   public List<UserInfo> findAllUser() { return this.userDao.findAllUser(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   public UserInfo findUserByName(String username) { return null; }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<UserInfo> findAllUserPage(int page, int size) {
/*  64 */     PageHelper.startPage(page, size);
/*  65 */     return this.userDao.findAllUser();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<UserInfo> findUserDel(int page, int size) {
/*  70 */     PageHelper.startPage(page, size);
/*  71 */     return this.userDao.findDelUser();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  76 */   public String getUserCount() { return this.userDao.getUserCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public String getProjectCount() { return this.userDao.getProjectCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   public String getCaseCount() { return this.userDao.getCaseCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean saveUser(UserInfo userInfo) {
/*     */     boolean flag;
/*  93 */     Integer saveBefore = this.userDao.getCount();
/*     */     
/*     */     try {
/*  96 */       this.userDao.saveUser(userInfo);
/*  97 */     } catch (Exception e) {
/*  98 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 101 */     Integer saveAfter = this.userDao.getCount();
/*     */     
/* 103 */     Integer num = Integer.valueOf(saveAfter.intValue() - saveBefore.intValue());
/* 104 */     if (num.toString().equals("1")) {
/* 105 */       flag = true;
/*     */     } else {
/* 107 */       flag = false;
/*     */     } 
/* 109 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 114 */   public UserInfo findUserById(String userid) { return this.userDao.findUserById(userid); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public List<RoleInfo> findUserOtherRole(String userid) { return this.userDao.findOtherRoles(userid); }
/*     */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\impl\UserServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */