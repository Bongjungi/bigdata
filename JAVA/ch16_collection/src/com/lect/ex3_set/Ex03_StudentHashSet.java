package com.lect.ex3_set;
import java.util.HashSet;
public class Ex03_StudentHashSet {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		Student s = new Student(6,"홍길동");//[6학년 홍길동]
		students.add(s);
		students.add(s);
		System.out.println(students);
		students.add(new Student(3,"홍길동"));//[6학년 홍길동, 3학년 홍길동]
		students.add(new Student(1,"장보고"));//[1학년 장보고, 6학년 홍길동, 3학년 홍길동]
		students.add(new Student(1,"장보고"));//[1학년 장보고, 6학년 홍길동, 3학년 홍길동, 1학년 장보고] //장보고가 두 번 들어가는 이유는 같은 객체인지 비교할 때 주소값을 비교하는데 두 장보고의 주소값이 다르기때문.
		System.out.println(students);       // 즉 같은 객체인지 비교할때 equals,hashcode를 쓴다. 그러므로 원하는대로 하기 위해서는 equals,hashcode를 override해야 한다.
		
	}
}
