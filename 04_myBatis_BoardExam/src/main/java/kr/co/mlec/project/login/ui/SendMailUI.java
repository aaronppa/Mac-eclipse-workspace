package kr.co.mlec.project.login.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.co.mlec.project.repository.mapper.MailMapper;
import kr.co.mlec.project.repository.vo.Mail;
import kr.co.mlec.project.repository.vo.User;

public class SendMailUI extends LoginBaseUI{
	MailMapper mapper;
	User user;
	
	SendMailUI(MailMapper mapper,User user){
		this.mapper=mapper;
		this.user =user;
	}
	@Override
	public void service() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String loginUser = user.getId();
		System.out.println(loginUser);
		
		List<Mail> list=mapper.sendMail(loginUser);

		System.out.println(loginUser+"님이 보낸 메일");

		
	if(list.size()>0) {
		for(Mail li : list) {
			System.out.println("--------------------------------");
			System.out.println("받는 사람 : "+li.getRecipient());
			System.out.println("제목 : "+li.getTitle());
			System.out.println("내용 : "+li.getContent());
			System.out.println("보낸 날짜 : "+sdf.format(li.getRegDate()));
			System.out.println("--------------------------------");
			}
		}else {
			System.out.println("보낸 메일이 없습니다.");
		}
	}
}
