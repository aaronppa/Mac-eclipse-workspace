package _01_basic.homework;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	// Connection을 관리하는 풀을 생성.
	// 최초 생성할 커넥션의 수 
	private static final int INIT_CNT = 3;
	private static List<Connection> free = new ArrayList<>();
	private static List<Connection> used = new ArrayList<>();

	// 사용하기 전에 클래스에 로딩한다.
	// 이때 호출되는 블럭, 한번만 수행됨. 
	static {
		try {
			for (int i =0; i < INIT_CNT; i++) {
				free.add(ConnectionFactory.getConnection());
			} // for
		} catch(Exception e) {
			System.out.println("초기 커넥션 풀 생성시 연결 오류 발생");
			e.printStackTrace();
		}

	}  // static block
	
	// 커넥션이 필요한 쪽에 요청이 오면 관리하는 커넥션을 넘겨준다. 
	public static Connection getConnection() throws Exception{
		
		if(free.isEmpty()) {
			throw new Exception("현재 사용할 수 있는 커넥션이 없습니다.");
			
		}
		Connection con = free.remove(0);
		used.add(con);
		
		return con;
		
	} // getConnection()
	
	// 사용자가 다 사용하고 반환한 커넥션을 used에서 찾아서 free로 옮긴다. 
	public static void releaseConnection(Connection con) {
			used.remove(con);
			free.add(con);
	} // releaseConnection();
	
	public static void main(String[] args) {
		/*
		List<Connection> free = ConnectionPool.free;
		for (int i = 0; i < free.size(); i++) {
			System.out.println(free.get(i));
		}
		 */
		try {
			for(int i = 1; i <= 10; i++) {
				System.out.println(i+"번째 연결 요청");
				Connection con = ConnectionPool.getConnection();
				System.out.println("연결 객체: "+ con);
				Thread.sleep(2000);
				//사용자가 사용한 커넥션을 반환하자
				ConnectionPool.releaseConnection(con);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	} // main

} // end class
