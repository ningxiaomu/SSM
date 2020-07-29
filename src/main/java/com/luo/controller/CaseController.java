/*     */ package com.luo.controller;;
/*     */ 
/*     */ import com.github.pagehelper.PageInfo;
/*     */ import com.luo.controller.CaseController;
/*     */ import com.luo.domain.CaseInfo;
/*     */ import com.luo.service.CaseService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ import org.springframework.web.servlet.View;
/*     */ import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/case"})
/*     */ public class CaseController
/*     */ {
/*     */   @Autowired
/*     */   private CaseService caseService;
/*     */   
/*     */   @RequestMapping({"/findAllCase"})
/*     */   @ResponseBody
/*     */   public ModelAndView findAllCase() {
/*  36 */     List<CaseInfo> list = new ArrayList<>();
/*  37 */     list = this.caseService.findAllCase();
/*  38 */     Map<String, List<CaseInfo>> map = new HashMap<>();
/*  39 */     map.put("result", list);
/*  40 */     System.out.println("list:" + list);
/*  41 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/saveCase"})
/*     */   @ResponseBody
/*     */   public ModelAndView saveCase(@RequestBody CaseInfo caseInfo) {
/*  53 */     String caseName = caseInfo.getCaseName();
/*  54 */     this.caseService.saveCase(caseInfo);
/*     */     
/*  56 */     boolean flag = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     Map<String, Boolean> map = new HashMap<>();
/*  63 */     map.put("result", Boolean.valueOf(flag));
/*  64 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/findAllSelectCase"})
/*     */   @ResponseBody
/*     */   public ModelAndView findAllSelectCase(String projectName, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {
/*  70 */     List<CaseInfo> list = new ArrayList<>();
/*  71 */     list = this.caseService.findAllSelectCasePage(projectName, page.intValue(), size.intValue());
/*  72 */     PageInfo pageInfo = new PageInfo(list);
/*  73 */     Map<String, Object> caseInfoMap = new HashMap<>();
/*  74 */     Map<String, Object> pageInfoMap = new HashMap<>();
/*  75 */     caseInfoMap.put("result", list);
/*  76 */     pageInfoMap.put("obj", pageInfo);
/*  77 */     caseInfoMap.putAll(pageInfoMap);
/*  78 */     return new ModelAndView((View)new MappingJackson2JsonView(), caseInfoMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/findConditionCase"})
/*     */   @ResponseBody
/*     */   public ModelAndView findConditionCase(String conditionSelect, String conditionValue, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {
/*  92 */     List<CaseInfo> list = new ArrayList<>();
/*     */     
/*  94 */     list = this.caseService.findConditionCase(conditionValue, conditionSelect, page, size);
/*  95 */     PageInfo pageInfo = new PageInfo(list);
/*  96 */     Map<String, Object> caseinfoMap = new HashMap<>();
/*     */     
/*  98 */     Map<String, Object> pageinfoMap = new HashMap<>();
/*     */     
/* 100 */     caseinfoMap.put("result", list);
/* 101 */     pageinfoMap.put("obj", pageInfo);
/* 102 */     caseinfoMap.putAll(pageinfoMap);
/* 103 */     return new ModelAndView((View)new MappingJackson2JsonView(), caseinfoMap);
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/findAllSelectCaseAfterEdit"})
/*     */   @ResponseBody
/*     */   public ModelAndView findAllSelectCaseAfterEdit(String projectName, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {
/* 110 */     ModelAndView modelAndView = new ModelAndView();
/* 111 */     List<CaseInfo> list = new ArrayList<>();
/* 112 */     list = this.caseService.findAllSelectCasePage(projectName, page.intValue(), size.intValue());
/* 113 */     System.out.println("编辑过后的list:" + list);
/* 114 */     PageInfo pageInfo = new PageInfo(list);
/* 115 */     System.out.println("pageInfo:" + pageInfo);
/* 116 */     modelAndView.addObject("pageInfo", pageInfo);
/* 117 */     modelAndView.addObject("caselist", list);
/*     */     
/* 119 */     modelAndView.setViewName("case-list-edit");
/* 120 */     return modelAndView;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/findAllSelectCaseAfterAdd"})
/*     */   public ModelAndView findAllSelectCaseAfterAdd(String projectName, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {
/* 126 */     ModelAndView modelAndView = new ModelAndView();
/* 127 */     List<CaseInfo> list = new ArrayList<>();
/* 128 */     list = this.caseService.findAllSelectCasePage(projectName, page.intValue(), size.intValue());
/* 129 */     PageInfo pageInfo = new PageInfo(list);
/* 130 */     System.out.println("pageInfo:" + pageInfo);
/* 131 */     modelAndView.addObject("pageInfo", pageInfo);
/* 132 */     modelAndView.addObject("caselist", list);
/* 133 */     modelAndView.setViewName("case-list-add");
/* 134 */     return modelAndView;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/findAllCasePage"})
/*     */   @ResponseBody
/*     */   public ModelAndView findAllCasePage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {
/* 141 */     List<CaseInfo> list = new ArrayList<>();
/* 142 */     list = this.caseService.findAllCasePage(page.intValue(), size.intValue());
/* 143 */     PageInfo pageInfo = new PageInfo(list);
/* 144 */     Map<String, Object> mp = new HashMap<>();
/* 145 */     mp.put("obj", pageInfo);
/* 146 */     System.out.println("pageInfo:" + mp);
/* 147 */     Map<String, Object> map = new HashMap<>();
/* 148 */     map.put("result", list);
/* 149 */     System.out.println("list:" + list);
/* 150 */     map.putAll(mp);
/* 151 */     System.out.println("最后的map" + map);
/* 152 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/delSelectCase"})
/*     */   @ResponseBody
/*     */   public ModelAndView delSelectCase(@RequestParam(value = "caseid", required = true) String caseid) {
/* 163 */     System.out.println("传过来的caseid:" + caseid);
/* 164 */     boolean result = this.caseService.delSelectCase(caseid);
/* 165 */     System.out.println("CaseController里的result:" + result);
/* 166 */     Map<String, Boolean> map = new HashMap<>();
/* 167 */     map.put("result", Boolean.valueOf(result));
/* 168 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/findCaseById"})
/*     */   public ModelAndView findCaseById(@RequestParam(value = "caseid", required = true) String caseid) {
/* 178 */     ModelAndView modelAndView = new ModelAndView();
/* 179 */     CaseInfo caseInfo = this.caseService.findCaseByCaseid(caseid);
/* 180 */     modelAndView.addObject("caseInfo", caseInfo);
/* 181 */     modelAndView.setViewName("case-edit");
/* 182 */     System.out.println("caseInfo:" + caseInfo);
/* 183 */     return modelAndView;
/*     */   }
/*     */   
/*     */   @RequestMapping({"findCaseByIdReturnJson"})
/*     */   public ModelAndView findCaseByIdReturnJson(@RequestParam(value = "caseid", required = true) String caseid) {
/* 188 */     List<CaseInfo> list = new ArrayList<>();
/* 189 */     list = this.caseService.findCaseByIdReturnJson(caseid);
/* 190 */     Map<String, List<CaseInfo>> map = new HashMap<>();
/* 191 */     map.put("result", list);
/* 192 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/editCase"})
/*     */   @ResponseBody
/*     */   public ModelAndView editCaseById(@RequestBody CaseInfo caseInfo) {
/* 203 */     System.out.println("controller里的caseinfo:" + caseInfo);
/* 204 */     boolean result = this.caseService.editCase(caseInfo);
/* 205 */     Map<String, Boolean> map = new HashMap<>();
/* 206 */     map.put("result", Boolean.valueOf(result));
/* 207 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/getProjectById"})
/*     */   public String getProjectById(String caseid) {
/* 213 */     String project = this.caseService.findProjectById(caseid);
/* 214 */     return project;
/*     */   }
/*     */ }


