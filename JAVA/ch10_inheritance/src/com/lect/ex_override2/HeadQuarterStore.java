package com.lect.ex_override2;
// override - 수정
// overload - 변수개수에 따라 중복사용
public class HeadQuarterStore {
	private String name;
	public HeadQuarterStore(String name) {
		this.name=name;
	}
	public void kimchi() {
		System.out.println("김치찌개:5000원");
	}
	public void budae() {
		System.out.println("부대찌개:6000원");
	}
	public void bibim() {
		System.out.println("비빔밥:6000원");
	}
	public void sundae() {
		System.out.println("순대국:5000원");
	}
	public void gonggi() {
		System.out.println("공기밥:1000원");
	}
	public String getName() {
		return name;
	}
	
}
