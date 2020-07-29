/*    */ package com.luo.controller;;
/*    */ 
/*    */ import com.luo.controller.MocoController;
/*    */ import com.luo.domain.MocoInfo;
/*    */ import com.luo.service.MocoService;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ import org.springframework.web.servlet.View;
/*    */ import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/moco"})
/*    */ public class MocoController
/*    */ {
/*    */   @Autowired
/*    */   private MocoService mocoService;
/*    */   
/*    */   @RequestMapping({"/findAllMoco"})
/*    */   @ResponseBody
/*    */   public ModelAndView findAllMoco() {
/* 30 */     List<MocoInfo> list = this.mocoService.findAllMoco();
/* 31 */     Map<String, List<MocoInfo>> map = new HashMap<>();
/* 32 */     System.out.println("测试list:" + list);
/* 33 */     map.put("result", list);
/* 34 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */   
/*    */   @RequestMapping({"/{url}"})
/*    */   @ResponseBody
/*    */   public String Moco_Get(@PathVariable("url") String url) {
/* 40 */     System.out.println("输入的url值为：" + url);
/* 41 */     String result = null;
/* 42 */     MocoInfo mocoInfo = null;
/*    */     
/* 44 */     if (url.contains("?")) {
/*    */       
/* 46 */       String[] urlList = url.split("\\?");
/*    */       
/* 48 */       String finallyUrl = urlList[0];
/* 49 */       mocoInfo = this.mocoService.findMocoInfo(finallyUrl);
/*    */       
/*    */       try {
/* 52 */         if (mocoInfo.getIs_need_par().equals("是")) {
/* 53 */           if (mocoInfo.getParamter().equals(urlList[1])) {
/* 54 */             result = this.mocoService.findReturnValue(url);
/*    */           } else {
/* 56 */             result = "参数不对，请重新输入";
/*    */           } 
/*    */         }
/* 59 */       } catch (Exception e) {
/* 60 */         e.printStackTrace();
/*    */       } 
/*    */     } else {
/*    */ 
/*    */       
/*    */       try {
/*    */ 
/*    */         
/* 68 */         result = this.mocoService.findReturnValue(url);
/* 69 */       } catch (Exception e) {
/* 70 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 75 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\controller\MocoController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */