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
<%--    <style>--%>
<%--        .parent {--%>
<%--            background: #FFF38F;--%>
<%--            cursor: pointer;--%>
<%--        }--%>
<%--        .odd {--%>
<%--            background: #FFFFEE;--%>
<%--        }--%>
<%--        /*.selected {*/--%>
<%--        /*    background: #FF6500;*/--%>
<%--        /*    color: #fff;*/--%>
<%--        /*}*/--%>
<%--    </style>--%>
    <%
        String interfaceId=request.getParameter("interfaceId");
    %>
    <body>
    <div style="display:none;" id="interfaceId"><%=interfaceId%></div>
    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">

<%--                    基本信息--%>
                    <div class="layui-card-body">
                        <div class="layui-inline layui-show-xs-block">
                            基本信息：
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
                                <th>操作</th>
                            </thead>
                            <tbody id="itbody">

                            </tbody>
                        </table>
                    </div>

<%--                    请求参数--%>
                    <div class="layui-card-body">
                        <div class="layui-inline layui-show-xs-block">
                            Headers：
                        </div>
                        <table class="layui-table layui-form" id="header">
                            <thead>
                            <tr id="itr2">
                                <th>参数名</th>
                                <th>参数值</th>
                                <th>是否必须</th>
                                <th>备注</th>
                                <th>操作</th>
                            </thead>
                            <tbody id="itbody2">

                            </tbody>
                        </table>
                        <button id="newBtn3" type="button" class="layui-btn layui-btn-primary layui-btn-fluid"><i class="layui-icon"></i> 新增一行</button><br>
                        <button class="layui-btn layui-btn-primary layui-btn-fluid" onclick="delRow3()"><i class="layui-icon">&#xe716;</i>删除一行</button>
                    </div>
    <div class="layui-form-item">
        <label for="L_repass" class="layui-form-label"></label>
        <p><input type="button" class="layui-btn" value="提交Header" id="L_repass3" onclick="interfaceAddHeader()"></p >
    </div>


<%--                    Body--%>

                    <div class="layui-card-body">
                        <div class="layui-inline layui-show-xs-block">Body：表格可被编辑哦</div>
                        <table class="layui-table layui-form" id="serviceTables" lay-filter="test3">
                            <thead>
                            <tr id="itr3">
<%--                                <th>ID</th>--%>
                                <th>名称</th>
                                <th>类型</th>
                                <th>是否必须</th>
                                <th>默认值</th>
                                <th>备注</th>
                                <th>操作</th>
                            </thead>
                            <tbody id="itbody3">

                            </tbody>
                        </table>
                        <button id="newBtn" type="button" class="layui-btn layui-btn-primary layui-btn-fluid"><i class="layui-icon"></i> 新增一行</button><br>
                        <button class="layui-btn layui-btn-primary layui-btn-fluid" onclick="delRow()"><i class="layui-icon">&#xe716;</i>删除一行</button>
                    </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label"></label>
            <p><input type="button" class="layui-btn" value="提交Body" id="L_repass" onclick="interfaceAddBody()"></p >
        </div>


