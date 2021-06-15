package com.lect.ex1person;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonMngGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//화면에 추가될 컴포넌트 변수
	private Container contenpane;
	private JPanel jpup, jpbtn;
	private JTextField txtname, txtkor, txteng, txtmat;
	private Vector<String> jnames; // 콤보박스 안에 들어갈 아이템;
	private JComboBox<String> comjob;
	private JButton btninput, btnsearch, btnoutput, btnexit;
	private JTextArea txtpool;
	private JScrollPane scrollpane;
	//db 연동을 위한 변수
	private PersonDao dao;
	private ArrayList<PersonDto> people;
	public PersonMngGUI(String title) {
		super(title);
		dao= PersonDao.getinstance();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenpane = getContentPane();
		contenpane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(5, 2));
		jpbtn = new JPanel(new FlowLayout());
		txtname= new JTextField(20);
		txtkor= new JTextField(20);
		txteng= new JTextField(20);
		txtmat= new JTextField(20);
		jnames = dao.jnamelist();
		comjob=new JComboBox<String>(jnames);
		ImageIcon icon1 = new ImageIcon("src/icon/join.png");
		btninput = new JButton("입력",icon1);
		ImageIcon icon2 = new ImageIcon("src/icon/search.png");
		btnsearch = new JButton("직업조회",icon2);
		ImageIcon icon3 = new ImageIcon("src/icon/output.png");
		btnoutput = new JButton("전체출력",icon3);
		ImageIcon icon4 = new ImageIcon("src/icon/exit.png");
		btnexit = new JButton("종료",icon4);
		btninput.setPreferredSize(new Dimension(150,50));
		btnsearch.setPreferredSize(new Dimension(150,50));
		btnoutput.setPreferredSize(new Dimension(150,50));
		btnexit.setPreferredSize(new Dimension(150,50));
		txtpool = new JTextArea(10,60);
		scrollpane = new JScrollPane(txtpool);
		jpup.add(new JLabel("이름",(int)CENTER_ALIGNMENT));jpup.add(txtname);
		jpup.add(new JLabel("직업",(int)CENTER_ALIGNMENT));jpup.add(comjob);
		jpup.add(new JLabel("국어",(int)CENTER_ALIGNMENT));jpup.add(txtkor);
		jpup.add(new JLabel("영어",(int)CENTER_ALIGNMENT));jpup.add(txteng);
		jpup.add(new JLabel("수학",(int)CENTER_ALIGNMENT));jpup.add(txtmat);
		jpbtn.add(btninput);jpbtn.add(btnsearch);jpbtn.add(btnoutput);jpbtn.add(btnexit);
		contenpane.add(jpup);contenpane.add(jpbtn);contenpane.add(scrollpane);
		setVisible(true);
		setSize(700, 450);
		setLocation(200, 150);
		btninput.addActionListener(this);
		btnoutput.addActionListener(this);
		btnsearch.addActionListener(this);
		btnexit.addActionListener(this);
		comjob.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btninput) {
			String name= txtname.getText().trim();
			String jname = comjob.getSelectedItem().toString();
			String korstr = txtkor.getText().trim();
			String engstr = txteng.getText().trim();
			String matstr = txtmat.getText().trim();
			if(name.equals("")||jname.equals("")||korstr.equals("")||engstr.equals("")||matstr.equals("")) {
				txtpool.setText("전부 입력하세요.");
				return;
			}
			int kor = Integer.parseInt(korstr);
			int eng = Integer.parseInt(engstr);
			int mat =Integer.parseInt(matstr);
			
			PersonDto dto = new PersonDto(jname,name,kor,eng,mat);
			int result = dao.insertPerson(dto);
			if(result==PersonDao.SUCCESS) {
				txtpool.setText("입력 성공");
				txtname.setText("");
				comjob.setSelectedIndex(0);
				txtkor.setText("");
				txteng.setText("");
				txtmat.setText("");
			}
		
		}else if(e.getSource()==btnsearch) {
			String jname = comjob.getSelectedItem().toString();
			if(jname.equals("")) {
				txtpool.setText("직업 선택하시오");
				return;
			}
			people = dao.selectJname(jname);
			if(people.isEmpty()) {
				txtpool.setText("해당 직업의 사람이 없습니다.");
				return;
			}
			for(PersonDto p : people) {
				txtpool.append(p.toString()+"\n");
			}
		}else if(e.getSource()==btnoutput) {
			people=dao.selectAll();
			for(PersonDto p : people) {
				//txtpool.append(p.toString()+"\n");
				txtpool.setText(txtpool.getText()+p.toString()+"\n");
			}
		}else if(e.getSource()==btnexit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new PersonMngGUI("연예인 성적관리");
	}

}
