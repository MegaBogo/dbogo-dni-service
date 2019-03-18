package com.dni.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dni.web.entity.Member;

public interface MemberService {
	public Member getMember(String id);
	public List<Member> getMemberList();
	public int addMember(Member member);
	
	public boolean isEmailDuplicated(String email);
	public boolean isIdDuplicated(String id);
}
