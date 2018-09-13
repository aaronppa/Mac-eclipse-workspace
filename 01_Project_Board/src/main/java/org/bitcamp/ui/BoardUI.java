package org.bitcamp.ui;

import java.util.Scanner;

import org.bitcamp._Project_Board.BoardDAO;

public class BoardUI {
	
	public BoardUI() {
		super();
		// TODO Auto-generated constructor stub
	}

	Scanner sc = new Scanner(System.in);
	
	public void service() {
		BoardDAO dao = new BoardDAO();
		BaseUI ui=null;
		
		while(true) {
			switch(menu()) {
			case 1 : ui = new ListBoardUI(dao) ; break;
			case 2 : ui = new DetailBoardUI(dao); break;
			case 3 : ui = new WriteBoardUI(dao); break;
			case 4 : ui = new UpdateBoardUI(dao); break;
			case 5 : ui = new DeleteBoardUI(dao); break;
			case 0 : quit();
			
			} // switch
			ui.service();
		} // while 
	} // service()
	
	public void quit() {
		System.out.println("게시판 프로그램을 종료합니다.");
		System.exit(0);
	}
	
	public int menu() {
		System.out.println("--------------------------------------");
		System.out.println("1. 전체 게시글 조회");
		System.out.println("2. 상세 게시글 조회");
		System.out.println("3. 게시글 등록");
		System.out.println("4. 게시글 수정");
		System.out.println("5. 게시글 삭제");
		System.out.println("0. 게시판 프로그램 종료");
		System.out.println("--------------------------------------");
		System.out.println("메뉴를 선택하세요: ");
		return Integer.parseInt(sc.nextLine());		
		
	} // main
	
}
