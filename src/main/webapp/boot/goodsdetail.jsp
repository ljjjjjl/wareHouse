<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset=utf-8">
    <title>货单明细管理</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/boot/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/boot/js/bootstrap.min.js"></script>

</head>
<body>
<!--页面中心内容-->
<div class="col-md-10">
    <div class="page-header" style="margin-top: -20px;">
        <h1>系统管理界面</h1>
    </div>
    <div>
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#goodsdetaillist" aria-controls="goodsdetails" role="tab" data-toggle="tab" id="goodsdetails">货号明细列表</a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane" id="goodsdetaillist">
                <a data-toggle="modal" data-target="#saveGoodsDetailModel">
                    <button class="btn btn-success btn-sm">增加货号明细信息</button>
                </a>
                <a style="margin-left: 560px;">
                    <label for="goodsdetailquery"></label><input id="goodsdetailquery" type="search" placeholder="请输入查询信息" style="height: 29px"/>
                    <button class="btn btn-info btn-sm">查询</button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <tr>
                        <th>编号</th>
                        <th>货物名称</th>
                        <th>颜色</th>
                        <th>尺码</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>13</td>
                        <td>1</td>
                        <td>13</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a data-toggle="modal" data-target="#updateGoodsDetailModel"><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>12</td>
                        <td>1</td>
                        <td>12</td>
                        <td>
                            <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                            <a href=""><button class="btn btn-warning btn-sm">修改</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>11</td>
                        <td>1</td>
                        <td>11</td>
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
<!--新增货号明细-->
<div class="modal fade" id="saveGoodsDetailModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加货物明细信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="saveGoodsDetailname">货物名称</label>
                        <input type="text" class="form-control" id="saveGoodsDetailname" placeholder="货物名称">
                    </div>
                    <div class="form-group">
                        <label for="saveGoodsDetailColor">新增货物颜色</label>
                        <input type="text" class="form-control" id="saveGoodsDetailColor" placeholder="货物颜色">
                    </div>
                    <div class="form-group">
                        <label for="saveGoodsDetailSize">新增货物尺码</label>
                        <input type="text" class="form-control" id="saveGoodsDetailSize" placeholder="货物尺码">
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
<!--修改货号明细-->
<div class="modal fade" id="updateGoodsDetailModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改货号明细信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="UpdateGoodsDetailname">修改货物名称</label>
                        <input type="text" class="form-control" id="UpdateGoodsDetailname" placeholder="货物名称">
                    </div>
                    <div class="form-group">
                        <label for="UpdateGoodsDetailColor">修改货物颜色</label>
                        <input type="text" class="form-control" id="UpdateGoodsDetailColor" placeholder="货物颜色">
                    </div>
                    <div class="form-group">
                        <label for="UpdateGoodsDetailSize">修改货物尺码</label>
                        <input type="text" class="form-control" id="UpdateGoodsDetailSize" placeholder="货物尺码">
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
</body>
</html>
