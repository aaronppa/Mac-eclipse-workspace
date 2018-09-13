package org.bitcamp.ex.it_objectinputstream_outputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamExample {

	public static void main(String[] args) throws Exception{
		//바이트기반의 파일출력스트림 생성 
		FileOutputStream fos = new FileOutputStream("/Users/wonchoi/Desktop/JavaPractice/Object.ser");
		
		// 바이트 기반의 객체 직렬화 수행 출력 스트림 생성
		// 보조스트림으로 위의 fos에 직렬화 기능 추가
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// 아래는 다양한 타입의 객체를 파일에 저장수행
		// 즉, 자바 객체를 직렬화하여 파일에 저장
		// 자바객체가 직렬화 될때, 실제 직렬화되는 것은 해당 객체의 
		// 필드 값임 <----- 매우 중요
		
		oos.writeObject(new Integer(10)); 
		oos.writeObject(new Double(3.14));
		oos.writeObject(new int[] {1,2,3});
		oos.writeObject(new String("홍길동"));
		
		oos.flush();
		
		oos.close();
		fos.close();
		
		// 바이트 기반의 파일 입력 스트림 생성 
		FileInputStream fis = new FileInputStream("/Users/wonchoi/Desktop/JavaPractice/Object.ser");
		
		// 바이트 기반의 객체 역직렬화 수행 출력 스트림 생성
		// 보조스트림으로 위의 fis에 역직렬화 기능 추가
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		/* 아래ㅐ는 파일에 저장된 여러개의 자바객체를
		 * 역직렬화하여 다시 JVM 힙영역에 객체로 생성파일에 저장된 자바객체가 역직렬화 될떄.
		 * 실제 역직렬화되는 것은 해당 저장객체의 
		 * 필드값임 <----- 매우 중
		 */
		Integer obj1 = (Integer) ois.readObject();
		Double obj2 = (Double) ois.readObject();
		int[] obj3 = (int[]) ois.readObject();
		String obj4 = (String) ois.readObject();
						
		ois.close();
		fis.close();
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3[0]+","+obj3[1]+","+obj3[2]);
		System.out.println(obj4);
		
	}
} // end class
