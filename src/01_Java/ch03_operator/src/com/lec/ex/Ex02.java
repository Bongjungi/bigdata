package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		int n1=10;
		n1++; // n1++�� n1�����Ŀ� ++���� ++n1�� ++�����Ŀ� n1����
		System.out.println(n1);
		n1--;
		System.out.println(n1);
		int n2=10;
		int n3= n2++;// n3�� n2�� �ְ� n2�� �ϳ� ������Ų��.
		System.out.printf("n3=%d, n2=%d\n",n3,n2);
		n3=n2--;
		System.out.printf("n3=%d, n2=%d\n",n3,n2);
	}
}
