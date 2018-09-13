package network;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Lotto {
	public static void main(String[] args) throws Exception{
		for(int i=1; i<+45;i++) {
		lottoImgSave("ball_"+i+".png");
		}
	}

	private static void lottoImgSave(String name) throws MalformedURLException, FileNotFoundException, IOException {
		URL url = new URL(
				"http://www.nlotto.co.kr/img/common_new/"+name);
	
		File f = new File("lotto");
		if(f.exists()==false) {
			f.mkdirs();
		}
		File file = new File(f, name);
		OutputStream out = new FileOutputStream(file);
		InputStream in = url.openStream();
		while(true) {
			int ch = in.read();
			if(ch==-1) break;
			out.write(ch);
		}
		out.close(); in.close();
		System.out.println(name+ "복사 성공");
	}
}

// 3CL1