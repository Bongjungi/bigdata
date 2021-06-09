package com.lect.programmers;

public class Ex4ClassMain {
	public static void main(String[] args) {
		Ex4Class ex = new Ex4Class();
		int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}}; 
		int[][] routes2 = {{-20,-15},{-14,-5},{-18,-13},{-5,-3},{3,5},{4,10}};
		System.out.println(ex.solution(routes));
		System.out.println(ex.solution(routes2));
	}
}
