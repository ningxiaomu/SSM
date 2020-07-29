/*     */ package com.luo.controller;;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.luo.controller.InterfaceController;
/*     */ import com.luo.domain.InterfaceBodyInfo;
/*     */ import com.luo.domain.InterfaceHeaderInfo;
/*     */ import com.luo.domain.InterfaceInfo;
/*     */ import com.luo.domain.InterfaceReturnDataInfo;
/*     */ import com.luo.service.InterfaceService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ import org.springframework.web.servlet.View;
/*     */ import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/interface"})
/*     */ public class InterfaceController
/*     */ {
/*     */   @RequestMapping({"/findAllInterface"})
/*     */   @ResponseBody
/*     */   public ModelAndView findAllInterface() {
/*  31 */     List<InterfaceInfo> list = new ArrayList<>();
/*  32 */     list = this.interfaceService.findAllInterface();
/*  33 */     Map<String, List<InterfaceInfo>> map = new HashMap<>();
/*  34 */     map.put("result", list);
/*  35 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   } @Autowired
/*     */   private InterfaceService interfaceService;
/*     */   @RequestMapping({"/findInterfaceById"})
/*     */   @ResponseBody
/*     */   public ModelAndView findInterfaceById(String InterfaceId) {
/*  41 */     List<InterfaceInfo> list = new ArrayList<>();
/*  42 */     list = this.interfaceService.findInterfaceById(InterfaceId);
/*  43 */     Map<String, List<InterfaceInfo>> map = new HashMap<>();
/*  44 */     map.put("result", list);
/*  45 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/findInterfaceHeaderById"})
/*     */   @ResponseBody
/*     */   public ModelAndView findInterfaceHeaderById(String InterfaceId) {
/*  56 */     List<InterfaceHeaderInfo> list = new ArrayList<>();
/*  57 */     list = this.interfaceService.findInterfaceHeaderById(InterfaceId);
/*  58 */     Map<String, List<InterfaceHeaderInfo>> map = new HashMap<>();
/*  59 */     map.put("result", list);
/*  60 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/findInterfaceBodyById"})
/*     */   @ResponseBody
/*     */   public ModelAndView findInterfaceBodyById(String InterfaceId) {
/*  71 */     List<InterfaceBodyInfo> list = new ArrayList<>();
/*  72 */     list = this.interfaceService.findInterfaceBodyById(InterfaceId);
/*  73 */     Map<String, List<InterfaceBodyInfo>> map = new HashMap<>();
/*  74 */     map.put("result", list);
/*  75 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/findInterfaceReturnDataById"})
/*     */   @ResponseBody
/*     */   public ModelAndView findInterfaceReturnDataById(String InterfaceId) {
/*  86 */     List<InterfaceReturnDataInfo> list = new ArrayList<>();
/*  87 */     list = this.interfaceService.findInterfaceReturnDataById(InterfaceId);
/*  88 */     Map<String, List<InterfaceReturnDataInfo>> map = new HashMap<>();
/*  89 */     map.put("result", list);
/*  90 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/editBasicInformation"})
/*     */   @ResponseBody
/*     */   public ModelAndView editBasicInformation(@RequestBody InterfaceInfo interfaceInfo) {
/* 101 */     boolean flag = true;
/* 102 */     flag = this.interfaceService.editBasicInformation(interfaceInfo);
/* 103 */     Map<String, Boolean> map = new HashMap<>();
/* 104 */     map.put("result", Boolean.valueOf(flag));
/* 105 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/delSelectInterface"})
/*     */   @ResponseBody
/*     */   public ModelAndView delSelectInterface(String InterfaceId) {
/* 117 */     boolean flag = this.interfaceService.delSelectInterface(InterfaceId);
/* 118 */     Map<String, Boolean> map = new HashMap<>();
/* 119 */     map.put("result", Boolean.valueOf(flag));
/* 120 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/addInterface"})
/*     */   @ResponseBody
/*     */   public ModelAndView addInterface(@RequestBody InterfaceInfo interfaceInfo) {
/* 132 */     this.interfaceService.addInterface(interfaceInfo);
/* 133 */     Map<String, Boolean> map = new HashMap<>();
/* 134 */     map.put("result", Boolean.valueOf(true));
/* 135 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/addBody"})
/*     */   @ResponseBody
/*     */   public ModelAndView addBody(String interfaceBodyInfo) {
/* 143 */     System.out.println("interfaceBodyInfo:" + interfaceBodyInfo);
/*     */     
/* 145 */     System.out.println("myinterfaceid:" + interfaceBodyInfo.substring(16, 48));
/* 146 */     this.interfaceService.delInterfaceBody(interfaceBodyInfo.substring(16, 48));
/* 147 */     String[] strArr = interfaceBodyInfo.split(";");
/* 148 */     for (int i = 0; i < strArr.length; i++) {
/* 149 */       String json_begin = "{";
/* 150 */       String json_end = "}";
/* 151 */       String jsonT = json_begin + strArr[i] + json_end;
/* 152 */       System.out.println(jsonT);
/* 153 */       JSONObject jsonObject = JSONObject.parseObject(jsonT);
/* 154 */       InterfaceBodyInfo info = new InterfaceBodyInfo();
/* 155 */       info.setInterfaceId(jsonObject.getString("interfaceId"));
/* 156 */       info.setParameterName_body(jsonObject.getString("parameterName_body"));
/* 157 */       info.setType_body(jsonObject.getString("type_body"));
/* 158 */       info.setDefaultValue_body(jsonObject.getString("defaultValue_body"));
/* 159 */       info.setIs_required_body(jsonObject.getString("is_required_body"));
/* 160 */       info.setRemark_body(jsonObject.getString("remark_body"));
/* 161 */       System.out.println("info:" + info);
/*     */       
/* 163 */       this.interfaceService.addInterfaceBody(info);
/*     */     } 
/* 165 */     Map<String, Boolean> map = new HashMap<>();
/* 166 */     map.put("result", Boolean.valueOf(true));
/* 167 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/addReturnData"})
/*     */   @ResponseBody
/*     */   public ModelAndView addReturnData(String Info) {
/* 174 */     System.out.println("interfaceBodyInfo:" + Info);
/*     */     
/* 176 */     System.out.println("myinterfaceid:" + Info.substring(16, 48));
/* 177 */     this.interfaceService.delInterfaceReturnData(Info.substring(16, 48));
/* 178 */     String[] strArr = Info.split(";");
/* 179 */     for (int i = 0; i < strArr.length; i++) {
/* 180 */       String json_begin = "{";
/* 181 */       String json_end = "}";
/* 182 */       String jsonT = json_begin + strArr[i] + json_end;
/* 183 */       System.out.println(jsonT);
/* 184 */       JSONObject jsonObject = JSONObject.parseObject(jsonT);
/* 185 */       InterfaceReturnDataInfo interfaceReturnDataInfo = new InterfaceReturnDataInfo();
/* 186 */       interfaceReturnDataInfo.setInterfaceId(jsonObject.getString("interfaceId"));
/* 187 */       interfaceReturnDataInfo.setParameterName_return(jsonObject.getString("parameterName_return"));
/* 188 */       interfaceReturnDataInfo.setType_return(jsonObject.getString("type_return"));
/* 189 */       interfaceReturnDataInfo.setDefaultValue_return(jsonObject.getString("defaultValue_return"));
/* 190 */       interfaceReturnDataInfo.setIs_required_return(jsonObject.getString("is_required_return"));
/* 191 */       interfaceReturnDataInfo.setRemark_return(jsonObject.getString("remark_return"));
/* 192 */       System.out.println("info:" + interfaceReturnDataInfo);
/*     */       
/* 194 */       this.interfaceService.addInterfaceReturnData(interfaceReturnDataInfo);
/*     */     } 
/* 196 */     Map<String, Boolean> map = new HashMap<>();
/* 197 */     map.put("result", Boolean.valueOf(true));
/* 198 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addHeader"})
/*     */   @ResponseBody
/*     */   public ModelAndView addHeader(String Info) {
/* 204 */     System.out.println("interfaceHeaderInfo:" + Info);
/*     */     
/* 206 */     System.out.println("myinterfaceid:" + Info.substring(16, 48));
/* 207 */     this.interfaceService.delInterfaceHeader(Info.substring(16, 48));
/* 208 */     String[] strArr = Info.split(";");
/* 209 */     for (int i = 0; i < strArr.length; i++) {
/* 210 */       String json_begin = "{";
/* 211 */       String json_end = "}";
/* 212 */       String jsonT = json_begin + strArr[i] + json_end;
/* 213 */       System.out.println(jsonT);
/* 214 */       JSONObject jsonObject = JSONObject.parseObject(jsonT);
/* 215 */       InterfaceHeaderInfo interfaceHeaderInfo = new InterfaceHeaderInfo();
/* 216 */       interfaceHeaderInfo.setInterfaceId(jsonObject.getString("interfaceId"));
/* 217 */       interfaceHeaderInfo.setName(jsonObject.getString("name"));
/* 218 */       interfaceHeaderInfo.setValue(jsonObject.getString("value"));
/* 219 */       interfaceHeaderInfo.setIs_must(jsonObject.getString("is_must"));
/* 220 */       interfaceHeaderInfo.setRemark(jsonObject.getString("remark"));
/* 221 */       System.out.println("info:" + interfaceHeaderInfo);
/*     */       
/* 223 */       this.interfaceService.addInterfaceHeader(interfaceHeaderInfo);
/*     */     } 
/* 225 */     Map<String, Boolean> map = new HashMap<>();
/* 226 */     map.put("result", Boolean.valueOf(true));
/* 227 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*     */   }
/*     */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\controller\InterfaceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */