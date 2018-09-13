package PracticeBoard.ui;

import BoardMapper.BoardMapper;
import PracticeBoard.Board;

public class UpdateBoardUI extends BaseUI {
	private BoardMapper mapper;

	public UpdateBoardUI(BoardMapper mapper) {
		this.mapper = mapper;
	}

	public void service() {
		Board b = new Board();
			int no = getInt("수정하실 글 번호를 입력하세요:");
			b = mapper.selectBoardbyNo(no);
			if(b==null) {
				System.out.println("수정할 글이 존재하지 않습니다.");				
			} else {
				b.setNo(no);
				b.setTitle(getStr("제목 수정:"));
				b.setContent(getStr("내용 수정:"));
				int cnt = mapper.updateBoard(b);	
				System.out.println(cnt+"개의 글이 수정되었습니다.");
			}

	}
} // end class
