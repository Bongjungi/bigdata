package com.lect.ex3_accessTest;

public class AccessTest {
//	private int privateMember;     // ���� Ŭ���� �������� �۵�
	int defaultMember;             // ����Ʈ�������� : ���� ��Ű�������� �۵�
	protected int protectedMember; //���� ��Ű���� ��ӹ��� Ŭ�������� �۵� ����
	public int publicMember;       //���� ������Ʈ ������ �۵�
//	private void privateMethod() {
//		System.out.println("�����̺��޼ҵ�");
//	}
	void defaultMethod() {
		System.out.println("����Ʈ�޼ҵ�");
	}
	protected void protectedMethod() {
		System.out.println("�����ص��޼ҵ�");
	}
	public void publicMethod() {
		System.out.println("�ۺ��޼ҵ�");
	}
}
