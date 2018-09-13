package kr.teamfive.signup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.teamfive.common.db.MyAppSqlConfig;
import kr.teamfive.repository.domain.Member;
import kr.teamfive.repository.mapper.LoginMapper;

@WebServlet("/jsp/signup/signup.do")
public class Signup extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		LoginMapper logmapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(LoginMapper.class);
		String id = request.getParameter("id");
		String name = logmapper.selectCheckMember(id);
		String pass = request.getParameter("password");
		String rePass = request.getParameter("repassword");
		System.out.println("password input: "+pass);
		System.out.println("repassword input: "+rePass);

		if(name==null && pass.equals(rePass)) {
			
				Member regMember = new Member();
				regMember.setId(id);
				regMember.setPassword(pass);
				regMember.setName(request.getParameter("name"));

				logmapper.insertMember(regMember);

				response.sendRedirect("/08_servletjsp/jsp/main/main.do");
				return;
		} else if(!name.isEmpty()) {
				RequestDispatcher rd =request.getRequestDispatcher("/jsp/signup/existinguser.jsp");
				rd.forward(request, response);
				return;
			} else {
			RequestDispatcher rde =request.getRequestDispatcher("/jsp/signup/pass_not_match.jsp");
			rde.forward(request, response);

		} // if-else

	} // service();

} // end class