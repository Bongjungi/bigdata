package com.lect.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex04_login extends Frame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private Panel panel;
	private Label lbl1;
	private Label lbl2;
	private TextField txtId;
	private TextField txtPw;
	private Button btnLogin;
	public Ex04_login(String title) {
		super(title);
		panel= new Panel();
		panel.setLayout(new GridLayout(2,2));
		lbl1= new Label("아 이 디");
		lbl2 =new Label("비밀번호");
		txtId= new TextField("ID",20);
		txtPw =new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("로그인");
		panel.add(lbl1);
		panel.add(txtId);
		panel.add(lbl2);
		panel.add(txtPw);
		add(panel,BorderLayout.CENTER);
		add(btnLogin,BorderLayout.SOUTH);
		setSize(new Dimension(300,150));
		setLocation(100,100);
		setVisible(true);
		setResizable(false);//사용자가 frame 사이즈 조정 불가.
		btnLogin.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLogin) {
			String id=txtId.getText().trim().toUpperCase();//대문자 수정
			String pw=txtPw.getText().trim();
			System.out.print("입력하신 ID는 "+id+", 입력하신 PW는 "+pw);
		}
		
	}
	public static void main(String[] args) {
		new Ex04_login("로그인");
	}
}
