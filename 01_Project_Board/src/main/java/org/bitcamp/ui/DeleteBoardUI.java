package org.bitcamp.ui;

import org.bitcamp._Project_Board.BoardDAO;

public class DeleteBoardUI extends BaseUI{
	BoardDAO dao;
	
	public DeleteBoardUI(BoardDAO dao) {
		this.dao = dao;
	} // constructor
	
	public void service() {
		int no = getInt("삭제할 글 번호를 입력하세요: ");
		int cnt = dao.deleteBoard(no);
		
		if(cnt==0) {
			System.out.println("삭제할 글이 없습니다.");
		}else {
		
		System.out.println("선택하신 글이 삭제되었습니다.");
		}
	} // service()
	
} // end class
