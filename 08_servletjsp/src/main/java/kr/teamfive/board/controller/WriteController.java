package kr.teamfive.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.teamfive.common.db.MyAppSqlConfig;
import kr.teamfive.repository.domain.Board;
import kr.teamfive.repository.mapper.BoardMapper;

@WebServlet("/servlet/board/write.do")
public class WriteController extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Post 방식일 경우 파라미터 한글 처리
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html; charset=utf-8");
    	
    	// 사용자 전송 파라미터 꺼내기 
    	String title = request.getParameter("title");
    	String writer = request.getParameter("writer");
    	String content = request.getParameter("content");
    	
    	// 파라미터를 데이터 베이스 처리를 위한 매퍼에게 넘긴다. 
    	BoardMapper mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardMapper.class);
    	
    	Board board = new Board();
    	board.setTitle(title);
    	board.setWriter(writer);
    	board.setContent(content);
    	
    	mapper.insertBoard(board);
    			
		response.sendRedirect("/08_servletjsp/servlet/board/list.do");
	}

	
} // end class
