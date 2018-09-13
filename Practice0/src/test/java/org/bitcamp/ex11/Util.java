package org.bitcamp.ex11;

public class Util{

	public static <T> Box <T> boxing(T t){
		Box<T> box = new Box<T>();
		box.set(t);
		
		return box;
		
	} // box
	
} // end class
