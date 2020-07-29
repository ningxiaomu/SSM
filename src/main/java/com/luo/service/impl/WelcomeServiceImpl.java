package com.luo.service.impl;
/*    */ 
/*    */ import com.luo.dao.WelcomeDao;
/*    */ import com.luo.domain.ResultSize;
/*    */ import com.luo.service.WelcomeService;
/*    */ import com.luo.service.impl.WelcomeServiceImpl;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("welcome")
/*    */ @Transactional
/*    */ public class WelcomeServiceImpl
/*    */   implements WelcomeService {
/*    */   @Autowired
/*    */   private WelcomeDao welcomeDao;
/*    */   
/* 19 */   public List<ResultSize> findAllResultSize() { return this.welcomeDao.findAllResultSize(); }
/*    */ }


