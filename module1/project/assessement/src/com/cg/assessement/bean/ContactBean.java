package com.cg.assessement.bean;

import java.io.Serializable;

public class ContactBean implements Serializable{
	private String name;
	private int number;
	private String cgroup;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCgroup() {
		return cgroup;
	}
	public void setCgroup(String cgroup) {
		this.cgroup = cgroup;
	}
	@Override
	public String toString() {
		return "ContactBean [name=" + name + ", number=" + number + ", cgroup=" + cgroup + "]";
	}
	
}
