package kr.co.mlec.project.repository.mapper;

import kr.co.mlec.project.repository.vo.User;

public interface UserMapper {
	
	void insertUser(User user);
	User selectUserLogin(User user);
	User selectFindPassword(User user);
	
}
