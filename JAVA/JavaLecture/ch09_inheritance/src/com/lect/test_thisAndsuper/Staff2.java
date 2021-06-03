package com.lect.test_thisAndsuper;

public class Staff2 extends Person2{
	private String id,name,department;

	public Staff2(String id, String name, String department) {
		super(id,name);
		this.department = department;
	}
	public void print() {
		System.out.println("(ID)"+id+" (이름)"+name+" (부서)"+department);
	}
	public String getId2() {
		return id;
	}
	public void setId2(String id) {
		this.id = id;
	}
	public String getName2() {
		return name;
	}
	public void setName2(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
