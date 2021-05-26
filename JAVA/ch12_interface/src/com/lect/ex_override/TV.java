package com.lect.ex_override;

public class TV implements IVolume{

	public int TV_MAX_VOLUME=20;
	public int TV_MIN_VOLUME=0;
	private int volumeLevel;
	public TV() {
	}
	public TV(int volumeLevel) {
		this.volumeLevel=volumeLevel;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel<TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV ������ 1��ŭ �÷� "+volumeLevel);
		}else {
			System.out.println("TV ������ �ִ�ġ�Դϴ�.");
		}

	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel+level<TV_MAX_VOLUME) {
			volumeLevel+=level;
			System.out.println("TV ������ " +level+"��ŭ �÷� "+volumeLevel);
		}else {
			volumeLevel=TV_MAX_VOLUME;
			System.out.println("TV ������ �ִ�ġ�Դϴ�.");
		}
		
		

	}

	@Override
	public void volumeDown() {
		if(volumeLevel>TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV ������ 1��ŭ ���� "+volumeLevel);
		}else {
			System.out.println("TV ������ �ּ�ġ�Դϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel+level>TV_MIN_VOLUME) {
			volumeLevel-=level;
			System.out.println("TV ������ " +level+"��ŭ ���� "+volumeLevel);
		}else {
			volumeLevel=TV_MIN_VOLUME;
			System.out.println("TV ������ �ּ�ġ�Դϴ�.");
		}

	}

	
}