<%--                            返回数据--%>
                            <div class="layui-card-body">
                                <div class="layui-inline layui-show-xs-block">返回数据：</div>
                                <table class="layui-table layui-form" id="returnData">
                                    <thead>
                                    <tr id="itr4">
                                        <th>名称</th>
                                        <th>类型</th>
                                        <th>是否必须</th>
                                        <th>默认值</th>
                                        <th>备注</th>
                                        <th>操作</th>
                                    </thead>
                                    <tbody id="itbody4">

                            </tbody>
                        </table>
                                <button id="newBtn2" type="button" class="layui-btn layui-btn-primary layui-btn-fluid"><i class="layui-icon"></i> 新增一行</button><br>
                                <button class="layui-btn layui-btn-primary layui-btn-fluid" onclick="delRow2()"><i class="layui-icon">&#xe716;</i>删除一行</button>
                    </div>
    <div class="layui-form-item">
        <label for="L_repass" class="layui-form-label"></label>
        <p><input type="button" class="layui-btn" value="提交返回数据" id="L_repass2" onclick="interfaceAddReturnData()"></p >
    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        //基本信息：
        $(document).ready(function () {
            var interfaceId=$('#interfaceId').text();
            var $table= $('#itbody');
            $.ajax({
                type:'POST',
                url:'/interface/findInterfaceById?InterfaceId='+interfaceId,
                dataType:'json',
                contentType:'application/json;chartset:utf-8',
                success:function (data) {
                    console.log(data)
                    for(var i=0;i<data.result.length;i++){
                        var interfaceId=data.result[i].interfaceId
                        var interfaceName=data.result[i].interfaceName
                        var project=data.result[i].project
                        var domain=data.result[i].domain
                        var method=data.result[i].method
                        var creator=data.result[i].creator
                        var joinTime=data.result[i].joinTime
                        var requestAddress=data.result[i].requestAddress
                        var $tr=$("<tr>"+"</tr>");
                        $table.append($tr);
                        $tr.append("<td>"+interfaceId+"</td>"+"<td>"+interfaceName+"</td>"+"<td>"+project+"</td>"+"<td>"+domain+"</td>"+"<td>"+method+"</td>"+"<td>"+requestAddress+"</td>"+"<td>"+creator+"</td>"+"<td>"+joinTime+"</td>"+"<td>"+"<a title='详细' href='interface-edit.jsp?interfaceId="+interfaceId+" '>"+"<a title='删除' id='"+interfaceId+"' onclick='delInterface(this.id)'>"+"<i class=\"layui-icon\">&#xe640;</i>"+"</a>"+"<a title='编辑' id='"+interfaceId+"' onclick='xadmin.open(\"编辑接口\",\"interface-basicinformationedit.jsp?interfaceId="+interfaceId+"&interfaceName="+interfaceName+"&project="+project+"&domain="+domain+"&requestAddress="+requestAddress+"&method="+method+"\",800,600)'>"+"<i class=\"layui-icon\">&#xe642;</i>"+"</a>"+"</td>")

                    }

                }
            })

        })

        //headers:
        $(document).ready(function () {
            var interfaceId=$('#interfaceId').text();
            var $table= $('#itbody2');
            $.ajax({
                type:'POST',
                url:'/interface/findInterfaceHeaderById?InterfaceId='+interfaceId,
                dataType:'json',
                contentType:'application/json;chartset:utf-8',
                success:function (data) {
                    for(var i=0;i<data.result.length;i++){
                        var name=data.result[i].name
                        var value=data.result[i].value
                        var is_must=data.result[i].is_must
                        var remark=data.result[i].remark
                        var $tr=$("<tr>"+"</tr>");
                        $table.append($tr);
                        $tr.append("<td>"+name+"</td>"+"<td>"+value+"</td>"+"<td>"+is_must+"</td>"+"<td>"+remark+"</td>"+"<td>"+"<a href='#' class='bjBtn3 layui-btn'>编辑"+"</a>"+"</td>")
                    }

                }
            })

        })
        //body:
        $(document).ready(function () {
            var interfaceId=$('#interfaceId').text();
            var $table= $('#itbody3');
            $.ajax({
                type:'POST',
                url:'/interface/findInterfaceBodyById?InterfaceId='+interfaceId,
                dataType:'json',
                contentType:'application/json;chartset:utf-8',
                success:function (data) {
                    for(var i=0;i<data.result.length;i++){
                        // var interfaceId=data.result[i].interfaceId
                        var parameterName_body=data.result[i].parameterName_body
                        var type_body=data.result[i].type_body
                        var is_required_body=data.result[i].is_required_body
                        var defaultValue_body=data.result[i].defaultValue_body
                        var remark_body=data.result[i].remark_body
                        var $tr=$("<tr>"+"</tr>");
                        $table.append($tr);
                        //$tr.append("<td>"+interfaceId+"</td>"+"<td>"+parameterName_body+"</td>"+"<td>"+type_body+"</td>"+"<td>"+is_required_body+"</td>"+"<td>"+defaultValue_body+"</td>"+"<td>"+remark_body+"</td>"+"<td>"+"<a title='详细' href='interface-edit.jsp?interfaceId="+interfaceId+" '>"+"<a title='编辑' id='"+interfaceId+"'   onclick='delCase(this.id)'>"+"<i class=\"layui-icon .bjBtn\">&#xe642;</i>"+"</a>"+"</td>")
                        $tr.append("<td>"+parameterName_body+"</td>"+"<td>"+type_body+"</td>"+"<td>"+is_required_body+"</td>"+"<td>"+defaultValue_body+"</td>"+"<td>"+remark_body+"</td>"+"<td>"+"<a href='#' class='bjBtn layui-btn'>编辑"+"</a>"+"</td>")
                    }

                }
            })

        })

        //返回数据：
        $(document).ready(function () {
            var interfaceId=$('#interfaceId').text();
            var $table= $('#itbody4');
            $.ajax({
                type:'POST',
                url:'/interface/findInterfaceReturnDataById?InterfaceId='+interfaceId,
                dataType:'json',
                contentType:'application/json;chartset:utf-8',
                success:function (data) {
                    for(var i=0;i<data.result.length;i++){
                        var interfaceId=data.result[i].interfaceId
                        var parameterName_return=data.result[i].parameterName_return
                        var type_return=data.result[i].type_return
                        var is_required_return=data.result[i].is_required_return
                        var defaultValue_return=data.result[i].defaultValue_return
                        var remark_return=data.result[i].remark_return
                        var trLength=$("#itbody4 tr:visible").length;
                        var trLength1 = "myclass"+trLength
                        var $tr=$('<tr id= \"'+trLength1+'\" class= \"'+trLength1+' parent\">'+"</tr>");
                        $table.append($tr);
                        //class=\"'+trLength+'\"

                        $tr.append("<td>"+parameterName_return+"</td>"+"<td>"+type_return+"</td>"+"<td>"+is_required_return+"</td>"+"<td>"+defaultValue_return+"</td>"+"<td>"+remark_return+"</td>"+"<td>"+"<a href='#' class='bjBtn2 layui-btn'>编辑"+"</a>"+"<a href='#' class='addson"+trLength+" layui-btn myadd'>添加子项"+"</a>"+"</td>")
                    }

                }
            })

        })

    </script>
    <script>
        /*用例删除*/
        function delInterface(interfaceId) {
            layer.confirm('确定要删除吗？',{btn:['确定','取消']},
                function () {
                    $.ajax({
                        type:'post',
                        url:'/interface/delSelectInterface?InterfaceId='+interfaceId,
                        success:function (data) {
                            console.log("result:"+data.result)
                            if(data.result==true){
                                alert("删除成功")
                                window.history.go(-1);

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

    <script>

        function addRow() {
            var $table= $('#itbody3');
            var $tr=$("<tr>"+"<td class='xx'></td>"+"<td></td>"+"<td></td>"+"<td></td>"+"<td></td>"+"<td><button type=\"button\" class=\"layui-btn layui-btn-xs qrBtn\"> <i class=\"layui-icon\">确定</i></td>"+"</tr>");
            $table.append($tr);
        }

        function delRow() {
            $("#itbody3 tr:last").remove();//移除最后一行
        }
        function delRow2() {
            $("#itbody4 tr:last").remove();//移除最后一行
        } function delRow3() {
            $("#itbody2 tr:last").remove();//移除最后一行
        }


    </script>
    <script>
        layui.use(['upload','form','layer'], function(){
            var $ = layui.jquery
                ,upload = layui.upload
                ,form = layui.form;
            var interfaceid=$('#interfaceId').text();
            console.log(interfaceid)

            // 新增服务项目
            $("#newBtn").click(function() {
                var intid=$('#interfaceId').text();
                var str = '';
                str += '<tr>';
                // str += '<td>'+intid+'</td>';
                str += '<td>';
                str += '<input type="text"  placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input">';
                str += '</td>';
                str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input"></td>';
                str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input"></td>';
                str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input"></td>';
                str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input"></td>';
                str += '<td><button type="button" class="layui-btn layui-btn-xs qrBtn"> <i class="layui-icon">确定</i></button>';
                str += '</tr>';

                $("#serviceTables").append(str);
            });
            // 确定
            $("#serviceTables").on("click",".qrBtn",function(){
                var intid=$('#interfaceId').text();
                $("#serviceTables tr:last").remove();
                var newStr = '';
                // var ID = $(this).parent().parent().find("td:nth-child(1)").find("td").val();
                var name = $(this).parent().parent().find("td:nth-child(1)").find("input").val();
                var type = $(this).parent().parent().find("td:nth-child(2)").find("input").val();
                var is_must = $(this).parent().parent().find("td:nth-child(3)").find("input").val();
                var example = $(this).parent().parent().find("td:nth-child(4)").find("input").val();
                var remark = $(this).parent().parent().find("td:nth-child(5)").find("input").val();

                newStr += '<tr>';
                // newStr += '<td name="ID">';
                // newStr += intid;
                // newStr += '</td>';
                newStr += '<td name="name">';
                newStr += name;
                newStr += '</td>';
                newStr += '<td name="type">' + type + '</td>';
                newStr += '<td name="is_must">' + is_must + '</td>';
                newStr += '<td name="example">' + example + '</td>';
                newStr += '<td name="remark">' + remark + '</td>';
                newStr += '<td><a href="#" class="co-green bjBtn layui-btn">编辑</a>  <a href="#" class="co-green"></a></td>';
                newStr += '</tr>';

                $("#serviceTables").append(newStr);
            });

            // 编辑
            $("#serviceTables").on("click", ".bjBtn", function () {
                var thinLine = $(this).parents('tr');
                thinLine.each(function (i) {
                    // var id = $(this).find("input[name='id']").val();
                    var reg = /编辑/;// 遍历 tr
                    $(this).children('td').each(function (j) {  // 遍历 tr 的各个 td
                        // alert("第"+(i+1)+"行，第"+(j+1)+"个td的值："+$(this).text()+"。");

                        var tdDom = $(this);
                        //保存初始值
                        var tdPreText = $(this).text();
                        //给td设置宽度和给input设置宽度并赋值
                        if (reg.test(tdPreText)) {
                            var newBtns = '<button type="button"  class="layui-btn layui-btn-xs qrBtn"><i class="layui-icon">确定</i></button>';
                            // newBtns += '<button type="button" class="layui-btn layui-btn-xs cancelBtn"><i class="layui-icon">取消</i></button>';
                            $(this).html(newBtns);
                        } else {
                            $(this).html("<input type='text'>").find("input").addClass('layui-input').val(tdPreText);
                        }

                    });
                });
            });


        });



    </script>
    <script>
        layui.use(['upload','form','layer'], function(){
            var $ = layui.jquery
                ,upload = layui.upload
                ,form = layui.form;
            var interfaceid=$('#interfaceId').text();


            // 新增服务项目
            $("#newBtn2").click(function() {
                var intid=$('#interfaceId').text();
                var trLength=$("#itbody4 tr:visible").length;
                console.log("trLength"+trLength)
                var my="myclass"+trLength
                var myid="id="+my;
                var str = '';
                str += '<tr class=\"'+my+'\">';
                // str += '<td>'+intid+'</td>';
                str += '<td>';
                str += '<input type="text"  placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input">';
                str += '</td>';
                str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input"></td>';
                str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input"></td>';
                str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input"></td>';
                str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input"></td>';
                str += '<td><button type="button" class="layui-btn layui-btn-xs qrBtn2" '+myid+'> <i class="layui-icon">确定</i></button>';
                str += '</tr>';

                $("#returnData").append(str);
            });
            // 确定
            $("#returnData").on("click",".qrBtn2",function(){
                var mmid=getID(6)
                var myid="id="+mmid;
                var intid=$('#interfaceId').text();
                $("#returnData tr:last").remove();
                var newStr = '';
                // var ID = $(this).parent().parent().find("td:nth-child(1)").find("td").val();
                var name = $(this).parent().parent().find("td:nth-child(1)").find("input").val();
                var type = $(this).parent().parent().find("td:nth-child(2)").find("input").val();
                var is_must = $(this).parent().parent().find("td:nth-child(3)").find("input").val();
                var example = $(this).parent().parent().find("td:nth-child(4)").find("input").val();
                var remark = $(this).parent().parent().find("td:nth-child(5)").find("input").val();

                newStr += '<tr>';
                newStr += '<td name="name">';
                newStr += name;
                newStr += '</td>';
                newStr += '<td name="type">' + type + '</td>';
                newStr += '<td name="is_must">' + is_must + '</td>';
                newStr += '<td name="example">' + example + '</td>';
                newStr += '<td name="remark">' + remark + '</td>';
                newStr += '<td><a href="#" class="co-green bjBtn2 layui-btn" '+myid+'>编辑</a>  <a href="#" class="co-green"></a></td>';
                newStr += '</tr>';
                //在此数据的上面一行的下面添加

                var $myid='#'+mmid;
                console.log("$myid:"+$myid)
                //无数据时添加
                $("#returnData").append(newStr);
                //$($myid).append(newStr);
                //$(this).after(newStr)
                //alert($(this).parent(id))

            });

            // 编辑
            $("#returnData").on("click", ".bjBtn2", function () {
                var trLength=$("#itbody4 tr:visible").length;
                console.log("trLength"+trLength)
                var my="myclass"+trLength
                var qr2="layui-btn layui-btn-xs qrBtn2 "+my;
                var myid="id="+getID(6);

                var thinLine = $(this).parents('tr');
                thinLine.each(function (i) {
                    // var id = $(this).find("input[name='id']").val();
                    var reg = /编辑/;// 遍历 tr
                    $(this).children('td').each(function (j) {  // 遍历 tr 的各个 td
                        // alert("第"+(i+1)+"行，第"+(j+1)+"个td的值："+$(this).text()+"。");

                        var tdDom = $(this);
                        //保存初始值
                        var tdPreText = $(this).text();
                        //给td设置宽度和给input设置宽度并赋值
                        if (reg.test(tdPreText)) {
                            var newBtns = '<button type="button" '+myid+' class="layui-btn layui-btn-xs qrBtn2"><i class="layui-icon">确定</i></button>';
                            // newBtns += '<button type="button" class="layui-btn layui-btn-xs cancelBtn"><i class="layui-icon">取消</i></button>';
                            $(this).html(newBtns);
                        } else {
                            $(this).html("<input type='text'>").find("input").addClass('layui-input').val(tdPreText);
                        }

                    });
                });
            });


        });
    </script>


    <script type="text/javascript">
        function interfaceAddBody() {
            var interfaceId=$('#interfaceId').text();
            var tabLen = document.getElementById("serviceTables");
            var jsonT = "";
            for (var i = 1; i < tabLen.rows.length; i++) {
                jsonT += ' "interfaceId":"' + interfaceId +
                            '","parameterName_body":"' + tabLen.rows[i].cells[0].innerHTML +
                            '","type_body":"' + tabLen.rows[i].cells[1].innerHTML +
                            '","is_required_body":"' + tabLen.rows[i].cells[2].innerHTML +
                            '","defaultValue_body":"' + tabLen.rows[i].cells[3].innerHTML +
                            '","remark_body":"' + tabLen.rows[i].cells[4].innerHTML+ '";'
            }
            jsonT= jsonT.substr(0, jsonT.length - 1);
            jsonT += "";
            console.log(jsonT);
            console.log(typeof (jsonT))
            $.ajax({
                type: 'post',
                url: '/interface/addBody?interfaceBodyInfo='+jsonT,
                contentType:'application/json;charset=utf-8',
                success: function (data) {
                    if(data.result == true){
                        alert("提交成功")
                        xadmin.close();
                        xadmin.refresh;
                    }else{
                        alert("提交失败");
                        xadmin.close();
                        xadmin.father_reload();
                    };

                },
                error : function() {
                    alert("异常！");
                }
            });
        }

        function interfaceAddReturnData() {
            var interfaceId=$('#interfaceId').text();
            var tabLen = document.getElementById("returnData");
            var jsonT = "";
            for (var i = 1; i < tabLen.rows.length; i++) {
                jsonT += ' "interfaceId":"' + interfaceId +
                    '","parameterName_return":"' + tabLen.rows[i].cells[0].innerHTML +
                    '","type_return":"' + tabLen.rows[i].cells[1].innerHTML +
                    '","is_required_return":"' + tabLen.rows[i].cells[2].innerHTML +
                    '","defaultValue_return":"' + tabLen.rows[i].cells[3].innerHTML +
                    '","remark_return":"' + tabLen.rows[i].cells[4].innerHTML+ '";'
            }
            jsonT= jsonT.substr(0, jsonT.length - 1);
            jsonT += "";
            console.log(jsonT);
            $.ajax({
                type: 'post',
                url: '/interface/addReturnData?Info='+jsonT,
                contentType:'application/json;charset=utf-8',
                success: function (data) {
                    if(data.result == true){
                        alert("提交成功")
                        xadmin.close();
                        xadmin.refresh;
                    }else{
                        alert("提交失败");
                        xadmin.close();
                        xadmin.father_reload();
                    };

                },
                error : function() {
                    alert("异常！");
                }
            });
        }

        function interfaceAddHeader() {
            var interfaceId=$('#interfaceId').text();
            var tabLen = document.getElementById("header");
            var jsonT = "";
            for (var i = 1; i < tabLen.rows.length; i++) {
                jsonT += ' "interfaceId":"' + interfaceId +
                    '","name":"' + tabLen.rows[i].cells[0].innerHTML +
                    '","value":"' + tabLen.rows[i].cells[1].innerHTML +
                    '","is_must":"' + tabLen.rows[i].cells[2].innerHTML +
                    '","remark":"' + tabLen.rows[i].cells[3].innerHTML+ '";'
            }
            jsonT= jsonT.substr(0, jsonT.length - 1);
            jsonT += "";
            console.log(jsonT);
            $.ajax({
                type: 'post',
                url: '/interface/addHeader?Info='+jsonT,
                contentType:'application/json;charset=utf-8',
                success: function (data) {
                    if(data.result == true){
                        alert("提交成功")
                        xadmin.close();
                        xadmin.refresh;
                    }else{
                        alert("提交失败");
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
        //增加返回数据的子项


        $("#returnData").on("click", ".myadd", function () {
            var index = $('.myadd').index(this);
            var myindex='myclass'+index;
            var myid="id="+myindex+'child';
            var str = '';
            // str += '<tr class=\"'+myindex+'\">';
            str += '<tr '+myid+'>';
            // str += '<td>'+intid+'</td>';
            str += '<td>';
            str += '<input type="text"  placeholder="请输入" autocomplete="off"';
            str += 'class="layui-input">';
            str += '</td>';
            str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
            str += 'class="layui-input"></td>';
            str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
            str += 'class="layui-input"></td>';
            str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
            str += 'class="layui-input"></td>';
            str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
            str += 'class="layui-input"></td>';
            str += '<td><button type="button" class="layui-btn layui-btn-xs qrBtn2"> <i class="layui-icon">确定</i></button>';
            str += '</tr>';
            // var myindex=""+".addson"+$('.myadd').index(this)+""
            var my = "."+myindex+""
            $("."+myindex+"").after(str);


        })
    </script>
    <script>
        //随机生成id
        function getID(length){
            return Number(Math.random().toString().substr(3,length) + Date.now()).toString(36);
        }
    </script>
    <script type="text/javascript">

        $(function(){
            $("tr.parent").click(function(){
                $(this).toggleClass('selected').siblings('.'+this.id+'child').toggle();
            })
        })
    </script>
    <script>
        //操作header
        layui.use(['upload','form','layer'], function(){
            var $ = layui.jquery
                ,upload = layui.upload
                ,form = layui.form;
            var interfaceid=$('#interfaceId').text();


            // 新增服务项目
            $("#newBtn3").click(function() {
                var intid=$('#interfaceId').text();
                var trLength=$("#itbody2 tr:visible").length;
                console.log("trLength"+trLength)
                var my="myclass"+trLength
                var myid="id="+my;
                var str = '';
                str += '<tr class=\"'+my+'\">';
                // str += '<td>'+intid+'</td>';
                str += '<td>';
                str += '<input type="text"  placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input">';
                str += '</td>';
                str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input"></td>';
                str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input"></td>';
                // str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                // str += 'class="layui-input"></td>';
                str += '<td><input type="text"   placeholder="请输入" autocomplete="off"';
                str += 'class="layui-input"></td>';
                str += '<td><button type="button" class="layui-btn layui-btn-xs qrBtn3" '+myid+'> <i class="layui-icon">确定</i></button>';
                str += '</tr>';

                $("#header").append(str);
            });
            // 确定
            $("#header").on("click",".qrBtn3",function(){
                var mmid=getID(6)
                var myid="id="+mmid;
                var intid=$('#interfaceId').text();
                $("#header tr:last").remove();
                var newStr = '';
                // var ID = $(this).parent().parent().find("td:nth-child(1)").find("td").val();
                var name = $(this).parent().parent().find("td:nth-child(1)").find("input").val();
                var type = $(this).parent().parent().find("td:nth-child(2)").find("input").val();
                var is_must = $(this).parent().parent().find("td:nth-child(3)").find("input").val();
                var remark = $(this).parent().parent().find("td:nth-child(4)").find("input").val();

                newStr += '<tr>';
                newStr += '<td name="name">';
                newStr += name;
                newStr += '</td>';
                newStr += '<td name="type">' + type + '</td>';
                newStr += '<td name="is_must">' + is_must + '</td>';
                newStr += '<td name="example">' + remark + '</td>';
                newStr += '<td><a href="#" class="co-green bjBtn3 layui-btn" '+myid+'>编辑</a>  <a href="#" class="co-green"></a></td>';
                newStr += '</tr>';
                //在此数据的上面一行的下面添加

                var $myid='#'+mmid;
                console.log("$myid:"+$myid)
                //无数据时添加
                $("#header").append(newStr);
                //$($myid).append(newStr);
                //$(this).after(newStr)
                //alert($(this).parent(id))

            });

            // 编辑
            $("#header").on("click", ".bjBtn3", function () {
                var trLength=$("#itbody2 tr:visible").length;
                console.log("trLength"+trLength)
                var my="myclass"+trLength
                var qr2="layui-btn layui-btn-xs qrBtn3 "+my;
                var myid="id="+getID(6);

                var thinLine = $(this).parents('tr');
                thinLine.each(function (i) {
                    // var id = $(this).find("input[name='id']").val();
                    var reg = /编辑/;// 遍历 tr
                    $(this).children('td').each(function (j) {  // 遍历 tr 的各个 td
                        // alert("第"+(i+1)+"行，第"+(j+1)+"个td的值："+$(this).text()+"。");

                        var tdDom = $(this);
                        //保存初始值
                        var tdPreText = $(this).text();
                        //给td设置宽度和给input设置宽度并赋值
                        if (reg.test(tdPreText)) {
                            var newBtns = '<button type="button" '+myid+' class="layui-btn layui-btn-xs qrBtn3"><i class="layui-icon">确定</i></button>';
                            // newBtns += '<button type="button" class="layui-btn layui-btn-xs cancelBtn"><i class="layui-icon">取消</i></button>';
                            $(this).html(newBtns);
                        } else {
                            $(this).html("<input type='text'>").find("input").addClass('layui-input').val(tdPreText);
                        }

                    });
                });
            });


        });
    </script>
    </body>






</html>