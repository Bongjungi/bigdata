package com.lect.ex_getclassGetname;

public class Mazinger implements IMoveArmLeg, IMissile {
	public Mazinger() {
		System.out.println("마징가입니다.");
		canMissile();
		canMoveArmLeg();
		System.out.println("-----------------");
	}
	@Override
	public void canMissile() {
		System.out.println("미사일을 쏠 수 있다.");

	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있다.");

	}
	public String toString() {
		return "미사일을 쏘고 팔다리를 움직이는 마징가";
	}

}
