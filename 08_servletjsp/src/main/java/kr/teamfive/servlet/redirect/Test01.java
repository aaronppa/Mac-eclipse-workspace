package kr.teamfive.servlet.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/redirect/test01")
public class Test01 extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/* redirect 방식으로 페이지 이동하기
		 * 	특징
		 * 	 1. URL 주소가 변된다. (브라우저에서 호출을 2번한다.)
		 * 	 2. 데이터 공유가 되지 않는다. 
		 * 	
		 *	응답코드: 302로 반환
		 *	응답헤더: Location 에 이동할 페이지 주소를 설정한다. 
		 *
		 */
	
		// http://localhost:8000/08_servletjsp/servlet/redirect/test01.jsp
		// http://localhost:8000/08_servletjsp/servlet/redirect/test01.jsp
//		response.sendRedirect("test01.jsp");
		
		//이동할 페이지 주소가 /로 시작할 경우 forward와는 다르게 프로젝트 경로부터 설정한다. 
		response.sendRedirect("/08_servletjsp/servlet/redirect/test01.jsp");
		
	} // service()

} // end class
