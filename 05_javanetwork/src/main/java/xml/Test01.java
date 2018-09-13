package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/*
  xml 문자열을 파싱 처리하는 api를 이해하자 

	Parser: DOM, SAX
	DOM: 전체를 메모리에 로딜 후 프로그램에서 접근가능하게 하는 방법 
		- 전체 데이터가 큰 경우메모리가 부하될 가능 성이 높음.
		- HTML DOM과 매우 유사.. 
	SAX: 한줄 읽고 처리, 이벤트 
	
	
*/
public class Test01 {
	public static void main(String[] args) {
		// data/data1.xml 파일의 내용을 읽어서 "다스베이더","호머","베트맨" 데이터를 추출 
		
		try {
			// DOM parser: DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			
			// xml document를 parser에게 처리 지시..
			Document doc = parser.parse("data/data1.xml");
			
			// parsed 된 내용 중에서 family 태크 정보를 가져온다.  
			NodeList list = doc.getElementsByTagName("family");
			for(int i=0; i<list.getLength();i++) {
				Node family = list.item(i);
				System.out.println(family.getTextContent());
			}
		} catch (Exception e){
			
			e.printStackTrace();
		}
	}
}
