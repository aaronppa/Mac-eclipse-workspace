package org.bitcamp.ex0806.firstday_practice;

import java.util.Arrays;

public class Problem1 {
//	문제 1.
//	주어진 숫자(number)에서 지정된 숫자(i)를 찾는 Exam01 클래스 입니다. 입력값에 따라 다음과 같은 출력이 나오도록, 해당 int 의 개수를 리턴하는 countNumber 메소드를 작성하시오
	

	public static void main(String[] args) {
	Problem1 ex01 = new Problem1();
	long number = 228754462;
	System.out.println( "입력 숫자 = " + number );
	System.out.println("2 횟수 => " + ex01.countNumber(number, 2));//3을 리턴 System.out.println("4 횟수 => " + ex01.countNumber(number, 4));//2를 리턴
	}
	/* 이곳에 countNumber 메소드를 작성하십시오. */ 

	public int countNumber(long number, int selectNumber) {
	int count=0;
	String num = String.valueOf(number);
	char[] array = num.toCharArray();
	System.out.println(Arrays.toString(array));
		
	for(int i=0;i<=array.length-1;i++) {
		if(array[i]==selectNumber) {
			count++;
		}
	}
	return count;
	} // end method
	
} // end class
//	출력결과>
//	입력 숫자 = 228754462 2 횟수 => 3
//	4 횟수 => 2