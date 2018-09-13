package org.bitcamp.ex0730.homework;

public class WaitQ {
	
	public synchronized void waitQ() {
		String threadName = 
				Thread.currentThread().getName();
		try {
			System.out.println("\t ("+threadName+") wait() invoked in suspend().");

			wait();

			System.out.println("\t ("+threadName+") waked up from wait() in suspend().");
		} catch (InterruptedException e) {
			System.out.println("\t ("+threadName+") interrupted then invoked.");
			
		} // try-catch
		
	} // suspend method
	
} // end class
