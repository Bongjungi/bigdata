package com.lect.ex_override2;

public class StoreNum2 extends HeadQuarterStore{
	public StoreNum2(String name) {
		super(name);
	}
	@Override
	public void budae() {
		System.out.println("�δ��:5000��");
	}
	@Override
	public void bibim() {
		System.out.println("�����:5000��");
	}
	@Override
	public void gonggi() {
		System.out.println("�����:����");
	}
	
}
