package kr.co.mlec.project.main.ui;

import java.util.Scanner;

import kr.co.mlec.project.common.db.MyAppSqlConfig;
import kr.co.mlec.project.login.ui.LoginUI;
import kr.co.mlec.project.repository.mapper.UserMapper;

public  class MainUI {
	Scanner sc = new Scanner(System.in);
	UserMapper mapper;
	
	public MainUI() {
		mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(UserMapper.class);
	}//constructor
	
	//로그인 전 
	public void service() {
		MainBaseUI ui = null;
		  while(true){
		  		
		 		switch(menu()){
		  			case 1 : ui = new SignUpUI(mapper);break;
		  			case 2 : ui = new LogonUI(mapper);break;
		  			case 3 : ui = new FindPasswordUI(mapper);break;
		  			case 4 : exit();
		  		
		 		}
		  			ui.service(); 
		  	}
	}
	
	public void exit() {
		System.out.println("메일 시스템이 종료되었습니다.");
		System.exit(0);
		//종료 
	}
	
	//로그인전메뉴 
	public int menu() {
		System.out.println("환영합니다! 고객님! 이메일 닷컴에 오신걸 환영합니다.");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("(1) 회원가입");
		System.out.println("(2) 로그인");
		System.out.println("(3) 비밀번호 찾기");
		System.out.println("(4) 종료");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.print("원하시는 서비스 번호를 입력해주세요:");
		return Integer.parseInt(sc.nextLine());
	}

	
}
