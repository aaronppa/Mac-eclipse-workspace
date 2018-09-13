package kr.co.mlec.project.recyclebin.ui;


import kr.co.mlec.project.repository.mapper.MailMapper;
import kr.co.mlec.project.repository.vo.Mail;
import kr.co.mlec.project.repository.vo.User;

public class RestoreMailUI extends RecycleBinBaseUI{
	MailMapper mapper;
	User user;
	
	RestoreMailUI(MailMapper mapper,User user){
		this.mapper=mapper;
		this.user =user;
	}
	
	@Override
	public void service() {
		String loginUser = user.getId();
		Mail mail = new Mail();
		
		mail.setMailNo(getInt("받은 편지함으로 이동시킬 메일 번호를 선택 하세요 : "));
		mail.setRecipient(loginUser);
		
		int cnt = mapper.updateRestoreMail(mail);
		if(cnt==1) {
			System.out.println("이동되었습니다");
		}
	}
}
