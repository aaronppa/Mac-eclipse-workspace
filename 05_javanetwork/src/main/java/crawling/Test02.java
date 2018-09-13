package crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test02 {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://www.naver.com").get(); // InputStream을 사용하기 때문에 IO try-catch 사용
//			System.out.println(doc.html());
			Elements list = doc.select("ul.ah_l > li.ah_item > a[href='#']");
			for (Element e: list) {
//				System.out.println(e.html());
				Elements sList = e.select("span");
				System.out.println(sList.get(0).html()+"\t"+sList.get(1).html());
			}
				/*
				  <ul class="ah_l"> 
				    <li class="ah_item"> 
				      <a href="#" class="ah_a" data-clk="lve.keyword"> 
				        <span class="ah_r">1</span> 
				        <span class="ah_k">태풍 제비</span> 
				      </a> 
				    </li> 
				 */
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} // main
	
} // end class
