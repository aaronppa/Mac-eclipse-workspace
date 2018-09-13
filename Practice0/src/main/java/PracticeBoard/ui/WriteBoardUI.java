package PracticeBoard.ui;

import BoardMapper.BoardMapper;
import PracticeBoard.Board;

public class WriteBoardUI extends BaseUI{
	private BoardMapper mapper;
	
	public WriteBoardUI(BoardMapper mapper) {
		this.mapper = mapper;
	} // constructor
	
	public void service() {
		Board b = new Board();
		b.setWriter(getStr("작성자를 입력하세요:"));
		b.setTitle(getStr("제목을 입력하세요:"));
		b.setContent(getStr("내용을 입력하세요:"));
		mapper.insertBoard(b);
		
		System.out.println("작성하신 글이 등록되었습니다.");
	}
} // end class
