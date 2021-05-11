package com.lec.ex;

public class VarEx06 {
//형변환 = 묵시적인형변환, 명시적인형변환
	public static void main(String[] args) {
		int i1=10;
		double d1=i1; //4바이트 i1을 8바이트 d1에 넣는다.i1이 더블로 바뀌어서 들어감. - 묵시적 변환
		System.out.printf("i1=%d, d1=%.2f\n",i1,d1);
		//i1=d1; 그냥은 불가능 공간부족
		d1=10.9;
		i1=(int)d1; //명시적 형변환 - 부족한 공간부분은 짤림
		System.out.printf("i1=%d, d1=%.2f\n",i1,d1);
	}
}
