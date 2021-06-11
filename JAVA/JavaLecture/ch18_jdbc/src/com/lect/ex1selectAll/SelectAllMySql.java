package com.lect.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllMySql {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		Connection conn = null; //DB���ắ��
		Statement stmt = null; //SQL�� ���� ��ü ����
		ResultSet rs = null; //SELECT �� ��� �޴� ��ü ����
		String sql = "SELECT * FROM PERSONAL"; // ctrl+shift+x �빮�ڷ� ����
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"root","mysql");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("���\t�̸�\t��å\t\t�����\t�Ի���\t\t�޿�\t��\t�μ���ȣ");
			while(rs.next()) { //rs.next()�� �ؾ� pno pname � ���� �� �ִ�. 
					int pno = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					Date startdate = rs.getDate("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					System.out.printf("%d\t%s\t%s\t%d\t%TS\t%d\t%d\t%d\n",pno,pname,job,manager,startdate,pay,bonus,dno);
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
