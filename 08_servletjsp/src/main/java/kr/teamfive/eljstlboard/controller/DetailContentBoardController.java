package kr.teamfive.eljstlboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.teamfive.common.db.MyAppSqlConfig;
import kr.teamfive.repository.domain.Board;
import kr.teamfive.repository.domain.Comment;
import kr.teamfive.repository.domain.FileAttach;
import kr.teamfive.repository.mapper.BoardMapper;

@WebServlet("/servlet/eljstlboard/content_detail.do")
public class DetailContentBoardController extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardMapper mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardMapper.class);
	 	// 데이터베이스게시물 목록 가지고 오기 
		int no = Integer.parseInt(request.getParameter("no"));
		Board board = mapper.selectBoardByNo(no);
		mapper.updateViewCnt(no);
		
		List<FileAttach> attFileList = mapper.selectFileAttach(no);
				
		request.setAttribute("board", board);
		request.setAttribute("attFileList", attFileList);
		for(FileAttach afl:attFileList) {
			System.out.println(afl);
		}
		
		List<Comment> commList = mapper.selectComments(no);
		request.setAttribute("commList", commList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/eljstl/board/content_detail.jsp");
		rd.forward(request, response);
		
	}
	
}//
