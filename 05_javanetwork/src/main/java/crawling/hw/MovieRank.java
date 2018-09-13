package crawling.hw;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MovieRank {
	private Document doc;
	
	public MovieRank() {
		try {
			this.doc = Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rmovie.nhn").get();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Rank() {
		Elements list = doc.select("#content tr > td.title");
		Elements aList = list.select("a[href^=/movie]");
		
		System.out.println("-------------------------------------");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("조회 시간: "+sdf.format(date));
		System.out.println("-------------------------------------");
		System.out.println("  순위\t\t 영화제목");
		System.out.println("-------------------------------------");
		for(int i=0;i<10;i++) {
			int no =i+1;
			System.out.printf(
					"%5d\t %s\n",
					no, aList.get(i).html()
					);
		} // for 
		System.out.println("-------------------------------------");
	}
	
}// end class
