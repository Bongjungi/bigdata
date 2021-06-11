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
		Connection conn = null; //DB연결변수
		Statement stmt = null; //SQL문 전송 객체 변수
		ResultSet rs = null; //SELECT 문 경과 받는 각체 변수
		String sql = "SELECT * FROM PERSONAL"; // ctrl+shift+x 대문자로 변경
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"root","mysql");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
			while(rs.next()) { //rs.next()를 해야 pno pname 등에 넣을 수 있다. 
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
