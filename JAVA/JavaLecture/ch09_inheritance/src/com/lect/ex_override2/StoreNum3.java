package com.lect.ex_override2;

public class StoreNum3 extends HeadQuarterStore{
	public StoreNum3(String name) {
		super(name);
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³:6000¿ø");
	}
	@Override
	public void budae() {
		System.out.println("ºÎ´ëÂî°³:7000¿ø");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä:7000¿ø");
	}
	@Override
	public void sundae() {
		System.out.println("¼ø´ë±¹:6000¿ø");
	}

}
