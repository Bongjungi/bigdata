package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		int n1=10;
		n1++; // n1++은 n1수행후에 ++수행 ++n1는 ++수행후에 n1수행
		System.out.println(n1);
		n1--;
		System.out.println(n1);
		int n2=10;
		int n3= n2++;// n3에 n2를 넣고 n2를 하나 증가시킨다.
		System.out.printf("n3=%d, n2=%d\n",n3,n2);
		n3=n2--;
		System.out.printf("n3=%d, n2=%d\n",n3,n2);
	}
}
