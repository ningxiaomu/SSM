package com.luo.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.luo.dao.SysLogDao;
/*    */ import com.luo.domain.SysLog;
/*    */ import com.luo.service.SysLogService;
/*    */ import com.luo.service.impl.SysLogServiceImpl;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("sysLogService")
/*    */ @Transactional(readOnly = false)
/*    */ public class SysLogServiceImpl
/*    */   implements SysLogService {
/*    */   @Autowired
/*    */   private SysLogDao sysLogDao;
/*    */   
/* 20 */   public void save(SysLog log) { this.sysLogDao.save(log); }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<SysLog> findAllLog(Integer page, Integer size) {
/* 25 */     PageHelper.startPage(page.intValue(), size.intValue());
/* 26 */     return this.sysLogDao.findAllLog();
/*    */   }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\impl\SysLogServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */