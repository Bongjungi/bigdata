package com.lect.test_thisAndsuper;

public class Staff extends Person{
	private String department;

	public Staff(String id, String name, String department) {
		super(id,name); //super.print�� �����ؾ��ϹǷ� this�� �ƴ� super�� ����. 
		this.department = department;
	}
	public void print() {
		super.print();
		System.out.println(" (�μ�)"+department);
	}
	
}
