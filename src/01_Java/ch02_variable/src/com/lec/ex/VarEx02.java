package com.lec.ex;

public class VarEx02 {
	public static void main(String[] args) {
		int i=10; //int-4byte¥�� ��������
		byte j=20; //byte-8bit¥�� ��������
		double h=1; //double-8byte¥�� �Ǽ�����
		char c='��'; //char-2byte¥�� ���ڰ���
		boolean b=true; //boolean-1byte¥�� Ʈ����������
		long l=2200000000L; //L�� ���� ������ �⺻������ int������ �ν��ؼ� long������ �ν��ϱ� ����
		System.out.println("i\t j\t h"); //println�� ��������(\n�� ����)
		System.out.println(i+"\t"+j+"\t"+h); 
		System.out.print("c\t c\n"); //print�� ��������� t�� ��,n�� �ٹٲ�
		System.out.print("���� c�� ��\n");
		System.out.printf("c=%c, c�� �ڵ尪=%d\n",c,(int)c);
		System.out.printf("h=%5.2f\t", h);
		System.out.printf("l=%d",l);
		// %d-���� %f-�Ǽ� %b-�Ҹ�       ex)%5.2f�� ����5�ڸ����Ҽ���2�ڸ�
		
	}
}
