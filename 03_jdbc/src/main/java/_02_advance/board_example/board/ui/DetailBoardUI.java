package _02_advance.board_example.board.ui;

import java.text.SimpleDateFormat;

import _02_advance.board_example.board.dao.BoardDAO;
import board.vo.Board;

public class DetailBoardUI extends BaseUI {
	private BoardDAO dao;
	
	public DetailBoardUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		int no = getInt("조회할 글번호를 입력하세요 : ");
		System.out.println("-------------------------------");
		// 조회수 증가
		dao.updateBoardViewCnt(no);

		Board board = dao.selectBoardByNo(no);
		
		if (board == null) {
			System.out.println("입력된 번호는 존재하지 않습니다.");
		} else {
			System.out.println("번호 : " + no);
			System.out.println("글쓴이 : " + board.getWriter());
			System.out.println("제목 : " + board.getTitle());
			System.out.println("내용 : " + board.getContent());
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss"
			);		
			System.out.println(
					"등록일시 : " + sdf.format(board.getRegDate())
			);
			System.out.println("조회수 : " + board.getViewCnt());
		}
		System.out.println("-------------------------------");
	}
}









