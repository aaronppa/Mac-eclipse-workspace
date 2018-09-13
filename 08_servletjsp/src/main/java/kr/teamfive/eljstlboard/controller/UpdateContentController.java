package kr.teamfive.eljstlboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.teamfive.common.db.MyAppSqlConfig;
import kr.teamfive.repository.domain.Board;
import kr.teamfive.repository.mapper.BoardMapper;

@WebServlet("/servlet/eljstlboard/update.do")
public class UpdateContentController extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardMapper mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardMapper.class);
		
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board board = new Board();
		board.setNo(no);
		board.setTitle(title);
		board.setContent(content);
		
		mapper.updateContent(board);
		
		response.sendRedirect("/08_servletjsp/servlet/eljstlboard/list.do");
	}
	
} // end class
