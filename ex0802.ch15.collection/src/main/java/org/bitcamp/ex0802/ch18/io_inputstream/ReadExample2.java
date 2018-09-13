package org.bitcamp.ex0802.ch18.io_inputstream;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample2 {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("/Users/wonchoi/Desktop/test.txt");
		int readByteNo;
		byte[] readBytes = new byte[3];
		String data = "";
		while( true ) {
			readByteNo = is.read(readBytes);
			if(readByteNo == -1) break;
			data += new String(readBytes, 0, readByteNo);
		}
		System.out.println(data);
		is.close();
	}

}