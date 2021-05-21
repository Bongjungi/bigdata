package com.lec.ex;

public class Sysout extends Var {
	public static void main(String[] args) {
		
	System.out.println((f==g)?"f와g는같다.":"f와g는다르다"); // float 3.14159265359와 double 3.14159265359는 다르다.
	
	System.out.println(f+"\t"+g);
	System.out.println("i\t j\t h"); //println은 개행포함(\n이 개행)
	System.out.println(i+"\t"+j+"\t"+h); 
	System.out.print("c\t c\n"); //print는 개행미포함 t는 탭,n은 줄바꿈
	System.out.print("변수 c의 값\n");
	System.out.printf("c=%c, c의 코드값=%d\n",c,(int)c);
	System.out.printf("h=%5.2f\t", h); //"h=.2f" - 정수 제한x, 소수 2자리 제한
	System.out.printf("l=%d",l);
	// %d-정수 %f-실수 %b-불린 %c-문자 %s-문자열       ex)%5.2f는 정수5자리에소수점2자리
	}
}
