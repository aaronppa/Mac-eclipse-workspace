package kr.teamfive.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/quiz02")
public class Quiz02 extends HttpServlet{
	int mind = (int)(Math.random()*100)+1;
	int count=0;
	StringBuffer str = new StringBuffer();
	String br = "<br>";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		

		
		int ans = Integer.parseInt(request.getParameter("answer"));
		
		PrintWriter out = response.getWriter();
		
		if(ans==mind) {
			out.println("정답입니다!");
			return;
		}

		if(ans<mind) {
			count++;
			out.println(count+"회 시도<hr>");
			str.append(ans+"보다 UP!"+br);
			out.println(str);
			out.println("<br><button onclick=\"history.back()\">되돌아가기</button>");
		} else {
			count++;
			out.println(count+"회 시도<hr>");
			str.append(ans+"보다 DOWN!"+br);
			out.println(str);
			out.println("<br><button onclick=\"history.back()\">되돌아가기</button>");
		} 
		
	}
	
}// end class
