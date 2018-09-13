package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Test01 {
	private static void test01() throws Exception{
		URL url = new URL("https://www.daum.net");
		// 연결된 url로 부터 응답 데이터를 추출하자. 
		InputStream in = url.openStream(); // 문자조합 하지 않는다. 그래서 한글이 깨짐. 
		while(true) {
			// -1 값을 반환하면 더이상 스트림으로 부터 읽을 데이터가 없다는 신호. 
			int ch = in.read();
			
			if(ch == -1) break;
			
			System.out.print((char)ch);
		}
		
	}
	
	private static void test02() throws Exception{
		URL url = new URL("https://www.daum.net");
		// 연결된 url로 부터 응답 데이터를 추출하자. 
		
//		InputStream in = url.openStream();
//		InputStreamReader isr = new InputStreamReader(in);
//		BufferedReader br = new BufferedReader(isr);
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(url.openStream(), "utf-8")
				); 
		
		
		
		while(true) {
			// readLine 값이 null을 반환하면 더이상 스트림으로 부터 읽을 데이터가 없다는 신호. 
			String line = br.readLine();
			
			if(line == null) break;
			
			System.out.println(line);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		try {
//			test01();
			test02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

