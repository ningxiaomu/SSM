package com.luo.service.impl;
/*    */ 
/*    */ import com.luo.dao.MocoDao;
/*    */ import com.luo.domain.MocoInfo;
/*    */ import com.luo.service.MocoService;
/*    */ import com.luo.service.impl.MocoServiceImpl;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("mocoService")
/*    */ @Transactional
/*    */ public class MocoServiceImpl
/*    */   implements MocoService
/*    */ {
/*    */   @Autowired
/*    */   private MocoDao mocoDao;
/*    */   
/* 20 */   public List<MocoInfo> findAllMoco() { return this.mocoDao.findAllMoco(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 25 */   public String findReturnValue(String url) { return this.mocoDao.findReturnValue(url); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 30 */   public MocoInfo findMocoInfo(String url) { return this.mocoDao.findMocoInfo(url); }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\impl\MocoServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */