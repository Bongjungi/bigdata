package com.lect.ex_override2;

public class StoreNum3 extends HeadQuarterStore{
	public StoreNum3(String name) {
		super(name);
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ�:6000��");
	}
	@Override
	public void budae() {
		System.out.println("�δ��:7000��");
	}
	@Override
	public void bibim() {
		System.out.println("�����:7000��");
	}
	@Override
	public void sundae() {
		System.out.println("���뱹:6000��");
	}

}
