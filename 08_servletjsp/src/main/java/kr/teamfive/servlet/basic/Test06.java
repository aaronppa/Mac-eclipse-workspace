/*
 * Servlet
 * Generic Servlet - init
 * MyHttpServlet - service(SR, SR)
 * 				 - service(HSR, HSR)
 * 				 - doGet
 * 			     - doPost
 * Test06        - service(SR, SR)
 */

package kr.teamfive.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/test06")
public class Test06 extends MyHttpServlet{
	// GenericServlet 상속 받은 경우 사용된다. 
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("Test06-service(SR, SR)");
//	}
	// HttpServlet - GET & POST 방식과 무관할떄 
//	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("Test06-service(HSR, HSR)");
//	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Test06-doGet(HSR, HSR)");
	}
	
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("Test06-doPost(HSR, HSR)");
//	}
	
}// end class