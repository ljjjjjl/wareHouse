<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="col-md-10">
    <div class="page-header" style="margin-top: -20px;">
        <h1>库存管理界面</h1>
    </div>
    <div>
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#orderoutlist" onclick="SelectOrderOut()" aria-controls="orderout" role="tab" data-toggle="tab" id="orderout">出库列表</a></li>
            <li role="presentation"><a href="#orderinlist" onclick="SelectOrderIn()" aria-controls="orderin" role="tab" data-toggle="tab" id="orderin">入库列表</a></li>
            <li role="presentation" style="display:none;"><a href="#orderoutdetaillist" aria-controls="orderoutdetail" role="tab" data-toggle="tab" id="orderoutdetail">出库明细列表</a></li>
            <li role="presentation" style="display:none;"><a href="#orderindetaillist" aria-controls="orderindetail" role="tab" data-toggle="tab" id="orderindetail">出库明细列表</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="orderoutlist">
                <a data-toggle="modal" data-target="#saveOrderoutModel">
                    <button class="btn btn-success btn-sm" id="saveOrderout" onclick="SelectwarenameoutA()">增加出库信息</button>
                </a>
                <a style="margin-left: 560px">
                    <label for="startOrderout"></label><input id="startOrderout" type="date" placeholder="请输入开始时间" style="height: 29px"/>
                    <span class="glyphicon glyphicon-minus"></span>
                    <label for="overOrderout"></label><input id="overOrderout" type="date" placeholder="请输入结束时间" style="height: 29px"/>
                    <button class="btn btn-info btn-sm" onclick="OrderoutSearch()"><span class="glyphicon glyphicon-search">查询</span></button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>单据编号</th>
                        <th>地址</th>
                        <th>创建时间</th>
                        <th>货单备注</th>
                        <th>仓库编号</th>
                        <th>经办人</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="orderoutlists">

                    </tbody>
                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" id="orderoutPage">
                            <%--                            <li>--%>
                            <%--                                <a href="#" aria-label="Previous">--%>
                            <%--                                    <span aria-hidden="true">&laquo;</span>--%>
                            <%--                                </a>--%>
                            <%--                            </li>--%>
                            <%--                            <li class="active"><a href="#">1</a></li>--%>
                            <%--                            <li><a href="#">2</a></li>--%>
                            <%--                            <li><a href="#">3</a></li>--%>
                            <%--                            <li><a href="#">4</a></li>--%>
                            <%--                            <li><a href="#">5</a></li>--%>
                            <%--                            <li>--%>
                            <%--                                <a href="#" aria-label="Next">--%>
                            <%--                                    <span aria-hidden="true">&raquo;</span>--%>
                            <%--                                </a>--%>
                            <%--                            </li>--%>
                    </nav>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="orderinlist">
                <a data-toggle="modal" data-target="#saveOrderinModel">
                    <button class="btn btn-success btn-sm" id="saveOrderin" onclick="SelectwarenameinA()">增加入库信息</button>
                </a>
                <a style="margin-left: 560px;">
                    <label for="startOrderin"></label><input id="startOrderin" type="date" placeholder="请输入开始时间" style="height: 29px"/>
                    <span class="glyphicon glyphicon-minus"></span>
                    <label for="overOrderin"></label><input id="overOrderin" type="date" placeholder="请输入结束时间" style="height: 29px"/>
                    <button class="btn btn-info btn-sm" onclick="OrderinSearch()"><span class="glyphicon glyphicon-search">查询</span></button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>单据编号</th>
                        <th>地址</th>
                        <th>创建时间</th>
                        <th>货单备注</th>
                        <th>仓库编号</th>
                        <th>经办人</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="orderinlists">

                    </tbody>
                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" id="orderinPage">
                            <%--                            <li>--%>
                            <%--                                <a href="#" aria-label="Previous">--%>
                            <%--                                    <span aria-hidden="true">&laquo;</span>--%>
                            <%--                                </a>--%>
                            <%--                            </li>--%>
                            <%--                            <li class="active"><a href="#">1</a></li>--%>
                            <%--                            <li><a href="#">2</a></li>--%>
                            <%--                            <li><a href="#">3</a></li>--%>
                            <%--                            <li><a href="#">4</a></li>--%>
                            <%--                            <li><a href="#">5</a></li>--%>
                            <%--                            <li>--%>
                            <%--                                <a href="#" aria-label="Next">--%>
                            <%--                                    <span aria-hidden="true">&raquo;</span>--%>
                            <%--                                </a>--%>
                            <%--                            </li>--%>
                        </ul>
                    </nav>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="orderoutdetaillist">
                <a data-toggle="modal" data-target="#saveOrderoutdetailModel">
                    <button class="btn btn-success btn-sm" onclick="SelectOrderidoutadd()">增加出库明细信息</button>
                </a>
                <a style="margin-left: 560px;">
                    <button class="btn btn-info btn-sm" onclick="SelectOrderOutDetail(null)">显示全部</button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>出库单编号</th>
                        <th>仓库名</th>
                        <th>货物名</th>
                        <th>货物明细</th>
                        <th>货物数量</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="orderoutdetaillists">

                    </tbody>
                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" id="orderoutdetailPage">
                            <%--                            <li>--%>
                            <%--                                <a href="#" aria-label="Previous">--%>
                            <%--                                    <span aria-hidden="true">&laquo;</span>--%>
                            <%--                                </a>--%>
                            <%--                            </li>--%>
                            <%--                            <li class="active"><a href="#">1</a></li>--%>
                            <%--                            <li><a href="#">2</a></li>--%>
                            <%--                            <li><a href="#">3</a></li>--%>
                            <%--                            <li><a href="#">4</a></li>--%>
                            <%--                            <li><a href="#">5</a></li>--%>
                            <%--                            <li>--%>
                            <%--                                <a href="#" aria-label="Next">--%>
                            <%--                                    <span aria-hidden="true">&raquo;</span>--%>
                            <%--                                </a>--%>
                            <%--                            </li>--%>
                        </ul>
                    </nav>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="orderindetaillist">
                <a data-toggle="modal" data-target="#saveOrderindetailModel">
                    <button class="btn btn-success btn-sm" onclick="SelectOrderidinadd()">增加入库明细信息</button>
                </a>
                <a style="margin-left: 560px;">
                    <button class="btn btn-info btn-sm" onclick="SelectOrderInDetail(null)">显示全部</button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>入库单编号</th>
                        <th>货物名</th>
                        <th>货物明细</th>
                        <th>货物数量</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="orderindetaillists">

                    </tbody>
                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" id="orderindetailPage">
                            <%--                            <li>--%>
                            <%--                                <a href="#" aria-label="Previous">--%>
                            <%--                                    <span aria-hidden="true">&laquo;</span>--%>
                            <%--                                </a>--%>
                            <%--                            </li>--%>
                            <%--                            <li class="active"><a href="#">1</a></li>--%>
                            <%--                            <li><a href="#">2</a></li>--%>
                            <%--                            <li><a href="#">3</a></li>--%>
                            <%--                            <li><a href="#">4</a></li>--%>
                            <%--                            <li><a href="#">5</a></li>--%>
                            <%--                            <li>--%>
                            <%--                                <a href="#" aria-label="Next">--%>
                            <%--                                    <span aria-hidden="true">&raquo;</span>--%>
                            <%--                                </a>--%>
                            <%--                            </li>--%>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>

