package _01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import util.DBProperties;

public class Test10 {
	public static void main(String[] args) throws Exception{
		Class.forName(DBProperties.driver);
		Connection con = DriverManager.getConnection(
				DBProperties.url,
				DBProperties.user,
				DBProperties.pass
				);

		Scanner sc = new Scanner(System.in);
		System.out.println("게시물을 작성합니다.");
		System.out.println("작성자: ");
		String user = sc.nextLine();
		System.out.println("제목 입력: ");
		String title = sc.nextLine();
		System.out.println("내용 입력: ");
		String content = sc.nextLine();

		StringBuffer sql = new StringBuffer();
		sql.append("insert into tb_board");
		sql.append("(no,title, content, writer) ");
		sql.append("values(s_board_no.nextval,");
		sql.append("?, ?, ?");
		sql.append(")");

		PreparedStatement stmt = con.prepareStatement(sql.toString());
		
		stmt.setString(1, title);
		stmt.setString(2, content);
		stmt.setString(3, user);

		int cnt = stmt.executeUpdate();

		System.out.println(cnt+"개 행이 추가 입력되었습니다.");

		sc.close();
	} // main
	
} // end class
