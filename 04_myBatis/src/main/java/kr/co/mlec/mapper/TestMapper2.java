package kr.co.mlec.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.domain.Member;
import kr.co.mlec.domain.Search;

// BoardDAO 의 역할.. -> SQL은 xml 파일로 빠져있다. 
 public interface TestMapper2 {

	Member selectMemberInfo1(String id) ;
	Member selectMemberInfo2(Member member);
	String selectMemberInfo3(String id);
	int selectMemberInfo4();
	List<Member> selectMemberList1();
	List<Member> selectMemberList2();
	List<String> selectMemberList3();
	List<Member> selectMemberIteratorList(Member param);
	List<Member> selectMemberIncludeList(String id);
	int selectMemberIncludeListCount(String id);
	List<Member> selectMemberSearchList(Search param);
	List<Member> selectMemberSearchList2(Member member);
	void insertMember(Member member);
	void deleteMember(String id);
	void updateMember(Member member);
	
	
} // end class








