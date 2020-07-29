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
        <title>ECS服务器性能监控</title>
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
                <br/>
                <div class="layui-card-header">CPU使用率(如遇到折现图未展示，请刷新此页面)</div>
                <br/>
                <br/>
                <div id="CPUUtilization" style="width: 1820px;height:500px;"></div>
                <div class="layui-card-header">内存使用率(如遇到折现图未展示，请刷新此页面)</div>
                <br/>
                <br/>
                <div id="memory_actualUsedSpace" style="width: 1820px;height:600px;"></div>


        </div>
        </div>
    </body>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        $(document).ready(function () {
            $.ajax({
                type:"post",
                url: "/performanceMonitor/CPUUtilization",
                dataType:"json",
                success:function (data) {
                    console.log("测试返回时间："+data.result.datapoints)
                    dataList=eval(data.result.datapoints);
                    console.log("数据长度："+dataList.length);
                    if(data!=null){

                        var myDate = new Date();
                        var year=myDate.getFullYear();        //获取当前年
                        var month=myDate.getMonth()+1;   //获取当前月
                        var date=myDate.getDate();            //获取当前日


                        var h=myDate.getHours();              //获取当前小时数(0-23)
                        var m=myDate.getMinutes();          //获取当前分钟数(0-59)
                        var s=myDate.getSeconds();
                        var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
                        console.log(now)
                        // 获取到这个DOM节点，然后初始化

                        var myChart = echarts.init(document.getElementById("CPUUtilization"));

                        // option 里面的内容基本涵盖你要画的图表的所有内容
                        var option = {
                            // 定义样式和数据
                            backgroundColor: '#FBFBFB',
                            tooltip: {
                                trigger: 'axis'
                            },
                            legend: {
                                data: ['CPU使用率']
                            },

                            calculable: true,


                            xAxis: [{
                                axisLabel: {
                                    rotate: 30,
                                    interval: 0
                                },
                                axisLine: {
                                    lineStyle: {
                                        color: 'red'
                                    }
                                },
                                type: 'category',
                                boundaryGap: false,
                                data: function() {

                                    var timeList=[]
                                    for(var i = 0;i<dataList.length;i++){

                                        var d = new Date(dataList[i].timestamp);
                                        var times=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes()
                                        timeList.push(times)
                                    }

                                    // for(var i=0;i<24;i++){
                                    //     for(var j =0;j<2;j++){
                                    //         var now;
                                    //         var hours=h+i;
                                    //         if(hours>=24){
                                    //             hours=hours-24;
                                    //         }
                                    //         var min=m+(j*30);
                                    //         if(min>=60){
                                    //             min=min-60
                                    //         }
                                    //         now = (hours)+":"+(min);
                                    //
                                    //         timeList.push(now)
                                    //     }
                                    // }
                                    return timeList;
                                }()
                            }],
                            yAxis: [{

                                type: 'value',
                                axisLine: {
                                    lineStyle: {
                                        color: '#CECECE'
                                    }
                                }
                            }],
                            series: [{
                                name: 'CPU使用率',
                                type: 'line',
                                symbol: 'none',
                                smooth: 0.3,
                                color: ['#66AEDE'],
                                data: function() {
                                    var timeList=[]
                                    for(var i = 0;i<dataList.length;i++){
                                        timeList.push(dataList[i].Average)
                                    }
                                    return timeList;
                                }()
                            }]
                        };


                        // 一定不要忘了这个，具体是干啥的我忘了，官网是这样写的使用刚指定的配置项和数据显示图表。
                        myChart.setOption(option);

                    }
                }
            })
        })

    </script>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        $(document).ready(function () {
            $.ajax({
                type:"post",
                url: "/performanceMonitor/memoryActualUsedSpace",
                dataType:"json",
                success:function (data) {
                    console.log(data.result)

                    dataList=eval(data.result.datapoints);

                    if(data!=null){

                        var myDate = new Date();
                        var year=myDate.getFullYear();        //获取当前年
                        var month=myDate.getMonth()+1;   //获取当前月
                        var date=myDate.getDate();            //获取当前日


                        var h=myDate.getHours();              //获取当前小时数(0-23)
                        var m=myDate.getMinutes();          //获取当前分钟数(0-59)
                        var s=myDate.getSeconds();
                        var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
                        console.log(now)
                        // 获取到这个DOM节点，然后初始化

                        var myChart = echarts.init(document.getElementById("memory_actualUsedSpace"));

                        // option 里面的内容基本涵盖你要画的图表的所有内容
                        var option = {
                            // 定义样式和数据
                            backgroundColor: '#FBFBFB',
                            tooltip: {
                                trigger: 'axis'
                            },
                            legend: {
                                data: ['memoryActualUsedSpace']
                            },

                            calculable: true,


                            xAxis: [{
                                axisLabel: {
                                    rotate: 30,
                                    interval: 0
                                },
                                axisLine: {
                                    lineStyle: {
                                        color: 'red'
                                    }
                                },
                                type: 'category',
                                boundaryGap: false,
                                data: function() {

                                    var timeList=[]
                                    for(var i = 0;i<dataList.length;i++){

                                        var d = new Date(dataList[i].timestamp);
                                        var times=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes()
                                        timeList.push(times)
                                    }


                                    return timeList;
                                }()
                            }],
                            yAxis: [{

                                type: 'value',
                                axisLine: {
                                    lineStyle: {
                                        color: '#CECECE'
                                    }
                                }
                            }],
                            series: [ {
                                name: '内存消耗',
                                type: 'line',
                                symbol: 'none',
                                smooth: 0.3,
                                color: ['#90EC7D'],
                                data: function() {
                                    var List=[]
                                    for(var i = 0;i<dataList.length;i++){
                                        List.push(dataList[i].Average)
                                    }
                                    return List;
                                }()
                            }]
                        };


                        // 一定不要忘了这个，具体是干啥的我忘了，官网是这样写的使用刚指定的配置项和数据显示图表。
                        myChart.setOption(option);

                    }
                }
            })
        })

    </script>

</html>