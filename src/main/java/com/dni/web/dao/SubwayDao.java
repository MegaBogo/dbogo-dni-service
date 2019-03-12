package com.dni.web.dao;

import java.util.List;

import com.dni.web.entity.Subway;
public interface SubwayDao {
	int insert(Subway subway);
	int update(Subway subway);
	int delete(int id);	
	
	Subway get(int id);
	List<Subway> getList();
	List<Subway> getList(int page);
	List<Subway> getList(String field, String name);
	List<Subway> getList(String field, String name, int page);
}
