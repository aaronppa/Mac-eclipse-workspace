package kr.teamfive.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.teamfive.common.db.MyAppSqlConfig;
import kr.teamfive.repository.domain.Board;
import kr.teamfive.repository.mapper.BoardMapper;

@WebServlet("/servlet/board/update_form.do")
public class UpdateFormController extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		BoardMapper mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardMapper.class);
	 	// 데이터베이스게시물 목록 가지고 오기 
		int no = Integer.parseInt(request.getParameter("no"));
		Board board = mapper.selectBoardByNo(no);
		
		request.setAttribute("board", board);
				
		RequestDispatcher rd = request.getRequestDispatcher("/servlet/board/update_form.jsp");
		rd.forward(request, response);
	}
	
} // end class
