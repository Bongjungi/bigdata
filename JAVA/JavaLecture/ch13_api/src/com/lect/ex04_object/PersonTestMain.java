package com.lect.ex04_object;

public class PersonTestMain {
	public static void main(String[] args) {
		Person sun = new Person(9999991111111L);
		Person moon = new Person(9999991111111L);
		Person star = null;
		if(sun==moon) {
			System.out.println("person과 person2는 같은 주소");
		}else {
			System.out.println("person과 person2는 다른 주소");
		}
		if(sun.equals(moon)) {
			System.out.println("같은 사람");
		}else {
			System.out.println("다른 사람");
		}
		if(sun.equals(star)) {
			System.out.println("같은 사람");
		}else {
			System.out.println("다른 사람");
		}
	}
}
