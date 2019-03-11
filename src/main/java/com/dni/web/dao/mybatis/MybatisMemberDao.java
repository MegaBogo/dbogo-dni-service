package com.dni.web.dao.mybatis;

import java.util.List;

import com.dni.web.dao.UsersDao;
import com.dni.web.entity.Users;

public class MybatisUsersDao implements UsersDao{

	
	
	@Override
	public int insert(Users users) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Users users) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Users get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getList(String field, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getList(String field, String name, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
