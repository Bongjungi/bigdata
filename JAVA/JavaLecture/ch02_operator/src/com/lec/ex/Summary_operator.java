package com.lec.ex;

public class Summary_operator {
	public static void main(String[] args) {
		int n1=33, n2=10, m,n,s1=10,s2,s3; double k; boolean re1,re2;
		//int a1,a2,a3; a1=a2=a3=10; - 가능
		//int a1=a2=a3;              - 불가능
		
		
		m=n1/n2; //33 나누기 10은 3이다. 4바이트 인트로 4바이트 인트를 나누면 4바이트 인트가 출력된다.
					// 그래서 몫을 구할때 쓴다.
		k=(double)n1/n2; //33 나누기 10은 3.3이다. 8바이트 더블이 분자여서 8바이트 실수 표현이 가능하다.
		n=n1%n2; // %는 나머지를 구할 때 쓴다.
		s2=s1++; //s3에 s1을 넣고 s1을 하나 증가 시킨다.
		s3=--s1; //s4에 s1을 넣고 s1을 하나 감소 시킨다.
		re1=n1!=n2; // n1과 n2가 다르다.
		re2=n1==n2; // n1과 n2가 같다.
		String res=(n1==n2)?"같다.":"다르다."; //삼항연산자
		// 비트연산자 &(And) |(Or) ^(Xor)
		
		System.out.printf("%d,%.2f,%d,%d,%d,%b,%b,%s",m,k,n,s2,s3,re1,re2,res);
		
		
		
		}
}
