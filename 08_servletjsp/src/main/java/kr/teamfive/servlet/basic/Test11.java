package kr.teamfive.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/test11")
public class Test11 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 
		
		// POST 방식일 경우에는 parameter 한글 처리를 해줘야 한다. 
		request.setCharacterEncoding("utf-8");
		
		// parameter 처리하기 
		String sms = request.getParameter("sms");
		
		System.out.println("사용자 전송 파라미터(sms): "+ sms);
		
		String[] lunch = request.getParameterValues("lunch");
		
		if(lunch==null) {
			System.out.println("선택된 메뉴가 없음.");
			return;
		}
		
		System.out.println("선택된 메뉴");
		for(String val:lunch) {
			System.out.println(val);
		}
	}
	
	
} // end class
