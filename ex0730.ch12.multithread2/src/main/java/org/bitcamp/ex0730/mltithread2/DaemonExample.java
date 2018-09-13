package org.bitcamp.ex0730.mltithread2;

public class DaemonExample {
	
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		// 데몬 만들기 
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("메인 스레드 종료");
	}
}