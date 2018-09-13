package kr.teamfive.servlet.basic;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/basic/test04")
public class Test04 extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) 
		throws IOException, ServletException{
		System.out.println("서버에서 호출되었습니다.2");
	};
	
} // end class
