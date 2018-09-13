package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class Test02 {
	private static void test05() throws Exception{
		String blogUrl = "https://openapi.naver.com/v1/search/blog";
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

//			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
//			
//			while(true) {
//				String line = br.readLine();
//				if(line==null) break;
//		
//				//서버에서 보내준 Response Data print
//				System.out.println(line);
//			}
			
			Gson gson = new Gson();
//			JsonBlog jb = gson.fromJson(new InputStreamReader(conn.getInputStream(),"utf-8"), JsonBlog.class);
			JsonBlog jb = gson.fromJson(new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8")), JsonBlog.class);
			
//			System.out.println("-----------------------------------------------------------------------------------");
//			System.out.println("블로거링크\t\t\t\t\t\t 블로거이름\t\t\t\t\t 제목");
//			System.out.println("-----------------------------------------------------------------------------------");
//			System.out.println(jb.getItems().get(0).getLink());
			
			List<Items> list = jb.getItems();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("블로그 검색어: "+searchWord);
			System.out.println("조회 결과 개수: "+jb.getTotal());
			System.out.println("-------------------------------------------------------------------");
			for(Items i:list) {
				System.out.println("*링크      : "+i.getLink());
				System.out.println("*블로거이름 : "+i.getBloggername());
				System.out.println("*제목      : "+i.getTitle());
				System.out.println();
			}
			
//			for(int i=0;i<jb.getItems().size();i++) {
//				System.out.println("*링크      : "+jb.getItems().get(i).getLink());
//				System.out.println("*블로거이름 : "+jb.getItems().get(i).getBloggername());
//				System.out.println("*제목      : "+jb.getItems().get(i).getTitle());
//				System.out.println();
//			}
			
			
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


/*
{
"lastBuildDate": "Thu, 23 Aug 2018 12:51:19 +0900",
"total": 19985,
"start": 1,
"display": 10,
"items": [
{
"title": "제 19호 태풍 '<b>솔릭</b>' 이렇게 준비하세요~!",
"link": "http://blog.naver.com/likeyyang?Redirect=Log&amp;logNo=221344292932",
"description": "&lt;사진출처: 기상청&gt; 제19호 태풍 <b>솔릭</b>은 미크로네시아에서 제출한 이름으로 전설속의 족장을 칭한다. 24일 오전 6시 기준 서울 남남동쪽 약 70Km부근 육상을 지나쳐 갈 것으로 예상되는 태풍 <b>솔릭</b>의 피해... ",
"bloggername": "양양군청 공식블로그",
"bloggerlink": "http://blog.naver.com/likeyyang",
"postdate": "20180823"

},
{
"title": "제주도 태풍 '<b>솔릭</b>' 피해 예방 대비방법",
"link": "http://blog.naver.com/jangbugon?Redirect=Log&amp;logNo=221344232273",
"description": "제주도 태풍 '<b>솔릭</b>' 피해 예방 대비방법 제19호 태풍 '<b>솔릭</b>'이 제주에 접근해 현재 제주도 육상 전역과 전 행상에는 강한 바람과 많은 비가 내리면서 위력을 드러내고 있습니다. 전국적으로도 크고 작은 태풍... ",
"bloggername": "고르라, 예비사회적기업",
"bloggerlink": "http://blog.naver.com/jangbugon",
"postdate": "20180823"

},
{
"title": "태풍 <b>솔릭</b> 이렇게 대비하세요!",
"link": "http://blog.naver.com/yeongju_city?Redirect=Log&amp;logNo=221344218064",
"description": "태풍 <b>솔릭</b>이 북상할땐 어떤 대비를 해야 할까요? 태풍 <b>솔릭</b>이 북상하고 있어서 피해가 우려되고 있다고 하는데요. 제19호 태풍 <b>솔릭</b>은 우리 한반도를 강타할 것이라고 기상청이 발표를 했어요. 우리 영주시도... ",
"bloggername": "힐링중심 행복영주 영주시청 공식 블로그",
"bloggerlink": "http://blog.naver.com/yeongju_city",
"postdate": "20180823"

},
{
"title": "<b>솔릭</b> 일본기상청 태풍진로예상",
"link": "http://blog.naver.com/jjjang958?Redirect=Log&amp;logNo=221343721968",
"description": "오늘도 달라진 19호 태풍 <b>솔릭</b> 진로예상 경로의 이야기다 나의 기대가 조금은 반영되었는지... 왼쪽으로 조금더 꺽였따. 아래사진은 오늘 일본기상청 <b>솔릭</b>의 태풍예상경로 이다 왼쪽 사진은 오전9시 오른쪽... ",
"bloggername": "짱구오빠농장",
"bloggerlink": "http://blog.naver.com/jjjang958",
"postdate": "20180822"

},
{
"title": "태풍 <b>솔릭</b> 대비하기/오이지지대 철수하고 퇴비넣고!",
"link": "http://blog.naver.com/eye4y?Redirect=Log&amp;logNo=221344095998",
"description": "태풍 <b>솔릭</b>이 북상한다고 해서 주말농장 작물 낙과 되지 않게 미리 수확하라고 하남시민체험농장에서... 땀을 비오듯이 흘렸습니다~ 태풍 <b>솔릭</b> 오기전인데도 햇빛은 뜨겁더군요! 고추 달려있는 애들 모두... ",
"bloggername": "성주는 즐거워~~",
"bloggerlink": "http://blog.naver.com/eye4y",
"postdate": "20180823"

},
{
"title": "6년만에 다시 온 19호 태풍 <b>솔릭</b> 진로 예상 대비책",
"link": "http://blog.naver.com/7412k?Redirect=Log&amp;logNo=221343744601",
"description": "모두가 걱정하는 한반도 내려진 19 태풍 <b>솔릭</b>의 부상으로 대한민국은 그야말로 폭풍 전야,, <b>솔릭</b> 주의보 비상사태입니다 여러분은 이에 어떻게 대비하고 계시나요? 강하게 발달한 <b>솔릭</b> 소식으로 이미 선박들은... ",
"bloggername": "규리의 한약초일기장",
"bloggerlink": "http://blog.naver.com/7412k",
"postdate": "20180822"

},
{
"title": "태풍 '<b>솔릭</b>'을 대비하라! 우석대학교가 소개하는 태풍 대비법",
"link": "http://blog.naver.com/woosukuni?Redirect=Log&amp;logNo=221343861287",
"description": "오늘 유난히 덥고 습하고 해가 쨍쨍한것 같아요~~ 22일 밤부터 24일까지 19호 태풍 <b>솔릭</b>이 한반도를 관통한다고 합니다... 6년만에 한반도 내륙에 강한 영향을 줄 '태풍 <b>솔릭</b>' 재난 피해 없이 무사히 지나갔으면... ",
"bloggername": "우석대학교 공식 블로그",
"bloggerlink": "http://blog.naver.com/woosukuni",
"postdate": "20180822"

},
{
"title": "태풍위치, 공포의 ‘<b>솔릭</b>'",
"link": "http://blog.naver.com/docukang?Redirect=Log&amp;logNo=221344056990",
"description": "태풍위치, 공포의 ‘<b>솔릭</b>’ 몇일 전까지만 해도 태풍 <b>솔릭</b>이 제주도에 상륙한다고 했다가 그다음엔 충남, 인천으로 진로를 예상했었는데.. 이제는 좀 더 북한쪽에 상륙한다는 태풍위치나 태풍진로예상이... ",
"bloggername": "나를 찾아 떠나는 여행",
"bloggerlink": "http://blog.naver.com/docukang",
"postdate": "20180822"

},
{
"title": "[태풍 특보] 19호 태풍 <b>솔릭</b> 북상, 태풍 시마론과 후지와라 효과?",
"link": "http://blog.naver.com/localtv23?Redirect=Log&amp;logNo=221344303346",
"description": "#19호태풍 #<b>솔릭</b> 이 북상하면서 #서해안 일대가 오전부터 #태풍영향권 에 들었습니다. #전남완도 는... 한국 기상청은 #<b>솔릭</b> 과 #시마론 이 합쳐질 가능성은 낮게 예측했습니다. #태풍<b>솔릭</b> 은 현재 #제주 서쪽에... ",
"bloggername": "CJ헬로 지역방송 공식블로그",
"bloggerlink": "http://blog.naver.com/localtv23",
"postdate": "20180823"

},
{
"title": "태풍 <b>솔릭</b> 경로 인천 향한다! 대비 어떻게?",
"link": "http://blog.naver.com/incheontogi?Redirect=Log&amp;logNo=221343793089",
"description": "제19호 태풍 <b>솔릭</b>이 중형급 세력을 유지하며 한반도를 향해 맹렬히 다가오고 있습니다. 그런데 그 경로가 인천과 가까이 향하고 있어 더욱 크게 우려가 되는 상황인데요. <b>솔릭</b>의 세력이 워낙 강하고 한반도... ",
"bloggername": "인천광역시 공식 블로그 온통인천",
"bloggerlink": "http://blog.naver.com/incheontogi",
"postdate": "20180822"

}
]
}

*/