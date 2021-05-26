package com.lect.test_thisAndsuper;

public class Student extends Person {
	private String ban;

	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
	}
	public void print() {
		super.print();
		System.out.println(" (¹Ý)"+ban);
	}
	
	
}
