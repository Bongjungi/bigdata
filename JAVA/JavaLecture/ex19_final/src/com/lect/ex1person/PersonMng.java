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
			System.out.println("1.�Է� , 2.������ ���, 3.��ü ���, �׿� ����");
			fn = sc.next();
			switch(fn) {
			case "1" :
				System.out.print("�Է��� �̸���?");
				String name = sc.next();
				System.out.print("�������� ���,����,������ ����");
				String jname = sc.next();
				System.out.println("����������?");
				int kor = sc.nextInt();
				System.out.println("����������?");
				int eng = sc.nextInt();
				System.out.println("����������?");
				int mat = sc.nextInt();
				PersonDto newPerson = new PersonDto(jname, name, kor, eng, mat);
				int result = dao.insertPerson(newPerson);
				System.out.println(result==PersonDao.SUCCESS?"����":"����");
				break;
			case "2" : 
				System.out.println("��ȸ�� �������� ���,����,����");
				jname=sc.next();
				person =dao.selectJname(jname);
				if(person.isEmpty()) {
					System.out.println("�ش� �������� ����� �ֽ��ϴ�.");
				}else {
					System.out.println("rank �̸� ���� ���� �� �� ��");
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
