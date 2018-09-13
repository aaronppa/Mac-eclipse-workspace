package kr.teamfive.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.teamfive.common.db.MyAppSqlConfig;
import kr.teamfive.repository.mapper.BoardMapper;

@WebServlet("/servlet/board/delete.do")
public class DeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardMapper mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardMapper.class); 
		int no = Integer.parseInt(request.getParameter("no"));
		
		mapper.deleteContent(no);
		
		response.sendRedirect("list.do");
	}

	
} // end class
