package kr.teamfive.common.file;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class TeamfiveFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File f) {
		// /Users/wonchoi/Desktop/JavaPractice/jsp_upload_testing/2018/09/06/12/a.jpg
		String parent = f.getParent(); // /Users/wonchoi/Desktop/JavaPractice/jsp_upload_testing/2018/09/06/12
		String name = f.getName(); // a.jpg
		String ext = "";
		// split, substring, indexOf
		int index = name.lastIndexOf(".");
		if (index!=-1) {
			ext = name.substring(index); // 마지막 "."이 있는 index 부터 마지막까지 (확장명)을 짤라라. 
		}
		
		String uName = UUID.randomUUID().toString();
		
		return new File(parent, uName+ext);
	}
	
}
