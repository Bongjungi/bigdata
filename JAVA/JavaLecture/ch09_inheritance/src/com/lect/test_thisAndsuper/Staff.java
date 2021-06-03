package com.lect.test_thisAndsuper;

public class Staff extends Person{
	private String department;

	public Staff(String id, String name, String department) {
		super(id,name); //super.print에 적용해야하므로 this가 아닌 super를 쓴다. 
		this.department = department;
	}
	public void print() {
		super.print();
		System.out.println(" (부서)"+department);
	}
	
}
