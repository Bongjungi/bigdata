package com.lect.ex_final;

public final class Dog extends Animal{
	@Override
	public void running() {
		speed+=10;
		System.out.println("�� ���ǵ�"+speed);
	}
	public void method() {
		System.out.println("method");
	}
}
