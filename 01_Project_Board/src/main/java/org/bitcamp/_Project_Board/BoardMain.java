package org.bitcamp._Project_Board;

import org.bitcamp.ui.BoardUI;

public class BoardMain {

	public static void main(String[] args) throws Exception{
		
		try {
			BoardUI board = new BoardUI();
			board.service();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
} // 
