package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Member2Dao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int EXISTENT = 0;
	public static final int NONEXISTENT = 1;
	private static Member2Dao INSTANCE;
	public static Member2Dao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new Member2Dao();
		}
		return INSTANCE;
	}
	private Member2Dao() {
		try {
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//id 중복체크
	public int idConfirm(String id) {
		int result=EXISTENT;
		String sql="SELECT * FROM MEMBER2 WHERE ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(!rs.next()) {
				result=NONEXISTENT;
			}
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
		
		return result;
	}
}
