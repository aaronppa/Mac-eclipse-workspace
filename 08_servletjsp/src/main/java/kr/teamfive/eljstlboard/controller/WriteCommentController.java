package kr.teamfive.eljstlboard.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.teamfive.common.db.MyAppSqlConfig;
import kr.teamfive.repository.domain.Comment;
import kr.teamfive.repository.mapper.BoardMapper;

@WebServlet("/servlet/eljstlboard/write_comment.do")
public class WriteCommentController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardMapper mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardMapper.class);
		Comment comment = new Comment();
		int no = Integer.parseInt(request.getParameter("no"));
		String writer = request.getParameter("writer");
		System.out.println("noParam: "+no);
		System.out.println("writerParam: "+writer);
		comment.setNo(no);
		comment.setWriter(writer);
		comment.setContent(request.getParameter("comment"));
		
		mapper.insertComment(comment);
		
		RequestDispatcher rd = request.getRequestDispatcher("/servlet/eljstlboard/content_detail.do?no="+no);
		rd.forward(request, response);
	}
		

} // end class
