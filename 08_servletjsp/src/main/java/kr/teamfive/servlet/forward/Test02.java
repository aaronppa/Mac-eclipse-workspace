package kr.teamfive.servlet.forward;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 	forward
 * 	 - URL unchanged (URL에 .jsp 방식으로 노출시키지 않는다. )
 * 	 - Data Sharing 
 */
@WebServlet("/servlet/forward/test02")
public class Test02 extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// 이동하는 페이지에 데이터를 공유하자.
	String msg="오늘의 날씨는 화창합니다.";
	
	List<String> list = new ArrayList<>();
	list.add("강남불백");
	list.add("피자몰");
	list.add("자연별곡");
	
	// 공유 :request
	request.setAttribute("msg",msg);
	request.setAttribute("list",list);
	
	// 공유된 데이터를 사용할 페이지로 이동
	RequestDispatcher rd = request.getRequestDispatcher("test02.jsp");
	rd.forward(request, response);
	
	}
}
