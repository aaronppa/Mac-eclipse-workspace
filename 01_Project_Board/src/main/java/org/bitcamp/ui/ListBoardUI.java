package org.bitcamp.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bitcamp._Project_Board.Board;
import org.bitcamp._Project_Board.BoardDAO;

public class ListBoardUI extends BaseUI{
	BoardDAO dao;
	
	public ListBoardUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		List<Board> list = dao.selectBoard();
		
		
		System.out.printf(" 조회된 게시물: %d\n", list.size());
		System.out.println("---------------------------------------------");
		System.out.println("글번호 \t 작성자 \t 제목 \t 등록날짜 \t 조회수 \t");
		System.out.println("---------------------------------------------");
		
		for(Board b: list) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy--MM--dd");
			System.out.printf(
					"%d\t%s\t%s\t%s\t%d\n",
					b.getNo(),b.getWriter(),b.getTitle(),sdf.format(b.getRegDate()), b.getViewCnt()
					);
		} 
		if(list.isEmpty()) {
		System.out.println("게시글이 없습니다.");
		
		} 
		
	} // service
	
} // end class
