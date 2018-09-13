package org.bitcamp.ex.io_console;

import java.io.InputStream;
import java.util.Arrays;

public class SystemInExample2 {
			public static void main(String[] args) throws Exception {			
			InputStream is = System.in;
			
			byte[] datas = new byte[100];
			
			System.out.print("이름: ");
			int nameBytes = is.read(datas);
			String name = new String(datas, 0, nameBytes-1);
			
			System.out.print("하고 싶은말: ");
			int commentBytes = is.read(datas);
			
			System.out.println(
					"- commentBytes: "+Arrays.toString(datas));
					
			// 버퍼의 내용을 엔터키(\r\n)는 제거하고 문자열로 변환
			
			String comment = new String(datas, 0, commentBytes-1);
			
			System.out.println("입력한 이름: " + name);	
			System.out.println("입력한 하고 싶은말: " + comment);	
		}
	}
