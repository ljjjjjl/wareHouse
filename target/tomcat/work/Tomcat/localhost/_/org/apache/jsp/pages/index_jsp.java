/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-06-20 06:47:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=utf-8\">\r\n");
      out.write("    <title>主页</title>\r\n");
      out.write("    <script type=\"text/javascript\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/index.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/user.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/goods.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/warehouse.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/stock.js\"></script>\r\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/boot/css/bootstrap.min.css\"/>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/boot/js/jquery-3.6.0.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/boot/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body onmousemove=\"timereset()\">\r\n");
      out.write("<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\r\n");
      out.write("                <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.jsp\">服装后台管理系统<span class=\"badge\">V1.0</span></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                <li><a>欢迎: <span class=\"text-danger text-center\" id=\"usernameshow\" ></span></a></li>\r\n");
      out.write("                <li class=\"dropdown\">\r\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">用户中心 <span class=\"caret\"></span></a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a onclick=\"Password()\">修改密码</a></li>\r\n");
      out.write("                        <li><a href=\"login.jsp\">登录</a></li>\r\n");
      out.write("                        <li><a onclick=\"Logout()\">退出</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<div class=\"row\" >\r\n");
      out.write("    <div class=\"col-md-2\">\r\n");
      out.write("        <div class=\"panel-group\" id=\"accordion\" role=\"tablist\" aria-multiselectable=\"true\">\r\n");
      out.write("            <div class=\"panel panel-default\">\r\n");
      out.write("                <div class=\"panel-heading\" role=\"tab\" id=\"Systemheading\">\r\n");
      out.write("                    <h4 class=\"panel-title\">\r\n");
      out.write("                        <a onclick=\"System()\" class=\"collapsed\" role=\"button\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#Systemcollapse\" aria-expanded=\"false\" aria-controls=\"Systemcollapse\">\r\n");
      out.write("                            <span class=\"glyphicon glyphicon-tasks\"></span>系统管理\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </h4>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"Systemcollapse\" class=\"panel-collapse collapse\" role=\"tabpanel\" aria-labelledby=\"Systemheading\">\r\n");
      out.write("                    <div class=\"panel-body\">\r\n");
      out.write("                        <ul class=\"list-group\">\r\n");
      out.write("                            <li class=\"list-group-item\"><a>仓库管理</a></li>\r\n");
      out.write("                            <li class=\"list-group-item\"><a>用户管理</a></li>\r\n");
      out.write("                            <li class=\"list-group-item\"><a>货号管理</a></li>\r\n");
      out.write("                            <li class=\"list-group-item\"><a>货号明细管理</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"panel panel-default\">\r\n");
      out.write("                <div class=\"panel-heading\" role=\"tab\" id=\"Stockheading\">\r\n");
      out.write("                    <h4 class=\"panel-title\">\r\n");
      out.write("                        <a onclick=\"Stock()\" class=\"collapsed\" role=\"button\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#Stockcollapse\" aria-expanded=\"false\" aria-controls=\"Stockcollapse\">\r\n");
      out.write("                            <span class=\"glyphicon glyphicon-folder-close\"></span>库存管理\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </h4>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"Stockcollapse\" class=\"panel-collapse collapse\" role=\"tabpanel\" aria-labelledby=\"Stockheading\">\r\n");
      out.write("                    <div class=\"panel-body\">\r\n");
      out.write("                        <ul class=\"list-group\">\r\n");
      out.write("                            <li class=\"list-group-item\"><a>入库管理</a></li>\r\n");
      out.write("                            <li class=\"list-group-item\"><a>出库管理</a></li>\r\n");
      out.write("                            <li class=\"list-group-item\"><a>入库明细管理</a></li>\r\n");
      out.write("                            <li class=\"list-group-item\"><a>出库明细管理</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"content\">\r\n");
      out.write("        <div class=\"col-md-10\">\r\n");
      out.write("            <div class=\"jumbotron text-center\" style=\"background-color: #2e6da4;width: 1200px;height: 500px;\">\r\n");
      out.write("                <h1>欢迎进入服装后台管理界面</h1>\r\n");
      out.write("                <p>本系统为厂商管理人员设计</p>\r\n");
      out.write("                <p><a class=\"btn btn-primary btn-lg \" href=\"https://github.com/\" target=\"_blank\" role=\"button\">了解更多</a></p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
