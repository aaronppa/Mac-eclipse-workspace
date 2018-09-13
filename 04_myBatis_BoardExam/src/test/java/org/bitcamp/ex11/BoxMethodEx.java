package org.bitcamp.ex11;

import junit.framework.TestCase;

public class BoxMethodEx extends TestCase{

	public void testBoxingMethodEx() {
		Box<Integer> box1 = Util.<Integer>boxing(100);
		int intValue = box1.get();
		
		Box<String> box2 =  Util.boxing("최원영");
		String strValue = box2.get();
		
		System.out.println(intValue);
		System.out.println(strValue);
	}
}
