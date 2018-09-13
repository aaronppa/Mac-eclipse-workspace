package openapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class Test02 {
	public static void main(String[] args) throws Exception{
//		  String clientId = "8FtQazsPmUz119RnaYBG";//애플리케이션 클라이언트 아이디값";
//	        String clientSecret = "F4OqMF3OJX";//애플리케이션 클라이언트 시크릿값";
//	        try {
//	            String text = "http://www.yonhapnews.co.kr/bulletin/2018/08/21/0200000000AKR20180821139600014.HTML?input=1195m";
//	            String apiURL = "https://openapi.naver.com/v1/util/shorturl?url=" + text;
//	            URL url = new URL(apiURL);
//	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
//	            con.setRequestMethod("GET");
//	            con.setRequestProperty("X-Naver-Client-Id", clientId);
//	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
//	            int responseCode = con.getResponseCode();
//	            BufferedReader br;
//	            if(responseCode==200) { // 정상 호출
//	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//	            } else {  // 에러 발생
//	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
//	            }
//	            String inputLine;
//	            StringBuffer response = new StringBuffer();
//	            while ((inputLine = br.readLine()) != null) {
//	                response.append(inputLine);
//	            }
//	            br.close();
//	            System.out.println(response.toString());
//	        } catch (Exception e) {
//	            System.out.println(e);
//	        }
		
		String shortUrl = "https://openapi.naver.com/v1/util/shorturl";
		try {
			String orgUrl = "http://www.yonhapnews.co.kr/bulletin/2018/08/21/0200000000AKR20180821139600014.HTML?input=1195m";
//			String parameter = "?url="+orgUrl;
//			System.out.println(parameter);
//			URL url = new URL(shortUrl + parameter);
			URL url = new URL(shortUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			// GET 방식 설정 
//			conn.setRequestMethod("GET");
			
			// POST 방식 설정 
			conn.setRequestMethod("POST");
			
			// Header Set
			conn.setRequestProperty("X-Naver-Client-Id", "8FtQazsPmUz119RnaYBG");
			conn.setRequestProperty("X-Naver-Client-Secret", "F4OqMF3OJX");
			
			// POST 방식일 경우 파라미터 설정 
			conn.setDoOutput(true);
			OutputStream out = conn.getOutputStream();
			out.write(("url="+orgUrl).getBytes("utf-8"));
			out.close();
			
			int code = conn.getResponseCode();
			System.out.println("Response Code: "+code);
						
			// Request후 Response 추출하기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8")); 
			
			while(true) {
				String line = br.readLine();
				if(line==null) break;
		
				//서버에서 보내준 Response Data print
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
