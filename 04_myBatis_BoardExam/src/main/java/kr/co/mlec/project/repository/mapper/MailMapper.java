package kr.co.mlec.project.repository.mapper;

import java.util.List;

import kr.co.mlec.project.repository.vo.Mail;
import kr.co.mlec.project.repository.vo.User;




public interface MailMapper {
	
	List<Mail> receiveMail(String user);
	
	
	List<Mail> sendMail(String sender);
	
	
	int mailWrite(Mail mail);
	
	int throwAway(Mail mail);
	
	//읽음
	void updateReadYN(String recipient);
	
	//휴지통리스트
	
	List<Mail> selectBinMail(String recipient);
	//휴지통 메일 복원
	int updateRestoreMail(Mail mail);
	//휴지통 메일 영구 삭제 
	int updateDeleteMail(Mail mail);
	//휴지통 비우기
	int updateDeleteMailAll(String recipient);
	
	
	
	
}

