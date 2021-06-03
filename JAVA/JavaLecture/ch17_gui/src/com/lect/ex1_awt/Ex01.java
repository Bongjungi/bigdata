package com.lect.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex01 extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button btn1;
	private Button btn2;
	public Ex01() {
		btn1=new Button("��ư");
		btn2=new Button("�׳� ��ư");
//									Frame�� layoutŸ�� : (�⺻)BorderLayout(��,��,��,��,��)- ��ġ ���� �ʼ�                      --��ư�� ���̵忡 ����.
//														   FlowLayout(�º��� ���, ������ �Ʒ���) - ��ġ ���� ���ص� ��    --��ư�� ���̵�� �ణ ������.
//														   GridLayout(���� �)                               --���� ��� ������ �ش� ��ҿ� ��.
		add(btn1, BorderLayout.CENTER);
		add(btn2, BorderLayout.SOUTH);
		setVisible(true);
		setSize(new Dimension(300,200));
//		pack();//�ּ����� �������
		setLocation(200,100);
		//3�� �� �ڵ� ����
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		setVisible(false);
		dispose(); // ������ ������Ʈ�� �ڿ�����
		System.exit(0);
		
	}
	public Ex01(String title) {
		this();
		setTitle(title);
	}
	public static void main(String[] args) {
		new Ex01("�ڹ�");
	}
}
