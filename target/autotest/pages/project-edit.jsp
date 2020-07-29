<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>项目编辑</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="../css/font.css">
        <link rel="stylesheet" href="../css/xadmin.css">
        <link rel="stylesheet" href="../css/layer.css">
        <script type="text/javascript" src="../js/jquery.min.js"></script>
        <script type="text/javascript" src="../js/layer.js"></script>
        <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="../js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <%
    String projectid=request.getParameter("projectid");
    String projectName=request.getParameter("projectName");
    String domain=request.getParameter("domain");
    String projectDesc=request.getParameter("projectDesc");
    String status=request.getParameter("status");
    %>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" id="editProject" action="##" method="post">
                    <div class="layui-form-item">
                        <label for="projectid" class="layui-form-label">
                            <span class="x-red">*</span>projectid
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="projectid" name="projectid" required="" lay-verify="required"
                                   autocomplete="off" class="layui-input" readonly="readonly" value=<%=projectid%>>
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>项目id
                        </div>
                    </div>

                  <div class="layui-form-item">
                      <label for="projectName" class="layui-form-label">
                          <span class="x-red">*</span>projectName
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="projectName" name="projectName" required="" lay-verify="required"
                          autocomplete="off" class="layui-input" value=<%=projectName%>>
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>项目名称
                      </div>
                  </div>



                    <div class="layui-form-item">
                        <label for="domain" class="layui-form-label">
                            <span class="x-red">*</span>domain
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="domain" name="domain" required="" lay-verify="required"
                                   autocomplete="off" class="layui-input" value=<%=domain%>>
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>域名
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label for="projectDesc" class="layui-form-label">
                            <span class="x-red">*</span>项目描述
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="projectDesc" name="projectDesc" required="" lay-verify="required"
                                   autocomplete="off" class="layui-input" value=<%=projectDesc%>>
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>非必填
                        </div>
                    </div>







                    <div class="layui-form-item">
                        <label for="status" class="layui-form-label">
                            <span class="x-red">*</span>status
                        </label>
                        <div class="layui-input-inline">
                            <select id="status" name="status">
                                <option>1</option>
                                <option>0</option>
                            </select>
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>启用状态：1是启用，0是禁用
                        </div>
                    </div>



                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"></label>
                        <p><input type="button" class="layui-btn" value="提交" id="L_repass" onclick="projectEdit()"></p >
                    </div>
              </form>
            </div>
        </div>
        <div style="display: none" id="pname"></div>


        <script>
            function projectEdit() {

                //定义验证规则
                /*验证项目是否选择*/
                var projectValue = $('#projectName').val();
                if(projectValue==""){
                    alert("请输入项目名称");
                    return;
                }else {
                    console.log("项目已选择")
                }
                /*验证域名是否选择*/
                var domainValue = $('#domain').val();
                if(domainValue==""){
                    alert("请输入域名")
                    return;
                }else{
                    console.log("域名已选择")
                }

                var formObject = {};
                var formArray =$("#editProject").serializeArray();
                $.each(formArray,function(i,item){
                    formObject[item.name] = item.value;
                });
                //查找父级页面的项目名称(方便跳转)




                $.ajax({
                    type: "POST",//方法类型
                    dataType: "json",//预期服务器返回的数据类型
                    url: "/project/editProject" ,//url
                    data:JSON.stringify(formObject),
                    contentType:'application/json;charset=utf-8',
                    success: function (data) {
                        console.log(data);//打印服务端返回的数据(调试用)
                        if (data.result == true) {
                            alert("修改成功");
                            xadmin.close();
                            xadmin.father_reload();
                        }else{
                            alert("修改失败");
                            xadmin.close();
                            xadmin.father_reload();
                        };
                    },
                    error : function() {
                        alert("异常！");
                    }
                });
            }
        </script>
        <script>

             function GetQueryValue(queryName) {
                     var query = decodeURI(window.location.search.substring(1));
                     var vars = query.split("&");
                     for (var i = 0; i < vars.length; i++) {
                             var pair = vars[i].split("=");
                             if (pair[0] == queryName) { return pair[1]; }
                        }
                    return null;
                }
        </script>


<%--        <script >--%>
<%--            //重写status--%>
<%--            var status=GetQueryValue('status')--%>
<%--            console.log("status:"+status)--%>
<%--            console.log(typeof (status))--%>
<%--            $('#status').append(new Option(status))--%>
<%--            if(status=='1'){--%>
<%--                $('#status').append(new Option('0'))--%>
<%--            }else if(status=='0'){--%>
<%--                $('#status').append(new Option('1'))--%>
<%--            }--%>
<%--        </script>--%>

        




    </body>

</html>
