package com.fuzzy.metro.chatter;

public class Colleague {

	private String username;	
	private int department;
	
	public Colleague(String user, int dept){
		username = user;
		department = dept;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	
}