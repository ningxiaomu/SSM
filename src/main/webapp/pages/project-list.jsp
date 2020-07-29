<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>项目列表</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="../css/font.css">
        <link rel="stylesheet" href="../css/xadmin.css">
        <script src="../lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="../js/xadmin.js"></script>
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
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">

                        <div class="layui-card-header">
                            <button class="layui-btn" onclick="xadmin.open('添加项目','./project-add.jsp',600,400)"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                              <thead>
                                <tr>

                                  <th>项目ID</th>
                                  <th>项目名称</th>
                                  <th>域名</th>
                                  <th>项目描述</th>
                                  <th>启用状态</th>
                                  <th>操作</th>
                              </thead>
                              <tbody>

                              </tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                  <a class="prev" href="">&lt;&lt;</a>
                                  <a class="num" href="">1</a>
                                  <span class="current">2</span>
                                  <a class="num" href="">3</a>
                                  <a class="num" href="">489</a>
                                  <a class="next" href="">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                type:"POST",
                dataType:"json",
                url:"/project/findAllProject",
                contentType:"application/json;charset=utf-8",
                success:function (data) {
                    var statusStrCss;

                    var $table=$('table tbody');
                    for (var i = 0; i <data.result.length; i++) {
                        var $tr=$("<tr>"+"</tr>");
                        $table.append($tr);
                        var projectid=data.result[i].projectid
                        var projectName=data.result[i].projectName
                        var domain=data.result[i].domain
                        var projectDesc=data.result[i].projectDesc
                        var status=data.result[i].status


                        var statusStr=data.result[i].statusStr

                        if(data.result[i].statusStr=='启用'){
                            statusStrCss='layui-btn layui-btn-normal layui-btn-mini';
                        }else if(data.result[i].statusStr=='停用'){
                            statusStrCss='layui-btn layui-btn-danger';
                        }else{
                            statusStrCss='layui-btn';
                        }
                       // $tr.append("<td>"+"<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\">"+"<i class=\"layui-icon layui-icon-ok\">"+"</i>"+"</div>"+"</td>"+"<td>"+data.result[i].projectid+"</td>"+"<td>"+data.result[i].projectName+"</td>"+"<td>"+data.result[i].domain+"</td>"+"<td>"+data.result[i].projectDesc+"</td>"+"<td>"+data.result[i].statusStr+"</td>")
                        $tr.append("<td>"+projectid+"</td>"+"<td>"+projectName+"</td>"+"<td>"+domain+"</td>"+"<td>"+projectDesc+"</td>"+"<td class='"+statusStrCss+"' >"+statusStr+"</td>"+"<td>"+"<a title='编辑"+"'  onclick='xadmin.open(\"编辑项目\",\"project-edit.jsp?projectid="+projectid+"&projectName="+projectName+"&status="+status+"&domain="+domain+"&projectDesc="+projectDesc+"\",800,600)' >"+"<i class=\"layui-icon\">&#xe642;</i>"+"</a>"+"<a title='删除' id='"+projectid+"' onclick='delProject(this.id)'>"+"<i class=\"layui-icon\">&#xe640;</i>"+"</a>"+"</td>")
                    }
                    console.log(data)
                }
            })
        })
    </script>


        <script>
        /*项目删除*/
        function delProject(projectid) {
            layer.confirm('确定要删除吗？',{btn:['确定','取消']},
                function () {
                    $.ajax({
                        type:'post',
                        url:'/project/deleteProject?projectid='+projectid,
                        success:function (data) {
                            console.log("result:"+data.result)
                            if(data.result==true){
                                alert("删除成功")

                            }else if(data.result==false){
                                alert("删除失败")
                            }else{
                                alert("出现未知错误")
                            }

                            window.location.reload();
                            console.log("刷新成功")
                        }
                    })
                }
            )
        }
    </script>


</html>