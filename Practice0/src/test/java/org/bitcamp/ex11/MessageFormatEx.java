package org.bitcamp.ex11;

import java.text.MessageFormat;

import junit.framework.TestCase;

public class MessageFormatEx extends TestCase{
	
	public void testMessageFormatEx(){
		String id = "java";
		String name = "최원영";
		String tel = "010-123-5678";
		
		String text = "회원 ID: {0} \n회원 이름: {1} \n회원 전화: {2}";
		String result1 = MessageFormat.format(text, id, name, tel);
		System.out.println(result1);
		System.out.println();
		
		String sql = "insert into member values( {0}, {1}, {2} )";
		Object[] arguments = { "'java'", "최원영", "'010-123-5678'" };
		String result2 = MessageFormat.format(sql, arguments);
		System.out.println(result2);
	}
}
