package com.dni.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dni.web.entity.Subway;

public interface SubwayService {
	public Subway getSubway(String userId);
	public Subway getSubway(String userId, int id);
	public List<Subway> getSubwayList();
	public int addSubway(Subway subway);
}
