package com.lec.car;

public class CarMain {
	public static void main(String[] args) { //car클래스 myporsche는 객체변수, 마이포르쉐의 타입(객체타입)은 Car라는 클래스
		                                     //int i 는 i는 변수 int는 기초데이터타입 Car car 는 car는 변수 Car는 클래스타입
		Car myPorsche = new Car(); //myPorsche공간에는 color cc brand speed drive() 등의 주소가 담기고 color 등이 생성되어 null 또는 0이 들어있다.
		//myPorsche.color="빨강"; Car class에서 color를 private해놔서 color를 직접 못 씀.
		myPorsche.setColor("빨강"); //그래서 setter를 쓴다. setcolor로 color에 색을 간접적으로 집어넣고 getcolor로 color에 있는 색을 가져다가 출력한다. 
		                           //color를 빨강으로 지정.
		System.out.println(myPorsche.getColor()); //지정된 color를 출력
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		//Car yourPorsche; - 주소만 있고 객체나 값이 없다.
		Car yourPorche = new Car();
		//yourPorche.color="쥐색";
		yourPorche.setColor("gray");
		System.out.println("나의 자동차 색은 "+myPorsche.getColor());
		System.out.println("너의 자동차 색은 " +yourPorche.getColor());
	}
}
