package com.lect.ex3insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


//1. �μ���ȣ�� �޾� �ش�μ���ȣ�� �ִ��� ��ȸ
//2-1. �ش� �μ���ȣ�� ���� ��� : �ߺ��� �μ���ȣ�Դϴ�.���
//2-2. �ش� �μ���ȣ�� ������ : �μ���� ��ġ�� �޾� insert�մϴ�.

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; 
		Statement stmt = null;
		ResultSet rs = null; 
		ArrayList<Integer> deptnoarr = new ArrayList<Integer>();
		String sql1 = "SELECT DEPTNO FROM DEPT"; 
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				do { 
					int deptno1 = rs.getInt("deptno");
					deptnoarr.add(deptno1);
				}while(rs.next());
			}else {
				System.out.println("��ȸ�� ����� �����ϴ�.");
			}
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("���ο� �μ��� �Է��Ͻðڽ��ϱ�?(Y/N)");
				String insert = sc.next();
				if(insert.equalsIgnoreCase("y")) {
					System.out.print("�μ� ��ȣ��? : ");
					int deptno;
					do {
						try {
							deptno = sc.nextInt();
							break;
						}catch (Exception e) {
							System.out.println("���� �Է�");
						}
					}while(true);
					int uniquesensor = 0;
					for(int i=0;i<deptnoarr.size();i++) {
						if(deptnoarr.get(i)==deptno) {
							uniquesensor=1;break;
						}
					}	
					if(uniquesensor==1) {
						System.out.println("�ߺ��� �μ���ȣ�Դϴ�.");
					}else {
						System.out.println("�Է��� �μ�����? : ");
						String dname = sc.next();
						byte[]d =dname.getBytes(); //dname�� ����Ʈ�� �ٲ㼭 ����ִ´�.
						int firstletterascii = (int)d[0];
						if((firstletterascii>=65 && firstletterascii<=90)||(firstletterascii>=97 && firstletterascii<=122)) {
							if(dname.length()>14) {
								System.out.println("�� ���");
								continue;
							}else {
								if(dname.length()>4) {
									System.out.println("�� ���");
									continue;
								}
							}
						}
						System.out.println("�Է��� �μ��� ��ġ��? : ");
						String loc = sc.next();
						String sql2 = String.format("INSERT INTO DEPT VALUES ('%d', '%s', '%s')", deptno, dname, loc);
						int result =stmt.executeUpdate(sql2);
						System.out.println(result==1?"�μ��߰�����":"�μ��߰�����");
					}	
				}else if(insert.equalsIgnoreCase("n")) {
					System.out.println("�����մϴ�.");break;
				}else {
					System.out.println("Y �Ǵ� N�� �Է����ּ���.");
				}
			}while(true);
			
			sc.close();
		} catch (InputMismatchException e) {
			System.out.println("���ڸ� �Է����ּ���.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+ " ����̹� ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(stmt!=null)stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
