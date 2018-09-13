package kr.teamfive.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 * 	Servlet Lifecycle methods()
 * 		init -> service(호출시 자동 호출)
 * 			-> destroy(메모리 해제 될때 호출 or Servlet 코드 변경 or 서버 중단..)
 * 		- init(ServletConfig)
 * 		- service(ServletRequest, ServletResponse)
 * 		- destry()
 * 
 * 		Servlet은 singleton object를 활용한다. 
 */

@WebServlet("/servlet/basic/test05")
public class Test05 extends MyGenericServlet{
	// init 메소드는 호출시 최초 한번만 실행된다. 
	public void init(ServletConfig sc) throws ServletException{
		System.out.println("서블릿 최초 호출시에만 실행됨...");
	}
	
	// 사용자에게 처리할 부분을 진행한다. 
	@Override
	public void service(ServletRequest req, ServletResponse res) 
		throws IOException, ServletException{
		System.out.println("서버에서 호출되었습니다.");
	};
	
} // end class
