<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>Jenkins</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="../css/font.css">
        <link rel="stylesheet" href="../css/xadmin.css">
        <script src="../lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="../js/xadmin.js"></script>
        <script type="text/javascript" src="../js/layer.js"></script>
        <script type="text/javascript" src="../js/jquery.min.js"></script>
        <!--[if lt IE 9]>
        <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
        <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <input type="button" class="layui-btn" value="一键构建" id="construction" onclick="construction()">
        </div>
        <div class="layui-fluid">
            <a class="layui-btn"  id="successfulReport" onclick="reportCheck()">最近构建成功的测试报告</a>
        </div>
        <div class="layui-card-body">
            <div>上次的构建结果</div>
            <table class="layui-table layui-form">
                <thead>
                <tr id="itr">
                    <th>构建序号</th>
                    <th>构建地址</th>
                    <th>构建主机</th>
                    <th>构建结果</th>
                </thead>
                <tbody id="itbody">
                </tbody>
            </table>
        </div>

        <div class="layui-card-body">
            <div>上次成功的构建信息</div>
            <table class="layui-table layui-form">
                <thead>
                <tr>
                    <th>构建序号</th>
                    <th>构建地址</th>
                    <th>构建主机</th>
                    <th>构建结果</th>


                </thead>
                <tbody id="itbody2">


                </tbody>
            </table>
        </div>


        <div class="layui-card-body">
            <div>上次失败的构建信息</div>
            <table class="layui-table layui-form">
                <thead>
                <tr>
                    <th>构建序号</th>
                    <th>构建地址</th>
                    <th>构建主机</th>
                    <th>构建结果</th>


                </thead>
                <tbody id="itbody3">


                </tbody>
            </table>
        </div>

<script>
    function reportCheck() {
        var lastSuccessfulBuildUrl="http://39.101.203.223:8081/job/api/lastSuccessfulBuild/api/json";
        $.ajax({
            type:"get",
            url:lastSuccessfulBuildUrl,
            async:false,
            success:function (data) {
                lastSuccessfulBuildNumber=data.id;
                reportUrl = "http://39.101.203.223:8080/"+lastSuccessfulBuildNumber.toString()+"/index.html"
                window.location.href=reportUrl;
            }
        })
    }
</script>

    <script>
        //立即构建
        var buildUrl="http://39.101.203.223:8081/job/api/build?token=664952305";
        //上次构建
        var lastBuildNumberUrl="http://39.101.203.223:8081/job/api/lastBuild/api/json";
        //上次成功构建
        var lastSuccessfulBuildUrl="http://39.101.203.223:8081/job/api/lastSuccessfulBuild/api/json";
        //上次失败构建
        var lastlastFailedBuildUrl="http://39.101.203.223:8081/job/api/lastFailedBuild/api/json";
        //上次完整的构建
        var lastCompletedBuildNumberUrl="http://39.101.203.223:8081/job/api/lastCompletedBuild/api/json";
        var lastBuildNumber;
        var lastCompletedBuildNumber;
        function construction() {
            //发送最后一次构建的请求

            var num;
            $.ajax({
                type:"get",
                url:lastBuildNumberUrl,
                async:false,
                success:function (data) {
                    lastBuildNumber=data.displayName;
                    num =(parseInt(lastBuildNumber)+1);
                    console.log(num)
                }
            })
            //发送最后一次构建完成的请求
            $.ajax({
                type:"get",
                url:lastCompletedBuildNumberUrl,
                async:false,
                success:function (data) {
                    lastCompletedBuildNumber=data.displayName;
                }
            })

            //判断是否具有正在构建中的任务

            if(lastBuildNumber==lastCompletedBuildNumber){
                //发出构建请求
                $.ajax({
                    type:"get",
                    url:buildUrl,
                    async:false,
                    success:function (data) {
                        alert("构建请求发出")
                    }
                })
            }else {
                alert("目前Jenkins存在正在构建的项目，请稍后再试！")
                return;
            }
        }

    </script>
    <script>
        $(document).ready(function () {
            $.ajax({
                type:'get',
                async:false,
                url:lastBuildNumberUrl,
                success:function (data) {
                    var result;
                    var statusStrCss;
                    $ta = $('#itbody')
                    var $tr=$("<tr>"+"</tr>");
                    $ta.append($tr)
                    if(data.result=='SUCCESS'){
                        statusStrCss='layui-btn layui-btn-normal layui-btn-mini';
                    }else if(data.result=='FAILURE'){
                        statusStrCss='layui-btn layui-btn-danger';
                    }
                    else{
                        statusStrCss='layui-btn';
                    }
                    if(data.result=='SUCCESS'){
                        result = 'SUCCESS'
                    }else if(data.result=='FAILURE'){
                        result = 'FAILURE'
                    }else {
                        result = '构建中'
                    }
                    $tr.append("<td>"+data.number+"</td>"+"<td>"+data.url+"</td>"+"<td>"+data.actions[0].causes[0].shortDescription+"</td>"+"<td class='"+statusStrCss+"'>"+result+"</td>")
                }
            })

            $.ajax({
                type:'get',
                async:false,
                url:lastSuccessfulBuildUrl,
                success:function (data) {
                    $ta = $('#itbody2')
                    var $tr=$("<tr>"+"</tr>");
                    var statusStrCss;
                    if(data.result=='SUCCESS'){
                        statusStrCss='layui-btn layui-btn-normal layui-btn-mini';
                    }else if(data.result=='FAILURE'){
                        statusStrCss='layui-btn layui-btn-danger';
                    }else{
                        statusStrCss='layui-btn';
                    }
                    $ta.append($tr)
                    $tr.append("<td>"+data.number+"</td>"+"<td>"+data.url+"</td>"+"<td>"+data.actions[0].causes[0].shortDescription+"</td>"+"<td class='"+statusStrCss+"'>"+data.result+"</td>")
                }
            })

            $.ajax({
                type:'get',
                async:false,
                url:lastlastFailedBuildUrl,
                success:function (data) {
                    $ta = $('#itbody3')
                    var $tr=$("<tr>"+"</tr>");
                    $ta.append($tr)
                    var statusStrCss;
                    if(data.result=='SUCCESS'){
                        statusStrCss='layui-btn layui-btn-normal layui-btn-mini';
                    }else if(data.result=='FAILURE'){
                        statusStrCss='layui-btn layui-btn-danger';
                    }else{
                        statusStrCss='layui-btn';
                    }
                    $tr.append("<td>"+data.number+"</td>"+"<td>"+data.url+"</td>"+"<td>"+data.actions[0].causes[0].shortDescription+"</td>"+"<td class='"+statusStrCss+"'>"+data.result+"</td>")
                }
            })
        })
    </script>
    </body>
</html>