package com.lect.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnIn, btnOut;
	private JTextField txtName, txtTel, txtAge;
	private JPanel jp,jp2;
	private Container contenPane;
	private ArrayList<Person> people= new ArrayList<Person>();
	private ImageIcon icon1, icon2;
	public MyFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jp = new JPanel(new GridLayout(3,2));
		jp2 = new JPanel(new FlowLayout());
		txtName= new JTextField();
		txtTel= new JTextField();
		txtAge = new JTextField();
		icon1= new ImageIcon("icon/join.png");
		icon2 = new ImageIcon("icon/output.png");
		jp.add(new JLabel("이름",(int)CENTER_ALIGNMENT)); jp.add(txtName); 
		jp.add(new JLabel("전화",(int)CENTER_ALIGNMENT));jp.add(txtTel);
		jp.add(new JLabel("나이",(int)CENTER_ALIGNMENT));jp.add(txtAge);
		btnIn = new JButton("입력", icon1);
		btnOut = new JButton("출력", icon2);
		jp2.add(btnIn); jp2.add(btnOut);
		contenPane.add(jp,BorderLayout.CENTER);
		contenPane.add(jp2,BorderLayout.SOUTH);
		
		
		setVisible(true);
		setBounds(500, 300, 300, 200);
		
		btnIn.addActionListener(this);
		btnOut.addActionListener(this);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIn) {
			String name = txtName.getText().trim();
			String tel = txtTel.getText().trim();
			int age = 0;
			if(tel.indexOf("-")==-1) {
				try{
					age = Integer.parseInt(txtAge.getText().trim());
				}catch(Exception e1) {
					System.out.println("잘못된 나이 입력에 따라 0으로 입력하겠습니다.");
					age=0;
				}
				if(age<0||age>150) {
					System.out.println("잘못된 나이 입력에 따라 0으로 입력하겠습니다.");
					age=0;
				}
				Person person = new Person(name,tel,age);
				people.add(person);
				System.out.println("저장 완료");
			}else {
				System.out.println("전화번호 입력 시, \'-\' 를 생략해 주세요");
				return;
			}
		}else if(e.getSource()==btnOut) {
			PrintWriter printWriter = null;
			Writer writer=null;
				try {
					writer = new FileWriter("txtFile/person.txt",true);
					printWriter = new PrintWriter(writer);
					for(int i=0;i<people.size();i++) {
						printWriter.print(people.get(i)+"\n");
					}
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}finally {
					if(printWriter!=null) {
						printWriter.close();
					}
					if(writer!=null) {
						try {
							writer.close();
						} catch (IOException e1) {
							System.out.println(e1.getMessage());
						}
					}
				}
			}
	}

	public static void main(String[] args) {
		new MyFrame("GUI 예제");
	}

}
