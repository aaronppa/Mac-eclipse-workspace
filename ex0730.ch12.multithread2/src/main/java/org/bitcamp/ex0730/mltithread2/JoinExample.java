package org.bitcamp.ex0730.mltithread2;

public class JoinExample {

	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.setName("sumThread");
		sumThread.start();
		
		try {
			sumThread.join();
		} catch (InterruptedException e) {
	;;
		}
		
		System.out.println("sum of 1~100: "+sumThread.getSum());
		
	} // main

} // end class
