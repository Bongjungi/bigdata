package com.lec.ex;

public class Sysout extends Var {
	public static void main(String[] args) {
		
	System.out.println((f==g)?"f��g�°���.":"f��g�´ٸ���"); // float 3.14159265359�� double 3.14159265359�� �ٸ���.
	
	System.out.println(f+"\t"+g);
	System.out.println("i\t j\t h"); //println�� ��������(\n�� ����)
	System.out.println(i+"\t"+j+"\t"+h); 
	System.out.print("c\t c\n"); //print�� ��������� t�� ��,n�� �ٹٲ�
	System.out.print("���� c�� ��\n");
	System.out.printf("c=%c, c�� �ڵ尪=%d\n",c,(int)c);
	System.out.printf("h=%5.2f\t", h); //"h=.2f" - ���� ����x, �Ҽ� 2�ڸ� ����
	System.out.printf("l=%d",l);
	// %d-���� %f-�Ǽ� %b-�Ҹ� %c-���� %s-���ڿ�       ex)%5.2f�� ����5�ڸ����Ҽ���2�ڸ�
	}
}
