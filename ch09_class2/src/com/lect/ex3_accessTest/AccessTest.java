package com.lect.ex3_accessTest;

public class AccessTest {
//	private int privateMember;     // 같은 클래스 내에서만 작동
	int defaultMember;             // 디폴트접근제한 : 같은 패키지에서만 작동
	protected int protectedMember; //같은 패키지와 상속받은 클래스에서 작동 가능
	public int publicMember;       //같은 프로젝트 내에서 작동
//	private void privateMethod() {
//		System.out.println("프라이빗메소드");
//	}
	void defaultMethod() {
		System.out.println("디폴트메소드");
	}
	protected void protectedMethod() {
		System.out.println("프로텍디드메소드");
	}
	public void publicMethod() {
		System.out.println("퍼블릭메소드");
	}
}
