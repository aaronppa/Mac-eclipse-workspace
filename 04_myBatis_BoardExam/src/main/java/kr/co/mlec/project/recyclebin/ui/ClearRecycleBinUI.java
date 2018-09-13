package kr.co.mlec.project.recyclebin.ui;


import kr.co.mlec.project.repository.mapper.MailMapper;
import kr.co.mlec.project.repository.vo.User;
//휴지통비우기 
public class ClearRecycleBinUI extends RecycleBinBaseUI{
	MailMapper mapper;
	User user;
	ClearRecycleBinUI(MailMapper mapper,User user){
		this.mapper=mapper;
		this.user = user;
	}
	@Override
	public void service() {	
		int cnt = mapper.updateDeleteMailAll(user.getId());
		if(cnt>=1) {
			System.out.println("휴지통이 비워졌습니다");
		}
		
	}
	
	
}
