package org.bitcamp.ex0730.mltithread2;

public class InterruptExample {

	public static void main(String[] args) {
		Thread thread = new PrintThread2();
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		;;
		} // try-catch
		
		thread.interrupt();
		
	} // main
	
} // end class
