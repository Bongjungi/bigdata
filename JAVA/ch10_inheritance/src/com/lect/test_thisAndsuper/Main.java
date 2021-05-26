package com.lect.test_thisAndsuper;
//자식 클래스의 print가 적용된다.
//super의 사용에 따라 id,name 적용이 달라진다.
public class Main {
	public static void main(String[] args) {
		Person[] ps= {new Student("A01","나학생","JAVA반"),new Student("A02","홍길동","C++반"),new Staff("S01","나직원","교무팀"),
				new Staff("S02","나도요","취업지원팀"),new Gangsa("G01", "나선생", "프로그래밍")};
		//Student a= new Student
		//Staff b= new Staff
		//Gangsa c= new Gangsa
		//Person[] ps={a,b,c} - 가능 - 스튜던트,강사,스태프도 이미 펄슨의 형태
		for(Person i:ps) {
			i.print();          //i.print();는 person에도 공간이 있어서 다른 클래스에 print함수를 받아들일수 있다.
			//System.out.println(i); - 가능?? - 자동으로 sysout(i.tostring)으로 바뀜.
		}
	}	
}
