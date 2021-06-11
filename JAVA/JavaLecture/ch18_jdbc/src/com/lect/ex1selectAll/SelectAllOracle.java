package com.lect.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; //DB���ắ��
		Statement stmt = null; //SQL�� ���� ��ü ����
		ResultSet rs = null; //SELECT �� ��� �޴� ��ü ����
		String sql = "SELECT * FROM EMP"; // ctrl+shift+x �빮�ڷ� ����
		try {
			Class.forName(driver);//(1) ����̹� �ε�
			conn = DriverManager.getConnection(url,"scott","tiger"); //(2) DB���� ��ü ����
			stmt = conn.createStatement(); //(3) SQL�� ���� ��ü ����
			rs = stmt.executeQuery(sql); //(4) SQL���� (5)����ޱ�
			if(rs.next()) {//������ ���� (6)����� �޾� ���ϴ� ���� ����  
				System.out.println("���\t�̸�\t��å\t\t�����\t�Ի���\t\t�Ի���2\t\t�޿�\t��\t�μ���ȣ");
				do { //if���� rs.next�� �߱� ������ empno,ename�� rs.get���� ���� �� �ִ�.
					 //if �������� dowhile�� �ƴ϶� while�� �Ἥ rs.next�� ������ �ؾ� ��.
					int empno = rs.getInt("empno");//��Ī �������� "��Ī"
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr");
					Date hiredate = rs.getDate("hiredate");
					Timestamp hiredate2 = rs.getTimestamp("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
		
					if(job!=null && job.length()<6) {
						System.out.printf("%d\t%s\t%s\t\t%d\t%TF\t%TF\t%d\t%d\t%d\n",empno,ename,job,mgr,hiredate,hiredate2,sal,comm,deptno);
					}else {
						System.out.printf("%d\t%s\t%s     \t%d\t%TF\t%TF\t%d\t%d\t%d\n",empno,ename,job,mgr,hiredate,hiredate2,sal,comm,deptno);
					}
	
				}while(rs.next());
		
			}else {
				System.out.println("��ȸ�� ����� �����ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+ " ����̹� ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(stmt!=null)stmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
