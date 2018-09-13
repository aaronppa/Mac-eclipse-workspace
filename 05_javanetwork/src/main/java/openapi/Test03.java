package openapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 
 	캡차 API 사용하기 
 	3단계 과정이 필요함 
 	
 	1. CAPTCHA Key 발급하기 
 		https://openapi.naver.com/v1/captcha/nkey 
 		code=0 으로 설정되어야한다. (Default)
 		
 
 */
public class Test03 {
	// CAPTCHA key 발급
	private static void test01() throws Exception{
		String line;
		String apiUrl = "https://openapi.naver.com/v1/captcha/nkey";
//		String param = "?code=0"; // Default라서 입력 하지 않아도 되지만, 입력한다면 code=0 으로 넣어줘야함. 
//		URL url = new URL(apiUrl+param); 
		URL url = new URL(apiUrl);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		
		// Header Set
		conn.setRequestProperty("X-Naver-Client-Id", "8FtQazsPmUz119RnaYBG");
		conn.setRequestProperty("X-Naver-Client-Secret", "F4OqMF3OJX");
		
		int code = conn.getResponseCode();
		System.out.println(code);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		
		while(true) {
			line = br.readLine();
			if(line==null) break;
			
			System.out.println(line);
		}
	}
	
	private static void test02(String key) throws Exception{
		String apiUrl="https://openapi.naver.com/v1/captcha/ncaptcha.bin";
		URL url = new URL(apiUrl+"?key="+key);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		
		conn.setRequestProperty("X-Naver-Client-Id", "8FtQazsPmUz119RnaYBG");
		conn.setRequestProperty("X-Naver-Client-Secret", "F4OqMF3OJX");
		
		int code = conn.getResponseCode();
		System.out.println(code);
		
		File f = new File("CAPTCHA");
		if(f.exists()==false) {
			f.mkdirs();
		}
		
		File file = new File(f, "captcha3.jpg");
		InputStream in = conn.getInputStream();
		OutputStream out = new FileOutputStream(file);
		while(true) {
			int ch = in.read();
			if(ch==-1) break;
			out.write(ch);
		}
		out.close(); in.close();
		System.out.println("이미지 생성 성공");
	}
	
	private static void test03() throws Exception{
		String apiUrl="https://openapi.naver.com/v1/captcha/nkey";
		String code ="1";
		String key = "a6Rob8dpsuYwfYU2";
		String value = "3CL1";
		String param = "?code="+code+"&key="+key+"&value="+value;
		URL url = new URL(apiUrl+param);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		
		conn.setRequestProperty("X-Naver-Client-Id", "8FtQazsPmUz119RnaYBG");
		conn.setRequestProperty("X-Naver-Client-Secret", "F4OqMF3OJX");
		
		int cd = conn.getResponseCode();
		System.out.println(cd);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		
		while(true) {
			String line = br.readLine();
			if(line==null) break;
			
			System.out.println(line);
		}
		
	}
	
	public static void main(String[] args) {
		try {
//			test01();
//			test02("a6Rob8dpsuYwfYU2");
			test03();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
