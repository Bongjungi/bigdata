package com.lect.ex1person;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {
	public static void main(String[] args) {
		//�Է�
		PersonDao dao = PersonDao.getinstance();
		PersonDto newPerson = new PersonDto("����","ȫȫȫ", 90, 80, 99);
		int result = dao.insertPerson(newPerson);
		System.out.println(result==1?"����":"����");
		//��ȸ
		ArrayList<PersonDto> person = dao.selectJname("���");
		for(PersonDto p : person) {
			System.out.println(p);
		}
		person=dao.selectAll();
		System.out.println("��ü");
		for(int idx=0;idx<person.size();idx++) {
			System.out.println(person.get(idx));
		}

		Vector<String> jnamelist = dao.jnamelist();
		for(int idx=0;idx<jnamelist.size();idx++) {
			System.out.println(jnamelist.get(idx));
		}
	}
}
