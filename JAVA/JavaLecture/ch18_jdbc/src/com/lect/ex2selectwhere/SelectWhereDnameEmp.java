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
		System.out.print("부서 이름은? : ");
		String dname = sc.next().toUpperCase();
		String sql1 = String.format("select * from dept where dname = '%s'", dname);
		String sql2 = String.format("SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER"+
				" FROM EMP W, EMP M, DEPT D" + //from 앞에 띄어쓰기 주의하자.
				" WHERE W.MGR=M.EMPNO AND W.DEPTNO= D.DEPTNO AND DNAME ='%s'",dname);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			
			if(rs.next()) {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println(dname+"의 부서 정보는 다음과 같습니다.");
				System.out.println("부서 번호 : "+deptno);
				System.out.println("부서 위치 : "+loc);
				rs.close(); //rs객체 해제
				rs =stmt.executeQuery(sql2);
				if(rs.next()) {
					System.out.println("사번\t이름\t급여\t상사명");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.printf("%d\t%s\t%d\t%s\n",empno,ename,sal,manager);
					}while(rs.next());
				}else {
					System.out.println("해당 부서 사원이 없습니다.");
				}
			}else {
				System.out.println("해당 부서명이 존재하지 않습니다.");
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
