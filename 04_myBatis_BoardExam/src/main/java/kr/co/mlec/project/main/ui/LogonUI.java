package kr.co.mlec.project.main.ui;

import kr.co.mlec.project.login.ui.LoginUI;
import kr.co.mlec.project.login.ui.SecretPassword;
import kr.co.mlec.project.repository.mapper.UserMapper;
import kr.co.mlec.project.repository.vo.User;

public class LogonUI extends MainBaseUI{
	
	UserMapper mapper;
	
	
	public LogonUI(UserMapper mapper) {
		this.mapper = mapper;
	}

	
	
	@Override
	public void service() {
		User user = new User();
		LoginUI loginSuccess= new LoginUI();	
		
		System.out.println("email계정으로 로그인. ");
		System.out.println();
		user.setId(getStr("아이디를 입력해주세요 : "));
		String pass;
		try {
			pass = SecretPassword.Encrypt(getStr("비밀번호를 입력해주세요 : "));
			user.setPassword(pass);
		} catch (Exception e) {}
		
		
		User loginUser= mapper.selectUserLogin(user);
			
			if(loginUser==null) {
				System.out.println("∴아이디나 비밀번호가 바르게 입력되지 않았습니다∴ ");
				System.out.println("다시 로그인해주세요.");
			} else {
			
			System.out.println(" ∴"+loginUser.getName()+"님 환영합니다 ∴");
			System.out.println();
			loginSuccess.service(loginUser);
			}//if-else
	}
}
