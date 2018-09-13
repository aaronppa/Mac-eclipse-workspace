package org.bitcamp.ex.ch12.blocking;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableExample {

	public static void main(String[] args) {
		String threadName = 
				"("+Thread.currentThread().getName()+
				", "+Thread.currentThread().getId()+")";
		
		System.out.println("- "+threadName+" ResultByRunnableExample::main(args) invoked.");
		
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		
		System.out.println("[작업 처리 요청]");
		
		class Task implements Runnable{
			Result result;
			Task(Result result) {
				this.result = result;
			} // constructor
			
			@Override
			public void run() {
				String threadName = 
						"("+Thread.currentThread().getName()+
						", "+Thread.currentThread().getId()+")";
				
				System.out.println("\t>> "+threadName+" Task::run() invoked.");
				
				int sum = 0;
				for(int i=1; i<=100; i++) {
					sum+=i;
				} // for
				
				result.addValue(sum);
			} // run method
		} // Task Nested class
	
		// 스레드풀에 처리할 작업(task)이 완료된 이후에
		// 리턴받을 값을 저장할 객체 생성 
		Result result = new Result();
		
		// 스레드풀에 위임처리할 작업(task) 생성 
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);
		
		/* 전달인자로 생성한 작엄(tasks)를 스레드풀의 작업큐 (jobQ)에 제출
		 * submit() 메소드로 제출하였으므로, 작업처리중 예외가 발생하더라도
		 * 스레드풀에서 해당 작업을 처리중이던 특정 스레드는 죽지 않음 
		 * 작업큐에 제출하면, 그 리턴값으로  Future 객체를 바로 얻음  
		 */
		Future<Result> future1 = executorService.submit(task1, result);
		Future<Result> future2 = executorService.submit(task2, result);
		
		try {
			// 각 작업(task)의 처리결과를 리턴받기 위해
			// Future 객체의 get() 메소드 호출
			// 이때, 아직까지 해당 작업(task)이 처리 완료되지 못하였으면 완료될때까지 블락 처리 
			result = future1.get(); // 작업처리완료때까지 블록킹 가능 
			result = future2.get(); // 작업처리완료때까지 블록킹 가능
			
			// 두개의 작업(tasks) 처리결과가 누적된 결과를 출력함 
			System.out.println("[처리 결과 "+result.accumValue);
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
	
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 모든 작업이 끝나고 나면, 자원정리차원에서 사용중이던 
		// 스레드풀 파괴 
		executorService.shutdown();
	} // main
} // end class


class Result {
	int accumValue;
	
	// 스레드 풀의 여러 스레드가 자신이 처리한 작업의 결과를 저장하기 위해
	// 동시에 접근가능(임계영역). 따라서 동기화 메소드로 선언 필요 
	synchronized void addValue(int value) {
		String threadName = 
				"("+Thread.currentThread().getName()+
				", "+Thread.currentThread().getId()+")";
		
		System.out.println(
				"- "+threadName+
				" Result::addValue("+value+") invoked."
				);
		accumValue += value; // 배열 작업처리 결과를 누적시킴 
	} // method
	
} // end class
