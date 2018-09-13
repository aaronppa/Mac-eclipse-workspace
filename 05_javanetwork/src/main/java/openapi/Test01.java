package openapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Test01 {
	public static void main(String[] args) {
//		String blogUrl = "https://openapi.naver.com/v1/search/blog.xml"; // xml데이터로 응답 받기 
		String blogUrl = "https://openapi.naver.com/v1/search/blog"; // json 데이터로 응답받기 
		try {
			String parameter = "?query="+URLEncoder.encode("태풍","UTF-8");
			System.out.println(parameter);
			URL url = new URL(blogUrl + parameter);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			// GET 방식 설정 
			conn.setRequestMethod("GET");
			
			// Header Set
			conn.setRequestProperty("X-Naver-Client-Id", "8FtQazsPmUz119RnaYBG");
			conn.setRequestProperty("X-Naver-Client-Secret", "F4OqMF3OJX");
			
			int code = conn.getResponseCode();
			System.out.println("Response Code: "+code);
						
			// Request후 Response 추출하기
			BufferedReader br = new BufferedReader( new InputStreamReader(conn.getInputStream(), "utf-8")); 
			
			while(true) {
				String line = br.readLine();
				if(line==null) break;
		
				//서버에서 보내준 Response Data print
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
<?xml version="1.0" encoding="UTF-8"?>
	<rss version="2.0">
		<channel>
			<title>Naver Open API - blog ::'자바'</title>
			<link>http://search.naver.com</link>
			<description>Naver Search Result</description>
			<lastBuildDate>Wed, 22 Aug 2018 13:13:14 +0900</lastBuildDate>
			<total>594835</total>
			<start>1</start>
			<display>10</display>
			<item>
				<title>&lt;b&gt;자바&lt;/b&gt;학원 코리아교육그룹 수업후기! 리뷰</title>
				<link>http://blog.naver.com/ha99haha?Redirect=Log&amp;logNo=221325302977</link>
				<description>오늘은 제가 &lt;b&gt;자바&lt;/b&gt; 학원에서 어떠한 수업을 들었으며, 취,업까지 어떠한 준비를 했는지 이야기를 해보려... 그런데 그때 친구가 다니는 &lt;b&gt;자바&lt;/b&gt;학원 코리아IT학원에서 설명회를 한다는 소식을 듣고 참석하게... </description>
				<bloggername>달빛</bloggername><bloggerlink>http://blog.naver.com/ha99haha</bloggerlink><postdate>20180724</postdate></item><item><title>대구&lt;b&gt;자바&lt;/b&gt;학원 어플개발 학습후기</title><link>http://blog.naver.com/restinia?Redirect=Log&amp;logNo=221330058805</link><description>오늘은 제가 다닐 대구&lt;b&gt;자바&lt;/b&gt;학원에 대한 후기를 포스팅하려고 해요. 컴퓨터공학과를 전공한 저는 집에서... 학년을 올라가면서 &lt;b&gt;자바&lt;/b&gt;언어도 배우고 이것저것 많이 배웠어요. 하지만..졸업을 한 시점에서 기억이... </description><bloggername>세상 살이 나그네</bloggername><bloggerlink>http://blog.naver.com/restinia</bloggerlink><postdate>20180731</postdate></item><item><title>&lt;b&gt;자바&lt;/b&gt;프로그래밍학원 앱개발 배운 적나라한 후기!</title><link>http://blog.naver.com/qorghgksquf?Redirect=Log&amp;logNo=221339900862</link><description>해준 &lt;b&gt;자바&lt;/b&gt;프로그래밍학원에 대해서 후기를 남겨볼까 한다 먼저 나는 정보통신학과를 졸업했는데, 대학교 4년동안 &lt;b&gt;자바&lt;/b&gt;, C언어, 웹 프로그래밍에 대해서 배우긴 했지만 이것을 활용하여 실무를 할 수 있을... </description><bloggername>1</bloggername><bloggerlink>http://blog.naver.com/qorghgksquf</bloggerlink><postdate>20180816</postdate></item><item><title>&lt;b&gt;자바&lt;/b&gt;국비지원 고민하지 마세요</title><link>http://blog.naver.com/jjkbw1234?Redirect=Log&amp;logNo=221321538228</link><description>&lt;b&gt;자바&lt;/b&gt;국비지원 고민하지 마세요 안녕하세요! 이제 대학교 1학기가 끝나고, 4학년 분들은 취업 준비에... 국비지원교육으로 받을 수 있는 교육은 많은데, 제가 특히 추천 드리는 부분은 &lt;b&gt;자바&lt;/b&gt; 스크립트 부분이에요.... </description><bloggername>달콤한스터디룸♬</bloggername><bloggerlink>http://blog.naver.com/jjkbw1234</bloggerlink><postdate>20180718</postdate></item><item><title>대구&lt;b&gt;자바&lt;/b&gt;학원 : 4차산업 혁명 첫 걸음 java</title><link>http://blog.naver.com/zero_hack?Redirect=Log&amp;logNo=221340137064</link><description>대구&lt;b&gt;자바&lt;/b&gt;학원 4차산업 혁명 첫 걸음 java 첫 느낌은 음.. 굉장히 세련되고 오.. 뭔가 컴퓨터 IT 하는 곳... 대구&lt;b&gt;자바&lt;/b&gt;학원 을 통해 점점 저의 실력이 향상되는 듯 한 느낌이 들때마다 엄청 뿌듯했습니다. 사실... </description><bloggername>동까스세상</bloggername><bloggerlink>http://blog.naver.com/zero_hack</bloggerlink><postdate>20180816</postdate></item><item><title>익산 카페 추천, &lt;b&gt;자바&lt;/b&gt;브레이크 에서 커피에 와플 먹으며 데이트 ♡</title><link>http://blog.naver.com/o_o_33?Redirect=Log&amp;logNo=221339661088</link><description>익산 &lt;b&gt;자바&lt;/b&gt;브레이크 카페 전북 익산시 선화로 510-7 063-832-2556 매일 10:00 ~ 22:30 엄청난 햇빛과 더위를... 익산 #신흥동 에 생긴 #&lt;b&gt;자바&lt;/b&gt;브레이크 !! 다소 쌩뚱맞은 곳에 2층짜리로 생겼어요. 좁은 길로 들어가야하니... </description><bloggername>조잘조잘 빡찡</bloggername><bloggerlink>http://blog.naver.com/o_o_33</bloggerlink><postdate>20180816</postdate></item><item><title>&lt;b&gt;자바&lt;/b&gt;긴팔원숭이의 영역싸움</title><link>http://blog.naver.com/ly0123?Redirect=Log&amp;logNo=221338708323</link><description>노래하는 원숭이들의 추격전이 벌어졌다 5단계 &lt;b&gt;자바&lt;/b&gt;긴팔원숭이의 영역싸움 인도네시아 &lt;b&gt;자바&lt;/b&gt;섬에 얼마 남지 않은 유인원 이웃 수컷이 침범하자, 암컷이 알리고 수컷들의 쫓고 쫓기는 추격전이 시작된다... </description><bloggername>ly0123님의 블로그</bloggername><bloggerlink>http://blog.naver.com/ly0123</bloggerlink><postdate>20180814</postdate></item><item><title>[왕초보를 위한 &lt;b&gt;자바&lt;/b&gt;] 01. 이클립스 환경 셋팅</title><link>http://blog.naver.com/jktk1?Redirect=Log&amp;logNo=221262026541</link><description>시중에는 수많은 &lt;b&gt;자바&lt;/b&gt;책이 있으며, 인터넷상에도 수많은 &lt;b&gt;자바&lt;/b&gt; 강좌가 있습니다. 그런데 그러한 것들 대부분은 처음부터 너무 많은 걸 설명합니다. 영어로 치면 ABC부터 배워야 할 학생한테 영어의 기원부터... </description><bloggername>릿드의 컴퓨터교실</bloggername><bloggerlink>http://blog.naver.com/jktk1</bloggerlink><postdate>20180426</postdate></item><item><title>자취방 꾸미기! &lt;b&gt;자바&lt;/b&gt;데코 여름이불 잉글랜더 LED 수납침대</title><link>http://blog.naver.com/kduckyoung?Redirect=Log&amp;logNo=221299216404</link><description>&lt;b&gt;자바&lt;/b&gt;데코 여름이불을 구매했습니다. &lt;b&gt;자바&lt;/b&gt;데코 여름이불 시어서커 원단을 통해 통풍 기능 강화 &lt;b&gt;자바&lt;/b&gt;데코 여름이불 자취방 여름 필수품 제가 구매한 &lt;b&gt;자바&lt;/b&gt;데코 여름이불 사진을 보시면, 체크무늬에 색상은... </description><bloggername>LIFE_TAILOR</bloggername><bloggerlink>http://blog.naver.com/kduckyoung</bloggerlink><postdate>20180615</postdate></item><item><title>엉망진창 식물 다듬기 (드라세나 &lt;b&gt;자바&lt;/b&gt;)</title><link>http://blog.naver.com/aflaree?Redirect=Log&amp;logNo=221336493467</link><description>식물의 원래 이름은 드라세나 &lt;b&gt;자바&lt;/b&gt;입니다. 식물에 대한 자세한 설명은 농사로 링크를 참조해주세요.... 이쁘게 새 단장한 드라세나 &lt;b&gt;자바&lt;/b&gt;는 누구에게 분양이 될지 기대됩니다. 이랑가드닝은 덕천에 있는... </description><bloggername>이랑가드닝</bloggername><bloggerlink>http://blog.naver.com/aflaree</bloggerlink><postdate>20180810</postdate></item></channel></rss>
*/