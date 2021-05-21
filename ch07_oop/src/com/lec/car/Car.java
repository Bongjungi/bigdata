package com.lec.car;
//클래스는 설계도, 객체는 자동차
//데이터(private) 메소드(public) setter getter
public class Car {
	private String color; private int cc, speed;//속성, 데이터
	public void drive() {
		speed=60; System.out.println("운전한다. 지금 속도 "+speed);	
	}
	public void park() {
		speed=0; System.out.println("주차한다. 지금 속도 "+speed);
	}
	public void race() {
		speed=120; System.out.println("레이싱한다. 지금 속도 "+speed);
	}
	//color,cc,speed - private 되어있으니 setter 필요
	public void setColor(String color) {
		this.color= color; //(내 객체의 칼라 = 변수 칼라)
	}
	public String getColor() {
		return color;
	}
	public void setCc(int cc) {
		this.cc=cc;
	}
	public int getCc() {
		return cc;
	}
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	public int getSpeed() {
		return speed;
	}
}
