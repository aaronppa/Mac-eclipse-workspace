package hw.translator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import com.google.gson.Gson;

public class PapagoAPI {

	public static void translate(String lang) {
		try {
			
		Scanner sc = new Scanner(System.in);
		
	
		System.out.println("번역하실 문장을 한국어로 입력하세요> ");
		String text = sc.nextLine();
		
		String trApi = "https://openapi.naver.com/v1/papago/n2mt";
		String param = "source=ko"+"&target="+lang+"&text="+URLEncoder.encode(text,"utf-8");
		URL url = new URL(trApi);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		conn.setRequestMethod("POST");

		conn.setRequestProperty("X-Naver-Client-Id", "8FtQazsPmUz119RnaYBG");
		conn.setRequestProperty("X-Naver-Client-Secret", "F4OqMF3OJX");

		conn.setDoOutput(true);
		OutputStream out = conn.getOutputStream();
		out.write((param).getBytes("utf-8"));
		out.close();
		
//		int respCode = conn.getResponseCode();
		
//		System.out.println(respCode);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8")); 
		
		Gson gson = new Gson();
		TranslateResult gcr = gson.fromJson(br, TranslateResult.class);
		
		Result rs = gcr.getMessage().getResult();
		
		String line = rs.getTranslatedText();
		System.out.println("번역결과: " +line);
		System.out.println("------------------------------------------------");


		} catch (Exception e) {
			// TODO: handle exception
		}
		
	} // translate();
} // end class
