package kr.teamfive.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout/logout.do")
public class LogOut extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session =request.getSession();
			session.invalidate();
			//메인 페이지로 이동하기
			response.sendRedirect(request.getContextPath()+"/main.do");
		
		
	}
}