package org.bitcamp.ex0726.ch14.lambda;

public class A_Won {

	public static void main(String... args) throws InterruptedException {
		// A Class를 상속받는 이름이 없는 익명의 자식객체(부모=A)를 
		// 생성하여 참조변수에 저장하고 이를 System.out.println()
		// 참조변수를 출력하세요.
	
		A_Won aa = new A_Won();
		
		A_Won a = new A_Won() {
			;;
		};
		System.out.println(a);
		System.out.println(aa);
		
//		while(true) {
//			System.out.println("Hello");
//			Thread.sleep(1000);
//		}
	
	} // main
	
} // end class
