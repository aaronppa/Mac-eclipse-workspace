package kr.teamfive.repository.mapper;

import java.util.List;

import kr.teamfive.repository.domain.Board;
import kr.teamfive.repository.domain.Comment;
import kr.teamfive.repository.domain.FileAttach;

public interface BoardMapper {
	
	List<Board> selectBoard();
	void insertBoard(Board board); 
	Board selectBoardByNo(int no);
	void deleteContent(int no);
	void updateContent(Board board);
	void updateViewCnt(int no);
	List<FileAttach> selectFileAttach(int no);
	void insertFileAttach(FileAttach file);
	List<Comment> selectComments(int no);
	void insertComment(Comment comment);
	void updateComment(Comment comment);
	void deleteComment(int no);
	
} // end class
