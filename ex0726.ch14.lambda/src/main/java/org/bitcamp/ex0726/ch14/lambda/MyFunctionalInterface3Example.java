package org.bitcamp.ex0726.ch14.lambda;

import junit.framework.TestCase;

public class MyFunctionalInterface3Example extends TestCase{

	public void testMyFunctionalInterface3Example() {
		MyFunctionalInterface3 fi;
		
		//-----------------------------------------//
		fi = (x,y) -> {
			int result = x+y;
			return result;
		};
		System.out.println(fi.method(2, 5));
	
		//-----------------------------------------//
		// 
		fi = (x,y) -> {return x+y;};
		System.out.println(fi.method(2, 5));
		
		//-----------------------------------------//
		// ??? return??
		fi = (x,y) -> x+y;
		System.out.println(fi.method(2,5));
		
		//-----------------------------------------//
		fi = (x,y) -> sum(x,y);
		System.out.println(fi.method(2, 5));
		
		
		
	} // test method
	
	public static int sum(int x, int y) {
		return (x+y);
	}
	
} // end class
