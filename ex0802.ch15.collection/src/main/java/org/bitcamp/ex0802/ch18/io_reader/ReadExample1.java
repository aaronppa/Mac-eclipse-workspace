package org.bitcamp.ex0802.ch18.io_reader;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample1 {

	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("/Users/wonchoi/Desktop/test.txt");
		int readData; // InputStream(reader)로부터 읽어온 문자수 
		while( true ) {
			readData = reader.read(); // 1개의 문자를 읽어옴. 
			
			// 읽어온 문자수가 -1 되면, EOF 의미(End of Life)
			// 즉, 해당 파일의 끝까지 다 읽었음을 뜻함. 
			if(readData == -1) break;
			System.out.print((char)readData);
		}
		
		reader.close();
	
	}
} // end class
