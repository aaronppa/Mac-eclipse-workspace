package org.bitcamp.ex0802.ch15.collection;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExample {

	public static void main(String[] args) {
		// 실무에서는 대부분이 Hashtable을 가장 많이 사용함.
		// Map 자료구조 생성(Key Type: String, value type: String) 
		Map<String, String> map = new Hashtable<>();
		
		// Map data structure(Hashtable)에 Key/Value 쌍의 항목 추가 
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디와 비밀번호를 입력해주세요.");
			System.out.println("아이디: ");
			String id = scanner.nextLine();
			
			System.out.println("비밀번호: ");
			String password = scanner.nextLine();
			System.out.println();
			
			if(map.containsKey(id)) {
				if(map.get(id).equals(password)) {
					System.out.println("로그인 되었습니다.");
					break;
					
				} else {
					System.out.println("비밀번호가 일치하지 않습니다. ");
					
				}
			} else {
				System.out.println("입력하신 아이디가 존재하지 않습니다.");
				
			} // if-else-else
		} // while loop
	} // main
	
} // end class
