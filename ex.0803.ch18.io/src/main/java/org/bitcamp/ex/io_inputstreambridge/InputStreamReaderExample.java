package org.bitcamp.ex.io_inputstreambridge;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {

	public static void main(String[] args) throws Exception {
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);	

		int readCharNo;
		char[] cbuf = new char[100];
		while ((readCharNo=reader.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.println(data);
		}
		// 보조스트림만 해제해도, 원 소스 스트림도 자동 해제 
		
		reader.close();
	}
}
