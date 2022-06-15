<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset=utf-8">
    <title>主页</title>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/js/index.js"></script>
<%--    <script type="text/javascript"  src="${pageContext.request.contextPath}/js/user.js"></script>--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/boot/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/boot/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">服装后台管理系统<span class="badge">V1.0</span></a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a>欢迎: <span class="text-danger text-center" id="usernameshow">${loginUser.user_name}</span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户中心 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a onclick="Password()">修改密码</a></li>
                        <li><a href="login.jsp">登录</a></li>
                        <li><a onclick="Logout()">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="row" >
    <div class="col-md-2">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="Systemheading">
                    <h4 class="panel-title">
                        <a onclick="System()" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#Systemcollapse" aria-expanded="true" aria-controls="Systemcollapse">
                            <span class="glyphicon glyphicon-tasks"></span>系统管理
                        </a>
                    </h4>
                </div>
                <div id="Systemcollapse" class="panel-collapse collapse" role="tabpanel" aria-labelledby="Systemheading">
                    <div class="panel-body">
                        <ul class="list-group">
                            <li class="list-group-item"><a>仓库管理</a></li>
                            <li class="list-group-item"><a>用户管理</a></li>
                            <li class="list-group-item"><a>货号管理</a></li>
                            <li class="list-group-item"><a>货号明细管理</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="Stockheading">
                    <h4 class="panel-title">
                        <a onclick="Stock()" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#Stockcollapse" aria-expanded="false" aria-controls="Stockcollapse">
                            <span class="glyphicon glyphicon-folder-close"></span>库存管理
                        </a>
                    </h4>
                </div>
                <div id="Stockcollapse" class="panel-collapse collapse" role="tabpanel" aria-labelledby="Stockheading">
                    <div class="panel-body">
                        <ul class="list-group">
                            <li class="list-group-item"><a>入库管理</a></li>
                            <li class="list-group-item"><a>出库管理</a></li>
                            <li class="list-group-item"><a>入库明细管理</a></li>
                            <li class="list-group-item"><a>出库明细管理</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="Permissionheading">
                    <h4 class="panel-title">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#permissioncollapse" aria-expanded="false" aria-controls="permissioncollapse">
                            <span class="glyphicon glyphicon-blackboard"></span>权限管理
                        </a>
                    </h4>
                </div>
                <div id="permissioncollapse" class="panel-collapse collapse" role="tabpanel" aria-labelledby="permissionheading">
                    <div class="panel-body">
                        <ul class="list-group">
                            <li class="list-group-item"><a>权限查询</a></li>
                            <li class="list-group-item"><a>权限管理</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="content">
        <div class="col-md-10">
            <div class="jumbotron text-center" style="background-color: #2e6da4;width: 1200px;height: 500px;">
                <h1>欢迎进入服装后台管理界面</h1>
                <p>本系统为厂商管理人员设计</p>
                <p><a class="btn btn-primary btn-lg " href="https://github.com/" target="_blank" role="button">了解更多</a></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>