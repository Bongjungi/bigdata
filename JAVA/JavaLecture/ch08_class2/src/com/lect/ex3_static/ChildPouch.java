package com.lect.ex3_static;

public class ChildPouch {
	private String name;
	static MomPouch momPouch = new MomPouch(); //static�� ������ mompouch�� �񽺵��� ������ ����(��ü������ �ƴ� Ŭ����(������)������ ����)�ȴ�.
	                                           //static�� ���� mompouch�� ChildpouchŬ������ �ִ�.
	public ChildPouch(String name) {
		this.name=name;
	}
	public void takeMoney(int money) {
		if(momPouch.money>=money) {
			momPouch.money-=money;
			System.out.println(name+"�� "+money+"�� �������� ��������"+momPouch.money);
		}else {
			System.out.println(name+"�� ���� �� ����. �������� "+momPouch.money);
		}
		
	}
}
