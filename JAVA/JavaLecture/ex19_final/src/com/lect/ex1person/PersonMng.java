package com.lect.ex1person;


import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getinstance();
		ArrayList<PersonDto> person = new ArrayList<PersonDto>();
		Scanner sc = new Scanner(System.in);
		String fn;
		do {
			System.out.println("1.입력 , 2.직업별 출력, 3.전체 출력, 그외 종료");
			fn = sc.next();
			switch(fn) {
			case "1" :
				System.out.print("입력할 이름은?");
				String name = sc.next();
				System.out.print("직업명은 배우,가수,엠씨만 가능");
				String jname = sc.next();
				System.out.println("국어점수는?");
				int kor = sc.nextInt();
				System.out.println("영어점수는?");
				int eng = sc.nextInt();
				System.out.println("수학점수는?");
				int mat = sc.nextInt();
				PersonDto newPerson = new PersonDto(jname, name, kor, eng, mat);
				int result = dao.insertPerson(newPerson);
				System.out.println(result==PersonDao.SUCCESS?"성공":"실패");
				break;
			case "2" : 
				System.out.println("조회할 직업명은 배우,가수,엠씨");
				jname=sc.next();
				person =dao.selectJname(jname);
				if(person.isEmpty()) {
					System.out.println("해당 직업명의 사람이 있습니다.");
				}else {
					System.out.println("rank 이름 직업 국어 영 수 총");
					for(PersonDto p : person) {
						System.out.println(p);
					}
				}
				break;
			case "3" :
				person=dao.selectAll();
				for(PersonDto p : person) {
					System.out.println(p);
				}
				break;
			}
			
		}while(fn.equals("1")||fn.equals("2"));
		sc.close();
		
	}
}
