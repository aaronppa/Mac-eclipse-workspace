package kr.co.mlec.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.domain.Member;
import kr.co.mlec.domain.Search;

// BoardDAO 의 역할.. -> SQL은 xml 파일로 빠져있다. 
public class TestMapper1 {
	
	// myBatis를 사용할 수 있게 하는 API 클래스...
	private static SqlSession session;
	private static final String NS="kr.co.mlec.mapper.TestMapper1.";
	
	public TestMapper1() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		System.out.println("SqlSession: "+session);
	}
	
	// method name & id from mapper.xml must be same.
	// session.method("statement",parameter)에서 "statement"는 mapper xml의 namespace를 가르키며, mapper xml내 id와 연결한다. 
	public Member selectMemberInfo1(String id) {
		return session.selectOne(NS+"selectMemberInfo1", id);
		
	}
	
	public Member selectMemberInfo2(Member member) {
		return session.selectOne(NS+"selectMemberInfo2", member);
	}
	
	public String selectMemberInfo3(String id) {
		return session.selectOne(NS+"selectMemberInfo3", id);
	}
	
	public int selectMemberInfo4() {
		return session.selectOne(NS+"selectMemberInfo4");
	}
	
	public List<Member> selectMemberList1() {
		return session.selectList(NS+"selectMemberList1");
	}
	
	public List<Member> selectMemberList2() {
		return session.selectList(NS+"selectMemberList2");
	}
	
	public List<String> selectMemberList3() {
		return session.selectList(NS+"selectMemberList3");
	}
	
	public List<Member> selectMemberIteratorList(Member param) {
		return session.selectList(NS+"selectMemberIteratorList", param);
	}
	
	public List<Member> selectMemberIncludeList(String id){
		return session.selectList(NS+"selectMemberIncludeList", id);
	}
	
	public int selectMemberIncludeListCount(String id){
		return session.selectOne(NS+"selectMemberIncludeListCount", id);
	}
	
	public List<Member> selectMemberSearchList(Search param){
		return session.selectList(NS+"selectMemberSearchList", param);
	}
	
	public List<Member> selectMemberSearchList2(Member member){
		return session.selectList(NS+"selectMemberSearchList2", member);
	}
	
	public void insertMember(Member member) {
//		session.insert(getClass().getName()+".insertMember", member); // 1번째 방법 
//		session.insert("kr.co.mlec.mapper.TestMapper1.insertMember", member); // 2번쨰 방법 
		session.insert(NS+"insertMember", member); // 보편화된 방법 
		
	}
	
	public void deleteMember(String id) {
//		session.delete(getClass().getName()+".deleteMember", member); // 1번째 방법 
//		session.delete("kr.co.mlec.mapper.TestMapper1.deleteMember", member); // 2번쨰 방법 
		session.delete(NS+"deleteMember", id);
	}
	
	public void updateMember(Member member) {
//		session.update(getClass().getName()+".updateMember", member); // 1번째 방법 
//		session.update("kr.co.mlec.mapper.TestMapper1.updateMember", member); // 2번쨰 방법 
		session.update(NS+"updateMember", member);
	}
	
	
} // end class








