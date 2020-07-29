<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>角色添加</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
  
  <body>
    <div class="layui-fluid">
        <div class="layui-row">
            <form action="" method="post" id="saveRole" class="layui-form layui-form-pane">
<%--                角色名称--%>
                <div class="layui-form-item">
                    <label for="roleName" class="layui-form-label">
                        <span class="x-red">*</span>角色名称
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="roleName" name="roleName" required="" lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>将会成为您角色的名称,必填
                    </div>
                </div>
                </div>
<%--                角色描述--%>
                <div class="layui-form-item">
                    <label for="roleDesc" class="layui-form-label">
                        <span class="x-red">*</span>角色描述
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="roleDesc" name="roleDesc" required="" lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red"></span>非必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label"></label>
                    <p><input type="button" class="layui-btn" value="提交" id="L_repass" onclick="role_add()">&nbsp;<input type="reset" class="layui-btn" value="重置"></p >
                </div>
            </form>
        </div>
    </div>


  </body>

<script type="text/javascript">

    function role_add() {
        var formObject = {};
        var formArray =$("#saveRole").serializeArray();
        $.each(formArray,function(i,item){
            formObject[item.name] = item.value;
        });
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/role/saveRole" ,//url
            data:JSON.stringify(formObject),
            contentType:'application/json;charset=utf-8',
            success: function (data) {
                console.log(data);//打印服务端返回的数据(调试用)
                if (data.result == true) {
                    alert("增加成功");
                    xadmin.close();
                    // 可以对父窗口进行刷新
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

</html>