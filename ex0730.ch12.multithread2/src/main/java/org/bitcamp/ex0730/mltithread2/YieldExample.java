package org.bitcamp.ex0730.mltithread2;

public class YieldExample {

	public static void main(String[] arg) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		threadA.start();
		threadB.start();
		
		try {Thread.sleep(100);}
		catch(InterruptedException e) {;;}
		
		threadA.work = false;
		
		try {Thread.sleep(3000);}
		catch(InterruptedException e) {;;}
		
		threadA.work = true;
		
		try {Thread.sleep(3000);}
		catch(InterruptedException e) {;;}
		
		threadA.stop = true;
		threadB.stop = true;
	}
} // end class
