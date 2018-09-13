package org.bitcamp.ex0730.mltithread2;

public class PrintThread2 extends Thread{

	public void run() {
		// how.1
//		try {
//			while(true) {
//				System.out.println("Running");
//
//				Thread.sleep(1);
//			} // while
//		} catch(InterruptedException e) {;;}

		//how.2
		while(true) {
			System.out.println("Running");

			if(Thread.interrupted()) {
				break;
			} // if
		} // while
		
		System.out.println("Resources being cleaned up");
		System.out.println("Terminating");
		
	} // run
	
} // end class
