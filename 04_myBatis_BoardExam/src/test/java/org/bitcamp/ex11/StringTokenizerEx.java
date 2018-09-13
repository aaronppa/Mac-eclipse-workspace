package org.bitcamp.ex11;

import java.util.StringTokenizer;

import junit.framework.TestCase;

public class StringTokenizerEx extends TestCase{

	public void testStringTokenizerEx() {
		String text = "Won/Stiles/Kyle";
		
		// method 1: get total number of token and run on for loop
		StringTokenizer st = new StringTokenizer(text, "/");
		int countTokens = st.countTokens();
		for(int i=0; i<countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		System.out.println("");;
		
		//method2: identify the remaining token and run in while loop
		
		st = new StringTokenizer(text,"/");
		while(st.hasMoreTokens()) {
			String token=st.nextToken();
			System.out.println(token);
		}
		
		
	}
} // end class
