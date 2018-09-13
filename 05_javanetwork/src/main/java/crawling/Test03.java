package crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test03 {
	public static void main(String[] args) {
		
		try {
			Document doc = Jsoup.connect("http://www.daum.net").get();
//			System.out.println(doc.html());
			
			Elements list = doc.select("ul.list_weather > li");
			for(Element e:list) {
				Elements cList = e.select("span, strong");

				System.out.println(cList.get(1).html()+"\t"+cList.get(2).html()+"\t"+cList.get(3).html()+cList.get(5).html());
				
			}
			
			/*
			  <ul class="list_weather"> 
                <li class=""> 
                  <span class="screen_out">날씨</span> 
                  <span class="txt_part">서울시</span> 
                  <strong class="img_weather ico_wm04">흐림</strong> 
                  <em class="screen_out">영상 26도</em> 
                  <span class="txt_temper" aria-hidden="true">26</span>
                  <span class="img_weather ico_degree" aria-hidden="true"> <span class="ir_wa">°C</span>
                  </span> 
                </li> 
			 */
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} // main
	
}// end class
