package org.bitcamp.ex0801.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//JDBC: Java DataBase Connectivity
//자바 프로그램에서 여러 데이터베이스에 접속 및 데이터 조작을 위한 자바표준 API
//현재 표준 JDBC v4.2 까지 나옴
public class App {
	// STEP 1: JDBC 파라미터 정보 설정
	// 		(1) JDBC url : 연결할 데이터베이스마다 다름
	//		(2) JDBC Driver FQCN : 연결할 데이터베이스마다 다름
	//		(3) 연결할 데이터베이스 계정 및 암호
	//		(4) 연결할 데이터베이스 서버의 IP주소와 Port 번호
	//		(5) 연결할 데이터베이스의 이름
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@192.168.0.10:1521/XE";
	static final String USER = "SCOTT";
	static final String PASS = "TIGER";

	public static void main(String[] args) {
//		while(true){
//		// Target Database Server와의 연결을 모델링한 클래스
//		Connection conn = null;
//
//		// Target Database Server에서 실행시키기 위한 SQL문장을 모델링한 클래스
//		PreparedStatement stmt = null;

		try (Connection conn =
				DriverManager.getConnection(DB_URL, USER, PASS);) {
//		try {
			//STEP 2: JDBC Driver Class Loading into JVM Method Area
			//        낮은버전의 JDBC 표준에서는 이 step이 반드시 필수이자 처음 실행되어야 할
			//        부분이었으나, 현재 표준(4.x)에서는 수행할 필요가 없어짐
//			System.out.println("- Loading JDBC Driver into JVM Method Area ...");
//			Class<?> clazz = Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("- clazz: "+clazz);
//			//STEP 3: 데이터베이스 서버에 접속 시도, 그 결과로 연결 객체(Connection) 반환
//			System.out.println("- Connecting to database...");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			System.out.println("\t>> conn: "+conn);
//
//			//STEP 4: 데이터베이스 서버에 SQL 문장실행 요청 및 그 결과 받음
//			System.out.println("- Creating statement...");
			String sql = 
					new StringBuffer().
					append("SELECT ").
					append("	empno, ename, job, mgr, ").
					append("	hiredate, sal, comm, deptno ").
					append("FROM emp ").
//					append("WHsqlERE empno = ?").
					toString();
//			System.out.println("\t>> sql: "+sql);

//			stmt = conn.prepareStatement(sql);
			PreparedStatement stmt = conn.prepareStatement(sql);
//			System.out.println("\t>> stmt: "+stmt);

			// 데이터베이스 서버에서 수행시킬 SQL 문장의 WHERE 조건에 입력될 값 설정
			// 이를 바인딩 한다라고 하고, 위 SQL 문장에서 ?를 바인딩 변수라 한다.
			// 즉, 바인딩 변수 = 바인딩할 값 입력
//			stmt.setInt(1, 7499);

			// 실제 데이터베이스에 위에서 만든 SQL 문장을 실행요청함
			// 그 결과로 ResultSet 객체가 리턴됨
			// 이 ResultSet 객체 안에 SQL문장의 실행결과가 들어옴
			ResultSet rs = stmt.executeQuery();
			System.out.println("\t>> rs: "+rs);

			//STEP 5: 리턴된 ResultSet 객체를 이용해, 모든 데이터(레코드)를
			//        가져와서 순서대로 출력함
			System.out.println();

			while(rs.next()){
				// 위의 SQL 문장에서 구성된 각 컬럼명으로 각 컬럼의 값을 각 레코드별로 얻음
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");
				String deptno = rs.getString("deptno");

				// 얻어낸 레코드별 모든 컬럼의 값을 순서대로 콘솔에 출력함
				System.out.print("\t>> " + empno);
				System.out.print(", " + ename);
				System.out.print(", " + job);
				System.out.print(", " + mgr);
				System.out.print(", " + hiredate);
				System.out.print(", " + sal);
				System.out.print(", " + comm);
				System.out.println(", " + deptno);
			} // while

			Thread.sleep(500);

			//STEP 6: JDBC를 위해 사용한 시스템 자원을 해제함
//			rs.close();		// ResultSet 객체를 닫음 (역순으로 닫아야함)
			//			stmt.close();	// PreparedStatement 객체를 닫음
			//			conn.close();	// Connection 객체를 닫음 (반드시 Connection 객체는 받아야함)
		} // try-with-resources (Finally resources를 정리할때 자동으로 정리해주는 것). 
		
		catch(SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		} catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
//		finally { 
//			// 이 블럭에서는 JDBC에서 사용된 자원을 해제하는 코드가 들어감
//			try{
//				if(stmt!=null) {
//					stmt.close();
//				} // if
//			} catch(SQLException se2) {;;} // try-catch
//
//			try{
//				if(conn!=null) {
//					conn.close();
//				} // if
//			}catch(SQLException se) {;;} // try-catch
//		} // try-catch-finally

		System.out.println("- Done.");
//		} // looping log while
	} // main

} // end class
