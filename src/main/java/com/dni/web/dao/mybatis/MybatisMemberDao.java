package com.dni.web.dao.mybatis;

import java.util.List;

import com.dni.web.dao.MemberDao;
import com.dni.web.entity.Member;

public class MybatisMemberDao implements MemberDao{

	
	
	@Override
	public int insert(Member users) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Member users) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getList(String field, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getList(String field, String name, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
