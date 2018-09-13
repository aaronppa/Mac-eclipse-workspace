package org.bitcamp.ex11;

import java.util.Arrays;

// deep cloning
public class Member2 implements Cloneable {
	

	public String name;
	public int age;
	public int[] scores;
	public Car car;
	
	public Member2(String name, int age, int[] scores, Car car){
		this.name = name;
		this.age = age;
		this.scores = scores;
		this.car = car;
		
	} // constructor

	// re-declaration of, @Overriding, clone()method to deep clone reference type object. 
	// Otherwise, it will be thin cloned, and the reference type object will change in dependency of clone or original
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// thin clone name and age field
		Member2 cloned = (Member2) super.clone();
		// clone scores
		cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
		// clone car
		cloned.car = new Car(this.car.model);
		
		// return deep cloned Member2 object
		return cloned;
	} //clone
	
	
	public Member2 getMember() {
		Member2 cloned = null;
		try {
			cloned = (Member2) clone();
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return cloned;
	} // getMember method
	
} // end class
