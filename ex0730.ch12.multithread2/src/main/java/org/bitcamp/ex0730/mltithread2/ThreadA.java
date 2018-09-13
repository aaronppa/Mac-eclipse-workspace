package org.bitcamp.ex0730.mltithread2;

public class ThreadA extends Thread{
	
	public boolean stop = false;
	public boolean work = true;
	
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("ThreadA Task: ");
			} else {
				Thread.yield();
			} // if-else
		
		} // while
		
		System.out.println("ThreadA Terminated");
		
	} // run method

} // class end
