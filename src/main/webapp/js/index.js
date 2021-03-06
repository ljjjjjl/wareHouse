var maxTime = 600;
var time = maxTime;
function timereset(){
    time = maxTime;
}
var intervalId = setInterval(function(){
    time--;
    if(time <= 0) {
        Logout();
        clearInterval(intervalId);
    }
}, 1000)


function System(){
    $("#content").load("../pages/system.jsp");
}
function Stock(){
    $("#content").load("../pages/stock.jsp")
}
function Password(){
    $("#content").load("../pages/changepw.jsp")
}

// username显示
window.onload=function() {
    $.ajax({
        type: "GET",
        url: "/user/username",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType: "json",
        async: false,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20041) {
                $("#usernameshow").html(obj.data.user_name);
            }
        },
    });
}


// 注销功能
function Logout() {
    $.ajax({
        type: "GET",
        url: "/user/logout",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType: "json",
        async: false,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20071) {
                alert("用户"+obj.data + obj.msg);
                window.location.href = "../pages/login.jsp";
            } else {
                alert("用户"+obj.data + obj.msg);
            }
        },
        error: function () {
            alert("系统繁忙，请重试！！！");
        }
    });
}



