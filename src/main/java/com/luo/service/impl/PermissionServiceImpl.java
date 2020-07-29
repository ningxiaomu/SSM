package com.luo.service.impl;
/*    */ 
/*    */ import com.luo.dao.PermissionDao;
/*    */ import com.luo.domain.PermissionInfo;
/*    */ import com.luo.service.PermissionService;
/*    */ import com.luo.service.impl.PermissionServiceImpl;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("permissionService")
/*    */ @Transactional
/*    */ public class PermissionServiceImpl
/*    */   implements PermissionService {
/*    */   @Autowired
/*    */   private PermissionDao permissionDao;
/*    */   
/* 19 */   public List<PermissionInfo> findAllPermission() { return this.permissionDao.findAllPermission(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean savePermission(PermissionInfo permissionInfo) {
/*    */     boolean flag;
/* 26 */     Integer saveBefore = this.permissionDao.getCountPermission();
/*    */     
/* 28 */     this.permissionDao.savePermission(permissionInfo);
/*    */     
/* 30 */     Integer saveAfter = this.permissionDao.getCountPermission();
/* 31 */     Integer num = Integer.valueOf(saveAfter.intValue() - saveBefore.intValue());
/* 32 */     if (num.toString().equals("1")) {
/* 33 */       flag = true;
/*    */     } else {
/* 35 */       flag = false;
/*    */     } 
/*    */     
/* 38 */     return flag;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\impl\PermissionServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */