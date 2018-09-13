package org.bitcamp.ex0730.mltithread2;

public class ThreadA2 extends Thread{

	private WorkObject workObject;
	
	public ThreadA2(WorkObject workObject) {
		this.workObject = workObject;
		this.setName("Thread-A");
	} // constructor
	
	@Override
	public void run() {
		workObject.suspend(); // 처음시작은 무조건 waiting 상태로 만듦. 
		
//		for(int i=0; i<10; i++) {
			workObject.methodA();
//		} // for
	} // run
	
} // end class
