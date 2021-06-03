package com.lect.ex1_awt;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//�̺�Ʈ �߰� ��� : 1. implements ActionListener -> ������Ʈ�� listener�߰� -> override�� ���� �߰�
public class Ex02_exitBtn extends Frame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private Button btnExit1;
	private Label lbl1;
	public Ex02_exitBtn(String title) {
		super(title);
		setLayout(new FlowLayout());
		btnExit1 = new Button("����");
		lbl1 = new Label("��ſ� �ݿ���");
		lbl1.setPreferredSize(new Dimension(150,200));
		btnExit1.setPreferredSize(new Dimension(200,200));
		add(lbl1);
		add(btnExit1);
		setVisible(true);
		setSize(new Dimension(500,300));
		setLocation(100,100);
		//btnExit Ŭ���̺�Ʈ�� �߻��ϸ� this.actionPerformed()�� ȣ���.
		btnExit1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnExit1) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new Ex02_exitBtn("���� ����");
	}
}