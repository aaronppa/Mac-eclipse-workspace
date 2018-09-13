package org.bitcamp.ex11;

import java.util.TimeZone;

import junit.framework.TestCase;

public class PrintTimeZoneID extends TestCase{

	public void testPrintTimeZoneID() {
		String[] availableIDs = TimeZone.getAvailableIDs();
		for(String id : availableIDs) {
			System.out.println(id);
		} // for
	} // test method
} // end class
