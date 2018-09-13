package org.bitcamp.ex0801.collection.list;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {

	public static void main(String[] args) {
//		List<String> list1 = Arrays.asList("홍길동","신용권","김자바");
		List<String> list1 = Arrays.asList(
				new String[] {"홍길동","신용권","김자바"}
				);
		
		String[] names = {"홍길동","신용권","김자바"};
		List<String> list3 = Arrays.asList(names);	
			
		
		for(String name: list1) {
			System.out.println(name);
			
		}
		
		List<Integer> list2 = Arrays.asList(1,2,3);
		for(int value: list2) {
			System.out.println(value);
		}
		
		for(String name: list3) {
			System.out.println(name);
			
		}
		
	} // main
} // end class
