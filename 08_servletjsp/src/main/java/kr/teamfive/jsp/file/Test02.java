/*
 * 	File Upload
 * 	 - 데이터가기존에 알던 파라미터 전송방식이 아니기 떄문에 기본 API 메서드를 이용해서 파라미터 정보 추출이 안된다.
 *   - 라이브러리를 활용한다. (cos.jar, common.io - Spring)
 *   
 */
package kr.teamfive.jsp.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/jsp/file/test02.do")
public class Test02 extends HttpServlet{
	/*
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		// 사용자가 전송한 데이터를 확인 

		InputStream in = request.getInputStream();
		Scanner sc =new Scanner(in);

		while(sc.hasNextLine()) {
			out.println(sc.nextLine());
		}

		out.close();
	}
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest mRequest = new MultipartRequest(
				request,
				"/Users/wonchoi/Desktop/JavaPractice/jsp_upload_testing", // 사용자가 전송한 파일이 저장될 폴더 지정 
				1024 * 1024 * 100, // 업로드될 파일의 최대 크기 지정 
				"utf-8", // 파라미터 코딩 지정
				new DefaultFileRenamePolicy() // 서버에 실제 저장되는 파일의 이름 규칙 지정 
				);


		String msg = mRequest.getParameter("msg");
		System.out.println("msg: "+msg);

		/*
		for(int i=1;i<6; i++) {
			File f = mRequest.getFile("attach"+i);
			if(f!=null) {
				 System.out.println("File Size(byte) : "+f.length());
				 // 사용자가 업로드한 원본 파일명 가져오기 
				 String oriName = mRequest.getOriginalFileName("attach"+i);
				 System.out.println("Original Filename : "+oriName);
				 // 서버에 실제 저장된 파일명 가져오기 
				 String sysName = mRequest.getFilesystemName("attach"+i);
				 System.out.println("System Filename : "+sysName);	 
			}
		}
		 */

		Enumeration<String> list = mRequest.getFileNames();

		while(list.hasMoreElements()) {
			// attach1, attach2, attach3, attach4, attach5
			String fName = list.nextElement();
			File f = mRequest.getFile(fName);
			if(f!=null) {
				System.out.println("File Size(byte) : "+f.length());
				// 사용자가 업로드한 원본 파일명 가져오기 
				String oriName = mRequest.getOriginalFileName(fName);
				System.out.println("Original Filename : "+oriName);
				// 서버에 실제 저장된 파일명 가져오기 
				String sysName = mRequest.getFilesystemName(fName);
				System.out.println("System Filename : "+sysName);	 
			}
		}

	}
} // end class
