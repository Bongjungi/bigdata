package com.lect.ex01_store;
//��ġ�- ����, �δ�� - ����, �����-����, ���뱹-����, �����-����
//�߻�Ŭ������ ���� ������� �ʰ� ��ӹ޴� Ŭ�������� ���� ���̴�.
//�߻�Ŭ������ ���� ������ �ڽ�Ŭ������ �ִ� �޼ҵ� ���� �θ�Ŭ���� Ÿ�����ε� ����� �� �ְԲ� �Ϸ��� �� ����
//HeadQuarterStore HS; ����
//new HeadQuarterStore; �Ұ���
public abstract class HeadQuarterStore {  //�߻�޼ҵ尡 �ϳ��� ������ �߻�Ŭ������ �ȴ�.
	private String name;
	public HeadQuarterStore(String name) {
		this.name=name;
	}
	public abstract void kimchi(); //�߻�޼ҵ�(�޼ҵ� ���Ǹ� �ϰ� �����δ� ���� �޼ҵ�)
	public abstract void budae(); 	//��ü ������ �ȵ�.
	public abstract void bibim(); 	
	public abstract void sundae(); 
	public abstract void gonggi(); 
	public String getName() {
		return name;
	}
}
