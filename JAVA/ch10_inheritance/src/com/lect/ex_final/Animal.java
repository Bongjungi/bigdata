package com.lect.ex_final;
//final  int �տ� ���̸� ������Ұ�, class �տ� ���̸� ��� �Ұ�. �޼ҵ� �տ� ���̸� override �Ұ�.
public class Animal {
	protected int speed;
	public void running() {
		speed+=5;
		System.out.println("�ٰ� �־��. ���� �ӵ�: "+speed);
	}
	public final void stop() {
		speed=0;
		System.out.println("����");
	}
}
