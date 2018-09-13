package PracticeBoard.ui;

import java.util.Scanner;

import BoardMapper.BoardMapper;
import common.db.MyAppSqlConfig;

public class BoardUI {
	private BoardMapper mapper;
	
	public BoardUI(){
		this.mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardMapper.class);
	}
	
	BaseUI ui = null;
	Scanner sc = new Scanner(System.in);
	
	public void service() throws Exception{
		while(true) {

			switch(menu()) {
			case 1: ui = new ListBoardUI(mapper); break;
			case 2: ui = new DetailBoardUI(mapper); break;
			case 3: ui = new WriteBoardUI(mapper); break;
			case 4: ui = new UpdateBoardUI(mapper); break;
			case 5: ui = new DeleteBoardUI(mapper); break;
			case 0: quit();
			} // switch
			ui.service();
		} // while

	}
	
	private int menu() {
		
		System.out.println("-----------------------------------------------");
		System.out.println("1. 전체글 조회");
		System.out.println("2. 상세 글 조회");
		System.out.println("3. 게시글 등록");
		System.out.println("4. 게시글 수정");
		System.out.println("5. 게시글 삭제");
		System.out.println("0. 게시판 프로그램 종료");
		System.out.println("-----------------------------------------------");
		System.out.println("게시판 메뉴의 번호를 입력하세요: ");
		int x = Integer.parseInt(sc.nextLine());
		return x;
	}

	public void quit() {
		System.out.println("게시판 프로그램을 종료합니다.");
		System.exit(0);
		sc.close();
	}
} // end class
