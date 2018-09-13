package kr.teamfive.common.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/common/file/download")
public class Download extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  공용으로 파일을 다운로드 받기 위한 필수 요구사항 
		 *   - 서버에 저장되어 있는 실제 파일명 (name) 
		 *   - 파일이 저장되어 있는 경로 (path)
		 *   - 다운로드 여부 (dname parameter가 존재하는 경우 다운, 없는 경우 이미지를 화면에 출력)
		 *   
		 */
		
		// http://loca~:/~/projectname/common/file/download
		// ?name=UUID.jpg&path=/2018/09/06/13
		// &dname=flower.jpg 
		String name = request.getParameter("name");
		String path = request.getParameter("path");
		
		// Download file name
		String dname = request.getParameter("dname");
				
		// dname의 존재여부에 따라서 화면 출력 또는 다운로드 처리한다. 
		if(dname==null) {
			response.setHeader("Content-Type", "image/jpg");
		}
		//  다운로드
		else{
			// 파일을 다운로드 시켜라. 
			response.setHeader("Content-Type", "application/octet-stream");
			
			// 다운로드 파일 이름 처리하기 
			dname = new String(dname.getBytes("utf-8"), "8859_1");
			
			response.setHeader("Content-Disposition", "attachment;filename="+dname);
		} // if-else
		
		// 다운로드 또는 화면에 보여질 파일의 위치 
//		String uploadPath = "/Users/wonchoi/Desktop/JavaPractice/jsp_upload_testing";
//		File f = new File(uploadPath+path, name);
		File f = new File(path, name);
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		OutputStream out = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		while(true) {
			int ch = bis.read();
			if(ch==-1) break;
			
			bos.write(ch);
		}
		
		bis.close();fis.close();bos.close();out.close();
		
	} // service()

		
} // end class
