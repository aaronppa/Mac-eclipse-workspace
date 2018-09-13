package _01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test04 {

	public static void main(String[] args) throws Exception{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr";
		String pass = "hr";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pass);
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into tb_board( ");
		sql.append("  no,title,content,writer");
		sql.append(") values(");
		sql.append("  s_board_no.nextval, 'jdbc 입력','입력성공','Won'  ");
		sql.append(") ");
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(sql.toString());
		
		System.out.println(cnt+"개의 행이 추가 되었습니다. ");
	} // main
	
} // end class
