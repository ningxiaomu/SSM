<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>接口列表</title>
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
                            <div class="layui-input-inline layui-show-xs-block">
                                <a class="layui-btn"  onclick="xadmin.open('添加接口','interface-add.jsp',800,600)"><i class="layui-icon"></i>增加</a>
                            </div>
                        </form>
                        <hr>
                    </div>
<%--                    基本信息--%>
                    <div class="layui-card-body">
                        <div class="layui-inline layui-show-xs-block">
                            接口列表：进入详细页面可查看更多信息与编辑接口
                        </div>
                        <table class="layui-table layui-form">
                            <thead>
                            <tr id="itr">
                                <th>接口ID</th>
                                <th>接口名称</th>
                                <th>所属项目</th>
                                <th>域名</th>

                                <th width="30">请求方法</th>
                                <th>请求地址</th>
                                <th>创建人</th>
                                <th>添加时间</th>
                                <th>详细</th>
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
               url:'/interface/findAllInterface',
               contentType:'application/json;charset=utf-8',
               success:function (data) {
                   for(var i=0;i<data.result.length;i++){
                       var interfaceId=data.result[i].interfaceId
                       var interfaceName=data.result[i].interfaceName
                       var project=data.result[i].project
                       var domain=data.result[i].domain
                       var method=data.result[i].method
                       var requestAddress=data.result[i].requestAddress
                       var creator=data.result[i].creator
                       var joinTime=data.result[i].joinTime
                       var requestAddress=data.result[i].requestAddress
                       var $tr=$("<tr>"+"</tr>");
                       $table.append($tr);
                       //$tr.append("<td>"+interfaceId+"</td>"+"<td>"+interfaceName+"</td>"+"<td>"+project+"</td>"+"<td>"+domain+"</td>"+"<td>"+method+"</td>"+"<td>"+requestAddress+"</td>"+"<td>"+creator+"</td>"+"<td>"+joinTime+"</td>"+"<td>"+"<a title='详细"+"'  onclick='xadmin.open(\"编辑接口\",\"interface-edit.jsp?interfaceId="+interfaceId+"\",800,600)' >"+"<i class=\"layui-icon\">&#xe735;</i>"+"</td>")
                       $tr.append("<td>"+interfaceId+"</td>"+"<td>"+interfaceName+"</td>"+"<td>"+project+"</td>"+"<td>"+domain+"</td>"+"<td>"+method+"</td>"+"<td>"+requestAddress+"</td>"+"<td>"+creator+"</td>"+"<td>"+joinTime+"</td>"+"<td>"+"<a title='详细' href='interface-edit.jsp?interfaceId="+interfaceId+" '>"+"<i class=\"layui-icon\">&#xe735;</i>"+"</td>")
                   }

               }
           })
       });

    </script>
    </body>






</html>