package kr.co.mlec.project.recyclebin.ui;

import kr.co.mlec.project.repository.mapper.MailMapper;
import kr.co.mlec.project.repository.vo.Mail;
import kr.co.mlec.project.repository.vo.User;

//영구삭제 
public class DeleteRecycleMailUI extends RecycleBinBaseUI {
	MailMapper mapper;
	User user;
	
	DeleteRecycleMailUI(MailMapper mapper,User user){
		this.mapper=mapper;
		this.user =user;
	}
	
	@Override
	public void service() {
		Mail mail = new Mail();
		
		
		mail.setMailNo(getInt("영구 삭제 할 이메일 고유번호를 선택 하세요"));
		mail.setRecipient(user.getId());
		int cnt = mapper.updateDeleteMail(mail);
		if(cnt ==1) {
		System.out.println("∴ 이메일이 삭제되었습니다 ∴");
		} else { System.out.println("메일번호를 다시 선택해주세요");
		}
		
	}
	
	
	
	
	
	
	

}
