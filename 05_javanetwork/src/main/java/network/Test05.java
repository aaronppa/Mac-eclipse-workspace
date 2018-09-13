package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 
	 Parameter
	 URL에 포함 하여 보내는 방식 : GET
	 URL에 제외하고 BODY 에 포함하여 보내는 방식: POST 
	 
	 HTTP: 규약 
	 CLIENT -------  요청(Request)  ----->  Server
	 CLIENT <------  응답(Response) ------  Server
 
	<Request>
		1. Request 시작 라인: 첫라인만 시작 라인 
		 	- 요청방식(GET or POST) 
		 		ex) GET /test04?id=hong&pass=1111 HTTP/1.1 "?"가 붙으면 GET 방식 
		 		ex) POST /test04 
		 	- URL 
		 	- HTTP version info  
		2. Header	
			ex) a=1\r\n
				b=21\r\n
				
		3. 첫 공백라인 (1\r\n): 줄넘김
		4. Body
			- Post 방식일떄 parameter 정보로 요청보냄 
 
  URL.class는 get 방식만 가능
  POST 방식으로 하려면  HttpURLConnection.class 사용해야 한다. 
 
 */

public class Test05 {
	public static void main(String[] args) throws Exception{
		//호출시 POST 방식 활용
		//해더값 추가하기 
		// HttpURLConnection
		URL url = new URL(
				"http://192.168.0.179:8000/test05"
		);
		
		// POST 방식
		// Parameter 전송 
		// Header 사용 
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		// 명시적으로 POST 방식 지정 
		conn.setRequestMethod("POST");
		
		// 헤더 값 설정하기 
		conn.setRequestProperty("my-account", "won");
		conn.setRequestProperty("my-msg", "call");
		
		// Parameter 사용하기 
		conn.setDoOutput(true);
		
		// Output Object 
		OutputStream out = conn.getOutputStream();
		out.write("id=hong&pass=1234".getBytes("utf-8")); // Parameter 를 Body 에 넣는 코드 
		out.close();
		
		// 응답 처리 부분 
		
		// 응답 코드: 200(success), 404(File not Found), 500(Server Error) 
		int code = conn.getResponseCode();
		System.out.println("Response Code: "+code);
		
		// Request후 Response 추출하기
		BufferedReader br = new BufferedReader( new InputStreamReader(conn.getInputStream(), "utf-8")); 
		
		while(true) {
			String line = br.readLine();
			if(line==null) break;
	
			//서버에서 보내준 Response Data print
			System.out.println(line);
		}
	
	} // main()
	
} // end class
