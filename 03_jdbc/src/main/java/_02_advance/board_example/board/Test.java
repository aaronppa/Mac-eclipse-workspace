package _02_advance.board_example.board;

import _02_advance.board_example.board.ui.BoardUI;

public class Test {
	public static void main(String[] args) {
		try {
			BoardUI ui = new BoardUI();
			ui.service();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
