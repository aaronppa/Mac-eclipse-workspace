import java.time.YearMonth;

public class YearMonthTest {

	public static void main(String[] args) {
		YearMonth yearMonth = YearMonth.now();
		System.out.println("\t- YearMonth: "+yearMonth);
		
		yearMonth = YearMonth.of(2024, 2);
		
		System.out.println("\t- The number of days of 2024.02: "+yearMonth.lengthOfMonth());
	}
} // end class
