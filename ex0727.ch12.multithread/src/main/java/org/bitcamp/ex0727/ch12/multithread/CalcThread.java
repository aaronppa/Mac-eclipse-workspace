package org.bitcamp.ex0727.ch12.multithread;

public class CalcThread extends Thread{

	public CalcThread(String name) {
		setName(name);
	} // constructor
	

	public void run() {
		for(int i=0; i<2000000000;i++) {
			
		}
		
		System.out.println(getName());
	} // run method
	
} // end class
