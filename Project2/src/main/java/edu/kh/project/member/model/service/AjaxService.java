package edu.kh.project.member.model.service;

import java.util.List;

import edu.kh.project.member.model.vo.Member;

// 서비스 인터페이스 만든 이유
// 설계, 유지보수성 향상, AOP 때문에
public interface AjaxService {

	/** 이메일 중복 검사 서비스
	 * 
	 * @param memberEmail
	 * @return result
	 */
	int emailDupCheck(String memberEmail);

	/**
	 * 닉네임 중복 검사 서비스
	 * @param memberNickname
	 * @return result
	 */
	int nicknameDupCheck(String memberNickname);

	/**
	 * 이메일로 회원 정보 조회
	 * @param email
	 * @return
	 */
	Member selectEmail(String email);

	/**
	 * 회원 정보 조회
	 * @return memberList
	 */
	List<Member> selectMemberList();

	
}
