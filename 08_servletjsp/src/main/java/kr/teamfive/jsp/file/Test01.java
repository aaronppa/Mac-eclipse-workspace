/*
 * 	File Upload
 * 	 - 데이터가기존에 알던 파라미터 전송방식이 아니기 떄문에 기본 API 메서드를 이용해서 파라미터 정보 추출이 안된다.
 *   - 라이브러리를 활용한다. (cos.jar, common.io - Spring)
 *   
 */
package kr.teamfive.jsp.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/jsp/file/test01.do")
public class Test01 extends HttpServlet{
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
		/* 전송된 파라미터 가져오기 : enctype이 multipart 방식 경우에는 동작되지 않는다. 
		String msg = request.getParameter("msg");
		System.out.println("msg: "+msg);
		*/
		
		// 파라미터 처리와 파일정보 처리를 위해 라이브러리 활용
		// 객체가 생성되면서 지정된 디렉토리 폴더 하위에 사용자가 선택한 파일이 저장되고 
		// 파라미터들이 자동 파싱처리된다. 
		MultipartRequest mRequest = new MultipartRequest(
				request,
				"/Users/wonchoi/Desktop/JavaPractice/jsp_upload_testing", // 사용자가 전송한 파일이 저장될 폴더 지정 
				1024 * 1024 * 100, // 업로드될 파일의 최대 크기 지정 
				"utf-8", // 파라미터 코딩 지정
				new DefaultFileRenamePolicy() // 서버에 실제 저장되는 파일의 이름 규칙 지정 
		);
		
		String msg = mRequest.getParameter("msg");
		System.out.println("msg: "+msg);
	
		// 원본파일명, 서버에 저장된 파일명, 파일 사이즈, 저장된 경로
		
		// 사용자가 화면에서 선택한 파일 타입의 파라미터 이름
		// 	<input type="file" name="attach1" />
		File f1 = mRequest.getFile("attach1");
		
		// 파일을 선택하지 않는 경우 반환된 파일객체는 null을 가진다. 
		if(f1!=null) {
			 System.out.println("File Size(byte) : "+f1.length());
			 // 사용자가 업로드한 원본 파일명 가져오기 
			 String oriName = mRequest.getOriginalFileName("attach1");
			 System.out.println("Original Filename : "+oriName);
			 // 서버에 실제 저장된 파일명 가져오기 
			 String sysName = mRequest.getFilesystemName("attach1");
			 System.out.println("System Filename : "+sysName);	 
		}
		
		File f2 = mRequest.getFile("attach2");
		
		// 파일을 선택하지 않는 경우 반환된 파일객체는 null을 가진다. 
		if(f2!=null) {
			System.out.println("File Size(byte) : "+f2.length());
			// 사용자가 업로드한 원본 파일명 가져오기 
			String oriName = mRequest.getOriginalFileName("attach2");
			System.out.println("Original Filename : "+oriName);
			// 서버에 실제 저장된 파일명 가져오기 
			String sysName = mRequest.getFilesystemName("attach2");
			System.out.println("System Filename : "+sysName);	 
		}
	}
} // end class
