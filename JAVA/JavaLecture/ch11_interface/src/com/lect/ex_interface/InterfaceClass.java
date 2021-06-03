package com.lect.ex_interface;
//Ex1 : const_num, method1
//Ex2 : const_string, method2
//구현받은 것이 추상메소드에 상수라서   이 클래스는    추상클래스가 되거나    오버라이드 해줘야 한다.
//클래스다이어그램 - 상속-채워진 화살표로 받은 아이가 주는 아이에게 화살표, 구현 - 평범한 화살표로 받은 아이가 주는 아이에게 화살표.
//추상클래스는 직접 사용하지 않고 상속받는 클래스들을 위한 것이다.
//추상클래스를 쓰는 이유는 자식클래스에 있는 메소드 등을 부모클래스 타입으로도 사용할 수 있게끔 하려는 것 같다.
//추상메소드가 하나라도 있으면 추상클래스가 된다.
public class InterfaceClass implements InterfaceEx1, InterfaceEx2{
	public void method1() {
		System.out.println("1. 실제 구현은 임플리먼트한 클래스에서 합니다.");
	}
	public String method2() {
		System.out.println("2. 실제 구현은 임플리먼트한 클래스에서 합니다.");
		return null; //null은 아무데서나 사용 가능하다.
	}
}
