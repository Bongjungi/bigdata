package com.lect.ex_constructor;

public class TestMain {
	public static void main(String[] args) {
		SuperIJ sup= new SuperIJ(1,2);
		System.out.println();
		Child child=new Child(10,20); //superij에 default생성자 없으면 에러 발생
		                              //상속받은Child는 실행하기 전에 SuperIJ생성자를 먼저 실행한다.
		System.out.println();
		SuperIJ odin=new Child(100,200);
		System.out.println(sup.getI());
		System.out.println(sup.getJ());
		System.out.println(child.getI());
		System.out.println(child.getJ());
		System.out.println(odin.getI());
		System.out.println(odin.getJ());
		
		child.sum();
//		odin.sum() 불가능 SuperIJ odin에는 sum이 없다.
		
	}
}
