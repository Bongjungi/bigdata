package com.lect.ex_getclassGetname;

public class Mazinger implements IMoveArmLeg, IMissile {
	public Mazinger() {
		System.out.println("��¡���Դϴ�.");
		canMissile();
		canMoveArmLeg();
		System.out.println("-----------------");
	}
	@Override
	public void canMissile() {
		System.out.println("�̻����� �� �� �ִ�.");

	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ִ�.");

	}
	public String toString() {
		return "�̻����� ��� �ȴٸ��� �����̴� ��¡��";
	}

}
