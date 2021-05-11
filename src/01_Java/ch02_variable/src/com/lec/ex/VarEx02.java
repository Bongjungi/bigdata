package com.lec.ex;

public class VarEx02 {
	public static void main(String[] args) {
		int i=10; //int-4byte짜리 정수공간
		byte j=20; //byte-8bit짜리 정수공간
		double h=1; //double-8byte짜리 실수공간
		char c='나'; //char-2byte짜리 문자공간
		boolean b=true; //boolean-1byte짜리 트루폴스공간
		long l=2200000000L; //L을 쓰는 이유는 기본적으로 int값으로 인식해서 long값으로 인식하기 위해
		System.out.println("i\t j\t h"); //println은 개행포함(\n이 개행)
		System.out.println(i+"\t"+j+"\t"+h); 
		System.out.print("c\t c\n"); //print는 개행미포함 t는 탭,n은 줄바꿈
		System.out.print("변수 c의 값\n");
		System.out.printf("c=%c, c의 코드값=%d\n",c,(int)c);
		System.out.printf("h=%5.2f\t", h);
		System.out.printf("l=%d",l);
		// %d-정수 %f-실수 %b-불린       ex)%5.2f는 정수5자리에소수점2자리
		
	}
}
