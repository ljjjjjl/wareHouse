<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!--页面中心内容-->
<div class="col-md-10">
    <div class="page-header" style="margin-top: -20px;">
        <h1>系统管理界面</h1>
    </div>
    <div>
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#repositorylist" aria-controls="repository" role="tab" data-toggle="tab" id="repository" onclick="SelectRepositorylists()">仓库列表</a></li>
            <li role="presentation" ><a href="#userlist" aria-controls="user" role="tab" data-toggle="tab" id="user" onclick="SelectUserlist()">用户列表</a></li>
            <li role="presentation"><a href="#goodslist" aria-controls="goods" role="tab" data-toggle="tab" id="goods" onclick="SelectGoodslist()">货号列表</a></li>
            <li role="presentation" style="display: none" ><a href="#goodsdetaillist" aria-controls="goodsdetail" role="tab" data-toggle="tab" id="goodsdetail">货品明细列表</a></li>
            <li role="presentation" style="display: none" ><a href="#warehousedetaillist" aria-controls="warehousedetail" role="tab" data-toggle="tab" id="warehousedetail">仓库明细列表</a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="repositorylist">
                <a data-toggle="modal" data-target="#saveRepositoryModel">
                    <button class="btn btn-success btn-sm" id="saveRepository">增加仓库信息</button>
                </a>
                <%--                    <a style="margin-left: 560px;">--%>
                <%--                        <label for="repositoryquery"></label><input id="repositoryquery" type="search" placeholder="请输入查询信息" style="height: 29px"/>--%>
                <%--                        <button class="btn btn-info btn-sm">查询</button>--%>
                <%--                    </a>--%>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>仓库编号</th>
                        <th>仓库名</th>
                        <%--                            <th>操作</th>--%>
                    </tr>
                    </thead>
                    <tbody id="repositorylists">

                    </tbody>
                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" id="warehousePage">
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
                    <button class="btn btn-info btn-sm" onclick="userSearch()">查询</button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr><th>编号</th><th>账户名</th><th>用户名</th><th>操作</th></tr>
                    </thead>
                    <tbody id="userlists">

                    </tbody>
                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" id="userPage">
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
                    <button class="btn btn-info btn-sm" onclick="goodsSearch()">查询</button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr><th>编号</th><th>货物编号</th><th>货物名称</th><th>操作</th></tr>
                    </thead>
                    <tbody id="goodslists">

                    </tbody>
                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" id="goodsPage">
                        </ul>
                    </nav>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="goodsdetaillist">
                <a data-toggle="modal" data-target="#saveGoodsDetailModel">
                    <button class="btn btn-success btn-sm" onclick="Selectgoodsname()">增加货号明细信息</button>
                </a>
                <a style="margin-left: 700px;">
                    <button class="btn btn-info btn-sm" onclick="SelectGoodsDetail(null)">显示全部</button>
                </a>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr><th>编号</th><th>货物颜色</th><th>货物尺码</th><th>操作</th></tr>
                    </thead>
                    <tbody id="goodsdetaillists">

                    </tbody>
                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" id="goodsDetailsPage">
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
            <div role="tabpanel" class="tab-pane" id="warehousedetaillist">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr><th>编号</th><th>仓库名</th><th>货品名</th><th>货品明细</th><th>货品数量</th></tr>
                    </thead>
                    <tbody id="warehousedetaillists">

                    </tbody>
                </table>
                <div style="margin-left: 400px">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" id="warehouseDetailsPage">
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
                        <button type="button" class="btn btn-primary" onclick="RepositoryAdd()">确认提交</button>
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
                <form id="addUserForm">
                    <div class="form-group">
                        <label for="useridadd">新增账户</label>
                        <input type="text" class="form-control" name="user_id" id="useridadd" placeholder="账户名">
                    </div>
                    <div class="form-group">
                        <label for="usernameadd">新增用户名</label>
                        <input type="text" class="form-control" name="user_name" id="usernameadd" placeholder="用户名">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" onclick="userAdd()" class="btn btn-primary">确认提交</button>
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
                <h4 class="modal-title">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" class="form-control" name="updateid" id="updateid">
                    <div class="form-group">
                        <label for="updateUserid">修改账户名</label>
                        <input type="text" class="form-control" name="updateUserid" id="updateUserid" placeholder="账户名">
                    </div>
                    <div class="form-group">
                        <label for="updateUserName">修改用户名</label>
                        <input type="text" class="form-control" name="updateUserName" id="updateUserName" placeholder="用户名">
                    </div>
                    <div class="form-group">
                        <label for="updateUserPassword">修改密码</label>
                        <input type="text" class="form-control" name="updateUserPassword" id="updateUserPassword" placeholder="密码">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
                        <button type="button" class="btn btn-primary" onclick="userEdit()">确认提交</button>
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
                    <%--                    <div class="form-group">--%>
                    <%--                        <label for="saveGoodsNo">新增货物编号</label>--%>
                    <%--                        <input type="text" class="form-control" id="saveGoodsNo" name="saveGoodsNo" placeholder="货物编号">--%>
                    <%--                    </div>--%>
                    <div class="form-group">
                        <label for="saveGoodsName">新增货物名称</label>
                        <input type="text" class="form-control" id="saveGoodsName" name="saveGoodsName" placeholder="货物名">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary" onclick="goodsAdd()">确认提交</button>
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
                    <input type="hidden" class="form-control" name="updategoodsid" id="updategoodsid">
                    <%--                    <div class="form-group">--%>
                    <%--                        <label for="UpdateGoodsNo">修改货物编号</label>--%>
                    <%--                        <input type="text" class="form-control" id="UpdateGoodsNo" name="UpdateGoodsNo" placeholder="货物编号">--%>
                    <%--                    </div>--%>
                    <div class="form-group">
                        <label for="UpdateGoodsName">修改货物名称</label>
                        <input type="text" class="form-control" id="UpdateGoodsName" name="UpdateGoodsName" placeholder="货物名">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消新增</button>
                        <button type="button" class="btn btn-primary" onclick="goodsEdit()">确认提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--新增货物明细--%>
<div class="modal fade" id="saveGoodsDetailModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加货物明细信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" class="form-control" name="addgoodsid" id="addgoodsid"/>
                    <div class="form-group">
                        <label for="SelectGoodsName">选择货品名称</label>
                        <select id="SelectGoodsName" class="form-control">
                        </select>
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
                        <button type="button" class="btn btn-primary" onclick="goodsdetailAdd()">确认提交</button>
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
                    <input type="hidden" class="form-control" name="updategoodsdetailid" id="updategoodsdetailid"/>
                    <input type="hidden" class="form-control" name="updategoodssid" id="updategoodssid"/>
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
                        <button type="button" class="btn btn-primary" onclick="goodsdetailEdit()">确认修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

