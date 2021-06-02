package com.lect.ex03_math;
//소수점 반올림, 올림, 버림
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("소수점에서 반올림, 올림, 버림");
		System.out.println("3.12를 올리면 "+Math.ceil(3.12));
		System.out.println("3.12를 반올림하면 "+Math.round(3.12));
		System.out.println("3.12를 내림하면 "+Math.floor(3.12));
		System.out.println("소수점 한자리에서 반올림, 올림, 버림");
		System.out.println("9.15를 소수점 한자리에서 올리면 "+Math.ceil(9.15*10)/10);
		System.out.println("9.15를 소수점 한자리에서 반올림하면 : "+Math.round(9.15*10)/10.0);//정수 나누기 정수 하면 정수 나온다. 그래서 10.0으로 한다.
		System.out.println("85를 올림"+Math.ceil(85/10.0)*10);
		
	}
}