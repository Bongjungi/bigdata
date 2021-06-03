package com.lect.ex_setterAndgetter;
// 패키지명, 클래스명, 데이터, 생성자함수, 메소드, settergetter
//main(); Square s =new Square()
//        Square s1 =new Square(10)
// import com.lect.ex2_human.*;         // * =all 안에 있는 모든 것을 import하겠다는 의미.
public class Square {
	private int side;
	public Square() {//생성자함수 : return type이 없고 클래스명과 같은 함수  //public 클래스명() - 이 함수는 생략하면 자동으로 입력되어서 여태까지도 작동했음. 
		//오른쪽 마우스 > source> generate constructor using superclass //만약 매개변수 있게 (public Square(무언가))설정 또는 private Square하면 생성자함수 생성안됨.
		//public void square 이런식으로 void같은거 넣으면 생성자함수가 아닌 일반함수로 인식한다.
		System.out.println("매개변수 없는 생성자 함수 호출됨");
	}
	public Square(int side) {// 매개변수 있는 생성자 함수의 용도 : 데이터 초기화 //오른쪽 마우스 > source > generate constructor using field
		this.side =side; // side를 입력하면 함수 내의 side를 먼저 인식하고 그 다음 클래스 내의 side를 인식한다. 
                         // 그러므로 클래스의 side를 사용하려면 this를 적어준다.
		System.out.println("매개변수 있는 생성자 함수 호출됨. side 초기화함");
	}
	public int area() {
		return side*side;
	}
	public void setSide(int side) {//Square s = new Square(); s.setside(10) s.getside()
		this.side=side;        //오른쪽 마우스 > source > generate settergetter 클릭 끝ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	}							//SetA 입력후 ctrl+ space 자동완성, sysout ctrl +space랑 비슷하다.			
	public int getside() {//s.getside
		return side;		//SetG 컨트롤스페이스
	}

}
