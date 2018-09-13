package kr.co.mlec.domain;

import java.util.Date;

public class Comment {
	private int commentNo;
	private int no;
	private String writer;
	private String content;
	private Date regDate;
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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
	
	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", no=" + no + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", toString()=" + super.toString() + "]";
	}
	
}
