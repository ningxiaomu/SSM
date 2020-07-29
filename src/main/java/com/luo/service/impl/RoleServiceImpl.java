package com.luo.service.impl;
/*    */ 
/*    */ import com.luo.dao.RoleDao;
/*    */ import com.luo.domain.RoleInfo;
/*    */ import com.luo.service.RoleService;
/*    */ import com.luo.service.impl.RoleServiceImpl;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("roleService")
/*    */ @Transactional
/*    */ public class RoleServiceImpl
/*    */   implements RoleService {
/*    */   @Autowired
/*    */   private RoleDao roleDao;
/*    */   
/* 19 */   public List<RoleInfo> findAllRole() { return this.roleDao.findAllRole(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean saveRole(RoleInfo roleInfo) {
/*    */     boolean flag;
/* 26 */     Integer saveBefore = this.roleDao.getCountRole();
/* 27 */     System.out.println("saveBefore:" + saveBefore);
/*    */     
/* 29 */     this.roleDao.saveRole(roleInfo);
/*    */     
/* 31 */     Integer saveAfter = this.roleDao.getCountRole();
/* 32 */     System.out.println("saveAfter:" + saveAfter);
/* 33 */     Integer num = Integer.valueOf(saveAfter.intValue() - saveBefore.intValue());
/* 34 */     if (num.toString().equals("1")) {
/* 35 */       flag = true;
/*    */     } else {
/* 37 */       flag = false;
/*    */     } 
/* 39 */     return flag;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\impl\RoleServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */