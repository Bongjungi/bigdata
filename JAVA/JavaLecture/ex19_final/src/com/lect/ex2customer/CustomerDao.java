package com.lect.ex2customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static CustomerDao INSTANCE;
	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static CustomerDao getinstance() {
		if(INSTANCE==null) {
			INSTANCE= new CustomerDao();
		}
		return INSTANCE;
	}
	public int insertdto(CustomerDto dto) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		int result=0;
		String sql="INSERT INTO CUSTOMER VALUES (CUSTOMER_ID_SQ.NEXTVAL,?,?,?)";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPhone());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getPoint());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	// SELECT * FROM CUSTOMER WHERE PHONE LIKE "%"||"9999";
	public ArrayList<CustomerDto> searchphone(String searchphone){
		ArrayList<CustomerDto> array = new ArrayList<CustomerDto>();
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "SELECT * FROM CUSTOMER WHERE PHONE LIKE '%'||?";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, searchphone);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String phone = rs.getString("phone");
				String name = rs.getString("name");
				int point = rs.getInt("point");
				array.add(new CustomerDto(id,phone, name, point));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return array;
		
	}
	
	public ArrayList<CustomerDto> allprint(){
		ArrayList<CustomerDto> array = new ArrayList<CustomerDto>();
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "SELECT * FROM CUSTOMER ORDER BY DESC";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String phone = rs.getString("phone");
				String name = rs.getString("name");
				int point = rs.getInt("point");
				array.add(new CustomerDto(id, phone, name, point));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return array;
		
	}
	
	
	
}
