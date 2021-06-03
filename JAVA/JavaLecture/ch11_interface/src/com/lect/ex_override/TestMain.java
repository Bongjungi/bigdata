package com.lect.ex_override;

public class TestMain {
	public static void main(String[] args) {
		Radio radio = new Radio();
		TV tv = new TV(5);
		Speaker speaker = new Speaker(20);
		radio.volumeDown();
		tv.volumeUp(20);
		IVolume[] device= {radio, tv, speaker};
		for(IVolume d : device) {
			System.out.println(d.getClass().getName());
		}
		
	}
}
