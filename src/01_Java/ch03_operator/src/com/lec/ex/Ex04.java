package com.lec.ex;

public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		System.out.println("(i<j)&&(++j>h):"+((i<j)&&(++j>h))); //+�ν�������
		System.out.println("j="+j);
		System.out.println("(i>j)&&(++j>h):"+((i>j)&&(++j>h))); //������i>j�� �����̶� &&�Ǵܳ�.������ ���� �ͱ��� ������.
		System.out.println("j="+j); //j�� 12�� ������ �ʴ� ������ i>j�� �����̾ ++j���� �������� �ʱ� ����
		System.out.println("(i<j)||(++j>h):"+((i<j)||(++j>h))); //������i<j�� ���̶� ||�Ǵܳ�
		System.out.println("j="+j);
	}
}
