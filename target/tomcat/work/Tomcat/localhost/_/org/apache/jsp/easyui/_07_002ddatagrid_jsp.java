/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-03-07 11:09:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.easyui;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _07_002ddatagrid_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>datagrid</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/default/easyui.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/icon.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.8.3.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 方式一：将静态HTML渲染为datagrid样式 -->\r\n");
      out.write("<table class=\"easyui-datagrid\">\r\n");
      out.write("    <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th data-options=\"field:'id'\">编号</th>\r\n");
      out.write("        <th data-options=\"field:'name'\">姓名</th>\r\n");
      out.write("        <th data-options=\"field:'age'\">年龄</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("    <tbody>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td>001</td>\r\n");
      out.write("        <td>小明</td>\r\n");
      out.write("        <td>90</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td>002</td>\r\n");
      out.write("        <td>老王</td>\r\n");
      out.write("        <td>3</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 方式二：发送ajax请求获取json数据创建datagrid -->\r\n");
      out.write("<table data-options=\"url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/json/datagrid_data.json'\"\r\n");
      out.write("       class=\"easyui-datagrid\">\r\n");
      out.write("    <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th data-options=\"field:'id'\">编号</th>\r\n");
      out.write("        <th data-options=\"field:'name'\">姓名</th>\r\n");
      out.write("        <th data-options=\"field:'age'\">年龄</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<hr>\r\n");
      out.write("<!-- 方式二：发送ajax请求获取json数据创建datagrid -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 方式三：使用easyUI提供的API创建datagrid -->\r\n");
      out.write("<table id=\"mytable\">\r\n");
      out.write("</table>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $(function(){\r\n");
      out.write("        //页面加载完成后，创建数据表格datagrid\r\n");
      out.write("        $(\"#mytable\").datagrid({\r\n");
      out.write("            //定义标题行所有的列\r\n");
      out.write("            columns:[[\r\n");
      out.write("                {title:'编号',field:'id',checkbox:true},\r\n");
      out.write("                {title:'姓名',field:'name'},\r\n");
      out.write("                {title:'年龄',field:'age'},\r\n");
      out.write("                {title:'地址',field:'address'}\r\n");
      out.write("            ]],\r\n");
      out.write("            //指定数据表格发送ajax请求的地址\r\n");
      out.write("            url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/json/datagrid_data.json',\r\n");
      out.write("            rownumbers:true,\r\n");
      out.write("            singleSelect:true,\r\n");
      out.write("            //定义工具栏\r\n");
      out.write("            toolbar:[\r\n");
      out.write("                {text:'添加',iconCls:'icon-add',\r\n");
      out.write("                    //为按钮绑定单击事件\r\n");
      out.write("                    handler:function(){\r\n");
      out.write("                        alert('add...');\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                {text:'删除',iconCls:'icon-remove'},\r\n");
      out.write("                {text:'修改',iconCls:'icon-edit'},\r\n");
      out.write("                {text:'查询',iconCls:'icon-search'}\r\n");
      out.write("            ],\r\n");
      out.write("            //显示分页条\r\n");
      out.write("            pagination:true,\r\n");
      out.write("            pageList:[3,5,7,10]\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
