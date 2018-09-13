package org.bitcamp.ex.io_console;

import java.io.InputStream;

public class SystemInExample1 {
	public static void main(String[] args) throws Exception {		
		System.out.println("== 메뉴 ==");
		System.out.println("1. 예금 조회");
		System.out.println("2. 예금 출금");
		System.out.println("3. 예금 입금");
		System.out.println("4. 종료 하기");
		System.out.print("메뉴를 선택하세요: ");
		
		InputStream is = System.in;
		
		/* InputStream.read() --> 입력스트림에서 1바이트를 읽음
		 * read() 메소드의 반환타입은 4바이트 int (실제 읽어온
		 * 1바이트 데이터는 4바이트 중 첫번째 바이트에 존재)
		 * 그렇다면, 2바이트인 한글을 입력하면 읽을때는 1바이트??
		 * 어떻게 될까?  
		 */
		char inputChar = (char) is.read();
		
		
		switch(inputChar) {
			case '1':
				System.out.println("예금 조회를 선택하셨습니다.");
				break;
			case '2':
				System.out.println("예금 출금를 선택하셨습니다.");
				break;
			case '3':
				System.out.println("예금 입금를 선택하셨습니다.");
				break;
			case '4':
				System.out.println("종료 하기를 선택하셨습니다.");
				break;
		}			
	}
}
