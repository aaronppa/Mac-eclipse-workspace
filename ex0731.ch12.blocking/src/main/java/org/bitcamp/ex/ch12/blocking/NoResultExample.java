package org.bitcamp.ex.ch12.blocking;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {

	public static void main(String[] args) {
		// 자바 프로그램이 구동되는 실행환경을 객체로 모델링한 결과로 나온 클라스 --> Runtime 

		// 멀티스레드 환경구현에서, 최적의 병렬성 확보를 위해, CPU Core개수만큼의 
		// 스레드를 가진 스레드 풀객체 생성 
		// ExecutorService는 Interface
		ExecutorService executorService = 
				Executors.newFixedThreadPool(
						//Runtime 객체를 이용하여, 현PC의 CPU Core 개수 획득 
						Runtime.getRuntime().availableProcessors()
						);

		System.out.println("CPU Core: "+Runtime.getRuntime().availableProcessors());
		System.out.println("[작업 처리 요청]");

		// Runnable 타입의 익명 구현객체로 스레드풀에서 처리할 작업(Task) 생성 
		// 요청된 자료처리는 return type이 void이기 때메 Runnable로 익명 구현객체 생
		Runnable runnable = new Runnable() {

			//스레드 풀의 특정 스레드가 처리할 작업내용 
			@Override
			public void run() {
				int sum = 0;
				for(int i=1; i<=10; i++) {
					sum += i;
				}
				System.out.println("[처리 결과] " + sum);
			} // run method
		}; // 익명구현객체 생성

		/* 전달인자로 생성한 작엄(tasks)를 스레드풀의 작업큐 (jobQ)에 제출
		 * submit() 메소드로 제출하였으므로, 작업처리중 예외가 발생하더라도
		 * 스레드풀에서 해당 작업을 처리중이던 특정 스레드는 죽지 않음 
		 * 작업큐에 제출하면, 그 리턴값으로  Future 객체를 바로 얻음  
		 * Future는 Wildcard로 불특정 Type의 클래를 받아야 함.*/
		Future<?> future = executorService.submit(runnable);

		// Future는 작업 처리 요청을 하고 기다리지 않는다. 미래 작업된 결과를 나중에 따로 요청(get) 할수 있다. 
		try {
			future.get(); // 작업처리완료때까지 블록킹 가능(기다림..waiting), Return 값이 없어도 작업이 어떻게 처리 되었는데 알아야 하기 떄문에 
			System.out.println("[작업 처리 완료]");
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
