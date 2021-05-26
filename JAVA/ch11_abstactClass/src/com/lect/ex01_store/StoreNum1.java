package com.lect.ex01_store;
//주택가 1호점 : 부대찌개 5000원 순대국 안팜.
public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String name) {
		super(name);  //이걸 쓰면 매개변수없는생성자가 없어도 상속 원만하게 가능하다. 
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 4500원");
		
	}

	@Override
	public void budae() {
		System.out.println("부대찌개 : 5000원");
		
	}

	@Override
	public void bibim() {
		System.out.println("비빔밥 : 6000원");
		
	}

	@Override
	public void sundae() {
		System.out.println("순대국 : 판매안함");
		
	}

	@Override
	public void gonggi() {
		System.out.println("공기밥 : 무료");
		
	}
	
}
