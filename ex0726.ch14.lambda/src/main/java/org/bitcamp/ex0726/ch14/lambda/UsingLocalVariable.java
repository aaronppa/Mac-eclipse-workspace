package org.bitcamp.ex0726.ch14.lambda;

public class UsingLocalVariable {

	void method(int arg) {
		//arg는 final 특성을 가짐
		
		int localVar = 40; //localVar는 final특성을 가짐
		int localVar2 = 0; // not used in lambda expression
		
		//arg = 31; 	//final 특성때문에 수정불가 
		//localVar =41; //final 특성때문에 수정불가 
		localVar2= 10; // if not used in lambda expression, the value can be changed. 
		
		// lambda expression
		MyFunctionalInterface fi = () -> {
			//Using LocalVar
			System.out.println("arg: "+ arg);
			System.out.println("localVar: "+ localVar+"\n");
			
		};
		fi.method();
	
	} // method
	
} // end class
