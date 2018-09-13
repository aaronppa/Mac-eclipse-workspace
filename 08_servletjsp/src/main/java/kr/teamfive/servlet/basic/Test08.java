/*
 * 	1. @WebServlet("/path"): 경로는 패키지를 기준으로 활용
 * 	2. 상속: HttpServlet
 * 	3. Method()
 * 		- GET/POST 구분이 필요가 없다면 : service(Http...)
 * 		- GET/POST 구분이 필요하다면: doGet, doPost
 * 		
 */
package kr.teamfive.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/test08")
public class Test08 extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		/*
		 * 	사용자에게 정보를 출력하자
		 * 	출력을 위한 IO 객체 얻기
		 * 	 - Byte: images, music -> OutputStream response.getOutputStream()
		 * 	 - Character: html, ... -> PrintWriter response.getWriter()
		 * 
		 * 	출력할 문서의 타입 설정 (서버에서 출력하는 문서의 종류를 알려준다.) 
		 * 	 - Browser에게 알려준다. -> response.setContentType("MainType/SubType; encoding");
		 * 		- response.setContentType("Text/html; charset=utf-8");
		 *   - 만약 브라우저가 해석할 수 없는 타입이라면, Download가 되버림..
		 */
		
		// 브라우저에게 문서의 타입을 html 로 한글이 포함되어있으니 인코딩을 utf-8로 설정
		
//		response.setContentType("text/html; charset=utf-8");
//		response.setContentType("text/html");
//		response.setContentType("text/plain");
		response.setContentType("taxt/plain");
		PrintWriter out = response.getWriter();
		out.println("<h1>성공-Success</h1>");
		out.close();
	}
	
} // end class
