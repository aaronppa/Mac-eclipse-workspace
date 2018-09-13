package org.bitcamp.ex.it_objectinputstream_outputstream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Child extends Parent implements Serializable{

	public String field2;
	
	// 직렬화 수행 메소드 ----- 매우 중요(후에라도 반드시 이해!)
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(field1); // 부모객체의 특정 필드값을 직렬화 
		out.defaultWriteObject(); // 자식객체의 필드값들을 직렬화 수행 
	} // writeObject
	
	// 직렬화 수행 메소드 ----- 매우 중요(후에라도 반드시 이해!)
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		field1 = in.readUTF(); // 부모객체의 특정 필드값을 역직렬화
		in.defaultReadObject(); // 자식객체의 필드값들을 역직렬화 수행 
	} // readObject
} // end class 
