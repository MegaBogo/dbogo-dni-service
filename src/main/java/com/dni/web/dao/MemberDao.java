package com.dni.web.dao;

import java.util.List;

import com.dni.web.entity.Users;

public interface UsersDao {
	int insert(Users users);
	int update(Users users);
	int delete(String id);
	
	Users get(String id);
	List<Users> getList();
	List<Users> getList(int page);
	List<Users> getList(String field, String name);
	List<Users> getList(String field, String name, int page);
	Users getByEmail(String email);
	
}
