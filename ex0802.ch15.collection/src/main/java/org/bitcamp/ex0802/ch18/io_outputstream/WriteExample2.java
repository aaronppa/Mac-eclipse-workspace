package org.bitcamp.ex0802.ch18.io_outputstream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample2 {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("/Users/wonchoi/Desktop/test.txt");
		byte[] data = "ABC".getBytes();
		os.write(data);
		os.flush();
		os.close();
	}

}