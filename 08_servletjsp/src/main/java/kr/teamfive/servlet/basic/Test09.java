package kr.teamfive.servlet.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/test09")
public class Test09 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 문서의 타입 설정
		// 이미지를 전송
		response.setContentType("image/jpg");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/wonchoi/Desktop/JavaPractice/forest.jpg"));
		
		// Byte 
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		
		while(true) {
			int ch = bis.read();
			if(ch==-1) break;
			
			bos.write(ch);
		}
		bos.close(); bis.close();
	}
	
}
