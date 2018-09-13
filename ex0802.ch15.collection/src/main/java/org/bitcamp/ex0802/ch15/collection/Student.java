package org.bitcamp.ex0802.ch15.collection;

public class Student {

	public int sno;
	public String name;
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	} // constructor
	
	/* Map 자료구조에서, 키 객체의 중복 여부 판단 순서:
	 * Step 1: 기준객체와 비교객체의 해시코드 비교검사 
	 * 			이 Step에서 같지 않으면, 이미 결과는 두 객체는 다름
	 * 			따라서, Step2 추가 검사 하지 않음.
	 * 
	 * Step 2: 기준객체와 비교 객체의 equals() 검사
	 * 			Step 1에서 해시코드가 같은 경우, 두번쨰로 이 Step 2 검사 
	 * 
	 * Object class의 hashCode() 메소드를 재정의함
	 * 이유: 중복여부를 판단하기 위함임 (Map에서 키는 중복허용 안됨).
	 */
	public int hashCode() {
		/* 이 객체의 해시코드를 생성하는 기준은 아래와 같음
		 * 객체의 해시코드 = 학생번호 + 학생이름문자열의 해시코드
		 * 그럼 왜? 학생이름은 원래의 hashCode() 메소드를 그대로 이용하나요???
		 *  ----> 답: 이미 String 클래스는 hashCode() 메소드가 재정의되어있음(이런경우를 대비하여)
		 *  
		 */
		
		return sno =name.hashCode();
	} // hashCode()
	
	
	// Object class의 hashCode() 메소드를 재정의함
	// 이유: 중복여부를 판단하기 위함임 (Map에서 키는 중복허용 안됨).
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student) obj;
			return(sno==student.sno)&& (name.equals(student.name)); 
		} else {
			return false;
		} // if else
	} // boolean equals()
	
	
	
	
} // end class
