package org.bitcamp.ex0730.mltithread2;

public class TargetThread extends Thread{

	public void run() {
		for(long i=0; i<2000000000; i++) {
			try {
				//1.5 second pause
				Thread.sleep(150);
			} catch(Exception e) {}
		}
//		try {
//			//1.5 second pause
//			Thread.sleep(150);
//		} catch(Exception e) {}

		for(long i=0; i<2000000000; i++) ;
	}

}

