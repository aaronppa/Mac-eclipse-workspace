package org.bitcamp.ex0726.ch14.lambda;

import junit.framework.TestCase;

public class MyMethodReferencesExample extends TestCase{

	public void testMyMethodReferencesExample() {
		MyFunctionalInterface2 fi;
		
		fi = (x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fi.method(2);
		
		// parameter argument can be changed accordingly
		fi = (a) -> {
			int result = a * 5;
			System.out.println(result);
		};
		fi.method(2);
		

		fi = (x) -> { System.out.println(x*5);};
		fi.method(2);
		
		fi = x -> System.out.println(x*5);
		fi.method(2);
	

	}

} // end class
