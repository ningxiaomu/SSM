/*    */ package com.luo.controller;;
/*    */ 
/*    */ import com.github.pagehelper.PageInfo;
/*    */ import com.luo.controller.SysLogController;
/*    */ import com.luo.domain.SysLog;
/*    */ import com.luo.service.SysLogService;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ import org.springframework.web.servlet.View;
/*    */ import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/sysLog"})
/*    */ public class SysLogController
/*    */ {
/*    */   @Autowired
/*    */   private SysLogService sysLogService;
/*    */   
/*    */   @RequestMapping({"/findAllLog"})
/*    */   @ResponseBody
/*    */   public ModelAndView findAllLog(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "100") Integer size) {
/* 30 */     List<SysLog> list = new ArrayList<>();
/* 31 */     list = this.sysLogService.findAllLog(page, size);
/* 32 */     PageInfo pageInfo = new PageInfo(list);
/* 33 */     Map<String, Object> mp = new HashMap<>();
/* 34 */     mp.put("obj", pageInfo);
/* 35 */     Map<String, Object> map = new HashMap<>();
/* 36 */     map.put("result", list);
/* 37 */     map.putAll(mp);
/* 38 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\controller\SysLogController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */