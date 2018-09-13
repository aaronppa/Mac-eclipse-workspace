package PracticeBoard;

import java.util.Date;

public class Board {
	int no;
	String writer;
	String title;
	String content;
	Date regDate;
	int viewCnt;
	
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Board(int no, String writer, String title, String content, Date regDate, int viewCnt) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getViewCnt() {
		return viewCnt;
	}


	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
	
} // end class
