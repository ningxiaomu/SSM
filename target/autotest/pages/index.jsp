<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>后台主页</title>
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
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script>
            // 是否开启刷新记忆tab功能
            // var is_remember = false;
        </script>
    </head>
    <body class="index">
        <!-- 顶部开始 -->
        <div class="container">
            <div class="logo">
                <a href="./index.jsp">X-admin v2.2</a></div>
            <div class="left_open">
                <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
            </div>
            <ul class="layui-nav left fast-add" lay-filter="">
                <li class="layui-nav-item">
                    <a href="javascript:;">+新增</a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->
                        <dd>
                            <a onclick="xadmin.open('最大化','http://www.baidu.com','','',true)">
                                <i class="iconfont">&#xe6a2;</i>弹出最大化</a></dd>
                        <dd>
                            <a onclick="xadmin.open('弹出自动宽高','http://www.baidu.com')">
                                <i class="iconfont">&#xe6a8;</i>弹出自动宽高</a></dd>
                        <dd>
                            <a onclick="xadmin.open('弹出指定宽高','http://www.baidu.com',500,300)">
                                <i class="iconfont">&#xe6a8;</i>弹出指定宽高</a></dd>
                        <dd>
                            <a onclick="xadmin.add_tab('在tab打开','member-list.html')">
                                <i class="iconfont">&#xe6b8;</i>在tab打开</a></dd>
                        <dd>
                            <a onclick="xadmin.add_tab('在tab打开刷新','member-del.html',true)">
                                <i class="iconfont">&#xe6b8;</i>在tab打开刷新</a></dd>
                    </dl>
                </li>
            </ul>
            <ul class="layui-nav right" lay-filter="">
                <li class="layui-nav-item">
                    <a href="javascript:;"><security:authentication property="principal.username"></security:authentication></a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->
                        <dd>
                            <a onclick="xadmin.open('个人信息','http://www.baidu.com')">个人信息</a></dd>
                        <dd>
                            <a onclick="xadmin.open('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/logout">退出</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item to-index">
                    <a href="/">前台首页</a></li>
            </ul>
        </div>
        <!-- 顶部结束 -->
        <!-- 中部开始 -->
        <!-- 左侧菜单开始 -->
        <div class="left-nav">
            <div id="side-nav">
                <ul id="nav">
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="会员管理">&#xe6b8;</i>
                            <cite>会员管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('会员列表','user-list.jsp',true)">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('会员删除','user-del.jsp',true)">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员删除</cite></a>
                            </li>

                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="接口管理">&#xe723;</i>
                            <cite>接口管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('项目管理','project-list.jsp')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>项目列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('接口列表','interface-list.jsp')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>接口列表</cite></a>
                            </li>

<%--                            <li id="interfaceList">--%>
<%--&lt;%&ndash;                                <a onclick="xadmin.add_tab('接口列表','interface-list.jsp')">&ndash;%&gt;--%>
<%--                                <a href="javascript:;" >--%>
<%--                                    <i class="iconfont">&#xe6a7;</i>--%>
<%--                                    <cite id="interfaceShowHide">接口列表</cite>--%>
<%--                                </a>--%>
<%--                                <ul id="interface">--%>
<%--&lt;%&ndash;                                    <li><a onclick="xadmin.add_tab('接口详情','interface-list.jsp')"><cite>接口1</cite></a></li>&ndash;%&gt;--%>
<%--                                </ul>--%>



                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('用例列表','case-list.jsp')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>用例列表</cite></a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="角色权限管理">&#xe726;</i>
                            <cite>角色权限管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('会员角色管理','user-role.jsp')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员角色管理</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('角色管理','role-list.jsp')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>角色管理</cite></a>
                            </li>
<%--                            <li>--%>
<%--                                <a onclick="xadmin.add_tab('权限分类','admin-cate.html')">--%>
<%--                                    <i class="iconfont">&#xe6a7;</i>--%>
<%--                                    <cite>权限分类</cite></a>--%>
<%--                            </li>--%>
                            <li>
                                <a onclick="xadmin.add_tab('权限管理','permission-list.jsp')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>权限管理</cite></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="系统统计">&#xe6ce;</i>
                            <cite>jenkins构建</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('Jenkins构建','Jenkins.jsp')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>Jenkins构建</cite></a>
                            </li>

                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="性能监控">&#xe757;</i>
                            <cite>性能监控</cite>
                            <i class="iconfont nav_right">&#xe757;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('性能监控','performanceMonitor.jsp')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>性能监控</cite></a>
                            </li>
                        </ul>
                    </li>

                    <%-- moco --%>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="mock管理">&#xe6f1;</i>
                            <cite>mock管理</cite>
                            <i class="iconfont nav_right">&#xe6f1;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('mock管理','mock.jsp')">
                                    <i class="iconfont">&#xe6f1;</i>
                                    <cite>mock管理</cite></a>
                            </li>
                        </ul>
                    </li>

