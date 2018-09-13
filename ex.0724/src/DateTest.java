import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date = new Date();
		date.getTime();
		date.getTimezoneOffset();
		date.getYear();
		date.getMonth();
		date.getDate();
		date.getDay();
		date.getHours();
		date.getMinutes();
		date.getSeconds();
		
		// Date 객체를 그대로 출력
				System.out.println("\t- Date: "+date);
				
				// 포맷터를 통해 Date객체 출력
				System.out.println("\t- formatter: "+formatter.format(date)); 
				
				// 1970.1.1 이후로 지난 밀리초를 long값으로 리턴
				System.out.println("\t- date.getTime(): "+date.getTime());
				
				// 1900년 이후로 지난 연수 리턴 즉, 1900+리턴값
				System.out.println("\t- date.getYear(): "+date.getYear());
				
				// 0:1월, 11: 12월 즉, 리턴값 + 1
				System.out.println("\t- date.getMonth(): "+date.getMonth());
				
				// 해당월의 몇일(1~31일). 오늘은 7월 3일 즉 3일
				System.out.println("\t- date.getDate(): "+date.getDate());
				
				// (0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 = Saturday)
				System.out.println("\t- date.getDay(): "+date.getDay());
				
				// (0 ~ 23)시
				System.out.println("\t- date.getHours(): "+date.getHours());
				
				// 분 ( 0 ~ 59 )
				System.out.println("\t- date.getMinutes(): "+date.getMinutes()); 
				
				// 초 ( 0 ~ 61 )
				System.out.println("\t- date.getSeconds(): "+date.getSeconds()); 	
			} // main

} // end class
