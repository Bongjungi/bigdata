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
			System.out.println("스피커 볼륨을 1만큼 올려 "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최대치입니다.");
		}

	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel+level<SPEAKER_MAX_VOLUME) {
			volumeLevel+=level;
			System.out.println("스피커 볼륨을 " +level+"만큼 올려 "+volumeLevel);
		}else {
			volumeLevel=SPEAKER_MAX_VOLUME;
			System.out.println("스피커 볼륨이 최대치입니다.");
		}
		
		

	}

	@Override
	public void volumeDown() {
		if(volumeLevel>SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("스피커 볼륨을 1만큼 낮춰 "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최소치입니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel+level>SPEAKER_MIN_VOLUME) {
			volumeLevel-=level;
			System.out.println("스피커 볼륨을 " +level+"만큼 낮춰 "+volumeLevel);
		}else {
			volumeLevel=SPEAKER_MIN_VOLUME;
			System.out.println("스피커 볼륨이 최소치입니다.");
		}

	}

}
