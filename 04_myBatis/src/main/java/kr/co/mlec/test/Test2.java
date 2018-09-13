package kr.co.mlec.test;

import java.util.List;

import common.db.MyAppSqlConfig;
import kr.co.mlec.domain.Member;
import kr.co.mlec.domain.Search;
import kr.co.mlec.mapper.TestMapper2;

public class Test2 {
	
	private TestMapper2 mapper;
	
	public Test2() {
		//mybatis를 이용한 인페이스 구현 객체 얻어오기 
		mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(TestMapper2.class);
	}
	// 데이터를 조회하기 : 하나의 로우를 반환
	private void test01() {
		Member member = mapper.selectMemberInfo1("member-4");
		System.out.println(member.getId());
		System.out.println(member.getName());
		System.out.println(member.getEmail());
		System.out.println(member.getAddr());
	}
	
	private void test00() {
		Member param = new Member();
		param.setId("member-4");
		param.setName("spring");
		Member member = mapper.selectMemberInfo2(param);
		System.out.println(member.getId());
		System.out.println(member.getName());
		System.out.println(member.getEmail());
		System.out.println(member.getAddr());
	}
	
	private void test0() {
		String name = mapper.selectMemberInfo3("member-4");
		System.out.println(name);
	}
	
	private void test() {
		System.out.println("count: " + mapper.selectMemberInfo4());
	}
	
	// 여러개의 로우를 결과로 받기
	private void test02() { 
//		List<Member> list = mapper.selectMemberList1();
		List<Member> list = mapper.selectMemberList2();
		for(Member m:list) {
			System.out.println("ID: "+m.getId());
			System.out.println("name: "+m.getName());
			System.out.println("addr: "+m.getAddr());
			System.out.println("email: "+m.getEmail());
			System.out.println("join date: "+m.getJoinDate());
		}
	}
	
	private void test03() { 
		List<String> list = mapper.selectMemberList3();
		for(String m:list) {
			System.out.println("name: "+m);
		}
	}

	// 회원 등록
	private void insertMember() {
		Member member = new Member();
		member.setId("member-5");
		member.setName("홍길동");
		member.setAddr("동굴");
		member.setEmail("hong@a.com");
		mapper.insertMember(member);
	}
	
	// 회원 수정
	private void updateMember()  {
		Member member = new Member();
		member.setId("member-5");;
		member.setName("길동홍");
		mapper.updateMember(member);
	}
	
	// 회원 삭제
	private void deleteMember() {
		mapper.deleteMember("member-5");
	}
	
	// 동적 쿼리 처리방식
	private void dynamicSearch() {
		Member param = new Member();
		param.setAddrs(new String[] {"busan", "seoul"});
		List<Member> list = mapper.selectMemberIteratorList(param);
		for (Member m: list) {
			System.out.println("name: "+m.getName());
			System.out.println("addr: "+m.getAddr());
		}
	}
	
	private void dynamicSearch1() {
		int cnt = mapper.selectMemberIncludeListCount("member-1");
		System.out.println("전체: "+cnt);
		List<Member> list = mapper.selectMemberIncludeList("member-1");
		for (Member m: list) {
			System.out.println("name: "+m.getName());
			System.out.println("addr: "+m.getAddr());
		}
	}
	
	private void dynamicSearch2() {
		Search param = new Search();
		param.setSearchType("id"); // 검색항목으로 아이디를 선택한 경우 
		param.setSearchType("name");  
		param.setSearchWord("s");
		List<Member> list = mapper.selectMemberSearchList(param);
		for (Member m: list) {
			System.out.println("name: "+m.getName());
			System.out.println("addr: "+m.getAddr());
		}
	}
	
	private void dynamicSearch3() {
		Member param = new Member();
		param.setId("member-1");  
		param.setName("sbc"); // 검색항목으로 아이디를 선택한 경우 
//		param.setSearchWord("s");
		List<Member> list = mapper.selectMemberSearchList2(param);
		for (Member m: list) {
			System.out.println("name: "+m.getName());
			System.out.println("addr: "+m.getAddr());
		}
	}
	
	
	public static void main(String[] args) {
		try {
			Test2 mt = new Test2();
//			mt.insertMember();
//			mt.updateMember();
//			mt.deleteMember();
//			mt.test01();
//			mt.test00();
//			mt.test0();
//			mt.test();
//			mt.test02();
//			mt.test03();
//			mt.dynamicSearch();
//			mt.dynamicSearch1();
//			mt.dynamicSearch2();
			mt.dynamicSearch3();
			System.out.println("successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










