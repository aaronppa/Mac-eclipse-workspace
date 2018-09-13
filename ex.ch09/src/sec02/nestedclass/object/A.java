package sec02.nestedclass.object;

public class A {
	A(){
		System.out.println("Object A instantiated");
	} // class A constructor
	
	public class B {
		B(){
			System.out.println("Object B instantiated");
		} // nested class B constructor
		
		int field1;
		void method1() {}
		
	} // nested class B
	
	// static member class
	static class C {
		C() {
			System.out.println("Object C instantiated");
		} // nested static class C constructor
		
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
				
	} // nested static class C
	
	void method() {
		// Local Class
		class D {
			D() {
				System.out.println("Object D instantiated");
			} // local nested class D constructor
			
			int field1;
			void method1() {}
			
		} // local nested class D 
		D d = new D();
		d.field1 = 3;
		d.method1();
	} // method with nested local class
	
} // end class