<!--模态框-->
<!--新增出库-->
<div class="modal fade" id="saveOrderoutModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加出库信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <%--                    <div class="form-group">--%>
                    <%--                        <label for="Orderoutidadd">新增单据编号</label>--%>
                    <%--                        <input type="text" class="form-control" id="Orderoutidadd" placeholder="单据编号">--%>
                    <%--                    </div>--%>
                    <div class="form-group">
                        <label for="Orderoutaddressadd">新增地址</label>
                        <input type="text" class="form-control" id="Orderoutaddressadd" placeholder="地址">
                    </div>
                    <div class="form-group">
                        <label for="Orderoutnoteadd">新增备注</label>
                        <input type="text" class="form-control" id="Orderoutnoteadd" placeholder="备注">
                    </div>
                    <div class="form-group">
                        <label for="Selectwarhouseadd">选择仓库名称</label>
                        <select id="Selectwarhouseadd" class="form-control">
                        </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary" onclick="OrderOutadd()">确认提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--修改出库-->
<div class="modal fade" id="updateOrderoutModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改出库信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" class="form-control" name="updateordersid" id="updateordersid">
                    <%--                    <div class="form-group">--%>
                    <%--                        <label for="Orderoutidupdate">修改单据编号</label>--%>
                    <%--                        <input type="text" class="form-control" id="Orderoutidupdate" placeholder="单据编号">--%>
                    <%--                    </div>--%>
                    <div class="form-group">
                        <label for="Orderoutaddressupdate">修改地址</label>
                        <input type="text" class="form-control" id="Orderoutaddressupdate" placeholder="地址">
                    </div>
                    <div class="form-group">
                        <label for="Orderoutnoteupdate">修改备注</label>
                        <input type="text" class="form-control" id="Orderoutnoteupdate" placeholder="备注">
                    </div>
                    <div class="form-group">
                        <label for="Selectwarhouseup">修改仓库名称</label>
                        <select id="Selectwarhouseup" class="form-control">
                        </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
                        <button type="button" class="btn btn-primary" onclick="OrderoutEdit()">确认提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--新增入库-->
