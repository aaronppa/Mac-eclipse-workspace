package crawling.hw;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TicketReserveRank {
	private Document doc;
	
	public TicketReserveRank() {
		try {
			this.doc = Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rreserve.nhn").get();						
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // constructor
	
	public void Rank() {
		Elements list = doc.select("tbody > tr > td");
		Elements pList = list.select("td.reserve_per.ar");
		Elements tList = list.select("td.title");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("조회 시간: "+sdf.format(date));
		System.out.println("---------------------------------------------");
		System.out.println("  순위\t 예매율\t 영화제목");
		System.out.println("---------------------------------------------");
		for(int i=0;i<10;i++) {
			int no=i+1;
			System.out.printf(
					"%5d\t %6s\t %s\n",
					no, pList.get(i).text(),tList.get(i).text()
					);
		}
	
	}
} // end class
