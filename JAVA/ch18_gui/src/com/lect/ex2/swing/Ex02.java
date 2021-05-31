package com.lect.ex2.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex02 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private JPanel jpanel;
	private JLabel jl;
	private JButton jBtn;
	private ImageIcon icon;
	private JTextField jtxtField;
	private JCheckBox jChkBox;
	private Vector<String> items = new Vector<String>();
	private JComboBox<String> jcombo;
	private JLabel jlBlank;
	private JButton jBtnExit;
	public Ex02() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jpanel = (JPanel)getContentPane();
		jpanel.setLayout(new FlowLayout());
		jl= new JLabel("Label");
		icon = new ImageIcon("icon/write.gif");
		jBtn = new JButton("Button", icon);
		jtxtField = new JTextField(20);
		items.add("A");items.add("B");items.add("C");
		jcombo= new JComboBox<String>(items);
		jChkBox = new JCheckBox("ChechBox");
		jlBlank = new JLabel();
		jBtnExit =new JButton("Exit");
		jpanel.add(jl);jpanel.add(jBtn);jpanel.add(jtxtField);jpanel.add(jcombo);jpanel.add(jChkBox);jpanel.add(jlBlank);jpanel.add(jBtnExit);
		jl.setPreferredSize(new Dimension(50,50));
		jBtn.setPreferredSize(new Dimension(200, 50));
		jtxtField.setPreferredSize(new Dimension(300, 50));
		jcombo.setPreferredSize(new Dimension(100,50));
		jChkBox.setPreferredSize(new Dimension(100, 50));
		jlBlank.setPreferredSize(new Dimension(200,50));
		jBtnExit.setPreferredSize(new Dimension(100, 50));
		setVisible(true);
		pack();
		setLocation(300,400);
		jBtn.addActionListener(this);//addactionlistener(actionperformed) -- this - 여기의 actionperformed를 적용하라
		jcombo.addActionListener(this);
		jChkBox.addActionListener(this);
		jBtnExit.addActionListener(this);	
	}
	public Ex02(String Title) {
		this();
		setTitle("제목");
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jBtn) {
			String temp = jtxtField.getText().trim().toUpperCase();
			if(temp.equals("")) {
				return;
			}
			jlBlank.setText(jtxtField.getText().trim());
			jcombo.addItem(jtxtField.getText());//items.add(temp);
			String name = JOptionPane.showInputDialog("이름을 입력하세요");
			jlBlank.setText(name);
			System.out.println(name);
		}else if(e.getSource()==jcombo) {
			jlBlank.setText(jcombo.getSelectedItem().toString());
			jcombo.setSelectedItem("C");//콤보 박스만 C로 고정
		}else if(e.getSource()==jChkBox) {
			if(jChkBox.isSelected()) {
				jlBlank.setText(jChkBox.getText());
				System.out.println(items);
			}
		}else if(e.getSource()==jBtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex02("이게 뭐야");
	}

}
