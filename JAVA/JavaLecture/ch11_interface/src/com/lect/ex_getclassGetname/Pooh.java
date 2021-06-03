package com.lect.ex_getclassGetname;

public class Pooh implements IMoveArmLeg {
	public Pooh() {
		System.out.println("푸");
		canMoveArmLeg();
		System.out.println("--------------------");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일수 있습니다.");
	}
	@Override
	public String toString() {
		return "팔다리를 움직이는 곰돌이 푸"; //tostring override를 했기 때문에 print(a)하면 print(a.tostring)이 적용되므로 결론을 쓰기 좋다.
	}

}
