package kr.co.mlec.test;

import java.util.List;

import common.db.MyAppSqlConfig;
import kr.co.mlec.domain.Board;
import kr.co.mlec.domain.Comment;
import kr.co.mlec.domain.Member;
import kr.co.mlec.mapper.TestMapper3;

public class Test3 {
	private TestMapper3 mapper;
	
	public Test3() {
		mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(TestMapper3.class);
	}

	public void test01() {
		/* 별도의 리스트를 활용하는 것은 비추천 (X)
		List<Member> list = mapper.selectMemberList();
		List<Account> accList = new ArrayList<>();
		for (Member m:list) {
			Account account = mapper.selectAccountById(m.getId());
			accList.add(account);
		}
		*/ 
		/* 이방법도 myBatis에서 제공하는 기능으로 변경하는 것을 추천!!!!!!
		List<Member> list = mapper.selectMemberList();
		for(Member m: list) {
			m.setAccount(mapper.selectAccountById(m.getId()));
		}
		*/
		// myBatis association 활용!!!!!
		List<Member> list = mapper.selectMemberList();
		System.out.println(list);
	}
	
	// insert 실행시 selectKey Tag 사용하기 
	public void test02() {
		// s_board_no.nextVal
//		int no = s_board_no.nextVal의 값을 저장 
//		int no = mapper.selectSeq(); // 예전 myBatis 이전의 방식 
		
		// tb_mybatis_board 테이블에 데이터를 추가한다. 
//		Board board = new Board();
//		board.setNo(no);
//		board.setWriter("Tester");
//		board.setTitle("Practice");
//		board.setContent("Getting Board_no");
//		mapper.insertBoard1(board);
		
		// myBatis 사용 예 
		Board board = new Board();
		board.setWriter("Tester");
		board.setTitle("Practice");
		board.setContent("Getting Board_no");
		mapper.insertBoard2(board);
		
		int no = board.getNo();
		System.out.println("입력된 시퀀스 글번호: "+ no);
		// b_mybatis_file 테이블에 데이터를 추가한다.
		Comment comment = new Comment();
		comment.setNo(no); // 댓글의 게시물 번호 
		comment.setWriter("sbc");
		comment.setContent("댓글 입니다.");
		mapper.insertComment(comment);
		System.out.println("댓글이 등록되었습니다.");
		/*
		 *	file_no, no(board_no), file_size, file_org_name, file_system_name
		 * 
		 */
	}
	
	// Collection Tag
	public void test03() {
		List<Board> list = mapper.selectBoardList();
		System.out.println(list);
	}
	
	public static void main(String[] args) {
	try {
		Test3 t = new Test3();
//		t.test01();	
//		t.test02();	
		t.test03();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










