package com.lect.ex_override;

public class ChildClass extends ParentClass { 
	
	
//	public void method1(int i) {} - overloading
	
	@Override //������̼� - �����Ϸ����� �˸��� �ּ�
	public void method1() {
		System.out.println("child�� method1");
		System.out.println();
	}
	
	public void method3() {
		System.out.println("child�� method3");
		System.out.println();
	}
}
