package com.lect.ex3_static;

public class ChildPouch {
	private String name;
	static MomPouch momPouch = new MomPouch(); //static을 넣으면 mompouch가 비스듬히 써지고 공유(객체영역이 아닌 클래스(데이터)영역에 저장)된다.
	                                           //static을 쓰면 mompouch는 Childpouch클래스에 있다.
	public ChildPouch(String name) {
		this.name=name;
	}
	public void takeMoney(int money) {
		if(momPouch.money>=money) {
			momPouch.money-=money;
			System.out.println(name+"가 "+money+"원 가져가서 엄마돈은"+momPouch.money);
		}else {
			System.out.println(name+"은 돈을 못 받음. 엄마돈은 "+momPouch.money);
		}
		
	}
}
