package org.bitcamp.ex0801.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class LinkedListExample {
	public static void main(String... args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i=0; i<1000000; i++) {
			list1.add(0, String.valueOf(i));
		} // for

		endTime = System.nanoTime();
		System.out.println("ArrayList Elapsed Time: "+(endTime-startTime)/Math.pow(10.0, 9)+" s");
	
		startTime = System.nanoTime();
		for(int i=0; i<1000000; i++) {
			list2.add(0, String.valueOf(i));
		} // for
		
		endTime = System.nanoTime();
		System.out.println("LinkedList Elapsed Time: "+(endTime-startTime)/Math.pow(10.0, 9)+" s");
		
	} // main
	
} // end class
