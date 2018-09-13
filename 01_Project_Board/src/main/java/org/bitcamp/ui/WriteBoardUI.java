package org.bitcamp.ui;

import org.bitcamp._Project_Board.Board;
import org.bitcamp._Project_Board.BoardDAO;

public class WriteBoardUI extends BaseUI{
	BoardDAO dao;
	
	public WriteBoardUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		Board boardVO = new Board();
				
		boardVO.setWriter(getStr("작성자: "));
		boardVO.setTitle(getStr("제목: "));
		boardVO.setContent(getStr("내용: "));
		
		dao.insertBoard(boardVO);
		
		System.out.println("작성한 글이 게시판에 등록되었습니다.");
	}
	
} // end class
