// JSOUP Preparation
// Download Library
// 선택자 이해하기.. : CSS
/*
 * 	select("선택자");
 * 	 1) 태그명 : 태그 이름으로 접근
 * 	   - select("div") --> any tag that is "div" element select
 * 	 2) .name : 태그의 속성의 이름이 class 인 것 중에서 속성의 값이 이름과 같은 것을 찾는다. 
 * 	   - select(".a") --> select element of class='a' 
 * 	 3) #name : 태그의 속성의 이름이 id 인 것 중에서 속성의 값이 이름과 같은 것 
 * 	   - select("#b") -->  select element of id='b'
 *   4) 태그명 태그명 : 앞의 태그의 모든 자식 중에서 뒤의 태그를 선택 
 *     - select("body div") --> select all element of div tag within body tag  
 *     - select("body p") --> select all element of p tag within body tag including any tag deeper
 *   5) 태그명 > 태그명 : 앞의 태그의 직계자식태그 중에서 모든 p 엘리먼트 선택 
 *     - select("body > p") --> select direct element of p tag within body tag only and no further tags
 *   6) [name='value'] : (attribute: 속성) 태그의 속성의 이름이 type이고 속성의 값이 text인 element 선택 
 *     -  <input type="text" /> --> select([type="text']) 
 *        <input name="a" /> : select("input"), select("[name='a']"), select("input[name='a']")
 *        <select name="b"><select/> : select("select[name='b']")
 *     
 *     EX1)
 *     select("table> tr > td > img.a")
 *     <html>
 *     	 <head>
 *     	 </head>
 *       <body>
 *         <table>
 *           <tr>
 *             <td>
 *               <img class = 'a'/>
 *             </td>
 *           </tr>
 *         </table>
 *       </body>
 *     </html>
 *     
 *     EX2)
 *     select("input [name='a']") --> select element of name attribut that is a within input tag 
 *     
 *     select("table.list_ranking > tbody > tr > tb.title > div > a")
 */
package crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Test01 {
	public static void main(String[] args) {
		String html = ""
			    	+ "<html>"
			    	+ "  <head>"
			    	+ "    <title>JSOUP Practice</title>"
			    	+ "  </head>"
			    	+ "  <body>"
			    	+ "    <p>parse HTML</p>"
			    	+ "    <div class='a'>Access Class</div>"
			    	+ "    <p id='b'>Access ID</p>"
			    	+ "    <div>"
			    	+ "      <p>div 안에 있는 p</p>"
			    	+ "     <a href='#1'>Up</a>"
			    	+ "     <a href='#2'>Down</a>"
			    	+ "     <a href='#3'>Middle</a>"
			    	+ "     <a href='http://www.naver.com'>Naver</a>"
			    	+ "    </div>"
			    	+ "  </body>"
			    	+ "</html>";
		
		Document doc = Jsoup.parse(html);
		
//		Elements list = doc.select("div");
//		Elements list = doc.select("p");
//		Elements list = doc.select("div.a");
//		Elements list = doc.select("#b");
//		Element el = doc.getElementById("b");
//		System.out.println(el.html());

//		Elements list = doc.select("div > a");
//		Elements list = doc.select("a[href^='http']"); // ^= 시작하는 문장이 'http'를 찾는다. 
//		Elements list = doc.select("a[href$='com']"); // $= 끝나는 문장이 'com'을 찾는다. 
		Elements list = doc.select("a[href*='com']"); // *= 문장에 'com'을 포함하는 것을 찾는다. 
		
		
		for(Element e:list) {
			System.out.println(e.html());
		}
		
	} // main
	
} // end class
