package com.dni.web.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dni.web.dao.MemberDao;
import com.dni.web.entity.Member;
import com.dni.web.service.MemberService;

public class MybatisMemberService implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member getMember(String id) {
		return memberDao.get(id);
	}

	@Override
	public List<Member> getMemberList() {
		return memberDao.getList();
	}

	@Override
	public int addMember(Member member) {
		return memberDao.insert(member);
	}

}
