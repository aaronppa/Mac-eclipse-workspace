package sec02.nestedclass.object;

public class Main {

	public static void main(String[]args) {
		A a= new A(); // Class A instantiation
		
		// instantiating instance member class A.B
		A.B b = a.new B();
		b.field1 = 3;
		b.method1();
		
		// instantiating static member class A.C
		A.C c = new A.C();
		c.field1 = 3;
		c.method1();
		A.C.field2 = 3;
		A.C.method2();
		A.C.field2 = 10;
		
		System.out.println(A.C.field2);
		
		a.method();
		
	} // main class
	
} // end class
