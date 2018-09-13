package org.bitcamp.ex0730.mltithread2;

public class StopFlagExample {

	public static void main(String[] args) {
		PrintThread1 printThread = new PrintThread1();
		printThread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			;;
		} // try-catch
		
		printThread.setStop(true);
		
	} // main
} // end class
