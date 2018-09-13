package kr.co.mlec.project.main.ui;

import kr.co.mlec.project.repository.mapper.UserMapper;
import kr.co.mlec.project.repository.vo.User;

public class FindPasswordUI extends MainBaseUI{
	MainUI ui = new MainUI();
	UserMapper mapper;
	User loginUser;
	
	public FindPasswordUI(UserMapper mapper) {
		this.mapper = mapper;
	}

	
	
	@Override
	public void service() {
		User user = new User();
		System.out.println("비밀번호 찾기 메뉴를 선택하셨습니다.");
		user.setId(getStr("비밀번호를 찾을 아이디를 입력해주세요 : "));
		user.setPassHint(getStr("비밀번호 힌트를 입력해주세요 : "));
		
		User loginUser = mapper.selectFindPassword(user);
		
		if(loginUser==null) {
			System.out.println("비밀번호 힌트와 아이디를 바르게 입력해주세요.");
			ui.service();
		} else {
			System.out.println("∴ 비밀번호 찾기에 성공하셨습니다 ∴");
			System.out.println("----------------------- ");
			System.out.println("아이디 : "+loginUser.getId());
			System.out.println("비밀번호 : "+loginUser.getPassword());
			System.out.println("----------------------- ");
			System.out.println("메인메뉴로 돌아갑니다");
			ui.service();
			
			
		}
		
		
	}
}
