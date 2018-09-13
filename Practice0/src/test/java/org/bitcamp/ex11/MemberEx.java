package org.bitcamp.ex11;

import junit.framework.TestCase;

public class MemberEx extends TestCase{

	public void testMemberThinCopy() {
	// Original Object Constructor
		Member original = new Member("Blue", "Won", "12345",25, true);
		
		// Change PW after cloning
		Member cloned = original.getMember();
		cloned.password = "67890";
		cloned.age = 33;
		
		System.out.println("[Field value of cloned object]");
		System.out.println("id: "+cloned.id);
		System.out.println("name: " + cloned.name);
		System.out.println("password: "+cloned.password);
		System.out.println("age: "+cloned.age);
		System.out.println("adult: "+cloned.adult);
		
		System.out.println();
		
		System.out.println("[Field value of original object]");
		System.out.println("id: "+original.id);
		System.out.println("name: " + original.name);
		System.out.println("password: "+original.password);
		System.out.println("age: "+original.age);
		System.out.println("adult: "+original.adult);
		
		System.out.println();
		
	}
	
	public void testMember2DeepCopy() {
		// Original Object Constructor
			Member2 original = new Member2("Won", 33, new int[] {90,90}, new Car("911 Turbo"));
			
			// Change 
			Member2 cloned = original.getMember();
			cloned.scores[0] = 100;
			cloned.car.model = "Ferrari";
			
			System.out.println("[Field value of cloned object]");
			System.out.println("name: " + cloned.name);
			System.out.println("age: "+cloned.age);
			System.out.print("Scores: "+"{");
			for(int i=0; i<cloned.scores.length; i++) {
				System.out.print(cloned.scores[i]);
				System.out.print((i==(cloned.scores.length-1))?"":",");
			}
			System.out.println("}");
			System.out.println("Car: "+cloned.car.model);
			
			System.out.println();
			
			System.out.println("[Field value of original object]");
			System.out.println("name: " + original.name);
			System.out.println("age: "+original.age);
			System.out.print("Scores: "+"{");
			for(int i=0; i<original.scores.length; i++) {
				System.out.print(original.scores[i]);
				System.out.print((i==(original.scores.length-1))?"":",");
				
			}
			System.out.println("}");
			System.out.println("Car: "+original.car.model);
			
			System.out.println();
			
		} // testMemberThinCopy
	
} // end class
