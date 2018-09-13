package org.bitcamp.ex0730.mltithread2;

public class WorkObject {

	public synchronized void suspend() {
		String threadName = 
				Thread.currentThread().getName()+", "+
						Thread.currentThread().getId();
		try {
			System.out.println("\t.0 ("+threadName+") wait() invoked in suspend().");

			wait();

			System.out.println("\t.0 ("+threadName+") waked up from wait() in suspend().");
		} catch (InterruptedException e) {
			System.out.println("\t.0 ("+threadName+") interrupted.");
		} // try-catch
	} // suspend method

	public synchronized void methodA() {
		String threadName = 
				Thread.currentThread().getName()+", "+
						Thread.currentThread().getId();

		System.out.println("- ("+threadName+") WorkObject::methodA waked up from wait() in suspend().");

		notify();
		System.out.println("\t.1 ("+threadName+") notify() invoked.");

		try {
			System.out.println("\t.2 ("+threadName+") wait() invoked().");
			wait();
			System.out.println("\t.3 ("+threadName+") waked up from wait().");
		} catch (InterruptedException e) {
			System.out.println("\t.4 ("+threadName+") interrupted");
		}

//		System.out.println("\t.4 ("+threadName+") finished.");
//		notify();
		
	} //methodA

	public synchronized void methodB() {
		String threadName = 
				Thread.currentThread().getName()+", "+
						Thread.currentThread().getId();

		System.out.println("- ("+threadName+") WorkObject::methodB waked up from wait() in suspend().");

		notify();
		System.out.println("\t.1 ("+threadName+") notify() invoked.");

		try {
			System.out.println("\t.2 ("+threadName+") wait() invoked().");
			wait();
			System.out.println("\t.3 ("+threadName+") waked up from wait().");
		} catch (InterruptedException e) {
			System.out.println("\t.4 ("+threadName+") interrupted");
		} // try-catch
//		System.out.println("\t.4 ("+threadName+") finished.");
//		notify();
	} // methodB

	public synchronized void methodC() {
		String threadName = 
				Thread.currentThread().getName()+", "+
						Thread.currentThread().getId();

		System.out.println("- ("+threadName+") WorkObject::methodC waked up from wait() in suspend().");

		notify();
		System.out.println("\t.1 ("+threadName+") notify() invoked.");

		try {
			System.out.println("\t.2 ("+threadName+") wait() invoked().");
			wait();
			System.out.println("\t.3 ("+threadName+") waked up from wait().");
		} catch (InterruptedException e) {
			System.out.println("\t.4 ("+threadName+") interrupted");
		} // try-catch
		
		System.out.println("\t.4 ("+threadName+") finished.");
//		notify();
		System.exit(0);
	} // methodC

} // end class
