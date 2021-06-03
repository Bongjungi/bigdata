package com.lect.ex2.swing;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//이벤트 추가 방법 : 1. implements ActionListener -> 컴포넌트에 listener추가 -> override에 로직 추가

//패널 또는 컨테이너에 container로 얻어오고 getContentPane(), 레이아웃 세팅.
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);//x버튼 누르면 닫힘.
		jpanel = (JPanel)getContentPane();
		jpanel.setLayout(new FlowLayout());
		jbtnExit1 = new JButton("종료");
		jlbl1 = new JLabel("즐거운 금요일", (int) CENTER_ALIGNMENT);
		jlbl1.setPreferredSize(new Dimension(150,200));
		jbtnExit1.setPreferredSize(new Dimension(200,200));
		add(jlbl1);
		add(jbtnExit1);
		setVisible(true);
//		setSize(new Dimension(500,300));
		pack();
		setLocation(100,100);
		setResizable(false);
		//btnExit 클릭이벤트를 발생하면 this.actionPerformed()가 호출됨.
		jbtnExit1.addActionListener(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtnExit1) {
			setVisible(false);
			dispose();//종료
			System.exit(0);//확실하게 종료
		}
		
	}
	public static void main(String[] args) {
		new Ex01_exitBtn("나의 예제");
	}
	
}