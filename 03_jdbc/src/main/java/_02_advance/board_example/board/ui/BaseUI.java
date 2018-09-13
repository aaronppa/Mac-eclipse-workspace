// UI 클래스들의 부모 클래스
// Scanner 과 관련된 기능을 추가
package _02_advance.board_example.board.ui;

import java.util.Scanner;

public abstract class BaseUI {
	public Scanner sc = new Scanner(System.in);
	
	// service()의 다향성 구현 
	// 각각 상세 메뉴의 service()기능은 다름으로 상세 메뉴의 정의 된 service()로 작동 
	public abstract void service();
	
	// Update, WriteBoard에서 글내용 수정 및 입력시 사용되는 scanner 기능. 
	public String getStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	
	// delete , detail 에서 글 번호 선택으로 조회시 사용. 
	public int getInt(String msg) {
		System.out.print(msg);
		return Integer.parseInt(sc.nextLine());
	}
}













