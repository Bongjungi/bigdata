package com.lect.ex3_set;
import java.util.HashSet;
public class Ex03_StudentHashSet {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		Student s = new Student(6,"ȫ�浿");//[6�г� ȫ�浿]
		students.add(s);
		students.add(s);
		System.out.println(students);
		students.add(new Student(3,"ȫ�浿"));//[6�г� ȫ�浿, 3�г� ȫ�浿]
		students.add(new Student(1,"�庸��"));//[1�г� �庸��, 6�г� ȫ�浿, 3�г� ȫ�浿]
		students.add(new Student(1,"�庸��"));//[1�г� �庸��, 6�г� ȫ�浿, 3�г� ȫ�浿, 1�г� �庸��] //�庸�� �� �� ���� ������ ���� ��ü���� ���� �� �ּҰ��� ���ϴµ� �� �庸���� �ּҰ��� �ٸ��⶧��.
		System.out.println(students);       // �� ���� ��ü���� ���Ҷ� equals,hashcode�� ����. �׷��Ƿ� ���ϴ´�� �ϱ� ���ؼ��� equals,hashcode�� override�ؾ� �Ѵ�.
		
	}
}
