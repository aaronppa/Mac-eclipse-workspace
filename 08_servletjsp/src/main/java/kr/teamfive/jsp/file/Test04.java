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

import kr.teamfive.common.file.TeamfiveFileRenamePolicy;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

@WebServlet("/jsp/file/test04.do")
public class Test04 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 	저장되는 경로와 파일의 이름을 변경하자  
		 */
		String uploadPath = "/Users/wonchoi/Desktop/JavaPractice/jsp_upload_testing";

		// 날짜를 활용해서 디렉토리를 구성(년/월/일/시)
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/HH");
		String datePath = sdf.format(new Date());
//		System.out.println(uploadPath+datePath);
		// File - mkdirs()
		File file = new File(uploadPath+datePath);
		if(file.exists()==false) file.mkdirs();

		MultipartRequest mRequest = new MultipartRequest(
				request,
				uploadPath+datePath, // 사용자가 전송한 파일이 저장될 폴더 지정 
				1024 * 1024 * 100, // 업로드될 파일의 최대 크기 지정 
				"utf-8", // 파라미터 코딩 지정
				new TeamfiveFileRenamePolicy() // 서버에 실제 저장되는 파일의 이름 규칙 지정 
				);


		String msg = mRequest.getParameter("msg");
		System.out.println("msg: "+msg);

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
				
				// Creating Thumbnails image files from original uploaded image files
				Thumbnails.of(new File(f.getParent(), sysName))
						.size(300,200)
						.outputFormat("jpg")
						.toFile(new File(f.getParent(), "thumb_"+sysName));
			}
		}

	}
} // end class
