package com.lect.ex04_object;

public class PersonTestMain {
	public static void main(String[] args) {
		Person sun = new Person(9999991111111L);
		Person moon = new Person(9999991111111L);
		Person star = null;
		if(sun==moon) {
			System.out.println("person�� person2�� ���� �ּ�");
		}else {
			System.out.println("person�� person2�� �ٸ� �ּ�");
		}
		if(sun.equals(moon)) {
			System.out.println("���� ���");
		}else {
			System.out.println("�ٸ� ���");
		}
		if(sun.equals(star)) {
			System.out.println("���� ���");
		}else {
			System.out.println("�ٸ� ���");
		}
	}
}
