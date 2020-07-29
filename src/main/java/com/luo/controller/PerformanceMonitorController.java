/*    */ package com.luo.controller;;
/*    */ 
/*    */ import com.aliyuncs.AcsRequest;
/*    */ import com.aliyuncs.DefaultAcsClient;
/*    */ import com.aliyuncs.cms.model.v20190101.DescribeMetricListRequest;
/*    */ import com.aliyuncs.cms.model.v20190101.DescribeMetricListResponse;
/*    */ import com.aliyuncs.exceptions.ClientException;
/*    */ import com.aliyuncs.profile.DefaultProfile;
/*    */ import com.aliyuncs.profile.IClientProfile;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ import org.springframework.web.servlet.View;
/*    */ import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/performanceMonitor"})
/*    */ public class PerformanceMonitorController
/*    */ {
/*    */   @RequestMapping({"/CPUUtilization"})
/*    */   @ResponseBody
/*    */   public ModelAndView CPUUtilization() throws ClientException {
/* 31 */     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*    */     
/* 33 */     String now = df.format(new Date());
/* 34 */     Calendar c1 = Calendar.getInstance();
/* 35 */     c1.add(5, -1);
/* 36 */     String lastDay = df.format(c1.getTime());
/* 37 */     System.out.println("上一天:" + lastDay);
/* 38 */     DefaultProfile profile = DefaultProfile.getProfile("cn-zhangjiakou", "LTAI4GDhPzoGf9dRrJhd9KeW", "MJoHA8DFs9Mpdekd6AV9o9gRoZb0uA");
/* 39 */     DefaultAcsClient defaultAcsClient = new DefaultAcsClient((IClientProfile)profile);
/*    */ 
/*    */     
/* 42 */     DescribeMetricListRequest request = new DescribeMetricListRequest();
/* 43 */     request.setRegionId("cn-zhangjiakou");
/* 44 */     request.setMetricName("CPUUtilization");
/* 45 */     request.setNamespace("acs_ecs_dashboard");
/* 46 */     request.setPeriod("1800");
/* 47 */     request.setStartTime(lastDay);
/* 48 */     DescribeMetricListResponse response = (DescribeMetricListResponse)defaultAcsClient.getAcsResponse((AcsRequest)request);
/*    */ 
/*    */     
/* 51 */     DescribeMetricListRequest request_mem = new DescribeMetricListRequest();
/* 52 */     request.setRegionId("cn-zhangjiakou");
/* 53 */     request.setMetricName("memory_actualUsedSpace");
/* 54 */     request.setNamespace("acs_ecs_dashboard");
/* 55 */     request.setPeriod("1800");
/* 56 */     request.setStartTime(lastDay);
/* 57 */     DescribeMetricListResponse response_mem = (DescribeMetricListResponse)defaultAcsClient.getAcsResponse((AcsRequest)request);
/*    */ 
/*    */ 
/*    */     
/* 61 */     Map<String, Object> map = new HashMap<>();
/* 62 */     map.put("result", response);
/* 63 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */ 
/*    */   
/*    */   @RequestMapping({"/memoryActualUsedSpace"})
/*    */   @ResponseBody
/*    */   public ModelAndView memory_actualUsedSpace() throws ClientException {
/* 70 */     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*    */     
/* 72 */     String now = df.format(new Date());
/* 73 */     Calendar c1 = Calendar.getInstance();
/* 74 */     c1.add(5, -1);
/* 75 */     String lastDay = df.format(c1.getTime());
/* 76 */     System.out.println("上一天:" + lastDay);
/* 77 */     DefaultProfile profile = DefaultProfile.getProfile("cn-zhangjiakou", "LTAI4GDhPzoGf9dRrJhd9KeW", "MJoHA8DFs9Mpdekd6AV9o9gRoZb0uA");
/* 78 */     DefaultAcsClient defaultAcsClient = new DefaultAcsClient((IClientProfile)profile);
/*    */     
/* 80 */     DescribeMetricListRequest request = new DescribeMetricListRequest();
/* 81 */     request.setRegionId("cn-zhangjiakou");
/* 82 */     request.setMetricName("memory_usedutilization");
/* 83 */     request.setNamespace("acs_ecs_dashboard");
/* 84 */     request.setPeriod("1800");
/* 85 */     request.setStartTime(lastDay);
/* 86 */     DescribeMetricListResponse response = (DescribeMetricListResponse)defaultAcsClient.getAcsResponse((AcsRequest)request);
/* 87 */     Map<String, Object> map = new HashMap<>();
/* 88 */     map.put("result", response);
/* 89 */     return new ModelAndView((View)new MappingJackson2JsonView(), map);
/*    */   }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\controller\PerformanceMonitorController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */