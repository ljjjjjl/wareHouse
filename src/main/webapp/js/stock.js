//获取出库列表
function SelectOrderOut(){
    $.ajax({
        type:"POST",
        url:"/orders/page/out",
        data:JSON.stringify({
            "currentPage": 1
        }),
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType:"json",
        async: false,
        success:function (result){
            const obj = typeof result == 'string' ? JSON.parse(result) : result;
            if(obj.code === 20041){
                const p = obj.data;
                ordersoutPageView(p);
            }else {
                alert(obj.msg);
            }
        },
        error:function(){
            alert("系统繁忙，请重试！！！");
        }
    });
}
function SelectOrderOut(page){
    $.ajax({
        type:"POST",
        url:"/orders/page/out",
        data:JSON.stringify({
            "currentPage": page
        }),
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType:"json",
        async: false,
        success:function (result){
            const obj = typeof result == 'string' ? JSON.parse(result) : result;
            if(obj.code === 20041){
                const p = obj.data;
                ordersoutPageView(p);
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
function ordersoutPageView(p){
    $("#orderoutPage").empty()
    console.log(p.currentPage)

    $("#orderoutPage").append("<li> <a onclick='SelectOrderOut("+(Number(p.currentPage)-1)+")' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>")
    for (let i = 1; i <= p.totalPage; i++){
        if (p.currentPage ===i)
            $("#orderoutPage").append("<li class='active'><a onclick='SelectOrderOut("+i+")'>" + i +"</a><li/>");
        else
            $("#orderoutPage").append("<li ><a onclick='SelectOrderOut("+i+")'>" + i +"</a><li/>");
    }
    $("#orderoutPage").append("<li> <a onclick='SelectOrderOut("+(Number(p.currentPage)+1)+")' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>")

    orderoutView(p.list)
}
//显示出库
function orderoutView(list) {
    $("#orderoutlists").empty();
    for (i in list) {
        var time = new Date(list[i].orders_date).Format("yyyy-MM-dd hh:mm:ss");
        $("#orderoutlists").append("<tr>" + "<td>" + list[i].id +
            "</td><td><a onclick='toorderoutdetail("+list[i].id+")'>" + list[i].orders_id +"</a>"+
            "</td><td>" + list[i].orders_address +
            "</td><td>" + time +
            "</td><td>" + list[i].orders_note +
            "</td><td>" + list[i].warehouse_id +
            "</td><td>" + list[i].user_id +
            "</td><td>" + "<a onclick='OrderoutDelete(" + list[i].id + ")'><button class='btn btn-danger btn-sm'>删除</button></a>" +
            "<a onclick='OrderoutEditModel(" + list[i].id + ")' data-toggle='modal' data-target='#updateOrderoutModel'><button class='btn btn-warning btn-sm'>修改</button></a>" +
            "</td>" + "<tr>")
    }
}

//出库删除
function OrderoutDelete(id) {
    var flag = confirm("是否确认删除？");
    if (flag) {
        $.ajax({
            type: "DELETE",
            url: "/orders/" + id,
            success: function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20021) {
                    alert("删除成功");
                    // $('#saveUserModel').modal('hide');
                    SelectOrderOut();
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

//出库增加
function OrderOutadd() {
    $("#orderoutlists").empty();
    var id = $("#Orderoutidadd").val();
    var address = $("#Orderoutaddressadd").val();
    var note = $("#Orderoutnoteadd").val();
    var warehouse = $("#Selectwarhouseadd").val();
    if (warehouse === "" || address === "") {
        alert("仓库或地址不能为空");
    } else {
        $.ajax({
            type: "POST",
            url: "/orders",
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            data: JSON.stringify({
                "orders_id": id,
                "orders_address": address,
                "orders_note": note,
                "warehouse_id": warehouse,
                "orders_type": "出库"
            }),
            dataType: "json",
            async: false,
            success: function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20011) {
                    alert(obj.msg);
                    SelectOrderOut();
                } else {
                    alert(obj.msg);
                }
            },
            error: function () {
                alert("系统繁忙，请重试！！！");
            }
        })
    }
}

//出库修改
function OrderoutEditModel(id) {
    $.ajax({
        type: "GET",
        url: "/orders/" + id,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            var orders = obj.data;
            if (obj.code === 20041) {
                //数据渲染到模态框
                $("#updateordersid").val(orders.id);
                $("#Orderoutidupdate").val(orders.orders_id);
                $("#Orderoutaddressupdate").val(orders.orders_address);
                $("#Orderoutnoteupdate").val(orders.orders_note);
                SelectwarenameoutU(orders.warehouse_id);
            }
        }
    })
}
function OrderoutEdit() {
    const id = $("#updateordersid").val();
    const orderid = $("#Orderoutidupdate").val();
    const address = $("#Orderoutaddressupdate").val();
    const note = $("#Orderoutnoteupdate").val();
    const warehouseid = $("#Selectwarhouseup").val();
    $.ajax({
        type: "PUT",
        url: "/orders",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        data: JSON.stringify({
            "id": id,
            "orders_id": orderid,
            "orders_address": address,
            "orders_note": note,
            "warehouse_id": warehouseid
        }),
        dataType: "json",
        async: false,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20031) {
                alert("修改成功");
                SelectOrderOut();
            } else {
                alert("修改失败");
            }
        },
        error: function () {
            alert("系统繁忙，请重试！！！");
        }
    })
}

//出库查询


//查询仓库名
function SelectwarenameoutA() {
    $.ajax({
        type: "GET",
        url: "/warehouse",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType: "json",
        async: false,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20041) {
                $("#Selectwarhouseadd").empty();
                $.each(obj.data, function (i, warehouse) {
                    $("#Selectwarhouseadd").append("<option value='" + warehouse.id + "'>" + warehouse.warehouse_name + "</option>");
                });
            } else {
                alert(obj.msg);
            }
        },
        error: function () {
            alert("系统繁忙，请重试！！！");
        }
    });
}
function SelectwarenameoutU(id) {
    $.ajax({
        type: "GET",
        url: "/warehouse",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType: "json",
        async: false,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20041) {
                $("#Selectwarhouseup").empty();
                $.each(obj.data, function (i, warehouse) {
                    if (warehouse.id === id) {
                        $("#Selectwarhouseup").append("<option selected value='" + warehouse.id + "'>" + warehouse.warehouse_name + "</option>");
                    } else {
                        $("#Selectwarhouseup").append("<option value='" + warehouse.id + "'>" + warehouse.warehouse_name + "</option>");
                    }
                });
            } else {
                alert(obj.msg);
            }
        },
        error: function () {
            alert("系统繁忙，请重试！！！");
        }
    });
}

//时间转换
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds() //秒
    };
    if (/(y+)/.test(fmt)) { //根据y的长度来截取年
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    }
    return fmt;
}

//获取入库列表
function SelectOrderIn() {
    $.ajax({
        type: "GET",
        url: "/orders/page/in",
        data:JSON.stringify({
            "currentPage": 1
        }),
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType:"json",
        async: false,
        success: function (result) {
            const obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20041) {
                const p = obj.data;
                orderinView(p, orderinlists);
            } else {
                alert(obj.msg);
            }
        },
        error: function () {
            alert("系统繁忙，请重试！！！");
        }
    });
}
function SelectOrderIn(page){
    $.ajax({
        type:"POST",
        url:"/orders/page/in",
        data:JSON.stringify({
            "currentPage": page
        }),
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType:"json",
        async: false,
        success:function (result){
            const obj = typeof result == 'string' ? JSON.parse(result) : result;
            if(obj.code === 20041){
                const p = obj.data;
                ordersinPageView(p);
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
function ordersinPageView(p){
    $("#orderinPage").empty()
    console.log(p.currentPage)

    $("#orderinPage").append("<li> <a onclick='SelectOrderIn("+(Number(p.currentPage)-1)+")' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>")
    for (let i = 1; i <= p.totalPage; i++){
        if (p.currentPage ===i)
            $("#orderinPage").append("<li class='active'><a onclick='SelectOrderIn("+i+")'>" + i +"</a><li/>");
        else
            $("#orderinPage").append("<li ><a onclick='SelectOrderIn("+i+")'>" + i +"</a><li/>");
    }
    $("#orderinPage").append("<li> <a onclick='SelectOrderIn("+(Number(p.currentPage)+1)+")' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>")

    orderinView(p.list)
}
//入库显示
function orderinView(list) {
    $("#orderinlists").empty();
    for (i in list) {
        var time = new Date(list[i].orders_date).Format("yyyy-MM-dd hh:mm:ss");
        $("#orderinlists").append("<tr>" + "<td>" + list[i].id +
            "</td><td><a onclick='toorderindetail("+list[i].id+")'>" + list[i].orders_id +"</a>"+
            "</td><td>" + list[i].orders_address +
            "</td><td>" + time +
            "</td><td>" + list[i].orders_note +
            "</td><td>" + list[i].warehouse_id +
            "</td><td>" + list[i].user_id +
            "</td><td>" + "<a onclick='OrderinDelete(" + list[i].id + ")'><button class='btn btn-danger btn-sm'>删除</button></a>" +
            "<a onclick='OrderinEditModel(" + list[i].id + ")' data-toggle='modal' data-target='#updateOrderinModel'><button class='btn btn-warning btn-sm'>修改</button></a>" +
            "</td>" + "<tr>");
    }
}

//入库删除
function OrderinDelete(id) {
    var flag = confirm("是否确认删除？");
    if (flag) {
        $.ajax({
            type: "DELETE",
            url: "/orders/" + id,
            success: function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20021) {
                    alert("删除成功");
                    // $('#saveUserModel').modal('hide');
                    SelectOrderIn();
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

//入库增加
function OrderinAdd() {
    var id = $("#Orderinidadd").val();
    var address = $("#Orderinaddressadd").val();
    var note = $("#Orderinnoteadd").val();
    var warehouse = $("#Selectwarhouseaddin").val();
    if (warehouse === "" || address === "") {
        alert("仓库或地址不能为空");
    } else {
        $.ajax({
            type: "POST",
            url: "/orders",
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            data: JSON.stringify({
                "orders_id": id,
                "orders_address": address,
                "orders_note": note,
                "warehouse_id": warehouse,
                "orders_type": "入库"
            }),
            dataType: "json",
            async: false,
            success: function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20011) {
                    alert(obj.msg);
                    SelectOrderIn();
                } else {
                    alert(obj.msg);
                }
            },
            error: function () {
                alert("系统繁忙，请重试！！！");
            }
        })
    }
}

//入库修改
function OrderinEditModel(id) {
    $.ajax({
        type: "GET",
        url: "/orders/" + id,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            var orders = obj.data;
            if (obj.code === 20041) {
                //数据渲染到模态框
                $("#updateordersidin").val(orders.id);
                $("#Orderinidupdate").val(orders.orders_id);
                $("#Orderinaddressupdate").val(orders.orders_address);
                $("#Orderinnoteupdate").val(orders.orders_note);
                SelectwarenameinU(orders.warehouse_id);
            }
        }
    })
}
function OrderinEdit() {
    const id = $("#updateordersidin").val();
    const orderid = $("#Orderinidupdate").val();
    const address = $("#Orderinaddressupdate").val();
    const note = $("#Orderinnoteupdate").val();
    const warehouseid = $("#Selectwarhouseupin").val();
    $.ajax({
        type: "PUT",
        url: "/orders",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        data: JSON.stringify({
            "id": id,
            "orders_id": orderid,
            "orders_address": address,
            "orders_note": note,
            "warehouse_id": warehouseid
        }),
        dataType: "json",
        async: false,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20031) {
                alert("修改成功");
                SelectOrderIn();
            } else {
                alert("修改失败");
            }
        },
        error: function () {
            alert("系统繁忙，请重试！！！");
        }
    })
}

//入库查询

//入库查询仓库名
function SelectwarenameinA() {
    $.ajax({
        type: "GET",
        url: "/warehouse",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType: "json",
        async: false,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20041) {
                $("#Selectwarhouseaddin").empty();
                $.each(obj.data, function (i, warehouse) {
                    $("#Selectwarhouseaddin").append("<option value='" + warehouse.id + "'>" + warehouse.warehouse_name + "</option>");
                });
            } else {
                alert(obj.msg);
            }
        },
        error: function () {
            alert("系统繁忙，请重试！！！");
        }
    });
}
function SelectwarenameinU(id) {
    $.ajax({
        type: "GET",
        url: "/warehouse",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType: "json",
        async: false,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20041) {
                $("#Selectwarhouseupin").empty();
                $.each(obj.data, function (i, warehouse) {
                    if (warehouse.id === id) {
                        $("#Selectwarhouseupin").append("<option selected value='" + warehouse.id + "'>" + warehouse.warehouse_name + "</option>");
                    } else {
                        $("#Selectwarhouseupin").append("<option value='" + warehouse.id + "'>" + warehouse.warehouse_name + "</option>");
                    }
                });
            } else {
                alert(obj.msg);
            }
        },
        error: function () {
            alert("系统繁忙，请重试！！！");
        }
    });
}

