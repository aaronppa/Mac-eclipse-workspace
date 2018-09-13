/*
 *	Page 이동 기술: forward 이해하기..  
 */

package kr.teamfive.servlet.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/forward/test01")
public class Test01 extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("forward - test01 서블릿 호출됨.");
		
		// 다른 서블릿 또는 JSP를 호출
		// 사용되는 API 클래스: RequestDispatcher.forward(request, response)
		
		// RequestDispatcher 객체를 얻을 때 이동할 페이지 주소를 설정한다. 
		// http://localhost:8000/08_servletjsp/servlet/forward/test01(Servlet)
		// http://localhost:8000/08_servletjsp/servlet/forward/test01(Servlet)
//		RequestDispatcher rd = request.getRequestDispatcher("test01.jsp");

		// 페이지 주소가 /로 시작할 경우: 프로젝트는 자동 인식되기 때문에 프로젝트 경로는 제외한다.
		//  /로 시작하는데 프로젝트 경로가 인식되는 경우 : @WebServlet, forward, url-pattern(web.xml) 
		RequestDispatcher rd = request.getRequestDispatcher("/servlet/forward/test01.jsp");
		
		// 설정된 페이지로 이동해라...
		rd.forward(request, response);
		
	}
}
