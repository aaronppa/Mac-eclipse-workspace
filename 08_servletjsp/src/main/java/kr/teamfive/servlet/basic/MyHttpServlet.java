package kr.teamfive.servlet.basic;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyHttpServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("MyHttp - service(SR, SR)");
		service((HttpServletRequest)req,(HttpServletResponse)res);
		
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MyHttp - service(HSR, HSR)");
		String method = req.getMethod();
		switch(method) {
		case "GET":
			doGet(req,res);
			break;
		case"POST" :
			doPost(req,res);
			break;
		}
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		res.sendError(405, "GET 방식을 지원하지 않습니다.");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		res.sendError(405, "POST 방식을 지원하지 않습니다.");
	}
	
} // end class
