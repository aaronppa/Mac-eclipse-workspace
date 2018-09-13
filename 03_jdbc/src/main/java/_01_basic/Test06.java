package _01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import util.DBProperties;

public class Test06 {
	public static void main(String[] args) throws Exception{
		Class.forName(DBProperties.driver);
		Connection con = DriverManager.getConnection(
					DBProperties.url,
					DBProperties.user,
					DBProperties.pass
				);
		
		// 값을 받아서 쿼리 작성
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 글번호: ");
		int no = Integer.parseInt(sc.nextLine());
		
		//  게시물 삭제 
		StringBuffer sql = new StringBuffer();
		sql.append("delete ");
		sql.append("  from tb_board ");
		sql.append(" where no = " + no); // 값을 받아서 쿼리 작성
	
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(sql.toString());
		
		System.out.println(cnt+"개의 행이 삭제되었습니다.");
		
		
		sc.close();
	} // main
	
} // end class
