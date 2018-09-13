package org.bitcamp.ex.it_objectinputstream_outputstream;

import java.io.Serializable;

// Serializable 인터페이스를 구현하고 있는 클래스의
// 객체만이 (역)직렬화의 대상이 됩니다.
// Serializable는 태그 인터페이스(Tag Interface) 

//@SuppressWarnings("serial")
@SuppressWarnings("serial")
public class ClassA implements Serializable{
	
//	private static final long serialVersionUID = 1785660878624422712L;

//	private static final long serialVersionUID = 1L;

	int field1; // (역) 직렬화의 대상
	
	ClassB field2 = new ClassB(); // (역) 직렬화의 대상
	
	static int field3; // (역) 직렬화의 대상에서 제외 
	transient int field4; // (역) 직렬화의 대상에서 제외 
	
} // end class
