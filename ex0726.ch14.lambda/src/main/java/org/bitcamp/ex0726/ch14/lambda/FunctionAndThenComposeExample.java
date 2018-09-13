package org.bitcamp.ex0726.ch14.lambda;

import java.util.function.Function;

public class FunctionAndThenComposeExample {
	public static void main(String[] args) {
	Function<Member,Address> functionA;
	Function<Address, String> functionB;
	Function<Member, String> functionAB;
	String city;

	functionA = (m) -> m.getAddress();
	functionB = (a) -> a.getCity();

	functionAB = functionA.andThen(functionB);
	city = functionAB.apply(
			new Member("Won Choi", "AaronPa", new Address("Korea", "Yongin"))
			);
	System.out.println("Residing City: "+city);

	functionAB=functionB.compose(functionA);
	city = functionAB.apply(
			new Member("Won Choi", "AaronPa", new Address("Korea", "Yongin"))
			);
	System.out.println("Residing City: "+city);


	}
} // end class
