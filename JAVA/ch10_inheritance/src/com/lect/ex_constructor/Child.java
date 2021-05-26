package com.lect.ex_constructor;
// main함수에서 Child child = new Child(1,2);
public class Child extends SuperIJ{
	private int total;
	public Child() {
		System.out.println("매개변수 없는 Child 생성자 함수");
	}
	public Child(int i, int j) {
//		this.i=i;     i는 private이라 상속받아도 직접 못쓴다. i가 protected는 가능(protected는 상속받은 클래스에서도 사용가능)
		setI(i);setJ(j);
		System.out.println("매개변수 있는 Child 생성자 함수");
	}
	public void sum() {
		total=getI()+getJ();
		System.out.println("본 객체의 total값은 "+total);
				
	}
}
