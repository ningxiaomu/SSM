package com.luo.service.impl;
/*     */ 
/*     */ import com.luo.dao.InterfaceDao;
/*     */ import com.luo.domain.InterfaceBodyInfo;
/*     */ import com.luo.domain.InterfaceHeaderInfo;
/*     */ import com.luo.domain.InterfaceInfo;
/*     */ import com.luo.domain.InterfaceReturnDataInfo;
/*     */ import com.luo.service.InterfaceService;
/*     */ import com.luo.service.impl.InterfaceServiceImpl;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ @Service("interfaceService")
/*     */ @Transactional
/*     */ public class InterfaceServiceImpl
/*     */   implements InterfaceService {
/*     */   @Autowired
/*     */   private InterfaceDao interfaceDao;
/*     */   
/*  22 */   public List<InterfaceInfo> findAllInterface() { return this.interfaceDao.findAllInterface(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  27 */   public List<InterfaceInfo> findInterfaceById(String interfaceId) { return this.interfaceDao.findInterfaceById(interfaceId); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  32 */   public List<InterfaceHeaderInfo> findInterfaceHeaderById(String interfaceId) { return this.interfaceDao.findInterfaceHeaderById(interfaceId); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   public List<InterfaceBodyInfo> findInterfaceBodyById(String interfaceId) { return this.interfaceDao.findInterfaceBodyById(interfaceId); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   public List<InterfaceReturnDataInfo> findInterfaceReturnDataById(String interfaceId) { return this.interfaceDao.findInterfaceReturnDataById(interfaceId); }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean editBasicInformation(InterfaceInfo interfaceInfo) {
/*     */     boolean flag;
/*  48 */     String interfaceId = interfaceInfo.getInterfaceId();
/*  49 */     this.interfaceDao.editBasicInformation(interfaceInfo);
/*  50 */     InterfaceInfo infoAfter = this.interfaceDao.findInterceInfoByIdInfo(interfaceId);
/*     */     
/*  52 */     if (interfaceInfo.getInterfaceName().equals(infoAfter.getInterfaceName()) && interfaceInfo.getProject().equals(infoAfter.getProject()) && interfaceInfo.getDomain().equals(infoAfter.getDomain()) && interfaceInfo.getRequestAddress().equals(infoAfter.getRequestAddress()) && interfaceInfo.getMethod().equals(infoAfter.getMethod())) {
/*  53 */       flag = true;
/*     */     } else {
/*  55 */       flag = false;
/*     */     } 
/*  57 */     return flag;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean delSelectInterface(String interfaceId) {
/*     */     boolean flag;
/*  63 */     this.interfaceDao.delSelectInterface(interfaceId);
/*  64 */     InterfaceInfo interfaceInfo = this.interfaceDao.findInterceInfoByIdInfo(interfaceId);
/*  65 */     if (interfaceInfo == null) {
/*     */       
/*  67 */       flag = true;
/*     */     } else {
/*  69 */       flag = false;
/*     */     } 
/*  71 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   public void addInterface(InterfaceInfo interfaceInfo) { this.interfaceDao.addInterface(interfaceInfo); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   public void addInterfaceBody(InterfaceBodyInfo info) { this.interfaceDao.addInterfaceBody(info); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   public void delInterfaceBody(String interfaceid) { this.interfaceDao.delInterfaceBody(interfaceid); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public void delInterfaceReturnData(String substring) { this.interfaceDao.delInterfaceReturnData(substring); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   public void addInterfaceReturnData(InterfaceReturnDataInfo info) { this.interfaceDao.addInterfaceReturnData(info); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   public void delInterfaceHeader(String substring) { this.interfaceDao.delInterfaceHeader(substring); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   public void addInterfaceHeader(InterfaceHeaderInfo interfaceHeaderInfo) { this.interfaceDao.addInterfaceHeader(interfaceHeaderInfo); }
/*     */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\impl\InterfaceServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */