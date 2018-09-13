package org.bitcamp.ex0802.ch15.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample1 {
	public static void main(String[] args) {
		// Map은 Key의 중복을 허용하지 않아나, 값은 중복 허용함 
		// Map은 Key와 값을 묶은 Map.Entry 객체를 만들어 저장 
		
		//Map 컬렉션 생성 (key type: String, value type: Integer)
		Map<String, Integer> map = new HashMap<>();
		
		//객체 저장
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		System.out.println("총 Entry 수: " + map.size());
		System.out.println();
		
		//객체 찾기	
		System.out.println("객체 찾기:");
		System.out.println("\t홍길동 : " + map.get("홍길동"));
//		System.out.println("\t"+map.get(95)+": "+"홍길동"); //반대로는 안됌.. 
		System.out.println();
		
		//객체를 하나씩 처리
		//Map에서 Key객체만 모아서 Set으로 반환 
		Set<String> keySet = map.keySet();
		
		//Set에서 반복자(Iterator)를 얻어옴 
		Iterator<String> keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()) {
		  String key = keyIterator.next();
		  Integer value = map.get(key);
		  System.out.println("\t" + key + " : " + value);
		} // while loop
		
		System.out.println();	
		
		//객체 삭제
		map.remove("홍길동");
		System.out.println("총 Entry 수: " + map.size());
		
		//객체를 하나씩 처리
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
		  Map.Entry<String, Integer> entry = entryIterator.next();
		  String key = entry.getKey();
		  Integer value = entry.getValue();
		  System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		//객체 전체 삭제
		map.clear();
		System.out.println("총 Entry 수: " + map.size());
	}
}