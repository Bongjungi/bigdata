package com.lect.ex_override;

public class ChildClass extends ParentClass { 
	
	
//	public void method1(int i) {} - overloading
	
	@Override //어노테이션 - 컴파일러한테 알리는 주석
	public void method1() {
		System.out.println("child의 method1");
		System.out.println();
	}
	
	public void method3() {
		System.out.println("child의 method3");
		System.out.println();
	}
}
