//仓库管理
function SelectRepositorylists(){
    $.ajax({
        type:"POST",
        url:"/warehouse/page",
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
                var p=obj.data;
                RepositoryPageView(p);
            }else {
                alert(obj.msg);
            }
        },
        error:function(){
            alert("系统繁忙，请重试！！！");
        }
    });
}
function SelectRepositorylistsByPage(page){
    $.ajax({
        type:"POST",
        url:"/warehouse/page",
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
                var p=obj.data;
                RepositoryPageView(p);
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
function RepositoryPageView(p){
    $("#warehousePage").empty()


    $("#warehousePage").append("<li> <a onclick='SelectRepositorylistsByPage("+(Number(p.currentPage)-1)+")' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>")
    for (let i = 1; i <= p.totalPage; i++){

        if (p.currentPage ===i)
            $("#warehousePage").append("<li class='active'><a onclick='SelectRepositorylistsByPage("+i+")'>" + i +"</a><li/>");
        else
            $("#warehousePage").append("<li ><a onclick='SelectRepositorylistsByPage("+i+")'>" + i +"</a><li/>");
    }
    $("#warehousePage").append("<li> <a onclick='SelectRepositorylistsByPage("+(Number(p.currentPage)+1)+")' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>")

    RepositoryView(p)
}
function RepositoryView(p){
    $("#repositorylists").empty();
    $.each(p.list,function (i,warehouse){
        $("#repositorylists").append("<tr>" +
            "<td>" + (Number(p.size)*Number(p.currentPage-1) +Number(i)+1) +
            "</td><td><a onclick='towarehousedetail("+warehouse.id+")'>"+  warehouse.warehouse_id +"</a>"+
            "</td><td>" + warehouse.warehouse_name +
            // "</td><td>" + "<a onclick='warehouseDelete(" + warehouse.id + ")'>" +
            // "<button class='btn btn-danger btn-sm'>删除</button></a>" +
            // "<a onclick='warehouseEditModel(" + warehouse.id + ")' data-toggle='modal' data-target='#updateRepositoryModel'>" +
            // "<button class='btn btn-warning btn-sm'>修改</button></a>" +
            "</td><tr>");
    })
}


function RepositoryAdd(){
    const name = $("#repositoryadd").val();
    if (name === ""){
        alert("仓库名不能为空")
    }else {
        $.ajax({
            type:"POST",
            url:"/warehouse",
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            data:JSON.stringify({
                "warehouse_name": name
            }),
            dataType:"json",
            async: false,
            success:function (result) {
                const obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20011) {
                    alert(obj.msg);
                    // $('#saveUserModel').modal('hide');
                    SelectRepositorylists();
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
//仓库明细管理
function SelectWarehouselists(id){

    $.ajax({
        type:"POST",
        url:"/warehouse_details/page",
        data:JSON.stringify({
            "others_id":id,
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
                var p=obj.data;
                console.log(p);
                WarehouselistsPageView(p,id);
            }else {
                alert(obj.msg);
            }
        },
        error:function(){
            alert("系统繁忙，请重试！！！");
        }
    });

}
function SelectWarehouselistsByPage(page,id){

    $.ajax({
        type:"POST",
        url:"/warehouse_details/page",
        data:JSON.stringify({
            "others_id":id,
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
                var p=obj.data;
                console.log(p);
                WarehouselistsPageView(p,id);
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
function WarehouselistsPageView(p,id){
    $("#warehouseDetailsPage").empty()
    console.log(id)

    $("#warehouseDetailsPage").append("<li> <a onclick='SelectWarehouselistsByPage("+(Number(p.currentPage)-1)+","+id+")' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>")
    for (let i = 1; i <= p.totalPage; i++){

        if (p.currentPage ===i)
            $("#warehouseDetailsPage").append("<li class='active'><a onclick='SelectWarehouselistsByPage("+i+","+id+")'>" + i +"</a><li/>");
        else
            $("#warehouseDetailsPage").append("<li ><a onclick='SelectWarehouselistsByPage("+i+","+id+")'>" + i +"</a><li/>");
    }
    $("#warehouseDetailsPage").append("<li> <a onclick='SelectWarehouselistsByPage("+(Number(p.currentPage)+1)+","+id+")' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>")

    WarehouseView(p,id)
}
function WarehouseView(p,wareid){
    $("#warehousedetaillists").empty();
    // console.log(list)
    $.each(p.list, function (i, warehousedetail) {
        $.ajax({
            type: "PATCH",
            url: "/goods_details/"+ warehousedetail.goods_details_id,
            async: false,
            success: function (result) {
                var goodsdetail = typeof result == 'string' ? JSON.parse(result) : result;
                var Goodsdetail = goodsdetail.data;
                if (goodsdetail.code === 20041) {
                    $.ajax({
                        type:"GET",
                        url:"/goods/"+Goodsdetail.goods_id,
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8',
                        },
                        dataType:"json",
                        async: false,
                        success:function (result){
                            const goods = typeof result == 'string' ? JSON.parse(result) : result;
                            const Goods = goods.data;
                            if(goods.code === 20041) {
                                $.ajax({
                                    type:"GET",
                                    url:"/warehouse/"+warehousedetail.warehouse_id,
                                    headers: {
                                        'Content-Type': 'application/json;charset=utf-8',
                                    },
                                    dataType:"json",
                                    async: false,
                                    success:function (result){
                                        const warehouse = typeof result == 'string' ? JSON.parse(result) : result;
                                        const Warehouse = warehouse.data;
                                        console.log(Warehouse.warehouse_name);
                                        if(warehouse.code === 20041) {
                                            $("#warehousedetaillists").append("" +
                                                "<tr>" +
                                                "<td>" + (Number(p.size)*Number(p.currentPage-1) +Number(i)+1) +
                                                "</td><td>" + Warehouse +
                                                "</td><td>" + Goods.goods_name +
                                                "</td><td>" + Goodsdetail.goods_color+","+Goodsdetail.goods_size +
                                                "</td><td>" + warehousedetail.num +
                                                "</td><tr>");
                                        }
                                    },
                                });
                            }
                        },
                    });
                }
            }
        })
    })
}

function towarehousedetail(id) {
    $("#warehousedetail").click();
    SelectWarehouselists(id);
}