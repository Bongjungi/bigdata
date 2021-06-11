package com.lect.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �μ���ȣ��? ");
		int deptno = sc.nextInt();
		System.out.print("�ٲ� �μ� �̸���? ");
		String dname = sc.next();
		System.out.println("�ٲ� �μ� ��ġ��? ");
		String loc = sc.next();
		String sql = String.format("UPDATE DEPT SET DNAME = '%s', LOC='%s' WHERE DEPTNO = %d", dname,loc,deptno);
		sc.close();
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"scott","tiger");
			stmt=conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0?"���� ����":"���� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
