package kr.teamfive.repository.domain;

import java.util.Date;
import java.util.List;

public class Board {
	private int no;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	private Date regDate;
	List<FileAttach> files;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public List<FileAttach> getFiles() {
		return files;
	}
	public void setFiles(List<FileAttach> files) {
		this.files = files;
	}
	
}