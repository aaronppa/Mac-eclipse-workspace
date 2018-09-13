package org.bitcamp.ex0801.collection.list;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {

	public static void main(String... args) {
		Set<Member> set = new HashSet<Member>();
		
		/* Set 객체는 중복을 허용하지 않음
		 * 과연 아래 두개의 멤버 객체는 동일할까???
		 * 과연 두개의 멤버 객체의 동일하단 기준은 무엇으로 할까??
		 * 아래처럼, 이름과 나이가 같으면 같은 객체로 간주할까?
		 * 나름의 기준을 세워야
		 */
		set.add(new Member("홍길동",30));
		set.add(new Member("홍길동",30));
		
		System.out.println("총 객체수: "+ set.size());
	} // main
} // end class
