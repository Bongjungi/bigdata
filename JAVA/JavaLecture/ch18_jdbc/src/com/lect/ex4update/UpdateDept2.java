package com.lect.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		System.out.print("Update�Һμ���ȣ�Է� : ");
		int deptno =sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			String sql1 = String.format("SELECT DEPTNO FROM DEPT WHERE DEPTNO = '%d'", deptno);
			rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				System.out.println("���ο� �μ� �̸� �Է�");
				String dname = sc.next();
				System.out.println("���ο� �μ� ��� �Է�");
				String loc = sc.next();
				sc.close();
				String sql2 = String.format("UPDATE DEPT SET DNAME = '%s', LOC='%s' WHERE DEPTNO = '%d'",dname,loc,deptno);
				int result = stmt.executeUpdate(sql2);
				System.out.println(result==1?"�μ����漺��":"�μ��������");
			}else {
				System.out.println("�μ� ��ȣ�� �������� �ʽ��ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
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
