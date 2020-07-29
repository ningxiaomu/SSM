/*    */ package com.luo.controller;;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.UUID;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/file"})
/*    */ public class FileController
/*    */ {
/*    */   @RequestMapping({"/upload"})
/*    */   public String fileUpload(HttpServletRequest request, MultipartFile upload) throws Exception {
/* 24 */     String path = request.getSession().getServletContext().getRealPath("/uploads/");
/* 25 */     System.out.println("path:" + path);
/*    */     
/* 27 */     File file = new File(path);
/* 28 */     if (!file.exists()) {
/* 29 */       file.mkdirs();
/*    */     }
/*    */ 
/*    */     
/* 33 */     String filename = upload.getOriginalFilename();
/*    */     
/* 35 */     String uuid = UUID.randomUUID().toString().replace("-", "");
/* 36 */     filename = uuid + "_" + filename;
/* 37 */     upload.transferTo(new File(path, filename));
/* 38 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\controller\FileController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */