package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Test04 {
	public static void main(String[] args) throws Exception{
		URL url = new URL(
				"http://192.168.0.179:8000/test03"
				);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(url.openStream(), "utf-8")
				);
		while(true) {
			String line = br.readLine();
			if(line==null) break;
			System.out.println(line);
		}
	}
}
