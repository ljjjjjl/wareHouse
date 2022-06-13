<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="../boot/css/bootstrap.min.css"/>
    <script src="../boot/js/jquery-3.6.0.js"></script>
    <script src="../boot/js/bootstrap.min.js"></script>
    <style>
        .form-control{
            height: 45px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row" style="margin-top: 60px;">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="text-center">用户登录</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="" method="post">
                <div class="form-group">
                    <label for="userid">用户名</label>
                    <input type="text" class="form-control" id="userid" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" placeholder="请输入密码">
                </div>
                <a type="submit" onclick="loginsubmit()" class="btn btn-danger btn-block" style="margin-top: 20px">登录</a>
            </form>
        </div>
    </div>
</div>
<script>
    function loginsubmit(){
        var user_id = $("#userid").val();
        var user_password = $("#password").val();
        if(user_id === "" || user_password === ""){
            alert("用户名或密码不能为空");
        }else {
            $.ajax({
                type:"POST",
                url:"/user/login",
                headers: {
                    'Content-Type': 'application/json;charset=utf-8',
                },
                data:JSON.stringify({
                    "user_id": user_id,
                    "user_password": user_password
                }),
                dataType:"json",
                async: false,
                success:function (result){
                    var obj = typeof result=='string'?JSON.parse(result):result;
                    console.log(obj.code);
                    console.log(obj.msg);
                    console.log(obj.data);
                    if(result.code === 20061){
                        alert(result.msg);
                        window.location.href = "index.jsp";
                    }else {
                        alert(result.msg);
                    }
                },
                error:function (){
                    alert("系统繁忙，请重试！！！");
                }
            });
        }
    }
</script>
</body>
</html>