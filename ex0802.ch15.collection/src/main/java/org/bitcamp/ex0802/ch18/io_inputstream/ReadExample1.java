package org.bitcamp.ex0802.ch18.io_inputstream;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample1 {

	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("/Users/wonchoi/Desktop/test.txt");
		int readData;
		while( true ) {
			readData = reader.read();
			if(readData == -1) break;
			System.out.print((char)readData);
		}
		
		reader.close();
	
	}

}