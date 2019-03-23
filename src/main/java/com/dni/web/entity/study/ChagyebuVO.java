package com.dni.web.entity.study;

import java.util.Arrays;

public class ChagyebuVO {
	private String[] member;
	private String[] type;
	
	public String[] getMember() {
		return member;
	}
	public void setMember(String[] member) {
		this.member = member;
	}
	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ChagyebuVO [member=" + Arrays.toString(member) + ", type=" + Arrays.toString(type) + "]";
	}
	
	
}
