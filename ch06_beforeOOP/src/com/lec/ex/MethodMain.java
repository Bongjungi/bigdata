package com.lec.ex;

public class MethodMain {
	public static void main(String[] args) {
		System.out.println(Method.sum(1,10));
		System.out.println(sum(1,10));
//		System.out.println(Method.evenodd(3)); -에러 발생. static 필요
	}
	private static int sum(int i, int j) {
		return 0;
	}
}
