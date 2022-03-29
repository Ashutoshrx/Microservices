package com.training.VO;

import com.training.entity.User;

public class ResponseTemplateVO {

	private Department department;
	private User user;
	@Override
	public String toString() {
		return "ResponseTemplateVO [department=" + department + ", user=" + user + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public ResponseTemplateVO(Department department, User user) {
		super();
		this.department = department;
		this.user = user;
	}
	public ResponseTemplateVO() {
		super();
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
