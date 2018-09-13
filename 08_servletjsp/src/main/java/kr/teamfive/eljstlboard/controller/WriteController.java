package kr.teamfive.eljstlboard.controller;

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

import kr.teamfive.common.db.MyAppSqlConfig;
import kr.teamfive.common.file.TeamfiveFileRenamePolicy;
import kr.teamfive.repository.domain.Board;
import kr.teamfive.repository.domain.FileAttach;
import kr.teamfive.repository.mapper.BoardMapper;

@WebServlet("/servlet/eljstlboard/write.do")
public class WriteController extends HttpServlet{
	BoardMapper mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardMapper.class);

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileAttach fa = new FileAttach();	
		
		String uploadPath="/Users/wonchoi/Desktop/JavaPractice/jsp_upload_testing";
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/HH");
		String datePath = sdf.format(new Date());
		
		File file = new File(uploadPath+datePath);
		if(file.exists()==false) file.mkdirs();
		
		MultipartRequest mRequest = new MultipartRequest(
				request,
				uploadPath+datePath,
				1024 * 1024 * 100,
				"utf-8",
				new TeamfiveFileRenamePolicy()
				);
		
    	// 사용자 전송 파라미터 꺼내기 
    	String title = mRequest.getParameter("title");
    	String writer = mRequest.getParameter("writer");
    	String content = mRequest.getParameter("content");
       	// 파라미터를 데이터 베이스 처리를 위한 매퍼에게 넘긴다. 
    	
    	Board board = new Board();
    	board.setTitle(title);
    	board.setWriter(writer);
    	board.setContent(content);
    	
    	mapper.insertBoard(board);
    	
    	int no = board.getNo();
    	
    	Enumeration<String> list = mRequest.getFileNames();

		while(list.hasMoreElements()) {
			fa.setFilePath(uploadPath+datePath);
			fa.setNo(no);
			// attach1, attach2, attach3, attach4, attach5
			String fName = list.nextElement();
			File f = mRequest.getFile(fName);
			if(f!=null) {
//				System.out.println("File Size(byte) : "+f.length());
				// 사용자가 업로드한 원본 파일명 가져오기 
				fa.setFileOriName(mRequest.getOriginalFileName(fName));
				// 서버에 실제 저장된 파일명 가져오기 
				fa.setFileSysName(mRequest.getFilesystemName(fName)); 
				mapper.insertFileAttach(fa);
			} // if
		} // while
    	
		response.sendRedirect("/08_servletjsp/servlet/eljstlboard/list.do");
	}

}