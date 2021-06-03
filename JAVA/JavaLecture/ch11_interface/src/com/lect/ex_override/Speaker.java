package com.lect.ex_override;

public class Speaker implements IVolume {
	public int SPEAKER_MAX_VOLUME=100;
	public int SPEAKER_MIN_VOLUME=0;
	private int volumeLevel;
	public Speaker() {
	}
	public Speaker(int volumeLevel) {
		this.volumeLevel=volumeLevel;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel<SPEAKER_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("����Ŀ ������ 1��ŭ �÷� "+volumeLevel);
		}else {
			System.out.println("����Ŀ ������ �ִ�ġ�Դϴ�.");
		}

	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel+level<SPEAKER_MAX_VOLUME) {
			volumeLevel+=level;
			System.out.println("����Ŀ ������ " +level+"��ŭ �÷� "+volumeLevel);
		}else {
			volumeLevel=SPEAKER_MAX_VOLUME;
			System.out.println("����Ŀ ������ �ִ�ġ�Դϴ�.");
		}
		
		

	}

	@Override
	public void volumeDown() {
		if(volumeLevel>SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("����Ŀ ������ 1��ŭ ���� "+volumeLevel);
		}else {
			System.out.println("����Ŀ ������ �ּ�ġ�Դϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel+level>SPEAKER_MIN_VOLUME) {
			volumeLevel-=level;
			System.out.println("����Ŀ ������ " +level+"��ŭ ���� "+volumeLevel);
		}else {
			volumeLevel=SPEAKER_MIN_VOLUME;
			System.out.println("����Ŀ ������ �ּ�ġ�Դϴ�.");
		}

	}

}
