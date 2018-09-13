/*
 * 	JDBC
 * 	- JAVA +SQL
 * 	- java.sql package, javax.sql package
 * 	- Connection : Database와 연결 정보  
 * 	- Statement : SQL문을 실행할 수 있는 객체 
 * 	- ResultSet : SQL문이 select 인 경우 반환되는 객체 
 * 
 * 	프로젝트에서 JDBC를 사용하기 위한 준비
 * 		- Vendor사에서 만들어서 배포하는 JDBC 드라이버를 인식하는 과정(Library)
 * 		- 일반적으로 Driver들은 jar 파일로 묶어서 배포됨... (ojdbc6.jar)
 * 		
 * 	메이븐을 사용하지 않은 경우
 * 		- project에 lib 폴더 생성
 * 		- Driver file(ojdbc6.jar)을 생성된 lib 폴더 복사
 * 		- 프로젝트가 복사된 Driver 파일을 인식하기 위해서 Buildpath에 추가한다. 
 * 	
 * 	JDBC  프로그램 작성 단계 이해하기..
 * 		- Driver Loading하기 : Class.forName("packageName.class")
 * 		- ex) Class.forName("oracle.jdbc.driver.OracleDriver");
 * 		- 데이터베이스 연결하기 : Connection, DriverManager 
 */

package _01_basic;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test01 {

	public static void main(String[] args) throws Exception {
		// 1. Driver Loading
		// ojdbc6.jar안에 있는 클래스명 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2.Database Connection
		// suburl : 	jdbc:oracle:thin:@설치된 주소:포트:서비스이름 
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr"
		);
		
		System.out.println("연결 객체 : "+ con);
	} // main
} // end class
