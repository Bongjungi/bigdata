package com.lect.ex6preparedStatement;
//10�� ���� ����. emp���� �����.
//�μ���ȣ�� �޾� emp���̺� �����ϴ� �μ���ȣ���� Ȯ�� �� dept�� ����
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
		System.out.println("������ �μ���ȣ�� ? : ");
		int deptno = sc.nextInt();
		sc.close();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sqlsel);
			pstmt.setInt(1, deptno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("��� ���� �μ���ȣ �Դϴ�.");
			}else {
				System.out.println("����ϴ� �μ���ȣ�� �ƴմϴ�.");
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(sqldel);//stmt�� conn.createStatement();
				pstmt.setInt(1, deptno);
				int result = pstmt.executeUpdate();//stmt�� stmt.executeUpdate(sql)
				if(result>0) {
					System.out.println("���� �Ϸ�");
				}else {
					System.out.println("�ش� �μ��� �������� �ʽ��ϴ�.");
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
