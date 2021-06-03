package com.lect.ex01_store;

public class StoreNum2 extends HeadQuarterStore{
	public StoreNum2(String name) {
		super(name);
	}
	@Override
	public void budae() {
		System.out.println("부대찌개 : 5000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 : 백만원");
	}
	@Override
	public void gonggi() {
		System.out.println("공기밥 : 무료");
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 백만원");
		
	}
	@Override
	public void sundae() {
		System.out.println("순대국 : 백만원");
		
	}
	
}
