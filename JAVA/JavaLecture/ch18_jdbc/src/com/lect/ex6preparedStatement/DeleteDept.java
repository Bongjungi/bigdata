package com.lect.ex6preparedStatement;
//10은 삭제 못함. emp에서 사용중.
//부서번호를 받아 emp테이블에 존재하는 부서번호인지 확인 후 dept에 삭제
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqlsel = "SELECT * FROM EMP WHERE DEPTNO = ?";
		String sqldel = "DELETE FROM DEPT WHERE DEPTNO = ?";
		System.out.println("삭제할 부서번호는 ? : ");
		int deptno = sc.nextInt();
		sc.close();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sqlsel);
			pstmt.setInt(1, deptno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("사용 중인 부서번호 입니다.");
			}else {
				System.out.println("사용하는 부서번호가 아닙니다.");
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(sqldel);//stmt는 conn.createStatement();
				pstmt.setInt(1, deptno);
				int result = pstmt.executeUpdate();//stmt는 stmt.executeUpdate(sql)
				if(result>0) {
					System.out.println("삭제 완료");
				}else {
					System.out.println("해당 부서가 존재하지 않습니다.");
				}
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
