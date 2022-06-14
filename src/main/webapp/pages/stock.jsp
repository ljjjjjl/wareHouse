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
            <li role="presentation" class="active"><a href="#orderoutlist" aria-controls="orderout" role="tab" data-toggle="tab" id="orderout">出库列表</a></li>
            <li role="presentation"><a href="#orderinlist" aria-controls="orderin" role="tab" data-toggle="tab" id="orderin">入库列表</a></li>
            <li role="presentation"><a href="#orderoutdetaillist" aria-controls="orderoutdetail" role="tab" data-toggle="tab" id="orderoutdetail">出库明细列表</a></li>
            <li role="presentation"><a href="#orderindetaillist" aria-controls="orderindetail" role="tab" data-toggle="tab" id="orderindetail">出库明细列表</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="orderoutlist">
                <a data-toggle="modal" data-target="#saveOrderoutModel">
                    <button class="btn btn-success btn-sm" id="saveOrderout">增加出库信息</button>
                </a>
                <a style="margin-left: 560px;">
                    <label for="inqueryOrderout"></label><input id="inqueryOrderout" type="search" placeholder="请输入查询信息" style="height: 29px"/>
                    <button class="btn btn-info btn-sm">查询</button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <tr>
                        <th>编号</th>
                        <th>单据编号</th>
                        <th>地址</th>
                        <th>货单创建时间</th>
                        <th>货单备注</th>
                        <th>所在仓库编号</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>1515</td>
                        <td>无</td>
                        <td>20220104</td>
                        <td>无</td>
                        <td>1</td>
                        <td>
                            <a id="deleteOrderout"><button class="btn btn-danger btn-sm">删除</button></a>
                            <a data-toggle="modal" data-target="#updateOrderoutModel"><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>1515</td>
                        <td>无</td>
                        <td>20220104</td>
                        <td>无</td>
                        <td>1</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a href=""><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>1515</td>
                        <td>无</td>
                        <td>20220104</td>
                        <td>无</td>
                        <td>1</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a href=""><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>

                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li class="disabled">
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="orderinlist">
                <a data-toggle="modal" data-target="#saveOrderinModel">
                    <button class="btn btn-success btn-sm" id="saveOrderin">增加入库信息</button>
                </a>
                <a style="margin-left: 560px;">
                    <label for="queryorderin"></label><input id="queryorderin" type="search" placeholder="请输入查询信息" style="height: 29px"/>
                    <button class="btn btn-info btn-sm">查询</button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <tr>
                        <th>编号</th>
                        <th>单据编号</th>
                        <th>地址</th>
                        <th>货单创建时间</th>
                        <th>货单备注</th>
                        <th>所在仓库编号</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>1515</td>
                        <td>无</td>
                        <td>20220104</td>
                        <td>无</td>
                        <td>1</td>
                        <td>
                            <a id="deleteUser"><button class="btn btn-danger btn-sm">删除</button></a>
                            <a data-toggle="modal" data-target="#updateOrderinModel"><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>1515</td>
                        <td>无</td>
                        <td>20220104</td>
                        <td>无</td>
                        <td>1</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a href=""><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>1515</td>
                        <td>20220104</td>
                        <td>无</td>
                        <td>1</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a href=""><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>

                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="orderoutdetaillist">
                <a data-toggle="modal" data-target="#saveOrderoutdetailModel">
                    <button class="btn btn-success btn-sm">增加出库明细信息</button>
                </a>
                <a style="margin-left: 560px;">
                    <label for="queryorderoutdetail"></label><input id="queryorderoutdetail" type="search" placeholder="请输入查询信息" style="height: 29px"/>
                    <button class="btn btn-info btn-sm">查询</button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <tr>
                        <th>编号</th>
                        <th>货物数量</th>
                        <th>货物名称</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>q100</td>
                        <td>羽绒服</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a data-toggle="modal" data-target="#updateOrderoutdetailModel"><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>x100</td>
                        <td>T恤</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a href=""><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>q102</td>
                        <td>长裤</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a href=""><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="orderindetaillist">
                <a data-toggle="modal" data-target="#saveOrderindetailModel">
                    <button class="btn btn-success btn-sm">增加入库明细信息</button>
                </a>
                <a style="margin-left: 560px;">
                    <label for="queryorderindetail"></label><input id="queryorderindetail" type="search" placeholder="请输入查询信息" style="height: 29px"/>
                    <button class="btn btn-info btn-sm">查询</button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <tr>
                        <th>编号</th>
                        <th>货物数量</th>
                        <th>货物名称</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>q100</td>
                        <td>羽绒服</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a data-toggle="modal" data-target="#updateOrderindetailModel"><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>q100</td>
                        <td>羽绒服</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a href=""><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>q100</td>
                        <td>羽绒服</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a href=""><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
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
                    <div class="form-group">
                        <label for="Orderoutidadd">新增单据编号</label>
                        <input type="text" class="form-control" id="Orderoutidadd" placeholder="单据编号">
                    </div>
                    <div class="form-group">
                        <label for="Orderoutaddressadd">新增地址</label>
                        <input type="text" class="form-control" id="Orderoutaddressadd" placeholder="地址">
                    </div>
                    <div class="form-group">
                        <label for="Orderoutnoteadd">新增备注</label>
                        <input type="text" class="form-control" id="Orderoutnoteadd" placeholder="备注">
                    </div>
                    <div class="form-group">
                        <label for="Orderoutwarehouseadd">新增仓库</label>
                        <input type="text" class="form-control" id="Orderoutwarehouseadd" placeholder="操作仓库编号">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary">确认提交</button>
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
                <h4 class="modal-title">修改出信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="Orderoutidupdate">修改单据编号</label>
                        <input type="text" class="form-control" id="Orderoutidupdate" placeholder="单据编号">
                    </div>
                    <div class="form-group">
                        <label for="Orderoutaddressupdate">修改地址</label>
                        <input type="text" class="form-control" id="Orderoutaddressupdate" placeholder="地址">
                    </div>
                    <div class="form-group">
                        <label for="Orderoutnoteupdate">修改备注</label>
                        <input type="text" class="form-control" id="Orderoutnoteupdate" placeholder="备注">
                    </div>
                    <div class="form-group">
                        <label for="Orderoutwarehouseupdate">修改仓库</label>
                        <input type="text" class="form-control" id="Orderoutwarehouseupdate" placeholder="操作仓库编号">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
                        <button type="button" class="btn btn-primary">确认提交</button>
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
                    <div class="form-group">
                        <label for="Orderinidadd">新增单据编号</label>
                        <input type="text" class="form-control" id="Orderinidadd" placeholder="单据编号">
                    </div>
                    <div class="form-group">
                        <label for="Orderinaddressadd">新增地址</label>
                        <input type="text" class="form-control" id="Orderinaddressadd" placeholder="地址">
                    </div>
                    <div class="form-group">
                        <label for="Orderinnoteadd">新增备注</label>
                        <input type="text" class="form-control" id="Orderinnoteadd" placeholder="备注">
                    </div>
                    <div class="form-group">
                        <label for="Orderinwarehouseadd">新增仓库</label>
                        <input type="text" class="form-control" id="Orderinwarehouseadd" placeholder="操作仓库编号">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary">确认提交</button>
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
                    <div class="form-group">
                        <label for="Orderinidupdate">修改单据编号</label>
                        <input type="text" class="form-control" id="Orderinidupdate" placeholder="单据编号">
                    </div>
                    <div class="form-group">
                        <label for="Orderinaddressupdate">修改地址</label>
                        <input type="text" class="form-control" id="Orderinaddressupdate" placeholder="地址">
                    </div>
                    <div class="form-group">
                        <label for="Orderinnoteupdate">修改备注</label>
                        <input type="text" class="form-control" id="Orderinnoteupdate" placeholder="备注">
                    </div>
                    <div class="form-group">
                        <label for="Orderinwarehouseupdate">修改仓库</label>
                        <input type="text" class="form-control" id="Orderinwarehouseupdate" placeholder="操作仓库编号">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
                        <button type="button" class="btn btn-primary">确认提交</button>
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
                        <label for="Orderoutdacountsave">新增货物数量</label>
                        <input type="text" class="form-control" id="Orderoutdacountsave" placeholder="货物数量">
                    </div>
                    <div class="form-group">
                        <label for="Orderoutdagoodssave">新增货物名称</label>
                        <input type="text" class="form-control" id="Orderoutdagoodssave" placeholder="货物名">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary">确认提交</button>
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
                    <div class="form-group">
                        <label for="Orderoutdacountupdate">新增货物数量</label>
                        <input type="text" class="form-control" id="Orderoutdacountupdate" placeholder="货物数量">
                    </div>
                    <div class="form-group">
                        <label for="Orderoutdagoodsupdate">新增货物名称</label>
                        <input type="text" class="form-control" id="Orderoutdagoodsupdate" placeholder="货物名">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary">确认提交</button>
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
                        <label for="Orderindacountsave">新增货物数量</label>
                        <input type="text" class="form-control" id="Orderindacountsave" placeholder="货物数量">
                    </div>
                    <div class="form-group">
                        <label for="Orderindagoodssave">新增货物名称</label>
                        <input type="text" class="form-control" id="Orderindagoodssave" placeholder="货物名">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary">确认提交</button>
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
                    <div class="form-group">
                        <label for="Orderindacountupdate">新增货物数量</label>
                        <input type="text" class="form-control" id="Orderindacountupdate" placeholder="货物数量">
                    </div>
                    <div class="form-group">
                        <label for="Orderindagoodsupdate">新增货物名称</label>
                        <input type="text" class="form-control" id="Orderindagoodsupdate" placeholder="货物名">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary">确认提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
