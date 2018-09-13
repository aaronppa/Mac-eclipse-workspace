package org.bitcamp.ex11;

import junit.framework.TestCase;

public class StringBuilderEx extends TestCase{

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		String sql= "";
		sql += "SELECT";
		
		sb.append("Java ");
		sb.append("Program Study");
		System.out.println(sb.toString());
		
		sb.insert(4, "2");
		System.out.println(sb.toString());
		
		sb.setCharAt(4, '6');
		System.out.println(sb.toString());
		
		sb.replace(6,13,"Book");
		System.out.println(sb.toString());
		
		sb.delete(4, 5);
		System.out.println(sb.toString());
		
		int length = sb.length();
		System.out.println("Total Number of Character: "+length);
		
		String result = sb.toString();
		System.out.println(result);
	}
}
