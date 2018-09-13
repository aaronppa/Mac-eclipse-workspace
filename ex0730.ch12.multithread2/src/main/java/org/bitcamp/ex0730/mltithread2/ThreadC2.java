package org.bitcamp.ex0730.mltithread2;

public class ThreadC2 extends Thread{

	private WorkObject workObject;
	
	public ThreadC2(WorkObject workObject) {
		this.workObject = workObject;
		this.setName("Thread-C");
	} // constructor
	
	@Override
	public void run() {
		workObject.suspend(); // 처음시작은 무조건 waiting 상태로 만듦.
		
//		for(int i=0; i<10; i++) {
			workObject.methodC();
//		} // for
	} // run
	
} // end class