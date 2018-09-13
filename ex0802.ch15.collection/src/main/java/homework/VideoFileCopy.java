package homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class VideoFileCopy {
		public static void main(String[] args) throws Exception {
			String originalFileName = "/Users/wonchoi/Google Drive/0. Coding/Bitcamp/Collaborative Homework/06 Week Team/0802/야생.wmv";
			String targetFileName = "/Users/wonchoi/Downloads/wild.wmv";
			
			FileInputStream fis = new FileInputStream(originalFileName);
			FileOutputStream fos = new FileOutputStream(targetFileName);
			
			int readByteNo;
			byte[] readBytes = new byte[800];
			
			long startTime;
			long endTime;
			
			startTime = System.nanoTime();
			while( (readByteNo = fis.read(readBytes)) != -1 ) {
				fos.write(readBytes, 0, readByteNo);
//				fos.flush();
			}
			
			fos.flush();
			fos.close();
			fis.close();
			endTime = System.nanoTime();
			System.out.println("Copy and Past Elapsed Time: "+(endTime-startTime)/Math.pow(10.0, 9)+" s");
			System.out.println("Successfully Copied and Pasted.");
		}
	}
