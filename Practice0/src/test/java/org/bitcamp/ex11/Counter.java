package org.bitcamp.ex11;

public class Counter {

	private int no;
	
	public Counter(int no) {
		this.no= no;
		
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("No."+no+" Object has been executed method finalize()");
	} // constructor
	
	
} // end class
