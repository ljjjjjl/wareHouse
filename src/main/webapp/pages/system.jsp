<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="utf-8" language="java" %>
    <!--页面中心内容-->
    <div class="col-md-10">
        <div class="page-header" style="margin-top: -20px;">
            <h1>系统管理界面</h1>
        </div>
        <div>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#repositorylist" aria-controls="repository" role="tab" data-toggle="tab" id="repository">仓库列表</a></li>
                <li role="presentation"><a href="#userlist" aria-controls="user" role="tab" data-toggle="tab" id="user">用户列表</a></li>
                <li role="presentation"><a href="#goodslist" aria-controls="goods" role="tab" data-toggle="tab" id="goods">货号列表</a></li>
                <li role="presentation"><a href="#goodsdetaillist" aria-controls="goods_detail" role="tab" data-toggle="tab" id="goodsdetail">货号明细列表</a></li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="repositorylist">
                    <a data-toggle="modal" data-target="#saveRepositoryModel">
                        <button class="btn btn-success btn-sm" id="saveRepository">增加仓库信息</button>
                    </a>
                    <a style="margin-left: 560px;">
                        <label for="repositoryquery"></label><input id="repositoryquery" type="search" placeholder="请输入查询信息" style="height: 29px"/>
                        <button class="btn btn-info btn-sm">查询</button>
                    </a>
                    <table class="table table-bordered table-striped table-hover">
                        <tr>
                            <th>编号</th>
                            <th>仓库名</th>
                            <th>操作</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>第一仓库</td>
                            <td>
                                <a id="deleteRepository"><button class="btn btn-danger btn-sm">删除</button></a>
                                <a data-toggle="modal" data-target="#updateRepositoryModel"><button class="btn btn-warning btn-sm">修改</button></a>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>第一仓库</td>
                            <td>
                                <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                                <a href=""><button class="btn btn-warning btn-sm">修改</button></a>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>第一仓库</td>
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
                <div role="tabpanel" class="tab-pane" id="userlist">
                    <a data-toggle="modal" data-target="#saveUserModel">
                        <button class="btn btn-success btn-sm" id="saveUser">增加用户信息</button>
                    </a>
                    <a style="margin-left: 560px;">
                        <label for="userquery"></label><input id="userquery" type="search" placeholder="请输入查询信息" style="height: 29px"/>
                        <button class="btn btn-info btn-sm">查询</button>
                    </a>
                    <table class="table table-bordered table-striped table-hover">
                        <tr>
                            <th>编号</th>
                            <th>账户名</th>
                            <th>用户名</th>
                            <th>操作</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>1</td>
                            <td>第一仓库</td>
                            <td>
                                <a id="deleteUser"><button class="btn btn-danger btn-sm">删除</button></a>
                                <a data-toggle="modal" data-target="#updateUserModel"><button class="btn btn-warning btn-sm">修改</button></a>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>1</td>
                            <td>第一仓库</td>
                            <td>
                                <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                                <a href=""><button class="btn btn-warning btn-sm">修改</button></a>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>1</td>
                            <td>第一仓库</td>
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
                <div role="tabpanel" class="tab-pane" id="goodslist">
                    <a data-toggle="modal" data-target="#saveGoodsModel">
                        <button class="btn btn-success btn-sm">增加货号信息</button>
                    </a>
                    <a style="margin-left: 560px;">
                        <label for="goodsquery"></label><input id="goodsquery" type="search" placeholder="请输入查询信息" style="height: 29px"/>
                        <button class="btn btn-info btn-sm">查询</button>
                    </a>
                    <table class="table table-bordered table-striped table-hover">
                        <tr>
                            <th>编号</th>
                            <th>货物编号</th>
                            <th>货物名称</th>
                            <th>操作</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>q100</td>
                            <td>羽绒服</td>
                            <td>
                                <a href=""><button class="btn btn-danger btn-sm">删除</button></a>
                                <a data-toggle="modal" data-target="#updateGoodsModel"><button class="btn btn-warning btn-sm">修改</button></a>
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
<!--新增仓库-->
<div class="modal fade" id="saveRepositoryModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加仓库信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="repositoryadd">新增仓库名</label>
                        <input type="text" class="form-control" id="repositoryadd" placeholder="仓库名">
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
<!--修改仓库-->
<div class="modal fade" id="updateRepositoryModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改仓库信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="updateRepositoryName">修改仓库名</label>
                        <input type="text" class="form-control" id="updateRepositoryName" placeholder="仓库名">
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
<!--新增用户-->
<div class="modal fade" id="saveUserModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加用户信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="useridadd">新增账户</label>
                        <input type="text" class="form-control" id="useridadd" placeholder="账户名">
                    </div>
                    <div class="form-group">
                        <label for="useradd">新增用户名</label>
                        <input type="text" class="form-control" id="useradd" placeholder="用户名">
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
<!--修改用户-->
<div class="modal fade" id="updateUserModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改仓库信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="updateUserName">修改用户名</label>
                        <input type="text" class="form-control" id="updateUserName" placeholder="用户名">
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
<!--新增货号-->
<div class="modal fade" id="saveGoodsModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加货号信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="saveGoodsNo">新增货物编号</label>
                        <input type="text" class="form-control" id="saveGoodsNo" placeholder="货物编号">
                    </div>
                    <div class="form-group">
                        <label for="saveGoodsName">新增货物名称</label>
                        <input type="text" class="form-control" id="saveGoodsName" placeholder="货物名">
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
<!--修改货号-->
<div class="modal fade" id="updateGoodsModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改货号信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="UpdateGoodsNo">修改货物编号</label>
                        <input type="text" class="form-control" id="UpdateGoodsNo" placeholder="货物编号">
                    </div>
                    <div class="form-group">
                        <label for="UpdateGoodsName">修改货物名称</label>
                        <input type="text" class="form-control" id="UpdateGoodsName" placeholder="货物名">
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
