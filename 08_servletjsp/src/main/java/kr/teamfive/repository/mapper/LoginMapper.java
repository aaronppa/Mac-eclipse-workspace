package kr.teamfive.repository.mapper;

import kr.teamfive.repository.domain.Member;

public interface LoginMapper {
	Member selectMember(Member member);
	void insertMember(Member member);
	String selectCheckMember(String id);

	
}