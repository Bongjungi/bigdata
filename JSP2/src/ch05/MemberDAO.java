package ch05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	public List<MemberDTO> memberlist(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null; //db접속
		PreparedStatement pstmt = null; //sql실행
		ResultSet rs = null; //결과
		try {
			conn=DB.dbConn();
			String sql = "select userid,passwd,name,to_char(reg_date,'yyyy-mm-dd') reg_date,address,tel from member order by name";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String userid = rs.getString("userid");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				MemberDTO dto = new MemberDTO(userid, passwd,name, reg_date,address,tel);
				list.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public void insert(MemberDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn=DB.dbConn();
			String sql="insert into member (userid,passwd,name,address,tel) values (?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getReg_date());
			pstmt.setString(5, dto.getTel());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				
			}
		}
		
	}
	public MemberDTO memberDetail(String id) {
		MemberDTO dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			String sql="select * from member where userid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				dto.setTel(rs.getString("tel"));
				dto.setReg_date(rs.getString("reg_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} 
		}
		return dto;
	}
	public void update(MemberDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn=DB.dbConn();
			String sql = "update member set passwd=?,name=?,address=?,tel=? where userid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,dto.getPasswd());
			pstmt.setString(2,dto.getName());
			pstmt.setString(3,dto.getAddress());
			pstmt.setString(4,dto.getTel());
			pstmt.setString(5,dto.getUserid());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void delete(String userid) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn=DB.dbConn();
			String sql="delete from member where userid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
