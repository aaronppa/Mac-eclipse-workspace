package org.bitcamp.ex0727.ch12.multithread;

import java.awt.Toolkit;

public class BeepPrintExample2 {

	public static void main(String[] args) {
//		//how1 - instantiating new BeepTask class to invoke run() method in the class object
//		Runnable beepTask = new BeepTask();
//		Thread thread = new Thread(beepTask);
//		thread.setName("BeepTask"); ///set the name for the specific thread

		//how2 - 
//		Thread thread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				Toolkit toolkit = Toolkit.getDefaultToolkit();
//
//				for(int i=0; i<5; i++) {
//					toolkit.beep();
//
//					try {Thread.sleep(500);
//					} catch (Exception e){}
//				}
//			}
//		});

		//how3
		Thread thread = new Thread(() -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();

			for(int i=0; i<5; i++) {
				toolkit.beep();
				
				Thread currThread = Thread.currentThread();
				String currThreadName = currThread.getName();
				System.out.println("\t- currThread: "+ currThreadName);
				
				try {Thread.sleep(1000);
				} catch (Exception e){}
			}
		});
		thread.setName("BeepBeep");
		
		thread.start();

		for(int i=0; i<Integer.MAX_VALUE;i++) {
			System.out.println("Beep");

			try {Thread.sleep(1000);
			} catch (Exception e){}
		}
	}
} // end class
