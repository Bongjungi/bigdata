package com.lect.ex03_math;
//�Ҽ��� �ݿø�, �ø�, ����
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("�Ҽ������� �ݿø�, �ø�, ����");
		System.out.println("3.12�� �ø��� "+Math.ceil(3.12));
		System.out.println("3.12�� �ݿø��ϸ� "+Math.round(3.12));
		System.out.println("3.12�� �����ϸ� "+Math.floor(3.12));
		System.out.println("�Ҽ��� ���ڸ����� �ݿø�, �ø�, ����");
		System.out.println("9.15�� �Ҽ��� ���ڸ����� �ø��� "+Math.ceil(9.15*10)/10);
		System.out.println("9.15�� �Ҽ��� ���ڸ����� �ݿø��ϸ� : "+Math.round(9.15*10)/10.0);//���� ������ ���� �ϸ� ���� ���´�. �׷��� 10.0���� �Ѵ�.
		System.out.println("85�� �ø�"+Math.ceil(85/10.0)*10);
		
	}
}