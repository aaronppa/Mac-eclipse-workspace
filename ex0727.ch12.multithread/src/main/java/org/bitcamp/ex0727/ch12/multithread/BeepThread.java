package org.bitcamp.ex0727.ch12.multithread;
import java.awt.Toolkit;

public class BeepThread extends Thread{

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		for(int i=0; i<Integer.MAX_VALUE; i++) {
			toolkit.beep();


			Thread currThread = Thread.currentThread();
			String currThreadName = currThread.getName();
			System.out.println("\t- currThread: "+ currThreadName);

			try {Thread.sleep(1000);
			} catch (Exception e){}
		}
	}

}
