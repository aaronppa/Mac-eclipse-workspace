package network;

import java.net.URL;

public class Test02 {
	public static void main(String[] args) throws Exception{
		URL url = new URL(
				"https://www.naver.com:80/board/login.do?msg=hello"
				);
		System.out.println(url.getProtocol()); // http
		System.out.println(url.getHost()); // www.naver.com
		System.out.println(url.getPort()); // 8080 - web default port(server)
		System.out.println(url.getPath()); // /board/login.do
		System.out.println(url.getQuery()); // msg=hello, parameter , "?"뒤는 Query parameter 부분 
		
		
	}
}


/*

https://news.naver.com/main/main.nhn?

Parameter 구조 
이름=값&이름=값 (여러개의 parameter가 있으면 "&"를 붙인다.  
mode=LSD&mid=shm&sid1=102

*/
