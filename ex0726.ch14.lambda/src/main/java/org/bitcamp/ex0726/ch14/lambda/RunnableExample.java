package org.bitcamp.ex0726.ch14.lambda;

import junit.framework.TestCase;

public class RunnableExample extends TestCase{
	public void testRunnableExample() {
		//			Runnable runnable = ()->{
		//				for(int i=0; i<10; i++){
		//					System.out.println(i);
		//				} // for
		//			};
		//		
		//			Thread thread = new Thread(runnable);
		//			thread.start();

		//		Thread thread = new Thread(() ->{
		//			for(int i=0; i<10; i++){
		//				System.out.println(i);
		//			} // for
		//		});
		//
		//		thread.start();

		Thread thread = new Thread() {

			@Override
			public void run() {
				for(int i=0; i<10; i++){
					System.out.println(i);
				} // for
			} // run method

		};
		thread.start();

	}
} // end class
