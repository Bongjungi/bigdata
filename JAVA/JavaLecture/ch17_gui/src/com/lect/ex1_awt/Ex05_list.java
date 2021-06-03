package com.lect.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex05_list extends Frame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	private Panel panel;
	private List list;
	private TextField txtField;
	private Button btnOk, btnExit;
	public Ex05_list() { //기본이 Borderlayout
		setSize(new Dimension(400,200));
		panel = new Panel(); // panel은 기본이 Flowlayout
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list= new List();
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel,BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true);
		setLocation(300,200);
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOk) {
			list.add(txtField.getText());
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex05_list();
	}
}
