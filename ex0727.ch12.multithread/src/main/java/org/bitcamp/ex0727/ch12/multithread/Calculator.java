package org.bitcamp.ex0727.ch12.multithread;

public class Calculator {

	private int memory;

	public int getMemory() {
		return memory;
	}

	public /* synchronized */ void setMemory(int memory) {


		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {}

		synchronized(this) {
			this.memory = memory;
			System.out.println(Thread.currentThread().getName() + ": "+this.memory);
		}
	}
} // end class
