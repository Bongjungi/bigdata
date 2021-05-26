package com.lect.ex01_store;
//김치찌개- 미정, 부대찌개 - 미정, 비빔밥-미정, 순대국-미정, 공기밥-미정
//추상클래스는 직접 사용하지 않고 상속받는 클래스들을 위한 것이다.
//추상클래스를 쓰는 이유는 자식클래스에 있는 메소드 등을 부모클래스 타입으로도 사용할 수 있게끔 하려는 것 같다
//HeadQuarterStore HS; 가능
//new HeadQuarterStore; 불가능
public abstract class HeadQuarterStore {  //추상메소드가 하나라도 있으면 추상클래스가 된다.
	private String name;
	public HeadQuarterStore(String name) {
		this.name=name;
	}
	public abstract void kimchi(); //추상메소드(메소드 정의만 하고 구현부는 없는 메소드)
	public abstract void budae(); 	//객체 생성이 안됨.
	public abstract void bibim(); 	
	public abstract void sundae(); 
	public abstract void gonggi(); 
	public String getName() {
		return name;
	}
}
