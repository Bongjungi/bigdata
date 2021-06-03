package com.lect.ex_interface;
// public static final 상수와 abstract method 추상메소드만 사용할 수 있다.
// public만 쓴다.
// 인터페이스는 다수의 개수를 구현(상속)해줄 수 있다. 왜냐하면 어차피 상수나 추상메소드이기때문에 일반 메소드같은 것이 겹칠 일이 없다는 것이 이유다.
//인터페이스는 작업명세서이다. 클래스 작성에 도움을 줄 목적으로 사용된다.
public interface InterfaceEx1 {
	public /*static final*/ int CONSTANT_NUM=1; //자동으로 static final이 적용된다.
	public /*abstract*/ void method1(); //자동으로 abstract가 적용된다.	
}