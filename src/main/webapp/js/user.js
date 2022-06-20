// 用户列表查询
function SelectUserlist(){
    $.ajax({
        type:"POST",
        url:"/user/page",
        data:JSON.stringify({
            "currentPage": 1
        }),
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType:"json",
        async: false,
        success:function (result){
            var obj = typeof result=='string'?JSON.parse(result):result;
            if(obj.code === 20041){
                // $("#userlists").empty();
                var p=obj.data;
                userPageView(p);
            }else {
                alert(obj.msg);
            }
        },
        error:function(){
            alert("系统繁忙，请重试！！！");
        }
    });
}
function SelectUserlistByPage(page){
    $.ajax({
        type:"POST",
        url:"/user/page",
        data:JSON.stringify({
            "currentPage": page
        }),
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType:"json",
        async: false,
        success:function (result){
            var obj = typeof result=='string'?JSON.parse(result):result;
            if(obj.code === 20041){
                // $("#userlists").empty();
                var p=obj.data;
                userPageView(p);
            }else {
                alert(obj.msg);
            }
        },
        error:function(){
            alert("系统繁忙，请重试！！！");
        }
    });
}
//页码显示
function userPageView(p){
    $("#userPage").empty()
    // console.log(123)
    // console.log(p.currentPage)


    $("#userPage").append("<li> <a onclick='SelectUserlistByPage("+(Number(p.currentPage)-1)+")' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>")
    for (let i = 1; i <= p.totalPage; i++){

        if (p.currentPage ===i)
            $("#userPage").append("<li class='active'><a onclick='SelectUserlistByPage("+i+")'>" + i +"</a><li/>");
        else
            $("#userPage").append("<li ><a onclick='SelectUserlistByPage("+i+")'>" + i +"</a><li/>");
    }
    $("#userPage").append("<li> <a onclick='SelectUserlistByPage("+(Number(p.currentPage)+1)+")' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>")

    userView(p)
}
// 用户列表显示
function userView(p){
    $("#userlists").empty();
    console.log(p.size*p.currentPage )
    for( i in p.list) {
        $("#userlists").append("" +

            "<tr>"+
            // "<td>" + p.list[i].id +
            // "</td>" +
            "<td>" + (Number(p.size)*Number(p.currentPage-1) +Number(i)+1) +
            "</td><td>" + p.list[i].user_id +
            "</td><td>" + p.list[i].user_name +
            "</td><td>" + "<a onclick='userDelete("+p.list[i].id+")'><button class='btn btn-danger btn-sm'>删除</button></a>" +
            "<a onclick='userEditModel("+p.list[i].id+")' data-toggle='modal' data-target='#updateUserModel'><button class='btn btn-warning btn-sm'>修改</button></a>" +
            "</td>"+"<tr>")
    }
}
// 用户新增
function userAdd(){
    var id = $("#useridadd").val();
    var name = $("#usernameadd").val();
    if (id === "" || name === ""){
        alert("账户或用户名不能为空")
    }else {
        $.ajax({
            type:"POST",
            url:"/user",
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            data:JSON.stringify({
                "user_id": id,
                "user_name": name
            }),
            dataType:"json",
            async: false,
            success:function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20011) {
                    alert(obj.msg);
                    // $('#saveUserModel').modal('hide');
                    SelectUserlist();
                }
                else{
                    alert(obj.msg);
                }
            },
            error:function (){
                alert("系统繁忙，请重试！！！");
            }
        })
    }
}
// 用户修改
function userEditModel(id){
    //根据id查询一个人信息
    $.ajax({
        type:"GET",
        url:"/user/"+id,
        success:function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            var user = obj.data;
            if(obj.code === 20041) {
                //数据渲染到模态框
                $("#updateid").val(user.id);
                $("#updateUserid").val(user.user_id);
                $("#updateUserName").val(user.user_name);
                $("#updateUserPassword").val(user.user_password);
            }
        }
    })
}
function userEdit(){
    var i = $("#updateid").val();
    var id = $("#updateUserid").val();
    var name = $("#updateUserName").val();
    var password = $("#updateUserPassword").val();
    $.ajax({
        type:"PUT",
        url:"/user",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        data:JSON.stringify({
            "id" : i,
            "user_id": id,
            "user_name": name,
            "user_password": password
        }),
        dataType:"json",
        async: false,
        success:function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20031) {
                alert("用户信息修改成功");
                // $('#saveUserModel').modal('hide');
                SelectUserlist();
            }
            else{
                alert("用户信息修改失败");
            }
        },
        error:function (){
            alert("系统繁忙，请重试！！！");
        }
    })
}
//用户删除
function userDelete(id){
    var flag = confirm("是否确认删除？");
    if(flag) {
        $.ajax({
            type: "DELETE",
            url: "/user/" + id,
            success: function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20021) {
                    alert("删除成功");
                    // $('#saveUserModel').modal('hide');
                    SelectUserlist();
                } else {
                    alert("删除失败");
                }
            },
            error: function () {
                alert("系统繁忙，请重试！！！");
            }
        })
    }
}
//用户查询
function userSearch(){

    const info = $("#userquery").val();
    if (info === ""){
        SelectUserlist()
    }else {
        console.log(info)
        $.ajax({
            type:"POST",
            url:"/user/info",
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            data:JSON.stringify({
                "currentPage": 1,
                "info":info
            }),
            dataType:"json",
            async: false,
            success:function (result){
                var obj = typeof result=='string'?JSON.parse(result):result;
                console.log(obj.data.list)
                if(obj.code === 20041){
                    // $("#userlists").empty();
                    var p=obj.data;
                    infoUserPageView(p);
                }else {
                    alert(obj.msg);
                }
            },
            error:function(){
                alert("系统繁忙，请重试！！！");
            }
        });
    }

}
function userSearchByPage(page){

    const info = $("#userquery").val();
    if (info === ""){
        SelectUserlist()
    }else {
        console.log(info)
        $.ajax({
            type:"POST",
            url:"/user/info",
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            data:JSON.stringify({
                "currentPage": page,
                "info":info
            }),
            dataType:"json",
            async: false,
            success:function (result){
                var obj = typeof result=='string'?JSON.parse(result):result;
                console.log(obj.data.list)
                if(obj.code === 20041){
                    // $("#userlists").empty();
                    var p=obj.data;
                    infoUserPageView(p);
                }else {
                    alert(obj.msg);
                }
            },
            error:function(){
                alert("系统繁忙，请重试！！！");
            }
        });
    }

}
//页码显示(用户查询)
function infoUserPageView(p){
    $("#userPage").empty()
    console.log(p.currentPage)

    $("#userPage").append("<li> <a onclick='userSearchByPage("+(Number(p.currentPage)-1)+")' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>")
    for (let i = 1; i <= p.totalPage; i++){
        if (p.currentPage ===i)
            $("#userPage").append("<li class='active'><a onclick='userSearchByPage("+i+")'>" + i +"</a><li/>");
        else
            $("#userPage").append("<li ><a onclick='userSearchByPage("+i+")'>" + i +"</a><li/>");
    }
    $("#userPage").append("<li> <a onclick='userSearchByPage("+(Number(p.currentPage)+1)+")' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>")

    userView(p)
}