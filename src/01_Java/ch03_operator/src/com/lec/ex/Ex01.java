package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		int re; double reD;
		re=n1+n2;
		System.out.printf("%d %c %d = %d\n",n1,'+',n2,re);
		reD=n1/n2; // 33������3�� 10�̴�. ������ 4����Ʈ¥���� 4����Ʈ�� ������ 4����Ʈ��.
		System.out.printf("%d %c %d = %f\n",n1,'/',n2,reD);
		reD=(double)n1/n2; // 33/3�� 11�� �Ƿ��� 8����Ʈ�� ���ڿ��� �Ѵ�.�и�� 4,8 �������
		System.out.printf("%d %c %d = %f\n",n1,'/',n2,reD);
		re=n1%n2; // �������� ���ϴ¹�
		System.out.printf("%d %c %d = %d\n",n1,'%',n2,re);
		if(n1%2==0) {
			System.out.println("n1�� ¦��");
		}
		else {
			System.out.println("n1�� Ȧ��");
		}
		if(n2%5==0) {
			System.out.println("5���");
		}
		else {
			System.out.println("5����ƴ�");
		}
	}
}
