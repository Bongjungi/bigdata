package com.lect.ex_override;
//Speaker, TV, Radio
public interface IVolume {
	public void volumeUp(); //추상메소드(메소드 정의만 하고 구현부는 없는 메소드) //객체 생성이 안됨.
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
//	public default void mute() {       //--일반메소드 사용가능...
//		System.out.println("무음처리합니다.");
//	}
}
	
	
