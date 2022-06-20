<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script>
    function ChangePW(user) {
        const id = $("#userpw").val();
        const oldpw = $("#oldpassword").val();
        const newpw = $("#newpassword").val();
        if (oldpw === newpw) {
            alert("新密码不能与原密码相同")
        } else {
            $.ajax({
                type:"DELETE",
                url:"/user",
                headers: {
                    'Content-Type': 'application/json;charset=utf-8',
                },
                data:JSON.stringify({
                    "id": id,
                    "user_id": user.user_id,
                    "user_password": newpw
                }),
                dataType:"json",
                async: false,
                success:function (result){
                    var obj = typeof result=='string'?JSON.parse(result):result;
                    if(obj.code === 20031){
                        alert("密码修改成功");
                    }else {
                        alert("密码修改失败");
                    }
                },
                error:function (){
                    alert("系统繁忙，请重试！！！");
                }
            });
        }
    }
    function judge(){
        const id = $("#userpw").val();
        const password = $("#password").val();
        const newpw = $("#newpassword").val();
        if (password !== newpw) {
            alert("新密码前后两次输入不同，请重新设置密码")
        } else {
            $.ajax({
                type:"GET",
                url:"/user/"+id,
                success:function (result){
                    var obj = typeof result=='string'?JSON.parse(result):result;
                    if(obj.code === 20041){
                        ChangePW(obj.data);
                    }else {
                        alert();
                    }
                },
                error:function (){
                    alert("系统繁忙，请重试！！！");
                }
            });
        }
    }
</script>

<div class="col-md-10">
    <div class="page-header" style="margin-top: -20px;">
        <h1>修改密码界面</h1>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-3">
            <form action="" method="post">
                <input type="hidden" class="form-control" name="userpw" id="userpw" value="${loginUser.id}"/>
                <div class="form-group">
                    <label for="oldpassword">原密码</label>
                    <input type="password" class="form-control" id="oldpassword" placeholder="请输入原密码">
                </div>
                <div class="form-group">
                    <label for="password">新密码</label>
                    <input type="password" class="form-control" id="password" placeholder="请输入密码">
                </div>
                <div class="form-group">
                    <label for="newpassword">再次输入新密码</label>
                    <input type="password" class="form-control" id="newpassword" placeholder="请输入密码">
                </div>
                <a type="submit" onclick="judge()" class="btn btn-danger btn-block" style="margin-top: 20px">确认修改</a>
            </form>
        </div>
    </div>
</div>
