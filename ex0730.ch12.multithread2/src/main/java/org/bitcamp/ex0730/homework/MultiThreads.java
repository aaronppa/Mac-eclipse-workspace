package org.bitcamp.ex0730.homework;



public class MultiThreads extends Thread{

	private WaitQ waitQueue = new WaitQ();
		
	public MultiThreads(String name) {
		this.setName(name);
	} // constructor
	
	@Override
	public void run() {

		waitQueue.waitQ();

	} // run method
	
} // end class
