package com.lect.ex_override;

public class Radio implements IVolume{

	public int Radio_MAX_VOLUME=50;
	public int Radio_MIN_VOLUME=0;
	private int volumeLevel;
	public Radio() {
	}
	public Radio(int volumeLevel) {
		this.volumeLevel=volumeLevel;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel<Radio_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("Radio ������ 1��ŭ �÷� "+volumeLevel);
		}else {
			System.out.println("Radio ������ �ִ�ġ�Դϴ�.");
		}

	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel+level<Radio_MAX_VOLUME) {
			volumeLevel+=level;
			System.out.println("Radio ������ " +level+"��ŭ �÷� "+volumeLevel);
		}else {
			volumeLevel=Radio_MAX_VOLUME;
			System.out.println("Radio ������ �ִ�ġ�Դϴ�.");
		}
		
		

	}

	@Override
	public void volumeDown() {
		if(volumeLevel>Radio_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("Radio ������ 1��ŭ ���� "+volumeLevel);
		}else {
			System.out.println("Radio ������ �ּ�ġ�Դϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel+level>Radio_MIN_VOLUME) {
			volumeLevel-=level;
			System.out.println("Radio ������ " +level+"��ŭ ���� "+volumeLevel);
		}else {
			volumeLevel=Radio_MIN_VOLUME;
			System.out.println("Radio ������ �ּ�ġ�Դϴ�.");
		}

	}

	
}
