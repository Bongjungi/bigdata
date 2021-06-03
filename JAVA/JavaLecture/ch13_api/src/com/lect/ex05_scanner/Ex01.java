package com.lect.ex05_scanner;
//next()//버퍼에 처음 나오는  whitespace는 무시하고 whitespace(띄어쓰기, \n, \t 등)에서 whitespace까지 출력한다.
//nextline() //버퍼에 \n이 나오는 앞까지 취하고 버처에 남아있는 \n은 제거
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력하세요? ");
		int age = scanner.nextInt();//"60"입력                                                                                       "60\n"남음
		System.out.println("입력하신 나이는 "+age); //                        "60"출력                             "\n"남음
		System.out.println("이름을 입력하세요: ");//                                                  "\n"남음
		String name = scanner.next();//"홍  길동"입력                                                                      "\n홍  길동\n"남음
		System.out.println("입력하신 이름은 "+name);//                         "홍"출력               "\n  길동\n"남음
		//scanner.nextLine();//이거입력하면 정상작동. 왜냐하면 \n길동입력하고 뒤의 \n을 모두 지워줘서 초기화된다고 보면 됌.
		                                                                
		System.out.println("입력하실 주소는?");
		String address = scanner.nextLine();//입력 못함.이미 \n 길동이 있음.     "길동"출력              없음(뒤의 \n들을 지움)      
		System.out.println("입력하신 주소는 "+address);          
		System.out.println("하고 싶은 말은?");
		String kkk = scanner.nextLine(); //"kkk"입력                  								"kkk\n"남음
		System.out.println(kkk);	//									"kkk"출력                  없음
		scanner.close();
	}
}
