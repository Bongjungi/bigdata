package com.lect.ex_final;
//final  int 앞에 붙이면 값변경불가, class 앞에 붙이면 상속 불가. 메소드 앞에 붙이면 override 불가.
public class Animal {
	protected int speed;
	public void running() {
		speed+=5;
		System.out.println("뛰고 있어요. 현재 속도: "+speed);
	}
	public final void stop() {
		speed=0;
		System.out.println("멈춤");
	}
}
