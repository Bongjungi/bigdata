package com.lect.ex_interface;

public class TestMain {
	public static void main(String[] args) {
		InterfaceClass obj = new InterfaceClass();
		System.out.println(InterfaceEx1.CONSTANT_NUM);
		System.out.println(InterfaceEx2.CONSTANT_STRING);
		System.out.println(InterfaceClass.CONSTANT_NUM);// �翬�� ex1�̶� ex2���� �ٸ��� ���ǵǾ� ������ ���� ���.
		System.out.println(InterfaceEx1.CONSTANT_NUM);
		System.out.println(InterfaceClass.CONSTANT_STRING);
		System.out.println(InterfaceEx2.CONSTANT_STRING);
		obj.method1();
		obj.method2();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		InterfaceEx1 obj1 = new InterfaceClass();
		obj1.method1();
//		obj1.method2(): �Ұ��� interfaceex1�� method2����. interfaceclass �ȿ��� �ִ�. �׷��Ƿ� �����ϰ� ������ �տ� (interfaceclass)�� �ٿ��� ���¸� ��ȯ���Ѷ�. 
		InterfaceEx2 obj2=new InterfaceClass();
		obj2.method2();
	}
}
