package _02_advance.board_example.board.ui;

import _02_advance.board_example.board.dao.BoardDAO;
import board.vo.Board;

public class WriteBoardUI extends BaseUI {
	private BoardDAO dao;
	public WriteBoardUI(BoardDAO dao) {
		this.dao = dao;
	}
	public void service() {
		Board boardVO = new Board();
		boardVO.setTitle(getStr("제목을 입력하세요 : "));
		boardVO.setWriter(getStr("글쓴이를 입력하세요 : "));
		boardVO.setContent(getStr("내용을 입력하세요 : "));
		dao.insertBoard(boardVO);
		System.out.println("게시글 등록이 완료되었습니다.");
	}
}



