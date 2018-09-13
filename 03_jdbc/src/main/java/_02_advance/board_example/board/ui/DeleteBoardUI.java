package _02_advance.board_example.board.ui;

import _02_advance.board_example.board.dao.BoardDAO;

public class DeleteBoardUI extends BaseUI {
	private BoardDAO dao;

	public DeleteBoardUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		int no = getInt("삭제할 글번호를 입력하세요 : ");
		int result = dao.deleteBoard(no);
		
		if (result == 0) {
			System.out.println(
				"입력하신 번호에 해당하는 게시글이 없습니다.");
			return;
		}
		/*
		if (dao.deleteBoard(getInt("삭제할 글번호를 입력하세요 : ")) == false) {
			System.out.println(
					"입력하신 번호에 해당하는 게시글이 없습니다.");
			return;
		}
		 */
		System.out.println("게시글이 삭제되었습니다.");
	}
}



