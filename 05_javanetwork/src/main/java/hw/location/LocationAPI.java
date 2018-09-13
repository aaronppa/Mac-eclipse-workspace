package hw.location;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class LocationAPI {

	public static void FindGeoCode() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("찾는 좌표의 위치를 입력하세요> ");
			String location = sc.nextLine();

			try {
				String param = "?query="+URLEncoder.encode(location,"UTF-8");
				String locationApi = "https://openapi.naver.com/v1/map/geocode"; 
				URL url = new URL(locationApi+param);
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();

				conn.setRequestMethod("GET");

				conn.setRequestProperty("X-Naver-Client-Id", "8FtQazsPmUz119RnaYBG");
				conn.setRequestProperty("X-Naver-Client-Secret", "F4OqMF3OJX");

				int respCode = conn.getResponseCode();

				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));

				Gson gson = new Gson();
				GeoCodeResult gcr = gson.fromJson(br, GeoCodeResult.class);

				List<Items> rsList = gcr.getResult().getItems();

				if(respCode==200) {
					System.out.println("-----------------------------------------------------------");
				System.out.println("찾은 주소 개수: "+rsList.size());
				System.out.println("-----------------------------------------------------------");
				int i =1;
					for(Items rs:rsList) {
						System.out.println(i+". "+rs.getAddress()+"의 좌표정보");
						System.out.println("x: "+rs.getPoint().getX()+"\t"+"y: "+rs.getPoint().getY());
						System.out.println("-----------------------------------------------------------");
						i++;
					}
				} else {
					System.out.println("오류 발생!!!! 다시 입력하세요.");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
					continue;
				}

			} catch (Exception e) {
				System.out.println("오류 발생!!!!");
				e.printStackTrace();
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
			}
		} // while
	} // FindGeoCode();

} // end class

/*
 {
    "result": {
        "total": 2,
        "userquery": "수지로 75",
        "items": [
            {
                "address": "경기도 용인시 수지구 수지로 75 심곡마을 광교 힐스테이트",
                "addrdetail": {
                    "country": "대한민국",
                    "sido": "경기도",
                    "sigugun": "용인시 수지구",
                    "dongmyun": "수지로",
                    "ri": "",
                    "rest": "75 심곡마을 광교 힐스테이트"
                },
                "isRoadAddress": true,
                "point": {
                    "x": 127.0743003,
                    "y": 37.3082513
                }
            },
            {
                "address": "전라북도 임실군 수지로 73-4 신덕교회",
                "addrdetail": {
                    "country": "대한민국",
                    "sido": "전라북도",
                    "sigugun": "임실군",
                    "dongmyun": "수지로",
                    "ri": "",
                    "rest": "73-4 신덕교회"
                },
                "isRoadAddress": true,
                "point": {
                    "x": 127.1753883,
                    "y": 35.6838500
                }
            }
        ]
    }
}


 */
