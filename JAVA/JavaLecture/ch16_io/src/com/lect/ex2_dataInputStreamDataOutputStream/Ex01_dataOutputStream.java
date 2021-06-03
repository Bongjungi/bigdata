package com.lect.ex2_dataInputStreamDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_dataOutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		DataOutputStream dos = null;
		try {
			os= new FileOutputStream("txtFile/dataFile.dat");
			dos = new DataOutputStream(os);
			dos.writeUTF("ȫ�浿"); //��Ʈ���� ����
			dos.writeInt(2); //int�� ����
			dos.writeDouble(95.9);//double�� ����
			
			dos.writeUTF("ȫ�浿"); //ó�� ������ ���� �߿�. ó���� ��Ʈ�� ��Ʈ ��������� ���������� �̴�� 
			dos.writeInt(2); //
			dos.writeDouble(95.9);
			System.out.println("���� ���� �Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null) {dos.close();}
				if(os!=null) {os.close();}
			}catch(Exception e) {
				
			}
		}
	}
}
