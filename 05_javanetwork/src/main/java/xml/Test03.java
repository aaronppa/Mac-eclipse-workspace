package xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test03 {
	public static void main(String[] args) {
		// data/data1.xml 파일의 내용을 읽어서 "다스베이더","호머","베트맨" 데이터를 추출 
		
		try {
			// DOM parser: DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			
			// xml document를 parser에게 처리 지시..
			Document doc = parser.parse("data/data2.xml");
			
			// parsed 된 내용 중에서 family 태크 정보를 가져온다.  
			NodeList list = doc.getElementsByTagName("family");
			
			List<Family> fList = new ArrayList<>();
			for(int i=0; i<list.getLength();i++) {
				Node family = list.item(i); // father, mother, me 태그를 포함해야 함 
				
				// family 안에 있는 자식 element 의 정보를 추출
				NodeList cList = family.getChildNodes();
//				System.out.println(cList.getLength()); // enter 값도 node 값으로 인식 
				
				Family fam = new Family();
				
				for(int j = 0; j<cList.getLength();j++) {
					Node cNode = cList.item(j);
					String name = cNode.getNodeName();
//					System.out.println("name: "+name);
					if(name.intern()=="#text") continue;
					
					switch(name) {
					case "father" : fam.setFather(cNode.getTextContent()); break; 
					case "mother" : fam.setMother(cNode.getTextContent()); break; 
					case "son" : fam.setSon(cNode.getTextContent()); break;
					}
					
				}
				fList.add(fam);
				System.out.println();
			}
			//fList : family 가족 정보가 설정되어 있는 리스트임
			for(Family f: fList) {
				System.out.println(
						f.getFather() +", " +
						f.getMother() +", " +
						f.getSon()
						);
			}
		} catch (Exception e){
			
			e.printStackTrace();
		}
	}
}
