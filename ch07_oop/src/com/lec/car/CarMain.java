package com.lec.car;

public class CarMain {
	public static void main(String[] args) { //carŬ���� myporsche�� ��ü����, ������������ Ÿ��(��üŸ��)�� Car��� Ŭ����
		                                     //int i �� i�� ���� int�� ���ʵ�����Ÿ�� Car car �� car�� ���� Car�� Ŭ����Ÿ��
		Car myPorsche = new Car(); //myPorsche�������� color cc brand speed drive() ���� �ּҰ� ���� color ���� �����Ǿ� null �Ǵ� 0�� ����ִ�.
		//myPorsche.color="����"; Car class���� color�� private�س��� color�� ���� �� ��.
		myPorsche.setColor("����"); //�׷��� setter�� ����. setcolor�� color�� ���� ���������� ����ְ� getcolor�� color�� �ִ� ���� �����ٰ� ����Ѵ�. 
		                           //color�� �������� ����.
		System.out.println(myPorsche.getColor()); //������ color�� ���
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		//Car yourPorsche; - �ּҸ� �ְ� ��ü�� ���� ����.
		Car yourPorche = new Car();
		//yourPorche.color="���";
		yourPorche.setColor("gray");
		System.out.println("���� �ڵ��� ���� "+myPorsche.getColor());
		System.out.println("���� �ڵ��� ���� " +yourPorche.getColor());
	}
}
