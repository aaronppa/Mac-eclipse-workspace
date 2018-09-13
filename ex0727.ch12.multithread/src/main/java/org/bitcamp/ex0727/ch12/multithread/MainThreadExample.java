package org.bitcamp.ex0727.ch12.multithread;

public class MainThreadExample {

	public static void main(String[] arg) {
 		Calculator calculator = new Calculator();

		
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	} // main
} // end class
