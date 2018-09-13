package board.vo;

import java.util.Date;

public class Board {
	private int no;
	private int viewCnt;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	
	public Board() {
		super();
	}
	public Board(int no, int viewCnt, String title, String content, String writer, Date regDate) {
		super();
		this.no = no;
		this.viewCnt = viewCnt;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Board [no=" + no + ", viewCnt=" + viewCnt + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", regDate=" + regDate + "]";
	}

}









