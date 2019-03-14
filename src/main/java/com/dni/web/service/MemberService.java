package com.dni.web.service;

import java.util.List;

import com.dni.web.entity.Member;
import com.dni.web.entity.Subway;

public interface MemberService {
	public Member getMember(String id);
	public List<Member> getMemberList();
	public int addMember(Member member);
	
	public boolean isEmailDuplicated(String email);
	public boolean isIdDuplicated(String id);
}
