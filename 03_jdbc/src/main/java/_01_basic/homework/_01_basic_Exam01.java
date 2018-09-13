package _01_basic.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class _01_basic_Exam01 {
	public static void printEmployee(String cityName, int salary) throws SQLException {
		// List 그릇을 만들어 담는 vo 생성. 
		// Select 문 -> executeQuery
		// 1. classFor
		// 2. Connection
		// 3. sql
		// 4. statement
		// 5. resultSet
		// 6. while 문으로 출력 
		// 6. close stmt and con
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		List<Exam01_Board_vo> list  = new ArrayList();
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select city,\n" + 
					"	   first_name,\n" + 
					"	   salary\n" + 
					"  from employees e\n" + 
					"  inner join departments d\n" + 
					"  on e.department_id = d.department_id\n" + 
					"  inner join locations l\n" + 
					"  on d.location_id = l.location_id ");
			sql.append("where l.city like '%"+cityName+"%' ");
			sql.append("and e.salary > "+salary);
									
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Exam01_Board_vo b = new Exam01_Board_vo();
				b.setCityName(rs.getString("city"));
				b.setEmployeeName(rs.getString("first_name"));
				b.setSalary(rs.getInt("salary"));
				list.add(b);
			} 
			
			for(Exam01_Board_vo b : list) {
				System.out.printf(
						"%s\t%s\t%d\n",
						b.getCityName(), b.getEmployeeName(), b.getSalary()
						);
			}
		
		} catch (Exception e) {
			;;
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}

	} // printEmployee()
	
	public static void main(String[] args) throws SQLException{
		System.out.println("=============================================================");
		
		printEmployee("cisco", 6000);
		
		System.out.println("=============================================================");
		
		printEmployee("attle", 15000);
		
		System.out.println("=============================================================");
		
	} // main
	
} // end class


/* SQL command

select city,
	   first_name,
	   salary
  from employees e
  inner join departments d
  on e.department_id = d.department_id
  inner join locations l
  on d.location_id = l.location_id
  where l.city like '%cityName%'
    and e.salary > 'salary' ;	   


*/