package org.bitcamp.ex11;

import java.util.Date;
import java.util.Calendar;

import junit.framework.TestCase;

public class ExitExample extends TestCase{

	public void testExit() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				if(status !=5) {
					throw new SecurityException();
					
				} // if
			} // override checkExit method
		});
		
		for(int i=0; i<10; i++) {
			// Print i Value
			System.out.println(i);
			try {
				// Request JVM exit
				System.exit(i);;
				
			} catch(SecurityException e) {}
			
		} // for
		
	} // test method
	
} // end class
