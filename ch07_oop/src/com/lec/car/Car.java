package com.lec.car;
//Ŭ������ ���赵, ��ü�� �ڵ���
//������(private) �޼ҵ�(public) setter getter
public class Car {
	private String color; private int cc, speed;//�Ӽ�, ������
	public void drive() {
		speed=60; System.out.println("�����Ѵ�. ���� �ӵ� "+speed);	
	}
	public void park() {
		speed=0; System.out.println("�����Ѵ�. ���� �ӵ� "+speed);
	}
	public void race() {
		speed=120; System.out.println("���̽��Ѵ�. ���� �ӵ� "+speed);
	}
	//color,cc,speed - private �Ǿ������� setter �ʿ�
	public void setColor(String color) {
		this.color= color; //(�� ��ü�� Į�� = ���� Į��)
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
