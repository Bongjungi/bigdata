package com.lect.myExample;

public class Run {                                 
	private int i=1;               
//	private static int j=1; 
//	i=2 불가능 i=2를 실행시켜줄 애가 없음.
	

	public void function() {
		
		i=2;
		
	}
	public void function2() {
		i=3;
	//	int i=4;//이 안에서만 작용하는 인트
	}
	public static void main(String[] args) {
		
		Run ex = new Run(); 
		System.out.println(ex.i);
		 ex.function();
		 System.out.println(ex.i);
		 ex.function2();
		 System.out.println(ex.i);	
		 
	}
	
}
//ctrl+shift+o = 쓸모 없는 거 지움 import 같은거
//private 여기서만 쓴다.
//static 클래스에 저장한다. 클래스변수는 하나만 존재한다. 모두 공유한다.