<div class="modal fade" id="saveOrderinModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加入库信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <%--                    <div class="form-group">--%>
                    <%--                        <label for="Orderinidadd">新增单据编号</label>--%>
                    <%--                        <input type="text" class="form-control" id="Orderinidadd" placeholder="单据编号">--%>
                    <%--                    </div>--%>
                    <div class="form-group">
                        <label for="Orderinaddressadd">新增地址</label>
                        <input type="text" class="form-control" id="Orderinaddressadd" placeholder="地址">
                    </div>
                    <div class="form-group">
                        <label for="Orderinnoteadd">新增备注</label>
                        <input type="text" class="form-control" id="Orderinnoteadd" placeholder="备注">
                    </div>
                    <div class="form-group">
                        <label for="Selectwarhouseaddin">选择仓库名称</label>
                        <select id="Selectwarhouseaddin" class="form-control">
                        </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary" onclick="OrderinAdd()">确认提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--修改入库-->
<div class="modal fade" id="updateOrderinModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改入库信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" class="form-control" name="updateordersidin" id="updateordersidin">
                    <%--                    <div class="form-group">--%>
                    <%--                        <label for="Orderinidupdate">修改单据编号</label>--%>
                    <%--                        <input type="text" class="form-control" id="Orderinidupdate" placeholder="单据编号">--%>
                    <%--                    </div>--%>
                    <div class="form-group">
                        <label for="Orderinaddressupdate">修改地址</label>
                        <input type="text" class="form-control" id="Orderinaddressupdate" placeholder="地址">
                    </div>
                    <div class="form-group">
                        <label for="Orderinnoteupdate">修改备注</label>
                        <input type="text" class="form-control" id="Orderinnoteupdate" placeholder="备注">
                    </div>
                    <div class="form-group">
                        <label for="Selectwarhouseupin">修改仓库名称</label>
                        <select id="Selectwarhouseupin" class="form-control">
                        </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
                        <button type="button" class="btn btn-primary" onclick="OrderinEdit()">确认提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--新增出库明细-->
<div class="modal fade" id="saveOrderoutdetailModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加出库明细信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="Selectordersdoutadd">选择出库单编号</label>
                        <select id="Selectordersdoutadd" class="form-control">
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="Selectgoodsorderoutadd">选择货物明细编号</label>
                        <select id="Selectgoodsorderoutadd" class="form-control">
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="Orderoutdacountsave">新增货物数量</label>
                        <input type="text" class="form-control" id="Orderoutdacountsave" placeholder="货物数量">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary" onclick="orderoutdetailAdd()">确认提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--修改出库明细-->
<div class="modal fade" id="updateOrderoutdetailModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改出库明细信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" class="form-control" name="updateordersdidout" id="updateordersdidout">
                    <input type="hidden" class="form-control" name="updateordersidout" id="updateorderdidout">
                    <%--                    <div class="form-group">--%>
                    <%--                        <label for="Selectordersdoutup">选择出库单编号</label>--%>
                    <%--                        <select id="Selectordersdoutup" class="form-control">--%>
                    <%--                        </select>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="form-group">--%>
                    <%--                        <label for="Selectgoodsorderoutup">选择货物明细编号</label>--%>
                    <%--                        <select id="Selectgoodsorderoutup" class="form-control">--%>
                    <%--                        </select>--%>
                    <%--                    </div>--%>
                    <div class="form-group">
                        <label for="Orderoutdacountupdate">修改货物数量</label>
                        <input type="text" class="form-control" id="Orderoutdacountupdate" placeholder="货物数量">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
                        <button type="button" class="btn btn-primary" onclick="orderoutdetailEdit()">确认修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--新增入库明细-->
<div class="modal fade" id="saveOrderindetailModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加入库明细信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="Selectordersdinadd">选择入库单编号</label>
                        <select id="Selectordersdinadd" class="form-control">
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="Selectgoodsorderinadd">选择货物明细编号</label>
                        <select id="Selectgoodsorderinadd" class="form-control">
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="Orderindacountsave">新增货物数量</label>
                        <input type="text" class="form-control" id="Orderindacountsave" placeholder="货物数量">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary" onclick="orderindetailAdd()">确认提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--修改入库明细-->
<div class="modal fade" id="updateOrderindetailModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改入库明细信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" class="form-control" name="updateordersdidin" id="updateordersdidin">
                    <input type="hidden" class="form-control" name="updateorderdidin" id="updateorderdidin">
                    <div class="form-group">
                        <label for="Orderindacountupdate">修改货物数量</label>
                        <input type="text" class="form-control" id="Orderindacountupdate" placeholder="货物数量">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
                        <button type="button" class="btn btn-primary" onclick="orderindetailEdit()">确认修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
