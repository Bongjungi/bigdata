package com.lect.ex3_readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

//1.키보드로부터 출력할 파일이름을 입력받습니다. (a.txt -> txtFile/a.txt)
//2.출력하고자 하는 내용을 라인단위로 반복적으로 받습니다.(단, 저장을 끝내고 싶으면 x)
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Writer writer =null;
		String outMsg;
		System.out.println("파일 이름을 입력해주세요 : ");
		String filename=scanner.nextLine();
		try {
			writer = new FileWriter("txtFile/"+filename);
			while(true) {
				System.out.println("출력하고자 하는 내용을 입력해주세요 : ");
				outMsg=scanner.nextLine();
				if(outMsg.equalsIgnoreCase("x")){
					break;
				}else {
					writer.write(outMsg+"\r\n");
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		scanner.close();
	}
		
	
}

