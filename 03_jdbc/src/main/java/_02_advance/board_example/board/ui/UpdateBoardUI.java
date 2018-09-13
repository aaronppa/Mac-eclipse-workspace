package _02_advance.board_example.board.ui;

import _02_advance.board_example.board.dao.BoardDAO;
import board.vo.Board;

public class UpdateBoardUI extends BaseUI {
	private BoardDAO dao;
	
	public UpdateBoardUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		Board board = new Board();
		board.setNo(getInt("수정할 글번호를 입력하세요 : "));
		board.setTitle(getStr("변경할 제목을 입력하세요 : "));
		board.setContent(getStr("변경할 내용을 입력하세요 : "));

		int result = dao.updateBoard(board);
		if (result == 0) {
			System.out.println("입력된 번호는 존재하지 않습니다.");
		} else {
			System.out.println("게시글이 수정되었습니다.");
		}
	}
}



