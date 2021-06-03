package com.lect.ex2.swing;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//�̺�Ʈ �߰� ��� : 1. implements ActionListener -> ������Ʈ�� listener�߰� -> override�� ���� �߰�

//�г� �Ǵ� �����̳ʿ� container�� ������ getContentPane(), ���̾ƿ� ����.
public class Ex01_exitBtn extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jpanel;
	private JButton jbtnExit1;
	private JLabel jlbl1;
	public Ex01_exitBtn(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//x��ư ������ ����.
		jpanel = (JPanel)getContentPane();
		jpanel.setLayout(new FlowLayout());
		jbtnExit1 = new JButton("����");
		jlbl1 = new JLabel("��ſ� �ݿ���", (int) CENTER_ALIGNMENT);
		jlbl1.setPreferredSize(new Dimension(150,200));
		jbtnExit1.setPreferredSize(new Dimension(200,200));
		add(jlbl1);
		add(jbtnExit1);
		setVisible(true);
//		setSize(new Dimension(500,300));
		pack();
		setLocation(100,100);
		setResizable(false);
		//btnExit Ŭ���̺�Ʈ�� �߻��ϸ� this.actionPerformed()�� ȣ���.
		jbtnExit1.addActionListener(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtnExit1) {
			setVisible(false);
			dispose();//����
			System.exit(0);//Ȯ���ϰ� ����
		}
		
	}
	public static void main(String[] args) {
		new Ex01_exitBtn("���� ����");
	}
	
}