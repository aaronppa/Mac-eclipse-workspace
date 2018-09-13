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
import javax.servlet.http.HttpServlet;

@WebServlet("/servlet/basic/test07")
public class Test07 extends HttpServlet{
 
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Test07-service(SR, SR)");
	}
 

	
	
}// end class