package PracticeBoard.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import BoardMapper.BoardMapper;
import PracticeBoard.Board;

public class ListBoardUI extends BaseUI{
	private BoardMapper mapper;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public ListBoardUI(BoardMapper mapper) {
		this.mapper = mapper;
	}

	public void service() {
		List<Board> list = mapper.selectBoard();
		System.out.printf("조회된 게시글: %d\n", list.size());
		System.out.println("--------------------------------------");
		System.out.println("글번호\t 제목\t 작성자\t 등록일\t 조회수");
		System.out.println("--------------------------------------");


		for(Board b:list) {
			System.out.printf(
					"%d\t %s\t %s\t %s\t %d\t\n",
					b.getNo(), b.getTitle(),b.getWriter(),sdf.format(b.getRegDate()), b.getViewCnt()
					);
		} // enhanced for

		if(list.isEmpty()) {
			System.out.println("게시글이 없습니다.");
		} 

	} // service()

} // end class
