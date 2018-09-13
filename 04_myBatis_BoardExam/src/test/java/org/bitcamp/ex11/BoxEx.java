package org.bitcamp.ex11;

import junit.framework.TestCase;

public class BoxEx extends TestCase{

	public void testBoxEx() {
		Box<String> box = new Box<String>();
		
		box.set("홍길동");
		String str = (String) box.get();
		
		Box<Integer> box1 = new Box<Integer>();
		box1.set(6);
		int apple = box1.get();
	}
}
