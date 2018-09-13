package org.bitcamp.ex0802.ch18.io_inputstream;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample3 {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("/Users/wonchoi/Desktop/test.txt");
		int readByteNo;
		byte[] readBytes = new byte[8];
		
		readByteNo = is.read(readBytes, 2, 3);
		System.out.println(" -readByteno: "+ readByteNo);
		for(int i=0; i<readBytes.length; i++) {
			System.out.println(readBytes[i]);
		}
		is.close();
	}

}