package crawling.hw;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PersonRank {
	private Document doc;
	
	public PersonRank() {
		try {
			this.doc = Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rpeople.nhn").get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // constructor
	
	public void Rank() {
		Elements list = doc.select("tbody > tr");
		Elements aList = list.select("td.title");
		Elements bList = list.select("td.birth.ac");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("조회 시간: "+sdf.format(date));
		System.out.println("----------------------------------------");
		System.out.println("  순위\t   생년월일\t\t 이름");
		System.out.println("----------------------------------------");
		
		int no=1;
		for(int i=0;i<10;i++) {
			System.out.printf(
					"%5d\t %10s\t\t %-5s\n",
					no+i, bList.get(i).text(), aList.get(i).text());
		}
	}

} // end class
