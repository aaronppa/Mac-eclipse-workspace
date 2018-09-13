/*
 * 	존재하는 게시글번호를 하나 찾아서
 * 	
 * 	해당글의 제목과 내용을 변경하는 프로그램 작성 후 실행	
 *	제목 :  프로그램 수정
 *	내용 :  잘 변경되었습니다. 
 */

package _01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test03 {

	public static void main(String[] args) throws Exception{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr";
		String pass = "hr";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pass);
		
		StringBuffer sql = new StringBuffer();
		sql.append("update tb_board ");
		sql.append("   set title = '프로그램 수정',");
		sql.append("       content = '잘 변경되었습니다.'");
		sql.append(" where no = 6");
		
		Statement stmt = con.createStatement();
		
		int cnt = stmt.executeUpdate(sql.toString());
		
		System.out.println(cnt+"개의 행이 수정되었습니다.");
		
	} // main
	
} // end class
