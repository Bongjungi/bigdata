package com.lect.ex_override;

public class TestMain {
	public static void main(String[] args) {
		ChildClass cc=new ChildClass();
		ParentClass pp=new ParentClass();
		ParentClass pc=new ChildClass();
		cc.method1();
		pp.method1();
		pc.method1();
		pc.method2();
		cc.method2();
		//pc.method3(); Ÿ�Զ����� �Ұ�
		((ChildClass)pc).method3();
		
	}
}
