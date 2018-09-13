package org.bitcamp.ex11;

public class AllObjectCompare {

	public static <T, E, R> R compareAddress(T obj1,T obj2) {
		Object result1 = (obj1 == obj2);
		R result = (R) result1;
		return result;
	} // compareAddress 
	


	
} // end class
