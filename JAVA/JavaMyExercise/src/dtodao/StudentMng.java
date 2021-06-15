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
		btnSNoSearch = new JButton("학번검색");
		btnSnameSearch = new JButton("이름검색");
		btnMNameSearch =new JButton("전공검색");
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpelOut = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		btnBtn = new JButton("버튼");
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		txtScore = new JTextField(10);
		jta = new JTextArea(10,50);
		scrollpane = new JScrollPane(jta);
		comMname = new JComboBox<String>(mnames);
		jpup.add(new JLabel("학번",(int)CENTER_ALIGNMENT));jpup.add(txtSNo);jpup.add(btnSNoSearch);
		jpup.add(new JLabel("이름",(int)CENTER_ALIGNMENT));jpup.add(txtSName);jpup.add(btnSnameSearch);
		jpup.add(new JLabel("전공",(int)CENTER_ALIGNMENT));jpup.add(comMname);jpup.add(btnMNameSearch);
		jpup.add(new JLabel("점수",(int)CENTER_ALIGNMENT));jpup.add(txtScore);jpup.add(btnBtn);
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
				jta.setText(txtSNo.getText().trim()+" 검색 완료");
			}catch(Exception e1){
				jta.setText(txtSNo.getText().trim()+"은 유효하지 않는 학번입니다.");
			}
		}else if(e.getSource()==btnSnameSearch) {
			jta.setText("");
			if(txtSName.getText().equals("")) {
				jta.setText("이름을 입력해주세요.");
			}else {
				students = dao.searchsname(txtSName.getText().trim());
				if(students.size()==0) {
					jta.setText("해당 이름의 학생이 없습니다.");
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
				jta.setText("전공을 선택하고 검색하세요.");
			}
			students = dao.searchmaj(comMname.getSelectedItem().toString());
			if(students.size()==0) {
				jta.setText("해당 학과에는 학생이 없습니다.");
			}else {
				jta.append("학번\t이름\t학과명\t점수\n------------------------------\n");
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
				jta.setText(txtSName.getText().trim()+" 입력 완료");
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
				jta.setText(txtSNo.getText().trim()+" 수정 완료");
			}
		}else if(e.getSource()==btnStudentOut) {
			jta.setText("");
			jta.append("등수\t이름\t학과명\t점수\n------------------------------------------------------------------------\n");
			students = dao.printstud();
			for(StudentDto p : students) {
				jta.append(p.toString()+"\n");
			}
		}else if(e.getSource()==btnExpelOut) {
			jta.setText("");
			jta.append("등수\t이름\t학과명\t점수\n------------------------------------------------------------------------\n");
			students = dao.printdelstud();
			for(StudentDto p : students) {
				jta.append(p.toString()+"\n");
			}
		}else if(e.getSource()==btnExpel) {
			jta.setText("");
			int result =dao.deletestud(txtSNo.getText().trim());
			if(result>0) {
				jta.setText(txtSNo.getText().trim()+" 제적완료");
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}else if(e.getSource()==btnBtn) {
			new Ex03_GUI("GUI 예제");
		}
	}
	public static void main(String[] args) {
		new StudentMng("학사관리");
	}
}