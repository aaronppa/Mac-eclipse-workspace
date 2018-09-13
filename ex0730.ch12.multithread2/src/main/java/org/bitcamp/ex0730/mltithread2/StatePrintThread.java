package org.bitcamp.ex0730.mltithread2;

public class StatePrintThread extends Thread{
	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	} // constructor

	public void run() {
		MONITOR_EXIT: while(true) {
			Thread.State state = targetThread.getState();
			
			switch(state) {
			case NEW :
				System.out.println("Target Thread Status: "+state);
				targetThread.start();
				break;
			case RUNNABLE :
				System.out.println("Target Thread Status: "+state);
				break;
			case BLOCKED :
				System.out.println("Target Thread Status: "+state);
				break;
			case WAITING :
				System.out.println("Target Thread Status: "+state);
				break;
			case TIMED_WAITING :
				System.out.println("Target Thread Status: "+state);
				break;	
			case TERMINATED :
				System.out.println("Target Thread Status: "+state);
				break MONITOR_EXIT;
			}
			
//			System.out.println("Target Thread Status: "+state);
//			if(state==Thread.State.NEW) {
//				targetThread.start();
//			} // if
//
//			if(state==Thread.State.TERMINATED) {
//				break;
//			} // if

			try {
				//0.5 second pause
				Thread.sleep(10);
			} catch (Exception e) {}

		} // while

	} // run method


} // end class
