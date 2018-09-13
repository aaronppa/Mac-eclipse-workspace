package org.bitcamp.ex0730.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

public class ExecuteVsSubmitExample {
	
	public static void main(String[] args) throws Exception {
		// 최대 스레드 개수가 2인 스레드 풀 생성 using Executors
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// 스레드 
		for(int i=0; i<10; i++) {

			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					
					//스레드풀의 진짜 구현클래스는 ThreadPoolExecutor 클래스임.
					//ExecutorService는 스레드풀의 규격인 인페이스 일뿐!!!
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;

					// 스레드 총 개수 및 작업 스레드 이름 출력. 
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();

					System.out.println(
							"[총 스레드 개수: "+poolSize +
							"] 작업 스레드 이름: "+threadName
							);
					
					// 예외 발생시
					int value = Integer.parseInt("3");
					
				} // run
				
			}; // 익명구현객체 생성 (작업- Task 생성)

			// 생성한 작업(Task)를 스레드풀의 작업큐에 제출 
			executorService.execute(runnable);
//			executorService.submit(runnable);

			Thread.sleep(10); // 0.1초 대기 
		}
		
		// ending thread pool (shutdown: 스레드풀에서 스레드 종료시키고 자원반납)
		executorService.shutdown();
	}
} // end class