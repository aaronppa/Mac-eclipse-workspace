package homework;

import java.awt.Toolkit;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;


public class MiniProjectTest {

	public static void main(String[]args) {

		ExecutorService executorService = Executors.newFixedThreadPool(

				Runtime.getRuntime().availableProcessors());

		System.out.println("[Start.beep]");

		// Beep Thread Task Assignment
		Runnable task = new Runnable() {

			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();

				toolkit.beep();
				try {Thread.sleep(1000);} catch(Exception e) {}

			}//run

		}; // anonymous instance

		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				// Properties instantiation using default constructor
				Properties properties = new Properties();

				// Searching for XXX.properties when loading from the instance
				// the classpath is in the same folder as the source file
				String path = MiniProjectTest.class.getResource("database.properties").getPath();

				// decoding to utf-8
				try {
					path = URLDecoder.decode(path, "utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				try {
					properties.load(new FileReader(path));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String DB_URL = properties.getProperty("url");
				String USER = properties.getProperty("username");
				String PASS = properties.getProperty("password");

				//				while(!executorService.isShutdown()) {

				try ( Connection conn = 
						DriverManager.getConnection(DB_URL, USER, PASS);) {
					
					System.out.println("DB Extracting...");
					String sql = new StringBuffer().
							append("SELECT ").
							append("	empno, ename, job, mgr,").
							append("hiredate, sal, comm, deptno ").
							append("FROM emp ").
							toString();

					PreparedStatement stmt = conn.prepareStatement(sql);

					while(!executorService.isShutdown()) {

						ResultSet rs = stmt.executeQuery();

						while(rs.next()) {
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							String job = rs.getString("job");
							String mgr = rs.getString("mgr");
							String hiredate = rs.getString("hiredate");
							String sal = rs.getString("sal");
							String comm = rs.getString("comm");
							String deptno = rs.getString("deptno");

							System.out.print("\t>> " + empno);
							System.out.print(", " + ename);
							System.out.print(", " + job);
							System.out.print(", " + mgr);
							System.out.print(", " + hiredate);
							System.out.print(", " + sal);
							System.out.print(", " + comm);
							System.out.println(", " + deptno);

							
						} // while
						System.out.println("- DB Extraction Done.");
						try {
							Thread.sleep(1000*2);
						} catch(Exception e) {
						} // try-catch
					} // outter while
					
				} catch(Exception se) {
					se.printStackTrace();
				} // try-with-resources 

			}// run method

		};

		// 마지막 포부 log print Thread Task Assignment
		Runnable task3 = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000*10);
				}catch(Exception e) {;;	}
				System.out.println("End.포부");
				System.out.println("성공적인 취업을 위하여");

				// 어짜피 마지막 Thread가 끝나면 모든 작업 종료 하고 리소스 파괴.
				// 근데 이부분이 매우 아리까리함..... 
				executorService.shutdownNow();

				System.out.println("[작업처리완료]");
			}//run


		}; // anonymous instance

		Future<?> future = executorService.submit(task); // Beep Task submit to ThreadPool
		Future<?> future1 = executorService.submit(task1); // Beep Task submit to ThreadPool
		//		// DB 데이터 추출(Task1) 데몬으로 호출 
		//		Task1 task1 = new Task1(); 
		//		task1.setDaemon(true);
		//		task1.start();

		// 음악 플레이(Task2) 데몬으로 호출
		Task22 task22 = new Task22();
		task22.setDaemon(true);
		task22.start();

		// Last statement printing log
		Future<?> future4 = executorService.submit(task3); 

		/* 간단한 코드로 전달인자(argument) 또는 매개변수(parameter)가 없는 것들은 
		 * 사실상 Future 객체를 만들 필요는 없지만, ThreadPool로 Submit 된 Thread 작업은 
		 * Exception이 나서 안돌아가도 아무 메세지를 전달 하지 않기 때문에 
		 * Future를 통해서 Exception 내용을 전달 받기 위해 쓰인다.
		 */
		try {

			future.get();
			future1.get(); 
			future4.get();

		}catch(CancellationException | ExecutionException | InterruptedException e) {
			e.printStackTrace();

			System.out.println("/t* [실행 예외 발생함]"+e.getMessage());

		}catch(Exception e) {
			e.printStackTrace();

			System.out.println("/t* [실행 예외 발생함]"+e.getMessage());
		}//try- multi- catch

	}//main

}//end class


class Task22 extends Thread{

	public void run() {

		try {
			Thread.sleep(2000);
			System.out.println("Start: music");

		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		BasicPlayer player = new BasicPlayer();

		try {

			player.open(App.class.getResource("Sleep Away.mp3"));
			player.play();
		}catch(BasicPlayerException e) {
			e.printStackTrace();
		} //try-catch	
	}//run
}
