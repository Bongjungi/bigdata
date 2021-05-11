package com.lec.ex;

public class Ex03 {
	public static void main(String[] args) {
		int n1=10; int n2=5;
		boolean re;
		re= n1>=n2;
		System.out.printf("%d %s %d= %b\n", n1,">=",n2,re);
		re= n1==n2;
		System.out.printf("%d %s %d= %b\n", n1,"==",n2,re);
		re= n1!=n2;
		System.out.printf("%d %s %d= %b\n", n1,"!=",n2,re);
		re= !(n1!=n2);
		System.out.printf("%d %s %d= %b\n", n1,"!=",n2,re);
		
	}

}
