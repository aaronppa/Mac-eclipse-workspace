package org.bitcamp.ex0730.homework;

public class CreateThreads {

	public static void main(String[] args) {
		Thread[] threadArr = new Thread[10];

		for(int i=0; i<10;i++) {
			threadArr[i] = new MultiThreads("Thread"+(i+1));

			threadArr[i].start();

		} // for loop to create 10 threads
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {;;}
		
		for(int j=0; j<10;j++) {
			if(j%2==0) {
				threadArr[j].interrupt();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {;;}
			} // if
		} // for odd first
		
		for(int k=0; k<10;k++) {
			if(k%2!=0) {
				threadArr[k].interrupt();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {;;}

			} // if

		} // for even second

		System.out.println("All Threads have been terminated.");
	} // main

} // end class
