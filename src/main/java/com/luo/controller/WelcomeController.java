/*    */ package com.luo.controller;;
/*    */ 
/*    */ import com.luo.controller.WelcomeController;
/*    */ import com.luo.domain.ResultSize;
/*    */ import com.luo.service.WelcomeService;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ import org.springframework.web.servlet.View;
/*    */ import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/welcome"})
/*    */ public class WelcomeController
/*    */ {
/*    */   @RequestMapping({"/findAllResultSize"})
/*    */   @ResponseBody
/*    */   public ModelAndView getResultSzie() {
/* 26 */     List<ResultSize> list = new ArrayList<>();
/* 27 */     list = this.welcomeService.findAllResultSize();
/* 28 */     Map<String, List<ResultSize>> map = new HashMap<>();
/* 29 */     map.put("result", list);
/* 30 */     System.out.println("测试结果数量：" + map);
/* 31 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */   
/*    */   @Autowired
/*    */   private WelcomeService welcomeService;
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\controller\WelcomeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */