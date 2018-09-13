package org.bitcamp.ex0726.ch14.lambda;

import junit.framework.TestCase;

public class UsingThisExample extends TestCase{

	public void testUsingThisExample() {
		UsingThis usingThis = new UsingThis();
		UsingThis.Inner inner = usingThis.new Inner();
		inner.method();
	}
}
