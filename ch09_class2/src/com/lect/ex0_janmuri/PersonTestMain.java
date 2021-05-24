package com.lect.ex0_janmuri;
class PersonTest{ //�� Ŭ������ �ٸ� ������ �� �� ����.
	private String name;
	private char gender;
	private int age;
	public PersonTest() {}
	public PersonTest(String name, char gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public void InfoPrint() {
		System.out.printf("�̸��� %s, ������ %c, ���̴� %d\n",name,gender,age);
	}
	public String infoString() {
		String result = "�̸�: "+name+", ���� : "+age+", gender : "+gender;
		return result;
	}
	public void SetName(String name) {
		this.name=name;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
public class PersonTestMain {
	public static void main(String[] args) {
		PersonTest[] person = {new PersonTest("ȫ�浿", 'M', 20), new PersonTest("ȫ���",'F',22), new PersonTest()};		
		person[2].SetName("ȫȫȫ"); person[2].setAge(25);person[2].setGender('M');
//		for(int idx=0;idx<person.length;idx++) {
//			person[idx].InfoPrint();
//		}
		for(PersonTest p : person) {
			System.out.println(p.infoString());
			p.InfoPrint();
		}
	}
}
