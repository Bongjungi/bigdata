package dtodao;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class StudentMng extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container contenpane;
	private JPanel jpup,jpbtn;
	private JButton btnSNoSearch,btnSnameSearch,btnMNameSearch,btnInput,btnUpdate,btnStudentOut,btnExpelOut,btnExpel,btnExit,btnBtn;
	private JTextField txtSNo,txtSName,txtScore;
	private JComboBox<String> comMname;
	private JTextArea jta;
	private JScrollPane scrollpane;
	private StudentDao dao;
	private ArrayList<StudentDto> students;
	public StudentMng(String title) {
		super(title);
		contenpane = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenpane.setLayout(new FlowLayout());
		dao = StudentDao.getinstance();
		Vector<String> mnames = dao.majorlist();
		jpup= new JPanel(new GridLayout(4,3));
		jpbtn = new JPanel(new FlowLayout());
		btnSNoSearch = new JButton("�й��˻�");
		btnSnameSearch = new JButton("�̸��˻�");
		btnMNameSearch =new JButton("�����˻�");
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		btnBtn = new JButton("��ư");
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		txtScore = new JTextField(10);
		jta = new JTextArea(10,50);
		scrollpane = new JScrollPane(jta);
		comMname = new JComboBox<String>(mnames);
		jpup.add(new JLabel("�й�",(int)CENTER_ALIGNMENT));jpup.add(txtSNo);jpup.add(btnSNoSearch);
		jpup.add(new JLabel("�̸�",(int)CENTER_ALIGNMENT));jpup.add(txtSName);jpup.add(btnSnameSearch);
		jpup.add(new JLabel("����",(int)CENTER_ALIGNMENT));jpup.add(comMname);jpup.add(btnMNameSearch);
		jpup.add(new JLabel("����",(int)CENTER_ALIGNMENT));jpup.add(txtScore);jpup.add(btnBtn);
		jpbtn.add(btnInput);jpbtn.add(btnUpdate);jpbtn.add(btnStudentOut);jpbtn.add(btnExpelOut);jpbtn.add(btnExpel);jpbtn.add(btnExit);
		contenpane.add(jpup);contenpane.add(jpbtn);contenpane.add(scrollpane);
		setVisible(true);
		setSize(700,450);
		setLocation(200, 150);
		btnSNoSearch.addActionListener(this);
		btnSnameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
		btnBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSNoSearch) {
			jta.setText("");
			try {
				StudentDto dto = dao.searchsno(txtSNo.getText().trim());
				txtSName.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				String score = Integer.toString(dto.getScore());
				txtScore.setText(score);
				jta.setText(txtSNo.getText().trim()+" �˻� �Ϸ�");
			}catch(Exception e1){
				jta.setText(txtSNo.getText().trim()+"�� ��ȿ���� �ʴ� �й��Դϴ�.");
			}
		}else if(e.getSource()==btnSnameSearch) {
			jta.setText("");
			if(txtSName.getText().equals("")) {
				jta.setText("�̸��� �Է����ּ���.");
			}else {
				students = dao.searchsname(txtSName.getText().trim());
				if(students.size()==0) {
					jta.setText("�ش� �̸��� �л��� �����ϴ�.");
				}else if(students.size()==1) {
					txtSNo.setText(students.get(0).getSno());
					txtSName.setText(students.get(0).getSname());
					comMname.setSelectedItem(students.get(0).getMname());
					int score = students.get(0).getScore();
					String strscore = Integer.toString(score);
					txtScore.setText(strscore);
				}else {
					for(StudentDto p : students) {
						jta.append(p.toString()+"\n");
					}
				}
			}
		}else if(e.getSource()==btnMNameSearch) {
			jta.setText("");
			if(comMname.getSelectedItem().toString().equals("")) {
				jta.setText("������ �����ϰ� �˻��ϼ���.");
			}
			students = dao.searchmaj(comMname.getSelectedItem().toString());
			if(students.size()==0) {
				jta.setText("�ش� �а����� �л��� �����ϴ�.");
			}else {
				jta.append("�й�\t�̸�\t�а���\t����\n------------------------------\n");
				for(StudentDto p : students) {
					jta.append(p.toString()+"\n");
				}
			}
		}else if(e.getSource()==btnInput) {
			jta.setText("");
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			String tempscore = txtScore.getText().trim();
			int score = Integer.parseInt(tempscore);
			StudentDto dto= new StudentDto("a", sname, mname, score);
			int result = dao.insertstud(dto);
			if(result>0) {
				jta.setText(txtSName.getText().trim()+" �Է� �Ϸ�");
			}
		}else if(e.getSource()==btnUpdate) {
			jta.setText("");
			String sno = txtSNo.getText().trim();
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			String tempscore = txtScore.getText().trim();
			int score = Integer.parseInt(tempscore);
			StudentDto dto= new StudentDto(sno, sname, mname, score);
			int result =dao.updatestud(dto);
			if(result>0) {
				jta.setText(txtSNo.getText().trim()+" ���� �Ϸ�");
			}
		}else if(e.getSource()==btnStudentOut) {
			jta.setText("");
			jta.append("���\t�̸�\t�а���\t����\n------------------------------------------------------------------------\n");
			students = dao.printstud();
			for(StudentDto p : students) {
				jta.append(p.toString()+"\n");
			}
		}else if(e.getSource()==btnExpelOut) {
			jta.setText("");
			jta.append("���\t�̸�\t�а���\t����\n------------------------------------------------------------------------\n");
			students = dao.printdelstud();
			for(StudentDto p : students) {
				jta.append(p.toString()+"\n");
			}
		}else if(e.getSource()==btnExpel) {
			jta.setText("");
			int result =dao.deletestud(txtSNo.getText().trim());
			if(result>0) {
				jta.setText(txtSNo.getText().trim()+" �����Ϸ�");
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}else if(e.getSource()==btnBtn) {
			new Ex03_GUI("GUI ����");
		}
	}
	public static void main(String[] args) {
		new StudentMng("�л����");
	}
}