package kr.co.mlec.project.login.ui;

import kr.co.mlec.project.repository.mapper.MailMapper;
import kr.co.mlec.project.repository.vo.Mail;
import kr.co.mlec.project.repository.vo.User;

public class WriteMailUI extends LoginBaseUI{
	MailMapper mapper;
	User user;
	WriteMailUI(MailMapper mapper,User user){
		this.mapper=mapper;
		this.user = user;
	}
	
	@Override
	public void service() {
		String loginUser = user.getId();
		Mail mail = new Mail();
		
		
		System.out.println("메일 쓰기를 선택하셨습니다.");
		mail.setSender(loginUser);
		mail.setRecipient(getStr("수신자(받을 사람)을 입력해 주세요 : "));
		mail.setTitle(getStr("제목을 입력하세요. : "));
		mail.setContent(getStr("내용을 입력해 주세요(200자 제한) 내용 : "));
		int cnt=mapper.mailWrite(mail);
		if(cnt==1) {
			System.out.println("메일 보내기가 완료 되었습니다.");
		}
	}
}
