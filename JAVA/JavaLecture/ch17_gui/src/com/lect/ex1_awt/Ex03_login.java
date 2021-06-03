package com.lect.ex1_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Ex03_login extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private Label lbl1;
	private Label lbl2;
	private TextField txtId;
	private TextField txtPw;
	private Button btnLogin;
	public Ex03_login(String title) {
		super(title);
		setLayout(new FlowLayout());
		lbl1= new Label("아 이 디");
		lbl2 =new Label("비밀번호");
		txtId= new TextField("ID",20);
		txtPw =new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("로그인");
		add(lbl1);
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		setSize(new Dimension(300,150));
		setLocation(100,100);
		setVisible(true);
		setResizable(false);//사용자가 frame 사이즈 조정 불가.
	}
	public static void main(String[] args) {
		new Ex03_login("로그인");
	}
}
