/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-06-14 08:24:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class system_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/user.js\"></script>\r\n");
      out.write("    <!--页面中心内容-->\r\n");
      out.write("    <div class=\"col-md-10\">\r\n");
      out.write("        <div class=\"page-header\" style=\"margin-top: -20px;\">\r\n");
      out.write("            <h1>系统管理界面</h1>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <!-- Nav tabs -->\r\n");
      out.write("            <ul class=\"nav nav-tabs\" role=\"tablist\">\r\n");
      out.write("                <li role=\"presentation\" class=\"active\"><a href=\"#repositorylist\" aria-controls=\"repository\" role=\"tab\" data-toggle=\"tab\" id=\"repository\">仓库列表</a></li>\r\n");
      out.write("                <li role=\"presentation\"><a href=\"#userlist\" aria-controls=\"user\" role=\"tab\" data-toggle=\"tab\" id=\"user\" onclick=\"SelectUserlist()\">用户列表</a></li>\r\n");
      out.write("                <li role=\"presentation\"><a href=\"#goodslist\" aria-controls=\"goods\" role=\"tab\" data-toggle=\"tab\" id=\"goods\" onclick=\"SelectGoodslist()\">货号列表</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <!-- Tab panes -->\r\n");
      out.write("            <div class=\"tab-content\">\r\n");
      out.write("                <div role=\"tabpanel\" class=\"tab-pane active\" id=\"repositorylist\">\r\n");
      out.write("                    <a data-toggle=\"modal\" data-target=\"#saveRepositoryModel\">\r\n");
      out.write("                        <button class=\"btn btn-success btn-sm\" id=\"saveRepository\">增加仓库信息</button>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a style=\"margin-left: 560px;\">\r\n");
      out.write("                        <label for=\"repositoryquery\"></label><input id=\"repositoryquery\" type=\"search\" placeholder=\"请输入查询信息\" style=\"height: 29px\"/>\r\n");
      out.write("                        <button class=\"btn btn-info btn-sm\">查询</button>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <table class=\"table table-bordered table-striped table-hover\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>编号</th>\r\n");
      out.write("                            <th>仓库名</th>\r\n");
      out.write("                            <th>操作</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>1</td>\r\n");
      out.write("                            <td>第一仓库</td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <a id=\"deleteRepository\"><button class=\"btn btn-danger btn-sm\">删除</button></a>\r\n");
      out.write("                                <a data-toggle=\"modal\" data-target=\"#updateRepositoryModel\"><button class=\"btn btn-warning btn-sm\">修改</button></a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>1</td>\r\n");
      out.write("                            <td>第一仓库</td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <a href=\"\"><button class=\"btn btn-danger btn-sm\">删除</button></a>\r\n");
      out.write("                                <a href=\"\"><button class=\"btn btn-warning btn-sm\">修改</button></a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>1</td>\r\n");
      out.write("                            <td>第一仓库</td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <a href=\"\"><button class=\"btn btn-danger btn-sm\">删除</button></a>\r\n");
      out.write("                                <a href=\"\"><button class=\"btn btn-warning btn-sm\">修改</button></a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("\r\n");
      out.write("                    </table>\r\n");
      out.write("                    <div style=\"margin-left: 400px\">\r\n");
      out.write("                        <nav aria-label=\"Page navigation\">\r\n");
      out.write("                            <ul class=\"pagination\">\r\n");
      out.write("                                <li class=\"disabled\">\r\n");
      out.write("                                    <a href=\"#\" aria-label=\"Previous\">\r\n");
      out.write("                                        <span aria-hidden=\"true\">&laquo;</span>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"active\"><a href=\"#\">1</a></li>\r\n");
      out.write("                                <li><a href=\"#\">2</a></li>\r\n");
      out.write("                                <li><a href=\"#\">3</a></li>\r\n");
      out.write("                                <li><a href=\"#\">4</a></li>\r\n");
      out.write("                                <li><a href=\"#\">5</a></li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"#\" aria-label=\"Next\">\r\n");
      out.write("                                        <span aria-hidden=\"true\">&raquo;</span>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </nav>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div role=\"tabpanel\" class=\"tab-pane\" id=\"userlist\">\r\n");
      out.write("                    <a data-toggle=\"modal\" data-target=\"#saveUserModel\">\r\n");
      out.write("                        <button class=\"btn btn-success btn-sm\" id=\"saveUser\">增加用户信息</button>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a style=\"margin-left: 560px;\">\r\n");
      out.write("                        <label for=\"userquery\"></label><input id=\"userquery\" type=\"search\" placeholder=\"请输入查询信息\" style=\"height: 29px\"/>\r\n");
      out.write("                        <button class=\"btn btn-info btn-sm\" onclick=\"userSearch()\">查询</button>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <table class=\"table table-bordered table-striped table-hover\" id=\"userlists\">\r\n");
      out.write("\r\n");
      out.write("                    </table>\r\n");
      out.write("                    <div style=\"margin-left: 400px\">\r\n");
      out.write("                        <nav aria-label=\"Page navigation\">\r\n");
      out.write("                            <ul class=\"pagination\" id=\"currentPage\">\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </nav>\r\n");
      out.write("                    </div>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div role=\"tabpanel\" class=\"tab-pane\" id=\"goodslist\">\r\n");
      out.write("                    <a data-toggle=\"modal\" data-target=\"#saveGoodsModel\">\r\n");
      out.write("                        <button class=\"btn btn-success btn-sm\">增加货号信息</button>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a style=\"margin-left: 560px;\">\r\n");
      out.write("                        <label for=\"goodsquery\"></label><input id=\"goodsquery\" type=\"search\" placeholder=\"请输入查询信息\" style=\"height: 29px\"/>\r\n");
      out.write("                        <button class=\"btn btn-info btn-sm\" onclick=\"goodsSearch()\">查询</button>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <table class=\"table table-bordered table-striped table-hover\" id=\"goodslists\">\r\n");
      out.write("                    </table>\r\n");
      out.write("                    <div style=\"margin-left: 400px\">\r\n");
      out.write("                        <nav aria-label=\"Page navigation\">\r\n");
      out.write("                            <ul class=\"pagination\">\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"#\" aria-label=\"Previous\">\r\n");
      out.write("                                        <span aria-hidden=\"true\">&laquo;</span>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"active\"><a href=\"#\">1</a></li>\r\n");
      out.write("                                <li><a href=\"#\">2</a></li>\r\n");
      out.write("                                <li><a href=\"#\">3</a></li>\r\n");
      out.write("                                <li><a href=\"#\">4</a></li>\r\n");
      out.write("                                <li><a href=\"#\">5</a></li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"#\" aria-label=\"Next\">\r\n");
      out.write("                                        <span aria-hidden=\"true\">&raquo;</span>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </nav>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("<!--模态框-->\r\n");
      out.write("<!--新增仓库-->\r\n");
      out.write("<div class=\"modal fade\" id=\"saveRepositoryModel\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                <h4 class=\"modal-title\">增加仓库信息</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <form>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"repositoryadd\">新增仓库名</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"repositoryadd\" placeholder=\"仓库名\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消新增</button>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary\">确认提交</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--修改仓库-->\r\n");
      out.write("<div class=\"modal fade\" id=\"updateRepositoryModel\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                <h4 class=\"modal-title\">修改仓库信息</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <form>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"updateRepositoryName\">修改仓库名</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"updateRepositoryName\" placeholder=\"仓库名\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消修改</button>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary\">确认提交</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--新增用户-->\r\n");
      out.write("<div class=\"modal fade\" id=\"saveUserModel\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                <h4 class=\"modal-title\">增加用户信息</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <form id=\"addUserForm\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"useridadd\">新增账户</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"user_id\" id=\"useridadd\" placeholder=\"账户名\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"usernameadd\">新增用户名</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"user_name\" id=\"usernameadd\" placeholder=\"用户名\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消新增</button>\r\n");
      out.write("                        <button type=\"button\" onclick=\"userAdd()\" class=\"btn btn-primary\">确认提交</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--修改用户-->\r\n");
      out.write("<div class=\"modal fade\" id=\"updateUserModel\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                <h4 class=\"modal-title\">修改用户信息</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <form>\r\n");
      out.write("                    <input type=\"hidden\" class=\"form-control\" name=\"updateid\" id=\"updateid\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"updateUserid\">修改账户名</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"updateUserid\" id=\"updateUserid\" placeholder=\"账户名\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"updateUserName\">修改用户名</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"updateUserName\" id=\"updateUserName\" placeholder=\"用户名\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"updateUserPassword\">修改密码</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"updateUserPassword\" id=\"updateUserPassword\" placeholder=\"密码\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消修改</button>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"userEdit()\">确认提交</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--新增货号-->\r\n");
      out.write("<div class=\"modal fade\" id=\"saveGoodsModel\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                <h4 class=\"modal-title\">增加货号信息</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <form>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"saveGoodsNo\">新增货物编号</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"saveGoodsNo\" name=\"saveGoodsNo\" placeholder=\"货物编号\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"saveGoodsName\">新增货物名称</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"saveGoodsName\" name=\"saveGoodsName\" placeholder=\"货物名\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消新增</button>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"goodsAdd()\">确认提交</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--修改货号-->\r\n");
      out.write("<div class=\"modal fade\" id=\"updateGoodsModel\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                <h4 class=\"modal-title\">修改货号信息</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <form>\r\n");
      out.write("                    <input type=\"hidden\" class=\"form-control\" name=\"updategoodsid\" id=\"updategoodsid\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"UpdateGoodsNo\">修改货物编号</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"UpdateGoodsNo\" name=\"UpdateGoodsNo\" placeholder=\"货物编号\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"UpdateGoodsName\">修改货物名称</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"UpdateGoodsName\" name=\"UpdateGoodsName\" placeholder=\"货物名\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消新增</button>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"goodsEdit()\">确认提交</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
