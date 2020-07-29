<%@ page import="java.util.Date" %>
<%@ page import="java.util.logging.SimpleFormatter" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>首页</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="../css/font.css">
        <link rel="stylesheet" href="../css/xadmin.css">
        <script type="text/javascript" src="../js/jquery.min.js"></script>
        <script src="../lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="../js/xadmin.js"></script>
        <script type="text/javascript" src="../js/echarts.min.js"></script>
        <!--[if lt IE 9]>
        <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
        <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
        <![endif]-->
    </head>
    <%
        Date time = new Date();
        String str="yy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    %>
    <body>
    <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href=""><cite>首页</cite></a>
          </span>
        <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
    </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <blockquote class="layui-elem-quote">欢迎管理员：
                                <span class="x-red"><security:authentication property="principal.username"></security:authentication></span>！当前时间:<%=simpleDateFormat.format(time)%>
                            </blockquote>

                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">数据统计</div>
                        <div class="layui-card-body ">
                            <ul class="layui-row layui-col-space10 layui-this x-admin-carousel x-admin-backlog">
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>会员数</h3>
                                        <p id="userCount"></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>项目数</h3>
                                        <p id="projectCount">

                                        </p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>用例数</h3>
                                        <p id="caseCount">

                                        </p>
                                    </a>
                                </li>

                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>文章数</h3>
                                        <p>
                                            <cite>67</cite></p>
                                    </a>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>

                <br/>
                <div class="layui-card-header">测试数据展示处：1.只展示最近五次的测试结果；2.如遇到柱状图未展示，请刷新此页面</div>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <div id="main" style="width: 600px;height:400px;"></div>
<%--                <div class="layui-col-sm6 layui-col-md3">--%>
<%--                    <div class="layui-card">--%>
<%--                        <div class="layui-card-header">下载--%>
<%--                            <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>--%>
<%--                        <div class="layui-card-body  ">--%>
<%--                            <p class="layuiadmin-big-font">33,555</p>--%>
<%--                            <p>新下载--%>
<%--                                <span class="layuiadmin-span-color">10%--%>
<%--                                    <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>--%>
<%--                            </p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="layui-col-sm6 layui-col-md3">--%>
<%--                    <div class="layui-card">--%>
<%--                        <div class="layui-card-header">下载--%>
<%--                            <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>--%>
<%--                        <div class="layui-card-body ">--%>
<%--                            <p class="layuiadmin-big-font">33,555</p>--%>
<%--                            <p>新下载--%>
<%--                                <span class="layuiadmin-span-color">10%--%>
<%--                                    <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>--%>
<%--                            </p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="layui-col-sm6 layui-col-md3">--%>
<%--                    <div class="layui-card">--%>
<%--                        <div class="layui-card-header">下载--%>
<%--                            <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>--%>
<%--                        <div class="layui-card-body ">--%>
<%--                            <p class="layuiadmin-big-font">33,555</p>--%>
<%--                            <p>新下载--%>
<%--                                <span class="layuiadmin-span-color">10%--%>
<%--                                    <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>--%>
<%--                            </p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="layui-col-sm6 layui-col-md3">--%>
<%--                    <div class="layui-card">--%>
<%--                        <div class="layui-card-header">下载--%>
<%--                            <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>--%>
<%--                        <div class="layui-card-body ">--%>
<%--                            <p class="layuiadmin-big-font">33,555</p>--%>
<%--                            <p>新下载--%>
<%--                                <span class="layuiadmin-span-color">10%--%>
<%--                                    <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>--%>
<%--                            </p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">系统信息</div>
                        <div class="layui-card-body ">
                            <table class="layui-table">
                                <tbody>
                                    <tr>
                                        <th>xxx版本</th>
                                        <td>1.0.180420</td></tr>
                                    <tr>
                                        <th>服务器地址</th>
                                        <td>x.xuebingsi.com</td></tr>
                                    <tr>
                                        <th>操作系统</th>
                                        <td>WINNT</td></tr>
                                    <tr>
                                        <th>运行环境</th>
                                        <td>Apache/2.4.23 (Win32) OpenSSL/1.0.2j mod_fcgid/2.3.9</td></tr>
                                    <tr>
                                        <th>PHP版本</th>
                                        <td>5.6.27</td></tr>
                                    <tr>
                                        <th>PHP运行方式</th>
                                        <td>cgi-fcgi</td></tr>
                                    <tr>
                                        <th>MYSQL版本</th>
                                        <td>5.5.53</td></tr>
                                    <tr>
                                        <th>ThinkPHP</th>
                                        <td>5.0.18</td></tr>
                                    <tr>
                                        <th>上传附件限制</th>
                                        <td>2M</td></tr>
                                    <tr>
                                        <th>执行时间限制</th>
                                        <td>30s</td></tr>
                                    <tr>
                                        <th>剩余空间</th>
                                        <td>86015.2M</td></tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <style id="welcome_style"></style>

            </div>
        </div>
        </div>
    </body>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        $(document).ready(function () {
            $.ajax({
                type:"post",
                url: "/welcome/findAllResultSize",
                dataType:"json",
                success:function (data) {
                    console.log("测试结果成功："+data.result[0].passed)

                    if(data!=null){
                        var myChart = echarts.init(document.getElementById('main'));

                        // 指定图表的配置项和数据
                        var option = {
                            color:['#5FC700', '#C23531', '#67E0E3'],
                            legend: {},
                            tooltip: {},
                            dataset: {
                                // 提供一份数据。
                                source: [
                                    ['product', 'Passed', 'Failed', 'Skipped'],
                                    [data.result[4].testTime.substring(5,16), data.result[4].passed, data.result[4].failed, data.result[4].skipped],
                                    [data.result[3].testTime.substring(5,16), data.result[3].passed, data.result[3].failed, data.result[3].skipped],
                                    [data.result[2].testTime.substring(5,16), data.result[2].passed, data.result[2].failed, data.result[2].skipped],
                                    [data.result[1].testTime.substring(5,16), data.result[1].passed, data.result[1].failed, data.result[1].skipped],
                                    [data.result[0].testTime.substring(5,16), data.result[0].passed, data.result[0].failed, data.result[0].skipped],
                                    //[data.result[4].testTime.substring(4,9), data.result[4].passed, data.result[4].failed, data.result[4].skipped],

                                ]
                            },
                            // 声明一个 X 轴，类目轴（category）。默认情况下，类目轴对应到 dataset 第一列。
                            xAxis: {type: 'category'},
                            // 声明一个 Y 轴，数值轴。
                            yAxis: {},
                            // 声明多个 bar 系列，默认情况下，每个系列会自动对应到 dataset 的每一列。
                            series: [
                                {type: 'bar',barGap:'-10%',barWidth:18,barCategoryGap:"20%"},
                                {type: 'bar',barGap:'120%',barWidth:18},
                                {type: 'bar',barGap:'120%',barWidth:15},


                            ]
                        };

                        // 使用刚指定的配置项和数据显示图表。
                        myChart.setOption(option);

                    }
                }
            })
        })

    </script>
    <script>
        $(document).ready(function () {
            $.ajax({
                type:"post",
                url:"/user/getUserCount",
                dataType:"json",
                success:function (data) {
                    if(data!=null){
                        $('#userCount').append("<cite>"+data.result[0]+"</cite>")
                        $('#projectCount').append("<cite>"+data.result[1]+"</cite>")
                        $('#caseCount').append("<cite>"+data.result[2]+"</cite>")
                    }
                    else {
                        return;
                    }

                }
            })
        })
    </script>
</html>