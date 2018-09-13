package org.bitcamp.ex0730.mltithread2;

public class WaitNotifyExample {

	public static void main(String[] args) {
		WorkObject sharedObject = new WorkObject();
		
		ThreadA2 threadA2 = new ThreadA2(sharedObject);
		ThreadB2 threadB2 = new ThreadB2(sharedObject);
		ThreadC2 threadC2 = new ThreadC2(sharedObject);
		
		threadA2.start();
		threadB2.start();
		threadC2.start();
		
		try {
		Thread.sleep(1000*1);	
		
		threadC2.interrupt(); // ThreadC2를 강제로 깨움. 
		} catch(InterruptedException e) {;;}
	
	/*------------------------------------------------------------------------------------------------------*/
		
		
	} // main
} // end class
