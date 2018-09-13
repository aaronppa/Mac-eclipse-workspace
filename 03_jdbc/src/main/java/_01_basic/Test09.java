package _01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import util.DBProperties;

public class Test09 {
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
		sql.append("  set title = ?, ");
		sql.append("      content = ? ");
		sql.append(" where no = "+no);
	
		// preparedStatement에는 statement 객체 생성시 parameter에 sql 문을 넣어야함. 
		PreparedStatement stmt = con.prepareStatement(sql.toString());
		
		//SQL문에 "?"가 존재한다면, ?에 값을 설정하는 코드가 실행하기 전에 나와야한다. 
		// set데이터타입(위치index(?),설정할 값); 
		// 데이터타입이 무엇인지 모를때는 setObject() 을 사용 
		stmt.setString(1,title);
		stmt.setString(2,content);
		stmt.setInt(3,no);
		
		int cnt = stmt.executeUpdate();
		
		System.out.println(cnt+"개 행이 수정되었습니다.");
		sc.close();
	} // main
	
} // end class
