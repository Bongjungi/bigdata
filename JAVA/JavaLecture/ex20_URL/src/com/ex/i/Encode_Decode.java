package com.ex.i;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Encode_Decode {
	public static void main(String[] args) {
		String url=null;
		try {
			url=URLEncoder.encode("한글 인코딩", "UTF-8");
			System.out.println(url);
			url=URLDecoder.decode("%ED%95%9C%EA%B8%80+%EC%9D%B8%EC%BD%94%EB%94%A9", "UTF-8");
			String a = URLEncoder.encode("1","UTF-8");
			System.out.println(a);
			System.out.println(url);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
