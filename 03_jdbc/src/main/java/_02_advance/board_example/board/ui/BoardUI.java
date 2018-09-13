package _02_advance.board_example.board.ui;

import java.util.Scanner;

import _02_advance.board_example.board.dao.BoardDAO;

public class BoardUI {
	// 등록, 수정, 삭제, 조회 같이 하나의 객체를 사용해야 한다.
	private BoardDAO dao = new BoardDAO();
	private Scanner sc = new Scanner(System.in);
	public void service() throws Exception {
		BaseUI ui = null;
		while (true) {
			switch (menu()) {
			case 1: ui = new ListBoardUI(dao);   break;
			case 2: ui = new DetailBoardUI(dao); break;
			case 3: ui = new WriteBoardUI(dao);  break;
			case 4: ui = new UpdateBoardUI(dao); break;
			case 5: ui = new DeleteBoardUI(dao); break;
			case 0: quit();
			}
			ui.service();
		}
	}

	private void quit() {
		System.out.println("게시판 프로그램을 종료합니다.");
		// 프로그램 프로세스를 종료시킨다.
		System.exit(0);
	}

	private int menu() {
		System.out.println("-----------------");
		System.out.println("1. 전체 게시물 조회");
		System.out.println("2. 글번호 조회");
		System.out.println("3. 글등록");
		System.out.println("4. 글수정");
		System.out.println("5. 글삭제");
		System.out.println("0. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

}








