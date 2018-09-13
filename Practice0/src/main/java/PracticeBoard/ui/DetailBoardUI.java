package PracticeBoard.ui;

import BoardMapper.BoardMapper;
import PracticeBoard.Board;

public class DetailBoardUI extends BaseUI{
	private BoardMapper mapper;
	
	public DetailBoardUI(BoardMapper mapper) {
		this.mapper = mapper;
	}
	
	public void service() {
		int no = getInt("조회할 글번호를 입력하세요: ");
		Board b = mapper.selectBoardbyNo(no);
		try {
		if(b!=null) {
		mapper.updateViewCnt(no);
		System.out.println("글번호: "+b.getNo());
		System.out.println("등록일: "+b.getRegDate());
		System.out.println("작성자: "+b.getWriter());
		System.out.println("제목: "+b.getTitle());
		System.out.println("내용: "+b.getContent());
		System.out.println("조회수: "+b.getViewCnt());
		}
		} catch (Exception e) {
			System.out.println("조회 하신 글이 존재하지 않습니다.");
		}
	}
} // end class
