package kr.co.soft.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.soft.beans.HelloWorld;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/soft/config/beans.xml");
		HelloWorld hello1 = (HelloWorld)ctx.getBean("hello");
		hello1.sayhello();
		HelloWorld hello2 = ctx.getBean("hello",HelloWorld.class);
		hello2.sayhello();
		ctx.close();
	}
	
}
