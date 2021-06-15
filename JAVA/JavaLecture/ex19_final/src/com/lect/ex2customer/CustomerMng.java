package com.lect.ex2customer;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class CustomerMng extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container contenpane;
	private JPanel jpup,jpdown;
	private JTextField txtphone,txtname,txtpoint;
	private JButton joinbtn,searchbtn,printbtn,exitbtn;
	private JTextArea jta;
	private JScrollPane scrollpane;
	private ArrayList<CustomerDto> customers;
	private CustomerDao dao;
	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		dao = CustomerDao.getinstance();
		contenpane = getContentPane();
		contenpane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3,2));
		jpdown = new JPanel(new FlowLayout());
		txtphone = new JTextField(15);
		txtname = new JTextField(15);
		txtpoint = new JTextField("1000",15);
		joinbtn = new JButton("가입");
		searchbtn = new JButton("폰조회");
		printbtn = new JButton("출력");
		exitbtn = new JButton("종료");
		jta = new JTextArea(15,30);
		scrollpane = new JScrollPane(jta);
		jpup.add(new JLabel("폰번호",(int)CENTER_ALIGNMENT));jpup.add(txtphone);
		jpup.add(new JLabel("이름",(int)CENTER_ALIGNMENT));jpup.add(txtname);
		jpup.add(new JLabel("포인트",(int)CENTER_ALIGNMENT));jpup.add(txtpoint);
		jpdown.add(joinbtn);jpdown.add(searchbtn);jpdown.add(printbtn);jpdown.add(exitbtn);
		contenpane.add(jpup);contenpane.add(jpdown);contenpane.add(scrollpane);
		setVisible(true);
		setSize(new Dimension(400,450));
		setLocation(200, 150);
		joinbtn.addActionListener(this);
		searchbtn.addActionListener(this);
		printbtn.addActionListener(this);
		exitbtn.addActionListener(this);	
	}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==joinbtn) {
			String phone, name; int point=1000;
			phone= txtphone.getText().trim();
			name = txtname.getText().trim();
			point=Integer.parseInt(txtpoint.getText().trim());
			CustomerDto newcus = new CustomerDto(0, phone, name, point);
			int result=dao.insertdto(newcus);
			if(result==1) {
				jta.setText("입력 성공");
				txtphone.setText("");
				txtname.setText("");
				txtpoint.setText("1000");
				
			}
		}else if(e.getSource()==searchbtn) {
			String searchphone =txtphone.getText().trim();
			customers=dao.searchphone(searchphone);
			for(CustomerDto customer : customers) {
				jta.append(customer.toString()+"\n");
			}
		}else if(e.getSource() == printbtn) {
			customers = dao.allprint();
			if(customers.size()==0) {
				jta.setText("회원이 없습니다");
			}else {
				for(CustomerDto customer : customers) {
					jta.append(customer.toString()+"\n");
				}
			}
		}else if(e.getSource()==exitbtn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new CustomerMng("회원관리");
		
	}
}
