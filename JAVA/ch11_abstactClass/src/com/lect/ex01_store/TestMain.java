package com.lect.ex01_store;


public class TestMain {
	public static void main(String[] args) {
//		HeadQuarterStore st = new HeadQuarterStore("����") {
//			
//			@Override
//			public void sundae() {	
//			}
//			@Override
//			public void kimchi() {	
//			}
//			@Override
//			public void gonggi() {
//			}
//			@Override
//			public void budae() {
//			}
//			@Override
//			public void bibim() {
//			}
//		};
		HeadQuarterStore[] hs = {new StoreNum1("��"),new StoreNum2("��"),new StoreNum3("�׳�")};
		for (HeadQuarterStore i: hs) {
			i.bibim();
			i.budae();
			i.gonggi();
			i.kimchi();
			i.sundae();
			
		}
		
	}
}
