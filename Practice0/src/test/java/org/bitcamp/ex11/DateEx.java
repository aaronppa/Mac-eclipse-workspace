package org.bitcamp.ex11;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

public class DateEx extends TestCase{
	
	public void testDateEx() {
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
	}

}
