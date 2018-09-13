package org.bitcamp.ex11;

import junit.framework.TestCase;

public class FinalizeEx extends TestCase{

	public void testCounter() {
		Counter counter = null;
		for(int i=1; i<=Integer.MAX_VALUE; i++) {
			counter = new Counter(i);
//			counter = null;
//			System.gc(); // can only request JVM to collect garbage asap, but JVM won't immediately execute the garbage collector
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
} // end class
