package com.lect.ex_getclassGetname;

public class AirPlain implements IMissile, ILight{
	public AirPlain() {
		System.out.println("비행기입니다.");
		canLight();
		canMissile();
		System.out.println("---------------------");
	}
	@Override
	public void canLight() {
		System.out.println("불빛발사 가능합니다.");
		
	}

	@Override
	public void canMissile() {
		System.out.println("미사일을 발사할 수 있습니다.");
		
	}
	@Override
	public String toString() {
		return "불빛발사하고 미사일발사하는 비행기";
	}
	

}
