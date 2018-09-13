/*
 *	html, css, javascript :  클라이언트 사이드 프로그램
 *	Servlet, JSP,... : 서버에서 실행 한 후 결과를 만들어서 넘기는 서버사이드 프로그램
 *	
 *	Tomcat: Server + Servlet Engine (java.class file conversion to HTML format) + JSP Engine
 *	
 *	Servlet: Web에서 실행되는 Java 
 *
 *	Servlet을 구현하기 위해서 필수 사항은 "상속"
 *		- Servlet Interface type으로 implemented 된 class file만 웹에서 호출되는 서블릿 클래스로 인식
 *		- Servlet Interface <- GenericServlet(abstract) <- HttpServlet(abstract) (이중에서 하나라도 상속을 받아야 java.class 파일이 웹에서 실행 가능)
 *
 *	To invoke Servlet: 가상의 경로와 서블릿을 연결시켜야한다.
 *		2가지 방법	
 *			1) web.xml 파일에 등록하는 방식
 *			2) Annotation
 */

package kr.teamfive.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test01 extends HttpServlet{
	public void service(
						HttpServletRequest request, HttpServletResponse response)
						throws IOException, ServletException{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Servlet Response Succuss :)</h1>");
		out.close();
		
	} // service()
	
} // end class
