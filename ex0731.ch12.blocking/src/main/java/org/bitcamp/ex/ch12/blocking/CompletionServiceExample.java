package org.bitcamp.ex.ch12.blocking;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceExample extends Thread {
	public static void main(String[] args) {
		ExecutorService  executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
		
		// 스레드풀에서 작업처리완료된 것들만 통보받기 위해,
		CompletionService<Integer> completionService  =  //CompletionSerivce는 interface
				new ExecutorCompletionService<Integer>(executorService); // 스레드풀 생성한 것을 이 생성자 parameter에 넣어준다.
						// ExecutorCompletionService는 구현 class
		
		System.out.println("[작업 처리 요청]");
		
		// Task가 3개로 생성 
		for(int i=0; i<3; i++) {
			
			completionService.submit(new Callable<Integer>() {
				// Callable 타입의 익명구현객체로 스레드풀에서 처리할 작업(Task) 생성
				
				// 스레드풀의 특정 스레드가 처리할 작업내용 
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for(int i=1; i<=10; i++) {
						sum += i;
					} //for 
					return sum;
				} // call method
			}); // submit() Method invoke 
		} // Task 3개 생성 완료 
		
		System.out.println("[처리 완료된 작업 확인]");
		
		// ThreadPool에 한가지 작업을 별도로 위임하여 처리하도록함. 
		// completionService.take를 위한 이 작업은 별도의 ThreadPool에서 무한으로 반복하고 예외처리가 되지 않은 한 
		// 무한 반복하고, 목적은 모니터링이다.
		// 이 스레드풀 작업이 끝나는 시점은 최하단에  executorService.shutdownNow(); 이 호출되면 ThreadPool 모니터링 작업이 중단되고 Terminate됨. 
		executorService.submit(new Runnable() {
			// Runnable 타입의익명구현객체로 스레드풀에서 처리할 작업(Task) 생성 
			
			// 스레드 풀의 특정 스레드가 처리할 작업 내용.
			@Override
			public void run() {
				while(true) {
					try {
						// completionService.take()?? -> Task 3개중 단 하나라도 먼저 끝나는 Task 작업의 future 객체를 얻는 코드  
						Future<Integer> future = completionService.take();
						int value = future.get();
						System.out.println("[처리 결과] " + value);
					} catch (Exception e) {
						break;
					} // try-catch
				} // while
			} // run
		});
		
		try { Thread.sleep(3000); } catch (InterruptedException e) {}
		executorService.shutdownNow();
	}
}