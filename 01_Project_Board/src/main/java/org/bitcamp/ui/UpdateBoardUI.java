package org.bitcamp.ui;

import org.bitcamp._Project_Board.Board;
import org.bitcamp._Project_Board.BoardDAO;

public class UpdateBoardUI extends BaseUI{
	BoardDAO dao;
	
	public UpdateBoardUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		Board board = new Board();
		board.setNo(getInt("변경할 게시글 번호: "));		
		board.setTitle(getStr("변경할 제목: "));
		board.setContent(getStr("변경할 내용: "));
		dao.updateBoard(board);
		
		System.out.println("선택하신 글이 수정되었습니다.");
	}

}
