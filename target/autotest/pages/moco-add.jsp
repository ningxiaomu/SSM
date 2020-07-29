<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>moco信息添加</title>
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

    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" id="mocoAdd" action="##" method="post">




                    <div class="layui-form-item" style="display:none;">
                        <label for="interfaceId" class="layui-form-label">
                            <span class="x-red">*</span>interfaceId
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="interfaceId" name="interfaceId" required="" lay-verify="required"
                                   autocomplete="off" class="layui-input"  >
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
                                   autocomplete="off" class="layui-input"  value=>
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
                          <select id="project" name="project" lay-verify="required" lay-filter="xmFilter">

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
                            <select id="domain" name="domain" lay-verify="required" lay-filter="xmFilter">


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
                                   autocomplete="off" class="layui-input" >
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
                                <option>post</option>
                                <option>get</option>
                            </select>
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>请求方法
                        </div>
                    </div>

                    <div>
                        <span class="x-red">注：</span>详细的接口数据可以在编辑页面中添加
                    </div>

                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"></label>
                        <p><input type="button" class="layui-btn" value="提交" id="L_repass" onclick="interfaceAdd()"></p >
                    </div>
              </form>

            </div>
        </div>



        <script>
            function interfaceAdd() {
                var formObject = {};
                var formArray =$("#editBasicInformation").serializeArray();
                $.each(formArray,function(i,item){
                    formObject[item.name] = item.value;
                });
                //查找父级页面的项目名称(方便跳转)

                $.ajax({
                    type: "POST",//方法类型
                    dataType: "json",//预期服务器返回的数据类型
                    url: "/interface/addInterface" ,//url
                    data:JSON.stringify(formObject),
                    contentType:'application/json;charset=utf-8',
                    success: function (data) {
                        console.log(data);//打印服务端返回的数据(调试用)
                        if (data.result == true) {
                            alert("添加成功");
                            xadmin.close();
                            xadmin.father_reload();
                        }else{
                            alert("添加失败");
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
        <script >
            layui.use(['form', 'upload', 'layer'], function () {
                var form = layui.form;
                //项目
                $.ajax({
                    url: '${pageContext.request.contextPath}/project/findAllProject',
                    dataType: 'json',
                    type: 'post',
                    success: function (data) {
                        $('#project').append(new Option("请选择项目"))
                        var list = [];
                        for (var i = 0; i <data.result.length ; i++) {
                            list.push(data.result[i].projectName)
                        }
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
            layui.use(['form', 'upload', 'layer'], function () {
                var form = layui.form;
                //域名
                $.ajax({
                    url: '${pageContext.request.contextPath}/project/findAllProject',
                    dataType: 'json',
                    type: 'post',
                    success: function (data) {
                        $('#domain').append(new Option("请选择域名"))
                        var list = [];
                        for (var i = 0; i <data.result.length ; i++) {
                            list.push(data.result[i].domain)
                        }
                        $.each(list, function (i, item) {
                            $('#domain').append(new Option(item));// 下拉菜单里添加元素
                        });
                        layui.form.render("select");
                        //重新渲染 固定写法
                    }
                })
            })
        </script>
    </body>

</html>
