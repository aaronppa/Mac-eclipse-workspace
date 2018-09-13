package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception{
		Class.forName(DBProperties.driver);
		return DriverManager.getConnection(
				DBProperties.url,
				DBProperties.user,
				DBProperties.pass
				);
	} // getConnection()
	
	public static void close(Statement stmt) {
		close(null, stmt);
	} // close(stmt)
	
	public static void close(Connection con, Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {;;}
		if(con != null) {
			try {
				con.close();
			} catch (Exception e) {;;}
		} // if 
	} // close(con, stmt)
	
}// end class
