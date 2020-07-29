<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>moco管理</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="../css/font.css">
        <link rel="stylesheet" href="../css/xadmin.css">
        <link rel="stylesheet" href="../css/pagination.css">
        <link rel="stylesheet" href="../css/layer.css">
        <link rel="stylesheet" href="../js/layer.js">
        <script src="../lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="../js/xadmin.js"></script>
        <script type="text/javascript" src="../js/jquery.min.js"></script>
        <script type="text/javascript" src="../js/layer.js"></script>
        <script type="text/javascript" src="../js/jquery.pagination.js"></script>
        <!--[if lt IE 9]>
        <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
        <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-body ">
                        <form class="layui-form layui-col-space5">
<%--                            <div class="layui-input-inline layui-show-xs-block">--%>
<%--                                <a class="layui-btn"  onclick="xadmin.open('添加moco','interface-add.jsp',800,600)"><i class="layui-icon"></i>增加</a>--%>
<%--                            </div>--%>
                        </form>
                        <hr>
                    </div>
<%--                    基本信息--%>
                    <div class="layui-card-body">
                        <div class="layui-inline layui-show-xs-block">
                            mock说明：此模式为非严格模式，只需要路径正确即可返回相应的text数据，如需严格模式请维护json文件
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            如：http://localhost:8081/mock/ +url地址
                        </div>
                        <table class="layui-table layui-form">
                            <thead>
                            <tr id="itr">
                                <th>ID</th>
                                <th>地址</th>
                                <th>请求方式</th>
                                <th>是否需要参数</th>
                                <th>参数</th>
                                <th>是否需要cookie</th>
                                <th>cookie</th>
                                <th>返回值</th>
                                <th>操作</th>
                            </thead>
                            <tbody id="itbody">

                            </tbody>
                        </table>
                    </div>


                </div>
            </div>
        </div>
    </div>
    <script>


       $(document).ready(function () {
           var $table=$('table tbody');
           $.ajax({
               type:'POST',
               dataType:'json',
               url:'/moco/findAllMoco',
               contentType:'application/json;charset=utf-8',
               success:function (data) {
                   for(var i=0;i<data.result.length;i++){
                       var id=data.result[i].id
                       var url=data.result[i].url
                       var method=data.result[i].method
                       var is_need_par=data.result[i].is_need_par
                       var paramter=data.result[i].paramter
                       if(paramter==null){
                           paramter="";
                       }
                       var is_need_cookie=data.result[i].is_need_cookie
                       var cookie=data.result[i].cookie
                       if(cookie==null){
                           cookie="";
                       }
                       var returnValue=data.result[i].returnValue
                       var $tr=$("<tr>"+"</tr>");
                       $table.append($tr);
                       $tr.append("<td>"+id+"</td>"+"<td>"+url+"</td>"+"<td>"+method+"</td>"+"<td>"+is_need_par+"</td>"+"<td>"+paramter+"</td>"+"<td>"+is_need_cookie+"</td>"+"<td>"+cookie+"</td>"+"<td>"+returnValue+"</td>"+"<td>"+"<a title='详细' href=''>"+"<i class=\"layui-icon\">&#xe735;</i>"+"</td>")
                   }

               }
           })
       });

    </script>
    </body>






</html>