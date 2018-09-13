package org.bitcamp.ex0802.ch18.io_outputstream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample1 {

	public static void main(String[] args) throws Exception {
		/* 바이트 기반의 출력스트림을 생성
		 * OutputStream: 추상클래스
		 * FileInputStream: OutputStream을 구현한 자식 클래스 
		 * 생성자 파라미터로 전달된 경로의 파일에 출력이 가능하게 
		 * 해주는 출력 스트림 
		 */
		
		OutputStream os = new FileOutputStream("/Users/wonchoi/Desktop/test.txt");
		
		// 문자열 리터럴로 "ABC"를 준비, 이를 위의 파일에 저장 
		// 문자열객체.getByte() 하면, 문자열 --> 바이트배열로 변환 
		byte[] data = "ABC".getBytes();
		
		// OutputStream의 1바이트 출력메소드인 write(int b)를 사용하여
		// 파일에 출력 
		for(int i=0; i<data.length; i++) {
			os.write(data[i]); // 파일에 1바이트씩 출력하는 메소드 
		}
		
		
		
		os.flush();
		os.close();
	}

}