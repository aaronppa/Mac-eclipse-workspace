package org.bitcamp.ex0726.ch14.lambda;

import junit.framework.TestCase;

public class MyFunctionalInterfaceExample extends TestCase{

	public void testMyFunctionalInterfaceExample() {
		MyFunctionalInterface fi;
		
		//1. using Lambda Expression
		fi=() -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();
		
		
		fi = () -> {System.out.println("method call2");};
		fi.method();
		
		// if only one executable method, {} can be skipped
		fi = () -> System.out.println("method call3");
		fi.method();
		
		// 2. method by creating anonymous ojbect
		fi = new MyFunctionalInterface() {
			
			@Override
			public void method() {
				String str = "method call1";
				System.out.println(str);
			} // method
		};
		fi.method();
		
		//3. Inteface Implementation
		fi = new MyFunctionalInterfaceImpl();
		fi.method();
		
		
		
	}
	
}
