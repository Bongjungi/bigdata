package com.lect.ex_override2;

public class StoreNum2 extends HeadQuarterStore{
	public StoreNum2(String name) {
		super(name);
	}
	@Override
	public void budae() {
		System.out.println("ºÎ´ëÂî°³:5000¿ø");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä:5000¿ø");
	}
	@Override
	public void gonggi() {
		System.out.println("°ø±â¹ä:¹«·á");
	}
	
}
