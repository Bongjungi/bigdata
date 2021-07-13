package ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
public class Crawling {
	public static void main(String[] args) {
		BufferedReader reader=null;
		try {
			URL url = new URL("https://finance.naver.com/");
			reader = new BufferedReader(new InputStreamReader(url.openStream(),"euc-kr"));
			String line; int check_line=0;
			while((line=reader.readLine())!=null) {
				if(line.contains("<a href=\"/marketindex/worldExchangeDetail.nhn?marketindexCd"))check_line=1;
				if(line.contains("<a href=\"/marketindex/?tabSel=worldExchange#tab_section\""))check_line=0;
				if(check_line==1) {
					if(line.contains("<a href=\"/marketindex/worldExchangeDetail.nhn?marketindexCd")) {
						String temp = line.split(">")[2].split("<")[0];
						temp=temp.trim();
						System.out.println(temp);
					}
					if(line.contains("<td>") && !line.contains("em")) {
						String temp = line.split(">")[2].split("<")[0];
						System.out.println(temp);
					}
					if(line.contains("<td>") && line.contains("em")) {
						String temp = line.split(">")[3].split("<")[0];
						System.out.println(temp);
						String temp2 = line.split(">")[5].split("<")[0];
						System.out.println(temp2);
						System.out.println();
					}
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(reader!=null)reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
