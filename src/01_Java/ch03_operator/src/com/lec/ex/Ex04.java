package com.lec.ex;

public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		System.out.println("(i<j)&&(++j>h):"+((i<j)&&(++j>h))); //+인식을위해
		System.out.println("j="+j);
		System.out.println("(i>j)&&(++j>h):"+((i>j)&&(++j>h))); //어차피i>j가 거짓이라 &&판단끝.귀찮게 뒤의 것까지 계산안함.
		System.out.println("j="+j); //j가 12가 나오지 않는 이유는 i>j가 거짓이어서 ++j까지 실행하지 않기 때문
		System.out.println("(i<j)||(++j>h):"+((i<j)||(++j>h))); //어차피i<j가 참이라 ||판단끝
		System.out.println("j="+j);
	}
}
