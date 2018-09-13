package PracticeBoard;

import PracticeBoard.ui.BoardUI;

public class BoardMain {

	public static void main(String[] args) throws Exception{
		BoardUI board = new BoardUI();
		try {
			board.service();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
} // end class