//出库管理
//跳转出库明细界面
function toorderoutdetail(id){
    $("#orderoutdetail").click();
    SelectOrderOutDetail(id);
}

//获取出库明细列表
function SelectOrderOutDetail(orders_id){
    if(id !== null){
        $.ajax({
            type:"POST",
            url:"/orders_details/page",
            data:JSON.stringify({
                "others_id":orders_id,
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
                    var list=obj.data;
                    orderoutdetailPageView(orders_id,list);
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
            url:"/orders_details/page",
            data:JSON.stringify({
                "others_id":orders_id,
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
                    var list=obj.data;
                    orderoutdetailPageView(orders_id,list);
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
function SelectOrderOutDetail(orders_id,page){
    if(orders_id !== null){
        $.ajax({
            type:"POST",
            url:"/orders_details/page",
            data:JSON.stringify({
                "others_id":orders_id,
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
                    var list=obj.data;
                    orderoutdetailPageView(orders_id,list);
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
            url:"/orders_details/page",
            data:JSON.stringify({
                "others_id":orders_id,
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
                    var list=obj.data;
                    orderoutdetailPageView(orders_id,list);
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
function orderoutdetailPageView(orders_id,p){
    $("#orderoutdetailPage").empty()
    console.log(p.currentPage)

    $("#orderoutdetailPage").append("<li> <a onclick='SelectOrderOutDetail("+orders_id+","+(Number(p.currentPage)-1)+")' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>")
    for (let i = 1; i <= p.totalPage; i++){
        if (p.currentPage ===i)
            $("#orderoutdetailPage").append("<li class='active'><a onclick='SelectOrderOutDetail("+orders_id+","+i+")'>" + i +"</a><li/>");
        else
            $("#orderoutdetailPage").append("<li ><a onclick='SelectOrderOutDetail("+orders_id+","+i+")'>" + i +"</a><li/>");
    }
    $("#orderoutdetailPage").append("<li> <a onclick='SelectOrderOutDetail("+orders_id+","+(Number(p.currentPage)+1)+")' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>")

    orderoutdetailView(p.list)
}
//显示出库明细
function orderoutdetailView(list){
    $("#orderoutdetaillists").empty();
    $.each(list,function (i,orderdetail){
        $("#orderoutdetaillists").append("<tr><td>" + orderdetail.id +
            "</td><td>" + orderdetail.amount +
            "</td><td>" + orderdetail.goods_details_id +
            "</td><td>" + orderdetail.orders_id +
            "</td><td>" + "<a onclick='orderoutdetailDelete(" + orderdetail.id+","+orderdetail.orders_id +")'>" +
            "<button class='btn btn-danger btn-sm'>删除</button></a>" +
            "<a onclick='orderoutdetailEditModel(" + orderdetail.id+","+orderdetail.orders_id +")' data-toggle='modal' data-target='#updateOrderoutdetailModel'>" +
            "<button class='btn btn-warning btn-sm'>修改</button></a>" +
            "</td><tr>");
    })
}

//出库明细删除
function orderoutdetailDelete(id,orders_id){
    var flag = confirm("是否确认删除？");
    if(flag) {
        $.ajax({
            type: "DELETE",
            url: "/orders_details/" + id,
            success: function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20021) {
                    alert("删除成功");
                    // $('#saveUserModel').modal('hide');
                    SelectOrderOutDetail(orders_id);
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

//出库明细修改
function orderoutdetailEditModel(id){
    $.ajax({
        type:"PATCH",
        url:"/orders_details/"+id,
        success:function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            var orders = obj.data;
            if(obj.code === 20041) {
                //数据渲染到模态框
                $("#Orderoutdacountupdate").val(orders.amount);
                $("#updateordersdidout").val(orders.id);
                $("#updateorderdidout").val(orders.orders_id);
            }
        }
    })
}
function orderoutdetailEdit(){
    const amount = $("#Orderoutdacountupdate").val();
    const id = $("#updateordersdidout").val();
    const orderid = $("#updateorderdidout").val();
    $.ajax({
        type: "PUT",
        url: "/orders_details/out",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        data: JSON.stringify({
            "id": id,
            "amount": amount,
        }),
        dataType: "json",
        async: false,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20011) {
                alert("修改成功");
                SelectOrderOutDetail(orderid);
            } else {
                alert("修改失败");
            }
        },
        error: function () {
            alert("系统繁忙，请重试！！！");
        }
    })
}



//出库明细增加
function orderoutdetailAdd(){
    var ordersid = $("#Selectordersdoutadd").val();
    var goodsdetail = $("#Selectgoodsorderoutadd").val();
    var amount = $("#Orderoutdacountsave").val();
    if (amount === "" || goodsdetail === "" || ordersid === ""){
        alert("不能为空")
    }else {
        $.ajax({
            type:"POST",
            url:"/orders_details/out",
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            data:JSON.stringify({
                "amount": amount,
                "goods_details_id": goodsdetail,
                "orders_id": ordersid
            }),
            dataType:"json",
            async: false,
            success:function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20011) {
                    alert("增加成功");
                    // $('#saveUserModel').modal('hide');
                    SelectOrderOutDetail(ordersid);
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
//出库查询货品明细编号
function SelectgoodsOrderoutadd(){
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
                $("#Selectgoodsorderoutadd").empty();
                $.each(obj.data,function (i,goods){
                    $("#Selectgoodsorderoutadd").append("<option value='" + goods.id + "'>"+ goods.id+"</option>");
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
//出库查询出库单号
function SelectOrderidoutadd(){
    $.ajax({
        type:"GET",
        url:"/orders/out",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType:"json",
        async: false,
        success:function (result){
            var obj = typeof result=='string'?JSON.parse(result):result;
            if(obj.code === 20041){
                console.log(obj.data);
                $("#Selectordersdoutadd").empty();
                $.each(obj.data,function (i,goods){
                    $("#Selectordersdoutadd").append("<option value='" + goods.id + "'>"+ goods.id+"</option>");
                });
                SelectgoodsOrderoutadd();
            }else {
                alert(obj.msg);
            }
        },
        error:function(){
            alert("系统繁忙，请重试！！！");
        }
    });
}

//入库明细管理
//跳转入库明细
function toorderindetail(id){
    $("#orderindetail").click();
    SelectOrderInDetail(id);
}

//获取入库明细列表
function SelectOrderInDetail(orders_id){
    $.ajax({
            type:"POST",
            url:"/orders_details/page",
        data:JSON.stringify({
            "others_id":orders_id,
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
                    var list=obj.data;
                    orderindetailPageView(orders_id,list);
                }else {
                    alert(obj.msg);
                }
            },
            error:function(){
                alert("系统繁忙，请重试！！！");
            }
        });
}
function SelectOrderInDetail(orders_id,page){
    $.ajax({
        type:"POST",
        url:"/orders_details/page",
        data:JSON.stringify({
            "others_id":orders_id,
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
                var list=obj.data;
                orderindetailPageView(orders_id,list);
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
function orderindetailPageView(orders_id,p){
    $("#orderindetailPage").empty()
    console.log(p.currentPage)

    $("#orderindetailPage").append("<li> <a onclick='SelectOrderInDetail("+orders_id+","+(Number(p.currentPage)-1)+")' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>")
    for (let i = 1; i <= p.totalPage; i++){
        if (p.currentPage ===i)
            $("#orderindetailPage").append("<li class='active'><a onclick='SelectOrderInDetail("+orders_id+","+i+")'>" + i +"</a><li/>");
        else
            $("#orderindetailPage").append("<li ><a onclick='SelectOrderInDetail("+orders_id+","+i+")'>" + i +"</a><li/>");
    }
    $("#orderindetailPage").append("<li> <a onclick='SelectOrderInDetail("+orders_id+","+(Number(p.currentPage)+1)+")' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>")

    orderindetailView(p.list)
}
//显示入库明细
function orderindetailView(list){
    $("#orderindetaillists").empty();
    $.each(list,function (i,orderdetail){
        $("#orderindetaillists").append("<tr><td>" + orderdetail.id +
            "</td><td>" + orderdetail.amount +
            "</td><td>" + orderdetail.goods_details_id +
            "</td><td>" + orderdetail.orders_id +
            "</td><td>" + "<a onclick='orderindetailDelete(" + orderdetail.id+","+orderdetail.orders_id +")'>" +
            "<button class='btn btn-danger btn-sm'>删除</button></a>" +
            "<a onclick='orderindetailEditModel(" + orderdetail.id+","+orderdetail.orders_id +")' data-toggle='modal' data-target='#updateOrderindetailModel'>" +
            "<button class='btn btn-warning btn-sm'>修改</button></a>" +
            "</td><tr>");
    })
}

//入库明细删除
function orderindetailDelete(id){
    var flag = confirm("是否确认删除？");
    if(flag) {
        $.ajax({
            type: "DELETE",
            url: "/orders_details/" + id,
            success: function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20021) {
                    alert("删除成功");
                    // $('#saveUserModel').modal('hide');
                    SelectOrderInDetail(id);
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

//入库明细增加
function orderindetailAdd(){
    var ordersid = $("#Selectordersdinadd").val();
    var goodsdetail = $("#Selectgoodsorderinadd").val();
    var amount = $("#Orderindacountsave").val();
    if (amount === "" || goodsdetail === "" || ordersid === ""){
        alert("不能为空")
    }else {
        $.ajax({
            type:"POST",
            url:"/orders_details/in",
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            data:JSON.stringify({
                "amount": amount,
                "goods_details_id": goodsdetail,
                "orders_id": ordersid
            }),
            dataType:"json",
            async: false,
            success:function (result) {
                var obj = typeof result == 'string' ? JSON.parse(result) : result;
                if (obj.code === 20011) {
                    alert("增加成功");
                    // $('#saveUserModel').modal('hide');
                    SelectOrderInDetail(ordersid);
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
//入库查询货品明细编号
function SelectgoodsOrderinadd(){
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
                $("#Selectgoodsorderinadd").empty();
                $.each(obj.data,function (i,goods){
                    $("#Selectgoodsorderinadd").append("<option value='" + goods.id + "'>"+ goods.id+"</option>");
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
//入库查询入库单号
function SelectOrderidinadd(){
    $.ajax({
        type:"GET",
        url:"/orders/in",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        dataType:"json",
        async: false,
        success:function (result){
            var obj = typeof result=='string'?JSON.parse(result):result;
            if(obj.code === 20041){
                console.log(obj.data);
                $("#Selectordersdinadd").empty();
                $.each(obj.data,function (i,goods){
                    $("#Selectordersdinadd").append("<option value='" + goods.id + "'>"+ goods.id+"</option>");
                });
                SelectgoodsOrderinadd();
            }else {
                alert(obj.msg);
            }
        },
        error:function(){
            alert("系统繁忙，请重试！！！");
        }
    });
}

//入库明细修改
function orderindetailEditModel(id){
    $.ajax({
        type:"PATCH",
        url:"/orders_details/"+id,
        success:function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            var orders = obj.data;
            if(obj.code === 20041) {
                //数据渲染到模态框
                console.log(orders.amount);
                $("#Orderindacountupdate").val(orders.amount);
                $("#updateordersdidin").val(orders.id);
                $("#updateorderdidin").val(orders.orders_id);
            }
        }
    })
}
function orderindetailEdit(){
    const amount = $("#Orderindacountupdate").val();
    const id = $("#updateordersdidin").val();
    const orderid = $("#updateorderdidin").val();
    $.ajax({
        type: "PUT",
        url: "/orders_details/in",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
        data: JSON.stringify({
            "id": id,
            "amount": amount,
        }),
        dataType: "json",
        async: false,
        success: function (result) {
            var obj = typeof result == 'string' ? JSON.parse(result) : result;
            if (obj.code === 20011) {
                alert("修改成功");
                SelectOrderInDetail(orderid);
            } else {
                alert("修改失败");
            }
        },
        error: function () {
            alert("系统繁忙，请重试！！！");
        }
    })
}
