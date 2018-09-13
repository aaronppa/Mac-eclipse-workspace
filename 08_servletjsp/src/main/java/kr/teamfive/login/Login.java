package kr.teamfive.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.teamfive.common.db.MyAppSqlConfig;
import kr.teamfive.repository.domain.Member;
import kr.teamfive.repository.mapper.LoginMapper;

@WebServlet("/jsp/login/login.do")
public class Login extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println(id+" "+password);
		LoginMapper mapper=MyAppSqlConfig.getSqlSessionInstance().getMapper(LoginMapper.class);
		Member member = new Member();
		member.setId(id);
		member.setPassword(password);
		Member login = mapper.selectMember(member);
		
		//사용자가 입력한 아이디와 패스워드에 해당하는 데이터가 없는 경우
		if(login==null) {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login/login_fail.jsp");
			rd.forward(request, response);
			return;
		} else {//로그인 성공, 사용자 정보를 관리한다.
			HttpSession session =request.getSession();
			session.setAttribute("id", login);
			//메인 페이지로 이동하기
			response.sendRedirect(request.getContextPath()+"/servlet/eljstlboard/list.do");
		}
		
		
	}
}
