package _02_advance.board_example.board.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import _02_advance.board_example.board.dao.BoardDAO;
import board.vo.Board;

public class ListBoardUI extends BaseUI {
	private BoardDAO dao;
	
	public ListBoardUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		List<Board> list = dao.selectBoard();
		System.out.printf("전체 %d개\n", list.size());
		System.out.println("-------------------------");
		System.out.println("번호\t글쓴이\t제목\t등록일\t조회수");
		System.out.println("-------------------------");
		// 2018-11-11
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd"
		);
		for (Board b : list) {
			System.out.printf(
				"%d\t%s\t%s\t%s\t%d\n", 
				b.getNo(), b.getWriter(), b.getTitle(), sdf.format(b.getRegDate()), b.getViewCnt() 
			);
		}
		if (list.isEmpty()) {
			System.out.println("게시물이 존재하지 않습니다.");
		}
		System.out.println("-------------------------");
	}
}



