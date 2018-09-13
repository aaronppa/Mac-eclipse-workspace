package _01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import util.DBProperties;

public class Test07 {
	public static void main(String[] args) throws Exception{
		Class.forName(DBProperties.driver);
		Connection con = DriverManager.getConnection(
				DBProperties.url,
				DBProperties.user,
				DBProperties.pass 
				);
		Scanner sc = new Scanner(System.in);
		System.out.println("변경할 게시글 번호:");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("제목수정: ");
		String title = sc.nextLine();
		System.out.println("내용수정: ");
		String content = sc.nextLine();
		
		StringBuffer sql = new StringBuffer();
		sql.append("update tb_board  ");
		sql.append("  set title = '"+title+"', ");
		sql.append("      content = '"+content+"' ");
		sql.append(" where no = "+no);
	
		System.out.println("생성된 SQL: "+sql.toString());
		
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(sql.toString());
		
		System.out.println(cnt+"개 행이 수정되었습니다.");
		sc.close();
	} // main
	
} // end class
