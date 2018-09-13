package PracticeBoard.ui;

import BoardMapper.BoardMapper;

public class DeleteBoardUI extends BaseUI {
	private BoardMapper mapper;

	public DeleteBoardUI(BoardMapper mapper) {
		this.mapper = mapper;
	}

	public void service() {
		
		int no = getInt("삭제하실 글 번호를 입력하세요: ");
		int cnt = mapper.deleteBoard(no);
		if(cnt==0) {
			System.out.println("삭제하실 행이 존재하시 않습니다.");
			
		} else {
		System.out.println(cnt+"개의 행이 삭제되었습니다.");
		}
	}
}