package org.bitcamp.ex11;

import java.util.Calendar;

import junit.framework.TestCase;

public class CalendarEx extends TestCase{
	public void testCalendarEx() {
	Calendar now = Calendar.getInstance();
	
	int year = now.get(Calendar.YEAR);
	int month = now.get(Calendar.MONTH)+1;
	int date = now.get(Calendar.DAY_OF_MONTH);
	
	int day = now.get(Calendar.DAY_OF_WEEK);
	String strDay = null;
		
	switch(day) {
	case Calendar.MONDAY:
		strDay = "Monday";
		break;
	case Calendar.TUESDAY:
		strDay = "Tuesday";
		break;
	case Calendar.WEDNESDAY:
		strDay = "Wednesday";
		break;
	case Calendar.THURSDAY:
		strDay = "Thursday";
		break;
	case Calendar.FRIDAY:
		strDay = "Friday";
		break;
	case Calendar.SATURDAY:
		strDay = "Saturday";
		break;
	default:
		strDay = "Sunday";

	} // switch
	
	int amPm = now.get(Calendar.AM_PM);
	String strAmPm = null;
	if(amPm == Calendar.AM) {
		strAmPm = "AM";
	} else {
		strAmPm = "PM";
	} // if-else
	
	int hour = now.get(Calendar.HOUR);
	int minute = now.get(Calendar.MINUTE);
	int second = now.get(Calendar.SECOND);
	
	System.out.print(year+"yr ");
	System.out.print(month+"mo ");
	System.out.print(date+"date ");
	System.out.print(strDay+":day ");
	System.out.print(strAmPm+"  ");
	System.out.print(hour+"hr ");
	System.out.print(minute+"min ");
	System.out.print(second+"sec ");
	} // test method
	
} // end class

