//仓库管理
function SelectRepositorylists(){
    $.ajax({
        type:"GET",
        url:"/warehouse",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType:"json",
        async: false,
        success:function (result){
            var obj = typeof result=='string'?JSON.parse(result):result;
            if(obj.code === 20041){
                var list=obj.data;
                RepositoryView(list);
            }else {
                alert(obj.msg);
            }
        },
        error:function(){
            alert("系统繁忙，请重试！！！");
        }
    });
}

function RepositoryView(list){
    $("#repositorylists").empty();
    $.each(list,function (i,warehouse){
        $("#repositorylists").append("<tr><td>" + warehouse.id +
            "</td><td>" + warehouse.warehouse_id +
            "</td><td>" + warehouse.warehouse_name +
            "</td><td>" + "<a onclick='warehouseDelete(" + warehouse.id + ")'>" +
            "<button class='btn btn-danger btn-sm'>删除</button></a>" +
            "<a onclick='warehouseEditModel(" + warehouse.id + ")' data-toggle='modal' data-target='#updateRepositoryModel'>" +
            "<button class='btn btn-warning btn-sm'>修改</button></a>" +
            "</td><tr>");
    })
}