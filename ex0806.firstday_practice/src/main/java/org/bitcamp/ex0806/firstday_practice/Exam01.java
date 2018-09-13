package org.bitcamp.ex0806.firstday_practice;

public class Exam01 {
		public static void main(String[] args) {
			Exam01 fn = new Exam01();
			
			long num = 228754462;
			System.out.println( "입력 숫자 = " + num);	
			System.out.println("2 횟수 => " + fn.countNumber(num, 2)); //3을 리턴
			System.out.println("4 횟수 => " + fn.countNumber(num, 4)); //2를 리턴
		}
		
		// 구현
		public int countNumber(long num, int i) {
			String val = String.valueOf(num);
			System.out.println(val);
			System.out.println(val.replaceAll("[" + val.replaceAll(i + "", "") + "]", "").length());
			return val.replaceAll("[" + val.replaceAll(i + "", "") + "]", "").length();

//			int count = 0;
//			char arrTemp = String.valueOf(i).charAt(0);
//			for (char data : String.valueOf(num).toCharArray()) {
//			    if (data == arrTemp) count++;
//			}
//			return count;
		}
	}