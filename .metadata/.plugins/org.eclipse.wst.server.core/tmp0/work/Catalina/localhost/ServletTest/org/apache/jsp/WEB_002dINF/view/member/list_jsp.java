/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.73
 * Generated at: 2020-09-09 11:39:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.ddit.member.vo.MemberVO;
import java.util.List;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
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

	List<MemberVO> memList = (List<MemberVO>) request.getAttribute("memList");
	String msg = (String) request.getAttribute("msg");
	



      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>회원목록</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"4\"><a href=\"insert.do\">[회원등록]</a></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>ID</td>\r\n");
      out.write("\t\t<td>이름</td>\r\n");
      out.write("\t\t<td>전화번호</td>\r\n");
      out.write("\t\t<td>주소</td>\r\n");
      out.write("\t</tr>\r\n");

	int memSize = (memList == null) ? 0 : memList.size();
	if(memSize > 0){
		for(int i=0; i<memSize; i++){

      out.write("\t\t\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>");
      out.print( memList.get(i).getMem_id() );
      out.write(" </td>\r\n");
      out.write("\t\t<td><a href=\"select.do?memId=");
      out.print(memList.get(i).getMem_id() );
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print( memList.get(i).getMem_name() );
      out.write("</a> </td>\r\n");
      out.write("\t\t<td>");
      out.print( memList.get(i).getMem_tel() );
      out.write(" </td>\r\n");
      out.write("\t\t<td>");
      out.print( memList.get(i).getMem_addr() );
      out.write(" </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\t\t\r\n");

		}
	}else{ // 회원정보가 존재하지 않을 경우... memSize=0

      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"4\">회원정보가 존재하지 않습니다.</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
			
	}

      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");

	
	if(msg.equals("성공")){

      out.write("\t\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\talert(\"정상적으로 처리되었습니다.\");\r\n");
      out.write("\t</script>\t\r\n");
      out.write("\t\t\r\n");
		
	}

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
