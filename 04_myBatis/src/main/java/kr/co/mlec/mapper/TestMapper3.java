package kr.co.mlec.mapper;

import java.util.List;

import kr.co.mlec.domain.Account;
import kr.co.mlec.domain.Board;
import kr.co.mlec.domain.Comment;
import kr.co.mlec.domain.Member;

public interface TestMapper3 {
	 List<Member> selectMemberList();
	 Account selectAccountById(String id);
	 
	 //게시글의 시퀀스 번호를 추출
	 int selectSeq();
	 void insertBoard1(Board board);
	 void insertBoard2(Board board); //selectKey
	 void insertComment(Comment comment);
	 List<Board> selectBoardList();
	 
} // end class








