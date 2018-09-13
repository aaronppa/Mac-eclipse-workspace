package kr.co.mlec.project.login.ui;

import java.util.Scanner;

import kr.co.mlec.project.common.db.MyAppSqlConfig;
import kr.co.mlec.project.main.ui.MainUI;
import kr.co.mlec.project.recyclebin.ui.RecycleBinMainUI;
import kr.co.mlec.project.repository.mapper.MailMapper;
import kr.co.mlec.project.repository.vo.User;

public class LoginUI {
	Scanner sc = new Scanner(System.in);
	LoginBaseUI ui = null;
	MainUI mainUi = new MainUI();
	MailMapper mapper;	
	RecycleBinMainUI rbm = new RecycleBinMainUI();
	public LoginUI() {
		mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(MailMapper.class);
	}

	public void service(User user) {	
		while(true) {
			switch(menu()) {
			case 1: ui = new ReceiveMailUI(mapper,user);break;
			case 2: ui = new SendMailUI(mapper,user);break;
			case 3: ui = new WriteMailUI(mapper,user);break;
			case 4: rbm.service(user); break;
			case 5: logOut();
			}
			ui.service();
		}//while end
	}
	public void logOut() {
		System.out.println("안전하게 로그아웃 되었습니다.");
		mainUi.service();
	}
	
	public int menu() {
		System.out.println("------------------------------------------");
		System.out.println("1. 받은메일함");
		System.out.println("2. 보낸메일함");
		System.out.println("3. 메일쓰기");
		System.out.println("4. 휴지통");
		System.out.println("5. 로그아웃 ");
		System.out.println("------------------------------------------ ");
		System.out.print("원하시는 서비스 번호를 입력해주세요 : ");

		return Integer.parseInt(sc.nextLine());
	}
}	
