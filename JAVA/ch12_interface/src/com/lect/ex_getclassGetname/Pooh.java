package com.lect.ex_getclassGetname;

public class Pooh implements IMoveArmLeg {
	public Pooh() {
		System.out.println("Ǫ");
		canMoveArmLeg();
		System.out.println("--------------------");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� �����ϼ� �ֽ��ϴ�.");
	}
	@Override
	public String toString() {
		return "�ȴٸ��� �����̴� ������ Ǫ"; //tostring override�� �߱� ������ print(a)�ϸ� print(a.tostring)�� ����ǹǷ� ����� ���� ����.
	}

}
