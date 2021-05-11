package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		int re; double reD;
		re=n1+n2;
		System.out.printf("%d %c %d = %d\n",n1,'+',n2,re);
		reD=n1/n2; // 33나누기3은 10이다. 이유는 4바이트짜리를 4바이트로 나누면 4바이트다.
		System.out.printf("%d %c %d = %f\n",n1,'/',n2,reD);
		reD=(double)n1/n2; // 33/3이 11이 되려면 8바이트가 분자여야 한다.분모는 4,8 상관없음
		System.out.printf("%d %c %d = %f\n",n1,'/',n2,reD);
		re=n1%n2; // 나머지를 구하는법
		System.out.printf("%d %c %d = %d\n",n1,'%',n2,re);
		if(n1%2==0) {
			System.out.println("n1은 짝수");
		}
		else {
			System.out.println("n1은 홀수");
		}
		if(n2%5==0) {
			System.out.println("5배수");
		}
		else {
			System.out.println("5배수아님");
		}
	}
}
