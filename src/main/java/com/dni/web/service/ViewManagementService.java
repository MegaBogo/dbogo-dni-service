package com.dni.web.service;

import java.util.List;

import com.dni.web.entity.Member;
import com.dni.web.entity.Subway;

public interface ViewManagementService {
	public Member getMember();
	public List<Member> getMemberList();
	public int addMember(Member member);
}
