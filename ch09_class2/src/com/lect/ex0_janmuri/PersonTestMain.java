package com.lect.ex0_janmuri;
class PersonTest{ //이 클래스는 다른 곳에서 쓸 수 없다.
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
		System.out.printf("이름은 %s, 성별은 %c, 나이는 %d\n",name,gender,age);
	}
	public String infoString() {
		String result = "이름: "+name+", 나이 : "+age+", gender : "+gender;
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
		PersonTest[] person = {new PersonTest("홍길동", 'M', 20), new PersonTest("홍길순",'F',22), new PersonTest()};		
		person[2].SetName("홍홍홍"); person[2].setAge(25);person[2].setGender('M');
//		for(int idx=0;idx<person.length;idx++) {
//			person[idx].InfoPrint();
//		}
		for(PersonTest p : person) {
			System.out.println(p.infoString());
			p.InfoPrint();
		}
	}
}
