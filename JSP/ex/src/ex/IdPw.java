package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class IdPw implements IIdPw{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static IdPw INSTANCE;
	public static IdPw getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new IdPw();
		}
		return INSTANCE;
	}
	private IdPw() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//id 중복확인
	public int idConfirm(String id) {
		int result=0;
		String sql="SELECT * FROM IdPw WHERE ID=?";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(!rs.next()) {
				result=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	public int login(String id, String pw) {
		int result=0;
		String sql="SELECT * FROM IdPw WHERE ID=? AND PW=?";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(!rs.next()) {
				result=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	//id에 맞는 oracle에 저장된 pw 가져오기
	public String pwget(String id) {
		String result=null;
		String sql="SELECT PW FROM IdPw WHERE ID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getString("pw");
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
	//id pw 삽입
	public int idpwinsert(String id, String pw, String tel, String address, String gender, String email) {
		int result=0;
		String sql="INSERT INTO IdPw VALUES (?,?,?,?,?,?)";
		Connection conn= null;
		PreparedStatement pstmt = null;
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, tel);
			pstmt.setString(4,address);
			pstmt.setString(5, gender);
			pstmt.setString(6, email);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	//비밀번호 변경해서 데이터베이스에 저장
	public String chChar(int e, int n, String str) {
		//e=23 n=999919 p=1009 q=991
		int ndegree = (int)Math.log10(n)+1;
		char[] dfformset = new char[ndegree];
		for(int i=0;i<dfformset.length;i++) {
			dfformset[i]='0';
		}
		String dfform=String.copyValueOf(dfformset);
		DecimalFormat df = new DecimalFormat(dfform);
		char[] charset = str.trim().replaceAll(" ","").toCharArray();//{I,l,o,v,e,y,o,u}
		char[] realcharset;
		if(charset.length%2==0) {
			realcharset=charset;
		}else {
			realcharset=new char[charset.length+1];
			for(int i=0;i<charset.length;i++) {
				realcharset[i]=charset[i];
			}
			realcharset[realcharset.length-1]='[';
		}
		//1~9는 숫자로 a=10,b=11 ...은 어떨지
		double[] intarr = new double[realcharset.length/2];
		for(int i=0;i<realcharset.length-1;i=i+2) {
			double tho=(int)realcharset[i];
			double one=(int)realcharset[i+1];
			intarr[i/2]=1000*tho+one;
		}
		String answer="";
		for(int i=0;i<intarr.length;i++) {
			double sum=1;
			for(int j=0;j<e;j++) {
				sum*=intarr[i];
				sum%=n;
			}
			int newsum = (int)sum;
			String tempstr = df.format(newsum).toString();
			answer = answer.concat(tempstr);
		}
		return answer;
	}
}
