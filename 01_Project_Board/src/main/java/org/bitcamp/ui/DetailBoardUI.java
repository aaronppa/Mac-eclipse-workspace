package org.bitcamp.ui;

import java.text.SimpleDateFormat;

import org.bitcamp._Project_Board.Board;
import org.bitcamp._Project_Board.BoardDAO;

public class DetailBoardUI extends BaseUI{
	BoardDAO dao;
	
	public DetailBoardUI(BoardDAO dao) {
		this.dao = dao;
	} // constructor
	
	public void service() {
		int cnt=0;
		int no = getInt("조회할 글 번호를 입력하세요: ");
		Board board = dao.selectBoardbyNo(no);
		cnt = dao.viewCount(no);
		
		if(cnt==0) {
			System.out.println("조회하신 글이 없습니다.");
		} else {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("글번호: "+no);
		System.out.println("등록일시: "+sdf.format(board.getRegDate()));
		System.out.println("조회수: "+board.getViewCnt());
		System.out.println("작성자: "+board.getWriter());
		System.out.println("제목: "+board.getTitle());
		System.out.println("내용: "+board.getContent());
		}
		
	}
	
	
} // end class
