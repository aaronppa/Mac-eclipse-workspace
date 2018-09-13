package org.bitcamp.ex0730.mltithread2;

public class ThreadStateExample {

	public static void main(String[] args) throws InterruptedException {
		StatePrintThread statePrintThread = 
				new StatePrintThread(new TargetThread());

		statePrintThread.start();

		statePrintThread.join();

		statePrintThread.interrupt(); // 중간에 인터럽트 신호 전달 

		// Running --> 일시정지로 가는 상황 
		Thread.sleep(100); // 바로 자러갑니다. (누가? main이.. )

		// OtherThreadObject.join(); // 왼쪽의 Thread가 종료될떄까지 일시정지 (main)
		// OtherThreadObject.suspend(); // 왼쪽의 Thread가 일시정지 상태로감  (main 아님) *!*!*!*(가능하면 쓰지마라)

//		wait(); // 바로 자러 갑니다. (main)
		
		// paused --> Runnable 상태로 가는 상황
		// pausedThreadObject.interrupt(): // pausedThreadObject이 깨어나서 Runnable 상태
		
		// 일시정지 상태에 있는 다른 Thread 에게 통지 
//		notify(); //
//		notifyAll(); //
		
		// pausedThreadObject.resume(); // 일시정지상태의 Thread를 재개시킴. *!*!*!*(가능하면 쓰지마라)
		//stop(); *!*!*!*(가능하면 쓰지마라)
		
	} // main
	
} // end class
