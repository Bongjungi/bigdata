package com.lect.test_thisAndsuper;

public class Gangsa extends Person{
	private String subject;

	public Gangsa(String id, String name, String subject) {
		super(id,name);
		this.subject = subject;
	}
	public void print() {
		super.print();
		System.out.println(" (°ú¸ñ)"+subject);
	}
	
	
}
