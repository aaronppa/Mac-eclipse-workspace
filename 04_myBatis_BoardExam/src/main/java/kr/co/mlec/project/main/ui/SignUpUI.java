package kr.co.mlec.project.main.ui;

import kr.co.mlec.project.login.ui.CertificationCode;
import kr.co.mlec.project.login.ui.SecretPassword;
import kr.co.mlec.project.repository.mapper.UserMapper;
import kr.co.mlec.project.repository.vo.User;

public class SignUpUI extends MainBaseUI {
	UserMapper mapper;
	public SignUpUI(UserMapper mapper) {
		this.mapper = mapper;
	}

	
	
	@Override
	public void service() {
		User user = new User();
		CertificationCode code = new CertificationCode();
		
		user.setId(getStr("아이디를 입력해주세요 : "));
		String pass = getStr("비밀번호를 입력해주세요 :");
		try {
			String encryptPass = SecretPassword.Encrypt(pass);
			user.setPassword(encryptPass);
			
		} catch (Exception e1) {
		}
		
		
		
		
		user.setPassHint(getStr("비밀번호 힌트를 입력하세요 : "));
		user.setName(getStr("이름을 입력하세요 : "));
		user.setGender(getStr("성별(F/M) : "));
		user.setPhone(getStr("휴대폰번호를 입력하세요 : "));
		System.out.println("회원 인증이 필요합니다" );
		code.setRecipient(getStr("이메일을 입력하세요"));
		System.out.println("인증번호가 발송되었습니다");
		
		try {
			code.mailSender();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int no = getInt("인증번호를 입력하세요");
		
		if (no==code.getCode()) {
			mapper.insertUser(user);
			System.out.println("=============================");
			System.out.println("∴ 회원가입이 완료되었습니다∴");
		} else {
			System.out.println(" 인증에 실패하였습니다" );
			System.out.println(" 초기 화면으로 돌아갑니다." );
			
		}
		
		
	}
}	
