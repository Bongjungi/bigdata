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
		btn1=new Button("버튼");
		btn2=new Button("그냥 버튼");
//									Frame의 layout타입 : (기본)BorderLayout(동,서,남,북,중)- 위치 지정 필수                      --버튼이 사이드에 붙음.
//														   FlowLayout(좌부터 우로, 위부터 아래로) - 위치 지정 안해도 됨    --버튼이 사이드와 약간 떨어짐.
//														   GridLayout(몇행 몇열)                               --몇행 몇열로 나눠서 해당 장소에 들어감.
		add(btn1, BorderLayout.CENTER);
		add(btn2, BorderLayout.SOUTH);
		setVisible(true);
		setSize(new Dimension(300,200));
//		pack();//최소한의 사이즈로
		setLocation(200,100);
		//3초 후 자동 종료
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		setVisible(false);
		dispose(); // 프레임 컴포넌트의 자원해제
		System.exit(0);
		
	}
	public Ex01(String title) {
		this();
		setTitle(title);
	}
	public static void main(String[] args) {
		new Ex01("자바");
	}
}
