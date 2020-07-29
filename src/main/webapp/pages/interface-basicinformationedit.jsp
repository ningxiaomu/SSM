<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>接口基本信息编辑</title>
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
    String interfaceId=request.getParameter("interfaceId");
    String interfaceName=request.getParameter("interfaceName");
    String project=request.getParameter("project");
    String domain=request.getParameter("domain");
    String method=request.getParameter("method");
    String requestAddress=request.getParameter("requestAddress");
    %>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" id="editBasicInformation" action="##" method="post">




                    <div class="layui-form-item" style="display:none;">
                        <label for="interfaceId" class="layui-form-label">
                            <span class="x-red">*</span>interfaceName
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="interfaceId" name="interfaceId" required="" lay-verify="required"
                                   autocomplete="off" class="layui-input"  value=<%=interfaceId%>>
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>接口名称
                        </div>

                    </div>

                    <div class="layui-form-item" style="display:none;">
                        <label for="creator" class="layui-form-label">
                            <span class="x-red">*</span>interfaceName
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="creator" name="creator" required="" lay-verify="required"
                                   autocomplete="off" class="layui-input"  value=<security:authentication property="principal.username"></security:authentication>>
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>接口名称
                        </div>

                    </div>




                    <div class="layui-form-item">
                        <label for="interfaceName" class="layui-form-label">
                            <span class="x-red">*</span>interfaceName
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="interfaceName" name="interfaceName" required="" lay-verify="required"
                                   autocomplete="off" class="layui-input"  value=<%=interfaceName%>>
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>接口名称
                        </div>

                    </div>




                  <div class="layui-form-item">
                      <label for="project" class="layui-form-label">
                          <span class="x-red">*</span>project
                      </label>
                      <div class="layui-input-inline">
                          <select id="project" name="project">

                          </select>
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>所属项目
                      </div>
                  </div>




                    <div class="layui-form-item">
                        <label for="domain" class="layui-form-label">
                            <span class="x-red">*</span>domain
                        </label>
                        <div class="layui-input-inline">
                            <select id="domain" name="domain">


                            </select>
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>域名
                        </div>
                    </div>




                    <div class="layui-form-item">
                        <label for="requestAddress" class="layui-form-label">
                            <span class="x-red">*</span>requestAddress
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="requestAddress" name="requestAddress" required="" lay-verify="required"
                                   autocomplete="off" class="layui-input" value=<%=requestAddress%>>
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>请求地址
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label for="method" class="layui-form-label">
                            <span class="x-red">*</span>method
                        </label>
                        <div class="layui-input-inline">
                            <select id="method" name="method">


                            </select>
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>请求方法
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"></label>
                        <p><input type="button" class="layui-btn" value="提交" id="L_repass" onclick="interfaceBasicEdit()"></p >
                    </div>
              </form>
            </div>
        </div>



        <script>
            function interfaceBasicEdit() {

                //定义验证规则
                /*验证项目是否选择*/
                // var projectValue = $('#projectName').val();
                // if(projectValue==""){
                //     alert("请输入项目名称");
                //     return;
                // }else {
                //     console.log("项目已选择")
                // }
                // /*验证域名是否选择*/
                // var domainValue = $('#domain').val();
                // if(domainValue==""){
                //     alert("请输入域名")
                //     return;
                // }else{
                //     console.log("域名已选择")
                // }
                var interfaceId=$('#interfaceId').text();
                var formObject = {};
                var formArray =$("#editBasicInformation").serializeArray();
                $.each(formArray,function(i,item){
                    formObject[item.name] = item.value;
                });
                //查找父级页面的项目名称(方便跳转)

                $.ajax({
                    type: "POST",//方法类型
                    dataType: "json",//预期服务器返回的数据类型
                    url: "/interface/editBasicInformation" ,//url
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
             //重写项目
             layui.use(['form', 'upload', 'layer'], function () {
                 var form = layui.form;
                 //检查项目添加到下拉框中
                 console.log("uri1:"+window.location.href)
                 console.log("uri2:"+window.location.search)
                 var project=GetQueryValue('project');
                 console.log("project:"+project)
                 // var project;
                 // project=window.location.search.substring()


                 $.ajax({
                     url: '${pageContext.request.contextPath}/project/findAllProject',
                     dataType: 'json',
                     type: 'post',
                     success: function (data) {
                         //var p="${caseInfo.project}"
                         $('#project').append(new Option(project))
                         // $('#project').append(new Option("请选择项目"))
                         var list = [];
                         for (var i = 0; i <data.result.length ; i++) {

                             list.push(data.result[i].projectName)

                         }

                         //删除重复的元素
                         for(var i=0;i<list.length;i++){
                             if(list[i]==project){
                                 list.splice(i,1);
                             }
                         }
                         console.log("最后的list为："+list)

                         $.each(list, function (i, item) {
                             $('#project').append(new Option(item));// 下拉菜单里添加元素
                         });
                         layui.form.render("select");
                         //重新渲染 固定写法
                     }
                 })
             })
        </script>
        <script >
            //重写method
            layui.use(['form','upload','layer'],function () {
                var method=GetQueryValue('method')
                console.log("method:"+method)
                $('#method').append(new Option(method))

                if(method=='post'){
                    $('#method').append(new Option('get'))
                }else if(method=='get'){
                    $('#method').append(new Option('post'))
                }
                // layui.form.render()
            })

        </script>
        <script >
            <%--//重写域名--%>
            var domain=GetQueryValue('domain')
            layui.use(['form', 'upload', 'layer'], function () {
                var form = layui.form;
                //检查项目添加到下拉框中
                $.ajax({
                    url: '${pageContext.request.contextPath}/project/findAllProject',
                    dataType: 'json',
                    type: 'post',
                    success: function (data) {
                        var p="${caseInfo.domain}"
                        $('#domain').append(new Option(domain))
                        var list = [];
                        for (var i = 0; i <data.result.length ; i++) {
                            list.push(data.result[i].domain)
                        }
                        //删除重复的元素
                        for(var i=0;i<list.length;i++){
                            if(list[i]==domain){
                                list.splice(i,1);
                            }
                        }
                        $.each(list, function (i, item) {
                            $('#domain').append(new Option(item));// 下拉菜单里添加元素
                        });
                        layui.form.render();
                        //重新渲染 固定写法
                    }
                })
            })
        </script>



        




    </body>

</html>
