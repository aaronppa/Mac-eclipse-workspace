package openapi;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test05 {
	private static void test05() throws Exception{
		String blogUrl = "https://openapi.naver.com/v1/search/blog.xml";
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("블로그 검색어 입력:");
			String searchWord = sc.nextLine();
			String parameter = "?query="+URLEncoder.encode(searchWord,"UTF-8");
			URL url = new URL(blogUrl+parameter);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();

			conn.setRequestMethod("GET");

			conn.setRequestProperty("X-Naver-Client-Id", "8FtQazsPmUz119RnaYBG");
			conn.setRequestProperty("X-Naver-Client-Secret", "F4OqMF3OJX");

			int code = conn.getResponseCode();
			System.out.println("Response Code: "+code);


			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();

			Document doc = parser.parse(conn.getInputStream()); 

			NodeList list = doc.getElementsByTagName("item");
			List<Blog> bList = new ArrayList<>();
			for(int i=0;i<list.getLength();i++) {
				Node item = list.item(i);

				NodeList cList = item.getChildNodes();
				Blog blog = new Blog();

				for(int j=0;j<cList.getLength();j++) {
					Node cNode = cList.item(j);
					String name = cNode.getNodeName();

					switch(name) {
					case "link": blog.setLink(cNode.getTextContent()); break;
					case "bloggername": blog.setBloggerName(cNode.getTextContent()); break;
					case "title": blog.setTitle(cNode.getTextContent()); break;
					} // switch
				} // inner for
				bList.add(blog);

			}
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("블로거링크\t\t\t\t\t\t 블로거이름\t\t\t\t\t 제목");
			System.out.println("-----------------------------------------------------------------------------------");

			for(Blog b:bList) {

				System.out.printf(
						"%s\t\t\t\t %s\t\t\t\t %s\t\t\t\t\n",
						b.getLink(),b.getBloggerName(),b.getTitle()
						);
			} // for print
		} // while

	} // test05()

	public static void main(String[] args) {
		try {
			test05();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} // end class
