package com.lect.test_thisAndsuper;
//�ڽ� Ŭ������ print�� ����ȴ�.
//super�� ��뿡 ���� id,name ������ �޶�����.
public class Main {
	public static void main(String[] args) {
		Person[] ps= {new Student("A01","���л�","JAVA��"),new Student("A02","ȫ�浿","C++��"),new Staff("S01","������","������"),
				new Staff("S02","������","���������"),new Gangsa("G01", "������", "���α׷���")};
		//Student a= new Student
		//Staff b= new Staff
		//Gangsa c= new Gangsa
		//Person[] ps={a,b,c} - ���� - ��Ʃ��Ʈ,����,�������� �̹� �޽��� ����
		for(Person i:ps) {
			i.print();          //i.print();�� person���� ������ �־ �ٸ� Ŭ������ print�Լ��� �޾Ƶ��ϼ� �ִ�.
			//System.out.println(i); - ����?? - �ڵ����� sysout(i.tostring)���� �ٲ�.
		}
	}	
}
