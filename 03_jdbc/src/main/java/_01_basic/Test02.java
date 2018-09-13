package _01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test02 {

	public static void main(String[] args) throws Exception{
		//1. Driver Loading
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. Connection
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE","hr","hr"
		);
		
		//3. SQL문 작성하기 
		StringBuffer sql = new StringBuffer();
		sql.append("delete "); // 습관적으로 sql 문 뒤에 스페이스 주기 
		sql.append("  from tb_board ");
		sql.append("  where no = 41 ");
		
		/*
		 * SQL 실행객체
		 * Statement
		 * 	   |
		 * 	PreparedStatement (현재 프레임워크들이 사용하는 인터페이스) 
		 * 	   |
		 * 	CallableStatement 
		 * 
		 * int cnt = stmt.executeUpdate(); : insert, delete, update (변경된 반환 값이 update된 결과 값임으로 int 타입임) 
		 * ResultSet rs = stmt.executeQuery(); : select
		 */
		
		//4. SQL Execution Object 얻기 
		Statement stmt = con.createStatement();
		
		//5. SQL Execution 
		int cnt = stmt.executeUpdate(sql.toString()); // Converting StringBuffer to String Type
		
		//6. 결과처리
		System.out.println(cnt +"개의 행이 삭제되었습니다.");
		
	}// main
	
} // end class
