package org.bitcamp.ex0726.ch14.lambda;

public class UsingThis {

	public int outterField = 10;
	
	
	class Inner {
		int innerField = 20;
		
		void method() {
			//Lambda Expression
			MyFunctionalInterface fi=() -> {
				System.out.println("\t- this: " + this);
				System.out.println("\t- UsintThis.this: " + UsingThis.this);
				
				System.out.println("outterField: "+ outterField);
				System.out.println("outterField: "+ UsingThis.this.outterField +"\n");
				
				System.out.println("innerField: "+ innerField);
				System.out.println("innerField: "+ this.innerField +"\n");
			};
		
			fi.method();
			
		} 
	}
}
