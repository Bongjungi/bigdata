package com.lect.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//오라클에서 50번 insert 후 commit 안하고 자바 실행하면 50번 부서 입력 시  에러. 60번 부서 입력 시 성공 
public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn =null;
		Statement stmt=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("입력할 부서번호는? : ");
		int deptno = sc.nextInt();
		System.out.println("입력할 부서명은? : ");
		String dname = sc.next();
		System.out.println("입력할 부서의 위치는? : ");
		String loc = sc.next();
		sc.close();
		String sql = String.format("INSERT INTO DEPT VALUES ('%d', '%s', '%s')", deptno, dname, loc);
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"scott","tiger");
			stmt=conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result==1?"부서추가성공":"부서추가실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
