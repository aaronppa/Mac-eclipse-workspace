import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = Calendar.getInstance();

		System.out.println("\t- Calendar: "+formatter.format(calendar.getTime()));

//		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.YEAR, 2230);
		
		System.out.println(
				"\t- Calendar After Update: "+
						formatter.format(calendar.getTime())
				);

		System.out.println(
				"\t- calendar.getMaximum(DAY_OF_MONTH): "+
						calendar.getMaximum(Calendar.DAY_OF_MONTH)
				);

		System.out.println(
				"\t- calendar.getActualMaximum(DAY_OF_MONTH): "+
						calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
				);

		System.out.println(
				"\t- calendar.get(DAY_OF_WEEK): "+
						calendar.get(Calendar.DAY_OF_WEEK)
				);

		System.out.println(
				"\t- calendar.get(YEAR): "+
						calendar.get(Calendar.YEAR)
				);

		System.out.println(
				"\t- calendar.get(MONTH): "+
						(calendar.get(Calendar.MONTH)+1)
				);

		System.out.println(
				"\t- calendar.get(DATE): "+
						calendar.get(Calendar.DATE)
				);

		System.out.println(
				"\t- calendar.get(DAY_OF_MONTH): "+
						calendar.get(Calendar.DAY_OF_MONTH)
				);
	}
} // end class
