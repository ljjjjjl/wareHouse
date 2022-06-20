// 货号列表查询
function SelectGoodslist(){
    $.ajax({
        type:"POST",
        url:"/goods/page",
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
                goodsPageView(p);
            }else {
                alert(obj.msg);
            }
        },
        error:function(){
            alert("系统繁忙，请重试！！！");
        }
    });
}
function SelectGoodslistByPage(page){
    $.ajax({
        type:"POST",
        url:"/goods/page",
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
                goodsPageView(p);
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
function goodsPageView(p){
    $("#goodsPage").empty()
    console.log(p.currentPage)

    $("#goodsPage").append("<li> <a onclick='SelectGoodslistByPage("+(Number(p.currentPage)-1)+")' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>")
    for (let i = 1; i <= p.totalPage; i++){
        if (p.currentPage ===i)
            $("#goodsPage").append("<li class='active'><a onclick='SelectGoodslistByPage("+i+")'>" + i +"</a><li/>");
        else
            $("#goodsPage").append("<li ><a onclick='SelectGoodslistByPage("+i+")'>" + i +"</a><li/>");
    }
    $("#goodsPage").append("<li> <a onclick='SelectGoodslistByPage("+(Number(p.currentPage)+1)+")' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>")

    goodsView(p)
}
// 货号列表显示
function goodsView(p){
    $("#goodslists").empty();
    // $("#goodslists").html("");
    for( i in p.list) {
        $("#goodslists").append("" +
            "<tr>" +
            // "<td>" + p.list[i].id +
            // "</td>" +
            "<td>" + (Number(p.size)*Number(p.currentPage-1) +Number(i)+1) +
            "</td><td><a onclick='togoodsdetail("+p.list[i].id+")'>"+ p.list[i].goods_id +"</a>"+
            "</td><td>" + p.list[i].goods_name +
            "</td><td>" + "<a onclick='goodsDelete("+p.list[i].id+")'><button class='btn btn-danger btn-sm'>删除</button></a>" +
            "<a onclick='goodsEditModel("+p.list[i].id+")' data-toggle='modal' data-target='#updateGoodsModel'><button class='btn btn-warning btn-sm'>修改</button></a>" +
            "</td>"+"<tr>")
    }
}
// 货号新增
function goodsAdd(){
    var id = $("#saveGoodsNo").val();
    var name = $("#saveGoodsName").val();
    if (id === "" || name === ""){
        alert("账户或用户名不能为空")
    }else {
        $.ajax({
            type:"POST",
            url:"/goods",
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            data:JSON.stringify({
                "goods_id": id,
                "goods_name": name
            }),
            dataType:"json",
            async: false,
            success:function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20011) {
                    alert(obj.msg);
                    // $('#saveUserModel').modal('hide');
                    SelectGoodslist();
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
// 货号修改
function goodsEditModel(id){
    console.log(id)
    //根据id查询一个人信息
    $.ajax({
        type:"GET",
        url:"/goods/"+id,
        success:function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            var goods = obj.data;
            if(obj.code === 20041) {

                //数据渲染到模态框
                $("#updategoodsid").val(goods.id);
                $("#UpdateGoodsNo").val(goods.goods_id);
                $("#UpdateGoodsName").val(goods.goods_name);
            }
        }
    })
}
function goodsEdit(){
    var i = $("#updategoodsid").val();
    var id = $("#UpdateGoodsNo").val();
    var name = $("#UpdateGoodsName").val();
    $.ajax({
        type:"PUT",
        url:"/goods",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        data:JSON.stringify({
            "id" : i,
            "goods_id": id,
            "goods_name": name
        }),
        dataType:"json",
        async: false,
        success:function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20031) {
                alert(obj.msg);
                // $('#saveUserModel').modal('hide');
                SelectGoodslist();
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
//货号删除
function goodsDelete(id){
    var flag = confirm("是否确认删除？");
    if(flag) {
        $.ajax({
            type: "DELETE",
            url: "/goods/" + id,
            success: function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20021) {
                    alert("删除成功");
                    // $('#saveUserModel').modal('hide');
                    SelectGoodslist();
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
//货号查询
function goodsSearch(){
    const info = $("#goodsquery").val();
    console.log(info);
    if(info === ""){
        SelectGoodslist();
    }else {
        console.log(info)
        $.ajax({
            type:"POST",
            url:"/goods/info",
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
                    infoGoodsPageView(p);
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
function goodsSearchByPage(page){
    const info = $("#goodsquery").val();
    console.log(info);
    if(info === ""){
        SelectGoodslist();
    }else {
        console.log(info)
        $.ajax({
            type:"POST",
            url:"/goods/info",
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
                    infoGoodsPageView(p);
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
function infoGoodsPageView(p){
    $("#goodsPage").empty()
    console.log(p.currentPage)

    $("#goodsPage").append("<li> <a onclick='goodsSearchByPage("+(Number(p.currentPage)-1)+")' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>")
    for (let i = 1; i <= p.totalPage; i++){
        if (p.currentPage ===i)
            $("#goodsPage").append("<li class='active'><a onclick='goodsSearchByPage("+i+")'>" + i +"</a><li/>");
        else
            $("#goodsPage").append("<li ><a onclick='goodsSearchByPage("+i+")'>" + i +"</a><li/>");
    }
    $("#goodsPage").append("<li> <a onclick='goodsSearchByPage("+(Number(p.currentPage)+1)+")' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>")

    goodsView(p.list)
}

//货号明细
function SelectGoodsDetail(goods_id){
    if(goods_id !== null){
        $.ajax({
            type:"POST",
            url:"/goods_details/page",
            data:JSON.stringify({
                "currentPage": 1,
                "others_id":goods_id
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
                    goodsDetailsPageView(p,goods_id);
                }else {
                    alert(obj.msg);
                }
            },
            error:function(){
                alert("系统繁忙，请重试！！！");
            }
        });
    }else{
        $.ajax({
            type:"POST",
            url:"/goods_details/info",
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
                    goodsDetailsPageView(p,goods_id);
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
function SelectGoodsDetailByPage(goods_id,page){
    if(goods_id !== null){
        $.ajax({
            type:"POST",
            url:"/goods_details/page",
            data:JSON.stringify({
                "currentPage": page,
                "others_id":goods_id
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
                    goodsDetailsPageView(p,goods_id);
                }else {
                    alert(obj.msg);
                }
            },
            error:function(){
                alert("系统繁忙，请重试！！！");
            }
        });
    }else{
        $.ajax({
            type:"POST",
            url:"/goods_details/info",
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
                    goodsDetailsPageView(p,goods_id);
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

//页码显示
function goodsDetailsPageView(p,goods_id){
    $("#goodsDetailsPage").empty()
    console.log("currentPage"+p.currentPage)

    $("#goodsDetailsPage").append("<li> <a onclick='SelectGoodsDetailByPage("+goods_id+","+(Number(p.currentPage)-1)+")' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>")
    for (let i = 1; i <= p.totalPage; i++){
        if (p.currentPage ===i)
            $("#goodsDetailsPage").append("<li class='active'><a onclick='SelectGoodsDetailByPage("+goods_id+","+i+")'>" + i +"</a><li/>");
        else
            $("#goodsDetailsPage").append("<li ><a onclick='SelectGoodsDetailByPage("+goods_id+","+i+")'>" + i +"</a><li/>");
    }
    $("#goodsDetailsPage").append("<li> <a onclick='SelectGoodsDetailByPage("+goods_id+","+(Number(p.currentPage)+1)+")' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>")

    goodsdetailView(p)
}
function goodsdetailView(p){
    $("#goodsdetaillists").empty();
    $.each(p.list,function (i,goods){
        $("#goodsdetaillists").append("" +
            "<tr>" +
            // "<td>" + goods.id +
            // "</td" +
            "><td>" + (Number(p.size)*Number(p.currentPage-1) +Number(i)+1) +
            "</td><td>" + goods.goods_color +
            "</td><td>" + goods.goods_size +
            "</td><td>" + "<a onclick='goodsdetailDelete(" + goods.id + ")'>" +
            "<button class='btn btn-danger btn-sm'>删除</button></a>" +
            "<a onclick='goodsdetailEditModel(" + goods.id + ")' data-toggle='modal' data-target='#updateGoodsDetailModel'>" +
            "<button class='btn btn-warning btn-sm'>修改</button></a>" +
            "</td><tr>");
    })
}

function goodsdetailAdd(){
    var id = $("#SelectGoodsName").val();
    console.log(id);
    var color = $("#saveGoodsDetailColor").val();
    var size = $("#saveGoodsDetailSize").val();
    if (color === "" || size === ""){
        alert("货品颜色或尺码不能为空")
    }else {
        $.ajax({
            type:"POST",
            url:"/goods_details",
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            data:JSON.stringify({
                "goods_color": color,
                "goods_size": size,
                "goods_id": id
            }),
            dataType:"json",
            async: false,
            success:function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20011) {
                    alert(obj.msg);
                    // $('#saveUserModel').modal('hide');
                    SelectGoodsDetail(id);
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

function goodsdetailDelete(id){
    var flag = confirm("是否确认删除？");
    if(flag) {
        $.ajax({
            type: "DELETE",
            url: "/goods_details/" + id,
            success: function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20021) {
                    alert("删除成功");
                    // $('#saveUserModel').modal('hide');
                    SelectGoodsDetail(null);
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

function goodsdetailEditModel(id){
    $.ajax({
        type:"PATCH",
        url:"/goods_details/"+id,
        success:function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            var goods = obj.data;
            if(obj.code === 20041) {
                //数据渲染到模态框
                $("#updategoodsdetailid").val(id);
                $("#updategoodssid").val(goods.goods_id);
                $("#UpdateGoodsDetailColor").val(goods.goods_color);
                $("#UpdateGoodsDetailSize").val(goods.goods_size);
            }
        }
    })
}
function goodsdetailEdit(){
    const id = $("#updategoodsdetailid").val();
    const goods_id = $("#updategoodssid").val();
    const color = $("#UpdateGoodsDetailColor").val();
    const size = $("#UpdateGoodsDetailSize").val();
    $.ajax({
        type:"PUT",
        url:"/goods_details",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        data:JSON.stringify({
            "goods_color": color,
            "goods_size": size,
            "id" : id,
            "goods_id": goods_id
        }),
        dataType:"json",
        async: false,
        success:function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20031) {
                alert(obj.msg);
                // $('#saveUserModel').modal('hide');
                SelectGoodsDetail(goods_id);
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

function Selectgoodsname(){
    $.ajax({
        type:"GET",
        url:"/goods",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType:"json",
        async: false,
        success:function (result){
            var obj = typeof result=='string'?JSON.parse(result):result;
            if(obj.code === 20041){
                console.log(obj.data);
                $("#SelectGoodsName").empty();
                $.each(obj.data,function (i,goods){
                    $("#SelectGoodsName").append("<option value='" + goods.id + "'>"+ goods.goods_name+"</option>");
                });
            }else {
                alert(obj.msg);
            }
        },
        error:function(){
            alert("系统繁忙，请重试！！！");
        }
    });
}

function togoodsdetail(id) {
    $("#goodsdetail").click();
    SelectGoodsDetail(id);
}

