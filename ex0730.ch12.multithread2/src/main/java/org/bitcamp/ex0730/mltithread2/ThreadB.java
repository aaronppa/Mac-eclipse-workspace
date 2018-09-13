package org.bitcamp.ex0730.mltithread2;

public class ThreadB extends Thread{
	
	public boolean stop = false;
	public boolean work = true;
	
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("ThreadB Task: ");
			} else {
				Thread.yield();
			} // if-else
		
		} // while
		
		System.out.println("ThreadB Terminated");
		
	} // run method

} // class end
