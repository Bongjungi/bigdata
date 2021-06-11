package com.lect.ex2selectwhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDnameEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("�μ� �̸���? : ");
		String dname = sc.next().toUpperCase();
		String sql1 = String.format("select * from dept where dname = '%s'", dname);
		String sql2 = String.format("SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER"+
				" FROM EMP W, EMP M, DEPT D" + //from �տ� ���� ��������.
				" WHERE W.MGR=M.EMPNO AND W.DEPTNO= D.DEPTNO AND DNAME ='%s'",dname);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			
			if(rs.next()) {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println(dname+"�� �μ� ������ ������ �����ϴ�.");
				System.out.println("�μ� ��ȣ : "+deptno);
				System.out.println("�μ� ��ġ : "+loc);
				rs.close(); //rs��ü ����
				rs =stmt.executeQuery(sql2);
				if(rs.next()) {
					System.out.println("���\t�̸�\t�޿�\t����");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.printf("%d\t%s\t%d\t%s\n",empno,ename,sal,manager);
					}while(rs.next());
				}else {
					System.out.println("�ش� �μ� ����� �����ϴ�.");
				}
			}else {
				System.out.println("�ش� �μ����� �������� �ʽ��ϴ�.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
