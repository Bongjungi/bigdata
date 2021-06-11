package com.lect.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// �μ����� �Է¹޾� �ش� �μ����� ���, �̸�, �޿�, ����̸� ����
public class SelectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String deptQuery = "SELECT * FROM DEPT WHERE DNAME = ?";
		String empQuery = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER" + 
				"    FROM EMP W, EMP M, DEPT D" + 
				"    WHERE W.MGR=M.EMPNO AND D.DEPTNO=W.DEPTNO AND DNAME=?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(deptQuery);
			System.out.println("�˻��ϰ��� �ϴ� �μ�����? ");
			String dname = sc.next().toUpperCase();
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("��û�Ͻ� "+dname+" �μ� ����");
				System.out.println("�μ���ȣ : "+rs.getInt("deptno"));
				System.out.println("�μ���ġ : "+rs.getString("loc"));
				rs.close();pstmt.close();
				pstmt = conn.prepareStatement(empQuery);
				pstmt.setString(1, dname);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					do {//while(rs.next())�� ���� ù��° rs.next�� ���󰣴�.
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+manager);
					}while(rs.next());
				}
			}else {
				System.out.println("�ش� �μ����� �������� �ʽ��ϴ�.");
			}
			sc.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
