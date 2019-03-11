package com.dni.web.dao;

import java.util.List;

import com.dni.web.entity.Member;

public interface MemberDao {
	int insert(Member users);
	int update(Member users);
	int delete(String id);
	
	Member get(String id);
	List<Member> getList();
	List<Member> getList(int page);
	List<Member> getList(String field, String name);
	List<Member> getList(String field, String name, int page);
	Member getByEmail(String email);
	
}
