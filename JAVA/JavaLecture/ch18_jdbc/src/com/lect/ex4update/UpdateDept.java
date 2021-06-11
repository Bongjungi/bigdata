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
		System.out.print("수정할 부서번호는? ");
		int deptno = sc.nextInt();
		System.out.print("바뀐 부서 이름는? ");
		String dname = sc.next();
		System.out.println("바뀐 부서 위치는? ");
		String loc = sc.next();
		String sql = String.format("UPDATE DEPT SET DNAME = '%s', LOC='%s' WHERE DEPTNO = %d", dname,loc,deptno);
		sc.close();
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"scott","tiger");
			stmt=conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0?"수정 성공":"수정 실패");
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
