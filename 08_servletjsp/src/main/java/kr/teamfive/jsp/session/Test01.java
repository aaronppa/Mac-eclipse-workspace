package kr.teamfive.jsp.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 *  세션과 관련된 기본 API 
 *  서버에는 session이라는 하나의 클라이언트 당 생기는 공간이 있고 
 *  그 공간에는  아무런 이름도 붙어 있지 않지만 JSESSIONID=값(session공간의 아이디, 이름)이 쌍으로 이름을 설정하고 서버에 저장됨.
 *  브라우저가 JSESSIONID=값이 
 *  클라이 언트에서 서버로 넘어갈 때 세션을 헤더에 쿠키를 통해 붙어 넘어감.
 *  Cookie: JSESSIONID=8B7E7FE6F62AE8DAB65423CA70E9B8D6
 *  쿠키를 이용한 세션 방식(관리를 쿠키를 통해서 함.)
 *  브라우저가 닫힏때 까지 살아 있음.*(30분 동안 아무 요청이 없으면 )
 *  
 *  
 *  
 *  쿠키는 클라이언트에 저장됨.
 *  서버의 부하는 덜어줄 수 있지만 보안은 좋지 못함.
 *  ex> 쇼핑몰 오늘 본 상품, ㅁ오늘 하루 더이상 보지 않기, 자동 로그인
 *  브라우저가 꺼져도 유지가 됨.
 *  
 *  
Session
Cookie 

사용자가 서버에 접속시 session 공간에 id가 부여된다..
서버는그 id를호출한 브라우저에게 jsessionid=값으로 돌려준다..  (헤더값에포함되어  전송) 
호출받은 브라우저는 서버로부터받은 jsid의 값을 저장한다.

서버로 재호출 시 
부여받은 jsid를 가지고 서버로 호출한다. (헤더값에 포함되어 전송) 

서버는 jsid를 확인하고 해당 공간을 찾아서 사용자를 구분한다. 

유효 범위  : 브라우저가 살아 있는 동안만  // cookie는 X 

session - 사용자 id를 cookie 에 담아 보냄.   == session은 서버에 정보 저장  cookie는 사용자에 정보 저장.   
 */
@ WebServlet("/jsp/session/test01.do")
public class Test01 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//서블릿에서 세션을 얻어오기
		HttpSession session = request.getSession();
		
		//사용자를 구분하기 위한 세션 아이디
		String id = session.getId();
		
		//세션의 유지 기간(초단위) 디폴트 30분	
		session.setMaxInactiveInterval(3);
		
		out.println("<h1>JSESSIONID : "+id+"</h1>");
		
		
	}
}