<%--                    文章开始--%>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="性能测试">&#xe6fb;</i>
                            <cite>文章博客</cite>
                            <i class="iconfont nav_right">&#xe6fc;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('文章','')">
                                    <i class="iconfont">&#xe6fc;</i>
                                    <cite>随心记</cite></a>
                            </li>
                        </ul>
                    </li>
<%--                    文章结束--%>
<%--                    上传文件开始--%>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="文件上传">&#xe75c;</i>
                            <cite>文件上传</cite>
                            <i class="iconfont nav_right">&#xe75c;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('文件上传','upload.jsp')">
                                    <i class="iconfont">&#xe75c;</i>
                                    <cite>文件上传</cite></a>
                            </li>
                        </ul>
                    </li>
<%--                    上传文件结束--%>
<%--                    <li>--%>
<%--                        <a href="javascript:;">--%>
<%--                            <i class="iconfont left-nav-li" lay-tips="其它页面">&#xe6b4;</i>--%>
<%--                            <cite>其它页面</cite>--%>
<%--                            <i class="iconfont nav_right">&#xe697;</i></a>--%>
<%--                        <ul class="sub-menu">--%>
<%--                            <li>--%>
<%--                                <a href="login.html" target="_blank">--%>
<%--                                    <i class="iconfont">&#xe6a7;</i>--%>
<%--                                    <cite>登录页面</cite></a>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a onclick="xadmin.add_tab('错误页面','error.jsp')">--%>
<%--                                    <i class="iconfont">&#xe6a7;</i>--%>
<%--                                    <cite>错误页面</cite></a>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a onclick="xadmin.add_tab('示例页面','demo.html')">--%>
<%--                                    <i class="iconfont">&#xe6a7;</i>--%>
<%--                                    <cite>示例页面</cite></a>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a onclick="xadmin.add_tab('更新日志','log.html')">--%>
<%--                                    <i class="iconfont">&#xe6a7;</i>--%>
<%--                                    <cite>更新日志</cite></a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
                    <%--                    操作日志开始--%>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="日志操作">&#xe69e;</i>
                            <cite>日志操作</cite>
                            <i class="iconfont nav_right">&#xe69e;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('日志操作','log-operation.jsp')">
                                    <i class="iconfont">&#xe69e;</i>
                                    <cite>日志操作</cite></a>
                            </li>
                        </ul>
                    </li>
                    <%--                    操作日志结束--%>

                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="第三方组件">&#xe6b4;</i>
                            <cite>layui第三方组件</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('滑块验证','https://fly.layui.com/extend/sliderVerify/')" target="">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>滑块验证</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('富文本编辑器','https://fly.layui.com/extend/layedit/')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>富文本编辑器</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('eleTree 树组件','https://fly.layui.com/extend/eleTree/')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>eleTree 树组件</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('图片截取','https://fly.layui.com/extend/croppers/')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>图片截取</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('formSelects 4.x 多选框','https://fly.layui.com/extend/formSelects/')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>formSelects 4.x 多选框</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('Magnifier 放大镜','https://fly.layui.com/extend/Magnifier/')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>Magnifier 放大镜</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('notice 通知控件','https://fly.layui.com/extend/notice/')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>notice 通知控件</cite></a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- <div class="x-slide_left"></div> -->
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="page-content">
            <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
                <ul class="layui-tab-title">
                    <li class="home">
                        <i class="layui-icon">&#xe68e;</i>我的桌面</li></ul>
                <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
                    <dl>
                        <dd data-type="this">关闭当前</dd>
                        <dd data-type="other">关闭其它</dd>
                        <dd data-type="all">关闭全部</dd></dl>
                </div>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe src='welcome.jsp' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
                    </div>
                </div>
                <div id="tab_show"></div>
            </div>
        </div>
        <div class="page-content-bg"></div>
        <style id="theme_style"></style>
        <!-- 右侧主体结束 -->
        <!-- 中部结束 -->
        <script>

//            $('#interface').append("");
//            var li=document.createElement("li")
//            $(document).ready(function () {
//                $.ajax({
//                    type:'POST',
//                    dataType:'json',
//                    url:'/interface/findAllInterface',
//                    contentType:'application/json;charset=utf-8',
//                    success:function (data) {
//                        console.log(data)
//                        for(var i=0;i<data.result.length;i++){
//                        // <li><a onclick="xadmin.add_tab('接口详情','interface-list.jsp')"><cite>接口1</cite></a></li>
//                            //$("#interfaceList ul").append('<li>'+data.result[i].interfaceId+'</li>');
//                            $("#interfaceList ul").append('<li>'+'<a onclick="xadmin.add_tab(\'接口详情\',\'interface-list.jsp\')">'+'<cite>'+data.result[i].interfaceName+'</cite>'+'</a>'+'</li>');
//                        }
//
//                    }
//                })
//            });
//
//
//        $(document).ready(function()
//        {
//            $("#interfaceList ul").hide();
//            $("#interfaceShowHide").click(function()
//            {
//
//                $("#interfaceList ul").toggle();
//            });
//        });

        </script>
    </body>

</html>