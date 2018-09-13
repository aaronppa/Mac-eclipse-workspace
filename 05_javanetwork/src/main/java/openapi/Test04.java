package openapi;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class Test04 {
	public static void main(String[] args) throws Exception{
		String shortUrl = "https://openapi.naver.com/v1/util/shorturl.xml";
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
			
			// 응답된 XML 데이터에서 원하는 값을 추출하자 
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			
			// xml document를 parser에게 처리 지시..
			Document doc = parser.parse(conn.getInputStream()); // XML data file path 없이  conn.getInputStream() 로 대체 해서 바로 추출 
			
			NodeList list = doc.getElementsByTagName("url");
			// <url><![CDATA[http://me2.do/xnEaXlPA]]></url>
			Node node = list.item(0);
			
			System.out.println(node.getTextContent());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
