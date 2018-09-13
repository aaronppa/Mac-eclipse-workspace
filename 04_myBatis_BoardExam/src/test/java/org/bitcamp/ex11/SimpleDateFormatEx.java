package org.bitcamp.ex11;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

public class SimpleDateFormatEx extends TestCase{

	public void testSimpleDateFormatEx() {
		Date  now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println( sdf.format(now) );
		
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println( sdf.format(now) );
		
		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println( sdf.format(now) );
		
		sdf = new SimpleDateFormat("Today is E");
		System.out.println( sdf.format(now) );
		
		sdf = new SimpleDateFormat("Today is D th day");
		System.out.println( sdf.format(now) );
		
//		sdf = new SimpleDateFormat("이달의 d번쨰 날");
//		System.out.println( sdf.format(now) );		
//		
		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println( sdf.format(now) );
		
		sdf = new SimpleDateFormat("올해의 D번째 날");
		System.out.println( sdf.format(now) );
		
		sdf = new SimpleDateFormat("이달의 d번쨰 날");
		System.out.println( sdf.format(now) );		
	}
} // end class
