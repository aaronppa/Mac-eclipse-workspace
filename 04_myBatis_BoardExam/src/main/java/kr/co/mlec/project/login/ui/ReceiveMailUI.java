package kr.co.mlec.project.login.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.co.mlec.project.repository.mapper.MailMapper;
import kr.co.mlec.project.repository.vo.Mail;
import kr.co.mlec.project.repository.vo.User;

public class ReceiveMailUI extends LoginBaseUI{
	MailMapper mapper;
	User user;
	
	ReceiveMailUI(MailMapper mapper,User user){
		this.mapper=mapper;
		this.user =user;
	}
	
	@Override
	public void service() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String loginUser = user.getId();
		List<Mail> list = mapper.receiveMail(loginUser);
			System.out.println(loginUser+"님이 받은 메일");
			
		if(list.size()>0) {
			for(Mail li : list) {
				System.out.println("--------------------------------");
				System.out.println("번호 : "+li.getMailNo());
				System.out.println("보낸 사람 : "+li.getSender());
				System.out.println("제목 : "+li.getTitle());
				System.out.println("내용 : "+li.getContent());
				System.out.println("받은 날짜 : "+sdf.format(li.getRegDate()));
				System.out.println("--------------------------------");
			}//for 
				mapper.updateReadYN(loginUser);
				
		
//				if(getStr("삭제할 이메일이 있습니까?(Y/N)")=="YES") {
				if(getStr("삭제할 이메일이 있습니까?(Y/N)").equals("Y")) {
					Mail mail = new Mail();
					
					int no = getInt("삭제할 이메일 번호 : ");
					mail.setMailNo(no);
					mail.setRecipient(loginUser);
					int cnt = mapper.throwAway(mail);
				
					if(cnt==1) {
					System.out.println("이메일이 삭제되었습니다.");
					}else {
						System.out.println("존재하지 않는 번호입니다.");
					}//inner if- else 
				} else {
					
				}	
					
		} else {
			System.out.println("받은 메일이 없습니다.");
		}//outer if- else 
		

		}
	}

