package org.bitcamp.ex0801.collection.list;

public class Member {
	public String name;
	public int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	} // constructor

	/* 두 객체의 중복을 비교하는 기준으로 아래와 같이
	 * 하기로 정했음!!! (어디까지나 엿장수 마음임!!!)
	 * Step 1: 이름(필드1) + 나이(필드2)로 해시코드값 생성 
	 * Step 2: 이름은 String클래스의 equals()매소드로 비교하고
	 * 			나이는 동등비교연산자(==)로 비교하기로함 
	 */

	// Duplication Check Step.1: hashCode() 
	public int hashCode() {
		System.out.println("- hashCode: "+name.hashCode()+age);

		return name.hashCode() + age;
	} // hashCode()

	// Duplication Check Step.2: equals()
	public boolean equals(Object obj) {
		/* instanceof 연산자 사용방법: 
		 * 참조변수명 instanceof 클래스명
		 * 해석: 왼쪽의 참조변수가 참조하는 객체의 타입(클래스)이 
		 * 오른쪽에 나오는 클래스와 같은지 비교 
		 */
		if(obj instanceof Member) {
			// member type의 객체로 강제형변환해서
			// 구슬의 타입을 맞춤 
			Member member = (Member) obj;
			return member.name.equals(name) && (member.age==age) ;
		} else {
			return false;
		}
	}


}
