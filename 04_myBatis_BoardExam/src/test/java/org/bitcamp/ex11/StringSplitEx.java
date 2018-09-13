package org.bitcamp.ex11;

import junit.framework.TestCase;

public class StringSplitEx extends TestCase{

	public void testStringSplitEx() {
		String text = "Won&Kyle,Stiles,Kevin-Diyah";
		String[] names = text.split("&|,|-");
		
		for(String name: names) {
			System.out.println(name);
		}
	}
}
