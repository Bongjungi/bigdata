package com.lect.ex_interface;

public class TestMain {
	public static void main(String[] args) {
		InterfaceClass obj = new InterfaceClass();
		System.out.println(InterfaceEx1.CONSTANT_NUM);
		System.out.println(InterfaceEx2.CONSTANT_STRING);
		System.out.println(InterfaceClass.CONSTANT_NUM);// 당연히 ex1이랑 ex2에서 다르게 정의되어 있으면 에러 뜬다.
		System.out.println(InterfaceEx1.CONSTANT_NUM);
		System.out.println(InterfaceClass.CONSTANT_STRING);
		System.out.println(InterfaceEx2.CONSTANT_STRING);
		obj.method1();
		obj.method2();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		InterfaceEx1 obj1 = new InterfaceClass();
		obj1.method1();
//		obj1.method2(): 불가능 interfaceex1에 method2없다. interfaceclass 안에는 있다. 그러므로 적용하고 싳으면 앞에 (interfaceclass)를 붙여서 형태를 변환시켜라. 
		InterfaceEx2 obj2=new InterfaceClass();
		obj2.method2();
	}
}
