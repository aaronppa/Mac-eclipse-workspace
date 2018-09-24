package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.db.MyAppSqlConfig;

@WebServlet("/ajax/list")
public class BoardList extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Database에서 게시물 목록을 조회해서
		BoardMapper mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardMapper.class);
		List<Board> list = mapper.selectBoard();
		
		// 화면에 보낸다. (json 문자열로 변환) // HTML이라서 객체를 공유할 수 없다. 
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(new Gson().toJson(list));
		out.close();
	}

	
}
