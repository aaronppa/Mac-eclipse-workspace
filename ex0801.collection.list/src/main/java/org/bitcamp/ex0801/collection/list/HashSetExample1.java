package org.bitcamp.ex0801.collection.list;

import java.util.*;

public class HashSetExample1 {
	public static void main(String[] args) {
		
		// HashSet 에 저장할 원소는 String 객체로 지정 
		Set<String> set = new HashSet<String>();
		
		/* Set: 순서가 무의미하기 때문에, 인덱스 사용불가
		 * 		중복을 허용하지 않고, null도 하나만 허용 
		 *  Issue: 과연 구슬주머니에 있는 구슬과 새로이 넣을 
		 *  		구슬이 같은 구슬인지(즉, 두개의 객체가	
		 *  		같은지)의 기준이 필요함.
		 *  String: 이미 위의 고민거리가 해결된 클래스
		 *  		즉, Object 클래스의 hashCode(), equals()
		 *  		두개의 메소드를 오버라이딩하고 있음. 
		 */
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java"); // 중복 데이터는 엎어쳐짐...
		set.add("iBATIS");
		
		int size = set.size();
		System.out.println("총 객체수: " + size);
		

		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) { // .hasNext(): 현재 구슬주머니에 접근할 구슬이 추가로 있다면, true return,
			String element = iterator.next(); // .next() : 추가로 접근할 구슬객체(원소) 반환 
			System.out.println("\t" + element);
		}
		
//		for(String element : set) {
//			System.out.println("\t" + element);
//		}
		
		set.remove("JDBC");
		set.remove("iBATIS");
		
		System.out.println("총 객체수: " + set.size());
		
		for(String element : set) {
			System.out.println("\t" + element);
		}
		
		set.clear();		
		if(set.isEmpty()) { System.out.println("비어 있음"); }
	}
}

