package org.bitcamp.ex0726.ch14.lambda;

public class Member {

	private String name;
	private String id;
	private Address address;
	
	public Member(String name, String id, Address address) {
		this.name = name;
		this.id = id;
		this.address = address;
		
	} // constructor

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}
	
	
	
} // end class
