package com.lect.ex_getclassGetname;

public class AirPlain implements IMissile, ILight{
	public AirPlain() {
		System.out.println("������Դϴ�.");
		canLight();
		canMissile();
		System.out.println("---------------------");
	}
	@Override
	public void canLight() {
		System.out.println("�Һ��߻� �����մϴ�.");
		
	}

	@Override
	public void canMissile() {
		System.out.println("�̻����� �߻��� �� �ֽ��ϴ�.");
		
	}
	@Override
	public String toString() {
		return "�Һ��߻��ϰ� �̻��Ϲ߻��ϴ� �����";
	}
	

}
