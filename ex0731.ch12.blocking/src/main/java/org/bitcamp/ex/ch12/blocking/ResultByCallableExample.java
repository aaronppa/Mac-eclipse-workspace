package org.bitcamp.ex.ch12.blocking;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByCallableExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors() 
				);

		System.out.println("[작업 처리 요청]");

		// Callable 타입의 익명구현객체로 스레드풀에서 처리할작업(task) 생성 
		Callable<Integer> task = new Callable<Integer>() {
			// Type parameter에는 기본 타입클래스가 들어갈수 없다. 구체타입만 들어갈 수 있다. 

			@Override
			public Integer call() throws Exception{
				int sum = 0;
				for(int i=1; i<=10; i++) {
					sum+=i;
				}
				return sum;
			} // call
		}; // 익명구현객체 생성 


		/* 전달인자로 생성한 작엄(tasks)를 스레드풀의 작업큐 (jobQ)에 제출
		 * submit() 메소드로 제출하였으므로, 작업처리중 예외가 발생하더라도
		 * 스레드풀에서 해당 작업을 처리중이던 특정 스레드는 죽지 않음 
		 * 작업큐에 제출하면, 그 리턴값으로  Future 객체를 바로 얻음  
		 */
		Future<Integer> future = executorService.submit(task);

		try{
			// 작업처리결과를 얻음 
			// auto unboxing
			int sum = future.get(); // 작업처리완료때까지 블록킹 가능(기다림.waiting)
			System.out.println("[처리 결과] "+sum); 
			System.out.println("[작업 처리 완료");
		} catch( // multi-catch
				CancellationException | // 작업이 취소되면 Exception
				ExecutionException | // 작업도중 오류가 나면 Exception
				InterruptedException // 작업도중 Interrupt 되면 Exception
				e) {
			e.printStackTrace();

			System.out.println("[실행 예외 발생함] " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("[실행 예외 발생함] " + e.getMessage());
		}// try-multi-catch

		// 모든 작업이 끝나고 나면, 자원정리차원에서 사용중이던 
		// 스레드풀 파괴 
		executorService.shutdown();
	} // main

} // end class
