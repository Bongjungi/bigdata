package com.lect.ex_override2;



public class TestMain {
	public static void main(String[] args) {
		HeadQuarterStore[] hs= {new HeadQuarterStore("����"),new StoreNum1("��"),new StoreNum2("��"),new StoreNum3("�׳�")};
		for(HeadQuarterStore i:hs) {
			System.out.println(i.getName());
			i.kimchi();i.budae();i.bibim();i.sundae();i.gonggi();
		}
		
	}
}
