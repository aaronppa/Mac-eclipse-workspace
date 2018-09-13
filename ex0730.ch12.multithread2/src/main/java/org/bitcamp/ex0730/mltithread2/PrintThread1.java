package org.bitcamp.ex0730.mltithread2;

public class PrintThread1 extends Thread{

	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	} //setStop
	
	public void run() {
		while(!stop) {
			System.out.println("Running");
		} // while
		
		System.out.println("Resources being cleaned up");
		System.out.println("Terminating");
	} // run
	
} // end class
