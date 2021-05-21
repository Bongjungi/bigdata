package com.lec.ex;
//다른 패키지면 import 필요함.
public class Method {
	public static int sum(int i,int j) {
		return i+j;
	}
	public String evenodd(int value) {
		return (value%2==0)?"짝수":"홀수";
	}
}
