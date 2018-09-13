package kr.teamfive.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/quiz01")
public class Quiz01 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	double result=0;
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	String op = request.getParameter("operator");
		
	switch(op) {
	case "+": result = num1 + num2; break;
	case "-": result = num1 - num2; break;
	case "*": result = num1 * num2; break;
	case "/": result = num1 / num2; break;
	}
	
	PrintWriter out = response.getWriter();
	out.println("결과: ");
	out.println(num1 + " " + op + " " + num2 + " = " + result);
	out.println("<br><button onclick=\"history.back()\">되돌아가기</button>");
	out.close();
	}
	
	
} // end class
